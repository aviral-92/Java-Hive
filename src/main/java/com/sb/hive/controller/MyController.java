package com.sb.hive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.hive.pojo.Pokemon;
import com.sb.hive.service.HiveServices;

@RestController
public class MyController {
	
	@Autowired
	private HiveServices HiveServices;

	@RequestMapping(value="/all")
	public List<Pokemon> getAllData(){
		
		return HiveServices.getAllData();
	}
}
