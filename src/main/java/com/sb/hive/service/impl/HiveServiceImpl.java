package com.sb.hive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.hive.dao.HiveServiceDao;
import com.sb.hive.pojo.Pokemon;
import com.sb.hive.service.HiveServices;

@Service
public class HiveServiceImpl implements HiveServices {
	
	@Autowired
	private HiveServiceDao HiveServiceDao;

	@Override
	public List<Pokemon> getAllData() {
		return HiveServiceDao.getAllData();
	}

}
