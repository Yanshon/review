package cn.dw.model;

import java.util.Date;

//实体类，类——》表。
public class Product {

//	   id                  int not null auto_increment,
//	   name                varchar(20),
//	   price               decimal(8,2),
//	   remark              longtext,
//	   date                timestamp default CURRENT_TIMESTAMP,
	private Integer id;
	private String name;
	private Double price;
	private String remark;
	private Date date;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}