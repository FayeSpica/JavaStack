package jre.orm.bean;

import java.sql.*;
import java.util.*;

public class Institute {
	private String name;
	private Integer id;
	public String getName(){
		return this.name;
	}
	public Integer getId(){
		return this.id;
	}
	public void setName(String name){
		 this.name = name;
	}
	public void setId(Integer id){
		 this.id = id;
	}
}
