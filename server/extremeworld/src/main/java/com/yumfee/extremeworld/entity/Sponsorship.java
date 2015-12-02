package com.yumfee.extremeworld.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sponsorship")
public class Sponsorship extends IdEntity{

	private double sum;
	private String message;
	private Date createTime;
	
	private User user;
	private Hobby hobby;
	
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne
	@JoinColumn(name = "hobby_id")
	public Hobby getHobby() {
		return hobby;
	}
	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}
	
	
	
}
