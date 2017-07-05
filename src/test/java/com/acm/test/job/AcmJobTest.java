package com.acm.test.job;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acm.base.entitys.ScheduleJob;
import com.acm.base.service.impl.QuartzJobFactoryImpl;

//@RunWith(SpringJUnit4ClassRunner.class)
//@Configuration("classpath:spring/spring-quartz.xml")
public class AcmJobTest {

	//@Autowired
	//private Scheduler schedulerFactoryBean;
	
	//@Test
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-quartz.xml");
		Scheduler schedulerFactoryBean = (Scheduler)context.getBean("schedulerFactoryBean");
		System.out.println(schedulerFactoryBean == null?true:false);
		try {
			test(schedulerFactoryBean);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		context.close();
	}

	public static void test(Scheduler schedulerFactoryBean) throws SchedulerException {
		
		List<ScheduleJob> jobList = new ArrayList<ScheduleJob>();
		for (int i = 0; i < 10; i++) {
			ScheduleJob job = new ScheduleJob();
			job.setJobId("10001" + i);
			job.setJobName("JobName_" + i);
			job.setJobGroup("dataWork");
			job.setJobStatus("1");
			job.setCronExpression("0/1 * * * * ?");
			job.setDesc("数据导入任务");
			jobList.add(job);
		}
		 for (ScheduleJob job : jobList) {
	         
	            TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());         
	            //获取trigger，即在spring配置文件中定义的 bean id="myTrigger"
	            CronTrigger trigger = (CronTrigger) schedulerFactoryBean.getTrigger(triggerKey);            
	            //不存在，创建一个
	            if (null == trigger) {
	                JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactoryImpl.class)
	                    .withIdentity(job.getJobName(), job.getJobGroup()).build();
	                jobDetail.getJobDataMap().put("scheduleJob", job);         
	                //表达式调度构建器
	                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job
	                    .getCronExpression());         
	                //按新的cronExpression表达式构建一个新的trigger
	                trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(scheduleBuilder).build();
	                schedulerFactoryBean.scheduleJob(jobDetail, trigger);
	            } else {                
	            		// Trigger已存在，那么更新相应的定时设置                
	            		//表达式调度构建器
	                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job
	                    .getCronExpression());         
	                //按新的cronExpression表达式重新构建trigger
	                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
	                    .withSchedule(scheduleBuilder).build();         
	                //按新的trigger重新
	                schedulerFactoryBean.scheduleJob(trigger);
	            }
		 }
	}

}
