package com.acm.base.entitys;

import java.io.Serializable;

public class AcmJob implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	// 设置trigger名称
	private String triggername;
	// 设置表达式
	private String cronexpression;
	// 设置Job名称
	private String jobdetailname;
	// 任务类名
	private String targetobject;
	// 类名对应的方法名
	private String methodname;
	// 设置是否并发启动任务 0是false 非0是true
	private String concurrent;
	// 如果计划任务不存则为1 存在则为0
	private String state;
	
	private String readme;
	// 是否是已经存在的springBean 1是 0 否
	private String isspringbean;
	
	/** 预留字段1 */
	private String reserved1;
	/** 预留字段2 */
	private String reserved2;
	/** 预留字段3 */
	private String reserved3;
	/** 预留字段4 */
	private String reserved4;
	/** 预留字段5 */
	private String reserved5;
	/** 预留字段6 */
	private String reserved6;
	/** 预留字段7 */
	private String reserved7;
	/** 预留字段8 */
	private String reserved8;
	/** 预留字段9 */
	private String reserved9;
	/** 预留字段10 */
	private String reserved10;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTriggername() {
		return triggername;
	}
	public void setTriggername(String triggername) {
		this.triggername = triggername;
	}
	public String getCronexpression() {
		return cronexpression;
	}
	public void setCronexpression(String cronexpression) {
		this.cronexpression = cronexpression;
	}
	public String getJobdetailname() {
		return jobdetailname;
	}
	public void setJobdetailname(String jobdetailname) {
		this.jobdetailname = jobdetailname;
	}
	public String getTargetobject() {
		return targetobject;
	}
	public void setTargetobject(String targetobject) {
		this.targetobject = targetobject;
	}
	public String getMethodname() {
		return methodname;
	}
	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}
	public String getConcurrent() {
		return concurrent;
	}
	public void setConcurrent(String concurrent) {
		this.concurrent = concurrent;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getReadme() {
		return readme;
	}
	public void setReadme(String readme) {
		this.readme = readme;
	}
	public String getIsspringbean() {
		return isspringbean;
	}
	public void setIsspringbean(String isspringbean) {
		this.isspringbean = isspringbean;
	}
	public String getReserved1() {
		return reserved1;
	}
	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}
	public String getReserved2() {
		return reserved2;
	}
	public void setReserved2(String reserved2) {
		this.reserved2 = reserved2;
	}
	public String getReserved3() {
		return reserved3;
	}
	public void setReserved3(String reserved3) {
		this.reserved3 = reserved3;
	}
	public String getReserved4() {
		return reserved4;
	}
	public void setReserved4(String reserved4) {
		this.reserved4 = reserved4;
	}
	public String getReserved5() {
		return reserved5;
	}
	public void setReserved5(String reserved5) {
		this.reserved5 = reserved5;
	}
	public String getReserved6() {
		return reserved6;
	}
	public void setReserved6(String reserved6) {
		this.reserved6 = reserved6;
	}
	public String getReserved7() {
		return reserved7;
	}
	public void setReserved7(String reserved7) {
		this.reserved7 = reserved7;
	}
	public String getReserved8() {
		return reserved8;
	}
	public void setReserved8(String reserved8) {
		this.reserved8 = reserved8;
	}
	public String getReserved9() {
		return reserved9;
	}
	public void setReserved9(String reserved9) {
		this.reserved9 = reserved9;
	}
	public String getReserved10() {
		return reserved10;
	}
	public void setReserved10(String reserved10) {
		this.reserved10 = reserved10;
	}
	
	
}
