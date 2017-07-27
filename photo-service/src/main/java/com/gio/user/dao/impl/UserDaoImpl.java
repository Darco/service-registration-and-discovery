package com.gio.user.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.gio.model.user.User;
import com.gio.user.dao.UserDao;
import com.gio.user.dao.mapper.UserRowMapper;

@Repository
public class UserDaoImpl implements UserDao{

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void addUser(User user){
		//String query = "INSERT INTO users(name , apaterno) value(? , ?)";
		 final SqlParameterSource source = new MapSqlParameterSource().addValue("name", user.getName()).addValue("apaterno", user.getApaterno());
		 namedParameterJdbcTemplate.update("INSERT INTO users (name , apaterno) VALUES (:name , :apaterno)", source);
	}

	@Override
	public void deleteUser(Integer id){
		final SqlParameterSource source = new MapSqlParameterSource().addValue("id", id);

		String sql = "DELETE FROM users WHERE id = :id";
		namedParameterJdbcTemplate.update(sql, source);
	}

	@Override
	public List<User> listUser(){
		String sql = "SELECT * FROM users";
		List<User> users = namedParameterJdbcTemplate.query(sql, new UserRowMapper());
		return users;
	}

	@Override
	public User getUserById(Integer id){
		User user = null;
		try {
			String sql = "SELECT * FROM users where id = :id";
			SqlParameterSource namedParameters =  new MapSqlParameterSource("id", Integer.valueOf(id));
			LOGGER.info(sql, user);
			user = namedParameterJdbcTemplate.queryForObject(sql, namedParameters, new UserRowMapper());

			LOGGER.info("user : {}", user);
		} catch (EmptyResultDataAccessException e) {
            LOGGER.error("Sin datos", e);
        } catch (IncorrectResultSizeDataAccessException e) {
            LOGGER.error("Registros incorrectos", e);
        } catch (DataAccessException e) {
            LOGGER.error("Error general", e);
        }
		return user;
	}

	public void update(User user){
		String sql = "UPDATE users SET name =:name, apaterno =: apaterno WHERE id = :id";
		final SqlParameterSource source = new MapSqlParameterSource().addValue("name", user.getName()).addValue("apaterno", user.getApaterno());
		namedParameterJdbcTemplate.update(sql, source);
	}

}
