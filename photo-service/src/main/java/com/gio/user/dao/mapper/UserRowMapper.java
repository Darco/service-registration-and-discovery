package com.gio.user.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gio.model.user.User;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet arg0, int arg1) throws SQLException {
		final User user = new User();
		user.setId(arg0.getInt("id"));
		user.setName(arg0.getString("name"));
		user.setApaterno(arg0.getString("apaterno"));
		
		return user;
	}
}
