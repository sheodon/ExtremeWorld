package com.yumfee.extremeworld.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_course_taxonomy")
public class CourseTaxonomy extends IdEntity
{
	private String name;
	private Date createTime;
	
	private List<Course> courses;

	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	@JsonIgnore
	@OneToMany
	@JoinColumn(name="taxonomy_id")
	public List<Course> getCourses()
	{
		return courses;
	}

	public void setCourses(List<Course> courses)
	{
		this.courses = courses;
	}
	
	
	
	
	
}
