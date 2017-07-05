package com.acm.wei.entitys;

import java.util.List;

public class WeiUser {
	private String openId;
	private String nickname;
	private Integer age;
	private Integer sex;
	private Integer subscribe;
	private String city;
	private String country;
	private String province;
	private String language;
	private String headimgurl;
	private Integer subscribe_time;
	private String unionid;
	private String remark;
	private String groupid;
	private List<String> tagid_list;
	
	public WeiUser(String openId, String nickname, Integer age, Integer sex, Integer subscribe, String city,
			String country, String province, String language, String headimgurl, Integer subscribe_time, String unionid,
			String remark, String groupid, List<String> tagid_list) {
		super();
		this.openId = openId;
		this.nickname = nickname;
		this.age = age;
		this.sex = sex;
		this.subscribe = subscribe;
		this.city = city;
		this.country = country;
		this.province = province;
		this.language = language;
		this.headimgurl = headimgurl;
		this.subscribe_time = subscribe_time;
		this.unionid = unionid;
		this.remark = remark;
		this.groupid = groupid;
		this.tagid_list = tagid_list;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public Integer getSubscribe_time() {
		return subscribe_time;
	}
	public void setSubscribe_time(Integer subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public List<String> getTagid_list() {
		return tagid_list;
	}
	public void setTagid_list(List<String> tagid_list) {
		this.tagid_list = tagid_list;
	}
	
}
