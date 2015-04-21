package com.yumfee.extremeworld.entity;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_topic")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("1")
public class Topic extends IdEntity
{
	private String title;
	private String excerpt;
	private String content;
	private int imageCount;
	private int replyCount;
	private Date createTime;
	private Date updateTime;
	private int status;
	private String ip;
	
	private UserInfo userInfo;
	
	private CourseBase coursce;
	
	@NotBlank
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getExcerpt()
	{
		return excerpt;
	}
	public void setExcerpt(String excerpt)
	{
		this.excerpt = excerpt;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public int getImageCount()
	{
		return imageCount;
	}
	public void setImageCount(int imageCount)
	{
		this.imageCount = imageCount;
	}
	public int getReplyCount()
	{
		return replyCount;
	}
	public void setReplyCount(int replyCount)
	{
		this.replyCount = replyCount;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getUpdateTime()
	{
		return updateTime;
	}
	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}
	public int getStatus()
	{
		return status;
	}
	public void setStatus(int status)
	{
		this.status = status;
	}
	public String getIp()
	{
		return ip;
	}
	public void setIp(String ip)
	{
		this.ip = ip;
	}
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUserInfo()
	{
		return userInfo;
	}
	public void setUserInfo(UserInfo user)
	{
		this.userInfo = user;
	}
	
	// optional表示该对象可有可无，它的值为true表示该外键可以为null，它的值为false表示该外键为not null  
	@ManyToOne(fetch=FetchType.LAZY, optional = false)
	@JoinTable(name = "tb_course_topic",
	joinColumns = { @JoinColumn(name="topic_id", referencedColumnName= "id")},
	inverseJoinColumns = { @JoinColumn(name="course_id", referencedColumnName = "id") })
	public CourseBase getCourse()
	{
		return coursce;
	}
	public void setCourse(CourseBase coursce)
	{
		this.coursce = coursce;
	}
	
	
}
