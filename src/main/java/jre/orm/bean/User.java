package jre.orm.bean;

import java.sql.*;
import java.util.*;

public class User {
	private java.sql.Date create_time;
	private java.sql.Timestamp create_timestamp;
	private String user_name;
	private Integer id;
	private String pwd;
	public java.sql.Date getCreate_time(){
		return this.create_time;
	}
	public java.sql.Timestamp getCreate_timestamp(){
		return this.create_timestamp;
	}
	public String getUser_name(){
		return this.user_name;
	}
	public Integer getId(){
		return this.id;
	}
	public String getPwd(){
		return this.pwd;
	}
	public void setCreate_time(java.sql.Date create_time){
		 this.create_time = create_time;
	}
	public void setCreate_timestamp(java.sql.Timestamp create_timestamp){
		 this.create_timestamp = create_timestamp;
	}
	public void setUser_name(String user_name){
		 this.user_name = user_name;
	}
	public void setId(Integer id){
		 this.id = id;
	}
	public void setPwd(String pwd){
		 this.pwd = pwd;
	}
}
