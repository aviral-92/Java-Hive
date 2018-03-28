package com.sb.hive.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sb.hive.constants.Constant;
import com.sb.hive.dao.HiveServiceDao;
import com.sb.hive.pojo.Pokemon;

@Repository
public class HiveServiceDaoImpl implements HiveServiceDao {

	private Connection con = null;
	private Statement stmt = null;
	private String Database = "default";

	@Override
	public List<Pokemon> getAllData() {

		if (con == null || stmt == null) {
			getConnections();
		}

		Pokemon pokemon = null;
		List<Pokemon> pokemons = new ArrayList<>();
		try {
			ResultSet res = stmt.executeQuery(Constant.FETCH_ALL);

			while (res.next()) {
				pokemon = new Pokemon();
				pokemon.setNum(res.getInt(1));
				pokemon.setName(res.getString(2));
				pokemon.setType1(res.getString(3));
				pokemon.setType2(res.getString(4));
				pokemon.setTotal(res.getInt(5));
				pokemon.setHp(res.getInt(6));
				pokemon.setAttack(res.getInt(7));
				pokemon.setDefense(res.getInt(8));
				pokemon.setSpecialAttack(res.getInt(9));
				pokemon.setSpecialDefense(res.getInt(10));
				pokemon.setSpeed(res.getInt(11));
				pokemons.add(pokemon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pokemons;
	}

	private void getConnections() {

		try {
			Class.forName(driverName);
			con = DriverManager.getConnection("jdbc:hive://localhost:10000/default", "", "");
			stmt = con.createStatement();
			stmt.execute("use " + Database);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
