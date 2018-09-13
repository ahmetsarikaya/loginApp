package com.ebebek.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ebebek.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User findUserByUsername(String username) {
		String sql = "select username,password,email,role from users where username=?";
		User user = jdbcTemplate.queryForObject(sql, new Object[] { username }, new UserRowMapper());
		return user;
	}

	@Override
	public int saveUser(User user) {
		String sql = "insert into users values(?,?,?,?)";
		return jdbcTemplate.update(sql,
				new Object[] { user.getUsername(), user.getPassword(), user.getEmail(), "USER" });
	}

	class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setRoles(rs.getString("role"));
			return user;
		}
	}
}
