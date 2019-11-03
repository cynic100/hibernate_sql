package com.hibernate03;

import java.util.HashSet;
import java.util.Set;

/*
 * sql 2008R2  数据库表结构
 */
/*CREATE TABLE cst_customer (
		  cust_id INT NOT NULL IDENTITY PRIMARY KEY(cust_id),
		  cust_name varchar(32) NOT NULL ,
		  cust_source varchar(32) ,
		  cust_industry varchar(32)  ,
		  cust_level varchar(32) ,
		  cust_phone varchar(64),
		  cust_mobile varchar(16),
		) */
/**
 * @Description: 表cst_customer实体类(用一句话描述该文件做什么)
 * @author xu_yuxin
 * @date 2019年10月19日
 * @version V1.0
 */
public class Customer {
	private int cust_id;
	private String cust_name;
	private String cust_source;
	private String cust_industry;
	private String cust_level;
	private String cust_phone;
	private String cust_mobile;

	// 通过ORM方式表示：一个客户对应多个联系人。
	// 放置的多的一方的集合。Hibernate默认使用的是Set集合。
	private Set<LinkMan> linkMans = new HashSet<LinkMan>();

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_source() {
		return cust_source;
	}

	public void setCust_source(String cust_source) {
		this.cust_source = cust_source;
	}

	public String getCust_industry() {
		return cust_industry;
	}

	public void setCust_industry(String cust_industry) {
		this.cust_industry = cust_industry;
	}

	public String getCust_level() {
		return cust_level;
	}

	public void setCust_level(String cust_level) {
		this.cust_level = cust_level;
	}

	public String getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

	public String getCust_mobile() {
		return cust_mobile;
	}

	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	
	

	public Set<LinkMan> getLinkMans() {
		return linkMans;
	}

	public void setLinkMans(Set<LinkMan> linkMans) {
		this.linkMans = linkMans;
	}

	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_source=" + cust_source
				+ ", cust_industry=" + cust_industry + ", cust_level=" + cust_level + ", cust_phone=" + cust_phone
				+ ", cust_mobile=" + cust_mobile + "]";
	}

}
