package com.hibernate.aplab8;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="Student")
public class Student {
	@Column
	String first;
	@Column
	String last;
	@Id
	int registration;
	@Column
	@Transient
	String password;
	@Column
	String month;
	@Column
	@Temporal(TemporalType.DATE)
	Date date;
	Student(){}
	Student(String first,String last,int registration,String password,String month)
	{
		this.first=  first;
		this.last = last;
		this.registration = registration;
		this.password = password;
		this.month = month;
		Calendar cal = Calendar. getInstance();
		Date date=cal.getTime();
		
		
	}
	public String toString() {
		return "Registration: "+this.registration+" Name: "+this.first+" "+this.last+" Month:"+this.month;
	}
	
}
