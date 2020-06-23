package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.controller.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addUser1(UserBean userBean) {

		return jdbcTemplate.update("insert into usermvc(firstname,lastname)values('" + userBean.getFirstName() + "','"
				+ userBean.getLastName() + "')");
	}

	private final static class UserMapper implements RowMapper<UserBean> {

		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			UserBean userBean = new UserBean();
			userBean.setFirstName(rs.getString("firstname"));
			userBean.setLastName(rs.getString("lastname"));
			userBean.setId(rs.getString("id"));

			return userBean;
		}

	}

	public List<UserBean> getAllUsers() {

		return jdbcTemplate.query("select * from usermvc", new UserMapper());

	}

	public int deleteUser(int uId) {

		return jdbcTemplate.update("delete from usermvc where id =" + uId + "");
	}

	public UserBean getDataById(String id) {
		String sql = "select * from usermvc where id='" + id + "'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<UserBean>() {

			/*
			 * @Override
			 */ public UserBean extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserBean userBean = new UserBean();
				if (rs.next()) {

					userBean.setFirstName(rs.getString("firstname"));
					userBean.setLastName(rs.getString("lastname"));
					userBean.setId(rs.getString("id"));

				}

				return userBean;
			}

		});
	}
	
	public int updateUser(UserBean userBean)
	{
		return jdbcTemplate.update("update usermvc set firstname='"+userBean.getFirstName()+"' lastname='"+userBean.getLastName()+"' where id="+userBean.getId()+"");
	}

}
