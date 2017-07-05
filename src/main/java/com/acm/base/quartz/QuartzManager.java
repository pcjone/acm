package com.acm.base.quartz;

import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;

import com.acm.base.entitys.AcmJob;
import com.acm.base.service.AcmJobService;

public class QuartzManager implements BeanFactoryAware {

	private Scheduler scheduler;

	private AcmJobService acmJobService;
	
	private static BeanFactory beanFactory = null;

	public void reScheduleJob() {
		// 通过查询数据库里计划任务来配置计划任务
		List<AcmJob> jobs = acmJobService.getAll();
	}

	/**
	 * 初始化
	 * @param acmJob
	 * @return
	 */
	public boolean configQuatrz(AcmJob acmJob) {
		boolean result = true;
		try {
			// 运行时可通过动态注入的scheduler得到trigger 
			TriggerKey triggerKey = TriggerKey.triggerKey(acmJob.getTriggername(), scheduler.DEFAULT_GROUP);
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey); 
			//判断是否null
			if(trigger != null) {
				update(acmJob,trigger);
			}else {
				
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void update(AcmJob acmJob, CronTrigger trigger) {
		//任务可用
		if(acmJob.getState().equals("1")) {
			// 判断从DB中取得的任务时间和现在的quartz线程中的任务时间是否相等  
	        // 如果相等，则表示用户并没有重新设定数据库中的任务时间，这种情况不需要重新rescheduleJob  
			if(trigger.getCronExpression().equalsIgnoreCase(acmJob.getCronexpression())) {
				
			}else {
				
			}
		}
	}

	public Scheduler getScheduler() {  
	    return scheduler;  
	}  
	  
	public void setScheduler(Scheduler scheduler) {  
	    this.scheduler = scheduler;  
	}  
	  
	public void setBeanFactory(BeanFactory factory) throws BeansException {  
	    this.beanFactory = factory;  
	  
	}  
	  
	public BeanFactory getBeanFactory() {  
	    return beanFactory;  
	}  
}
