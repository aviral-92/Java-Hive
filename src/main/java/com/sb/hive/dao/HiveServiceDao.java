package com.sb.hive.dao;

import java.util.List;

import com.sb.hive.pojo.Pokemon;

public interface HiveServiceDao {

	public static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
	
	public List<Pokemon> getAllData();
}
