package com.hibernate03;
/*
 * 联系人的实体
CREATE TABLE cst_linkman (
  lkm_id int NOT NULL IDENTITY PRIMARY KEY (lkm_id) ,-- '联系人编号(主键)',
  lkm_name varchar(16) DEFAULT NULL ,-- '联系人姓名',
  lkm_cust_id INT NOT NULL ,-- '客户id',cst_customer的cust_id
  lkm_gender char(1) DEFAULT NULL ,-- '联系人性别',
  lkm_phone varchar(16) DEFAULT NULL ,-- '联系人办公电话',
  lkm_mobile varchar(16) DEFAULT NULL ,-- '联系人手机',
  lkm_email varchar(64) DEFAULT NULL ,-- '联系人邮箱',
  lkm_qq varchar(16) DEFAULT NULL ,-- '联系人qq',
  lkm_position varchar(16) DEFAULT NULL ,-- '联系人职位',
  lkm_memo varchar(512) DEFAULT NULL ,-- '联系人备注',
 )
*/
public class LinkMan {
	private int lkm_id;
	private String lkm_name;	
	private String lkm_gender;
	private String lkm_phone;
	private String lkm_mobile;
	private String lkm_email;
	private String lkm_qq;
	private String lkm_position;
	private String lkm_memo;

	// 通过ORM方式表示：一个联系人只能属于某一个客户。
	// 放置的是一的一方的对象。
	private Customer customer;
	
	
	
	
	public LinkMan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LinkMan(int lkm_id, String lkm_name) {
		super();
		this.lkm_id = lkm_id;
		this.lkm_name = lkm_name;
	}

	public int getLkm_id() {
		return lkm_id;
	}
	public void setLkm_id(int lkm_id) {
		this.lkm_id = lkm_id;
	}
	public String getLkm_name() {
		return lkm_name;
	}
	public void setLkm_name(String lkm_name) {
		this.lkm_name = lkm_name;
	}
	public String getLkm_gender() {
		return lkm_gender;
	}
	public void setLkm_gender(String lkm_gender) {
		this.lkm_gender = lkm_gender;
	}
	public String getLkm_phone() {
		return lkm_phone;
	}
	public void setLkm_phone(String lkm_phone) {
		this.lkm_phone = lkm_phone;
	}
	public String getLkm_mobile() {
		return lkm_mobile;
	}
	public void setLkm_mobile(String lkm_mobile) {
		this.lkm_mobile = lkm_mobile;
	}
	public String getLkm_email() {
		return lkm_email;
	}
	public void setLkm_email(String lkm_email) {
		this.lkm_email = lkm_email;
	}
	public String getLkm_qq() {
		return lkm_qq;
	}
	public void setLkm_qq(String lkm_qq) {
		this.lkm_qq = lkm_qq;
	}
	public String getLkm_position() {
		return lkm_position;
	}
	public void setLkm_position(String lkm_position) {
		this.lkm_position = lkm_position;
	}
	public String getLkm_memo() {
		return lkm_memo;
	}
	public void setLkm_memo(String lkm_memo) {
		this.lkm_memo = lkm_memo;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "LinkMan [lkm_id=" + lkm_id + ", lkm_name=" + lkm_name + ", lkm_gender=" + lkm_gender + ", lkm_phone="
				+ lkm_phone + ", lkm_mobile=" + lkm_mobile + ", lkm_email=" + lkm_email + ", lkm_qq=" + lkm_qq
				+ ", lkm_position=" + lkm_position + ", lkm_memo=" + lkm_memo + "]";
	}
	
	
	
	
	
	
	
}
