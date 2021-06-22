package com.addworld.data.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.addworld.data.entities.AddworldAgency;
import com.mysql.jdbc.PreparedStatement;

@Repository
public class AddworldAgencyRepositoryImpl implements AddworldAgencyRepository{

	private JdbcTemplate template;
	
	private static final String SIMPLE_QUERY = "SELECT NAME FROM ADDWORLD_AGENCY WHERE AGENCY_ID = ?";
	private static final String COLUMNS = "AGENCY_ID, NAME, ADDRESS, CITY, STATE, POSTAL_CODE";
	private static final String FIND_BY_ID_QUERY = "select " + COLUMNS + " from ADDWORLD_AGENCY where AGENCY_ID=?";
	private static final String FIND_BY_STATE_QUERY = "select " + COLUMNS + " from ADDWORLD_AGENCY where STATE=?";
	private static final String INSERT_STATEMENT = "insert into ADDWORLD_AGENCY (" + COLUMNS + ") values (?,?,?,?,?,?)";
	private static final String INSERT_AUTOGENID_STATEMENT = "insert into ADDWORLD_AGENCY (" + COLUMNS + ") values (null,?,?,?,?,?)";
	private static final String UPDATE_STATEMENT = "update ADDWORLD_AGENCY set NAME=?, ADDRESS=?, CITY=?, STATE=?, POSTAL_CODE=?" +
													" where AGENCY_ID=?";
	private static final String DELETE_STATEMENT = "delete from ADDWORLD_AGENCY where AGENCY_ID=?";
	
	
	@Autowired
	public AddworldAgencyRepositoryImpl(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}
	
	public String findAgencyNameById(Integer agencyId) {
		return this.template.queryForObject(SIMPLE_QUERY, new Object[] {agencyId}, String.class);
	}
	
	public void insert(AddworldAgency agency) {
		this.template.update(INSERT_STATEMENT, new Object[] {
				agency.getAgencyId(),
				agency.getName(),
				agency.getAddress(),
				agency.getCity(),
				agency.getState(),
				agency.getPostalCode()
		});
	}
	
	public void insertUsingAutoGenId(final AddworldAgency agency) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		this.template.update(new PreparedStatementCreator() {
			
			public java.sql.PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				
				java.sql.PreparedStatement statement = con.prepareStatement(INSERT_AUTOGENID_STATEMENT, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, agency.getName());
				statement.setString(2, agency.getAddress());
				statement.setString(3,  agency.getCity());
				statement.setString(4, agency.getState());
				statement.setInt(5,  agency.getPostalCode());
				
				
				return statement;
			}
		}, keyHolder);
		
		agency.setAgencyId(keyHolder.getKey().intValue());
	}

	public void update(AddworldAgency agency) {
		this.template.update(UPDATE_STATEMENT, new Object[] {
				agency.getName(),
				agency.getAddress(),
				agency.getCity(),
				agency.getState(),
				agency.getPostalCode(),
				agency.getAgencyId()
		});
	
	}

	public void delete(AddworldAgency agency) {
		this.template.update(DELETE_STATEMENT, new Object[] {
				agency.getAgencyId()
		});
	}
	
		private static class AddworldAgencyRowMapper implements RowMapper<AddworldAgency> {
		//it is called for each row at a time
		//it can be replaced with a ResultSet which will retrive all the results in a single call
		public AddworldAgency mapRow(ResultSet rs, int rowNum) throws SQLException {
			AddworldAgency agency = new AddworldAgency();
			agency.setAgencyId(rs.getInt("AGENCY_ID"));
			agency.setName(rs.getString("NAME"));
			agency.setAddress(rs.getString("ADDRESS"));
			agency.setCity(rs.getString("CITY"));
			agency.setState(rs.getString("STATE"));
			agency.setPostalCode(rs.getInt("POSTAL_CODE"));
			return agency;
		}
		
	}

	public AddworldAgency findById(Integer id) {		
		return this.template.queryForObject(FIND_BY_ID_QUERY, new Object[]{id}, new AddworldAgencyRowMapper());
	}

	//use RowMapper to retrieve rows from DB
	public List<AddworldAgency> findAgencyByState(String state) {
		return this.template.query(FIND_BY_STATE_QUERY, new Object[] {state}, new AddworldAgencyRowMapper());
	}
	
}
