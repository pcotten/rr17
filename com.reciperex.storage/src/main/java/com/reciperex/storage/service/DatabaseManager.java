package com.reciperex.storage.service;

import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.apache.commons.dbutils.DbUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mysql.cj.x.json.JsonArray;
import com.mysql.cj.x.json.JsonParser;
import com.reciperex.model.Ingredient;
import com.reciperex.model.Pantry;
import com.reciperex.model.User;

public class DatabaseManager {
	
	DatabaseConfig config = new DatabaseConfig();
	QueryRunner queryRunner = new QueryRunner();
	ObjectMapper mapper = new ObjectMapper();
	JSONParser parser = new JSONParser();
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	
	public DatabaseManager(){
		init();
	}
	 
	private void init(){
		 try {
			
			Class.forName(config.JDBC_DRIVER);
			
			mapper.registerModule(new JavaTimeModule());
			mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	 }
	
	public Object retrieveSingleEntity(Map<String, String> constraints, Class cls){
		
		Object entity = null;
		
		List<Map<String, Object>> mapList = null;
		JSONArray jArray = null;
		JSONObject jObj = null;
		conn = getConnection();
		sql = "SELECT * FROM " + cls.getSimpleName().toLowerCase();
		sql = addSQLConstraints(sql, constraints);
		mapList = mapListQuery(conn, sql);
		String json = mapToJSON(mapList);
		try {
			entity = cls.newInstance();
			jArray = (JSONArray) parser.parse(json);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (jArray != null){
			json = jArray.get(0).toString();
		}
		entity = mapToObject(json, cls);
		
		return entity;
	}
	
	public List<Object> retrieveEntities(Map<String, String> constraints, Class cls){
		
		Object entity = null;
		List<Object> entityList = new ArrayList<Object>();
		
		List<Map<String, Object>> mapList = null;
		JSONArray jArray = null;
		JSONObject jObj = null;
		conn = getConnection();
		sql = "SELECT * FROM " + cls.getSimpleName().toLowerCase();
		sql = addSQLConstraints(sql, constraints);
		mapList = mapListQuery(conn, sql);
		String json = mapToJSON(mapList);
		try {
			entity = cls.newInstance();
			jArray = (JSONArray) parser.parse(json);
			if (jArray != null){
				for (Object o : jArray){
//					json = jArray.get(jArray.indexOf(o)).toString();
					entityList.add(mapToObject(o.toString(), cls));
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return entityList;
	}
	
	public int DeleteEntity(String table, Map<String, String> constraints){
		
		String stmtVars = "";
		conn = getConnection();
		
		int r = -1;
		sql = "DELETE FROM " + table;
		sql = addSQLConstraints(sql, constraints);
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return r;
		
	}
	
	private String addSQLConstraints(String sql, Map<String, String> constraints){
		String[] keys = constraints.keySet().toArray(new String[constraints.keySet().size()]);
		if (keys.length != 0){
			sql += " WHERE ";
			for (int i = 0; i < keys.length; i++){
				sql += keys[i] + " = " + constraints.get(keys[i]);
				if (i != keys.length - 1){
					sql += " AND ";
				}
				else sql += ";";
			}
		}
		else sql += ";";
		return sql;
	}
	
	
//	public User retrieveUser(Integer id){
//		
//		User user = null;
//		List<Map<String, Object>> mapList = null;
//		JSONArray jArray = null;
//		JSONObject jObj = null;
//		conn = getConnection();
//		sql = "SELECT * FROM user WHERE id = " + id + ";";
//		mapList = mapListQuery(conn, sql);
//		String json = mapToJSON(mapList);
//		try {
//			jArray = (JSONArray) parser.parse(json);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (jArray != null){
//			json = jArray.get(0).toString();
//		}
//		user = (User)mapToObject(json, User.class);
//		
//		return user;
//	}
//	
//	public Ingredient retrieveIngredient(Integer id){
//		
//		Ingredient ingredient = null;
//		List<Map<String, Object>> mapList = null;
//		JSONArray jArray = null;
//		JSONObject jObj = null;
//		conn = getConnection();
//		sql = "SELECT * FROM ingredient WHERE id = " + id + ";";
//		mapList = mapListQuery(conn, sql);
//		String json = mapToJSON(mapList);
//		try {
//			jArray = (JSONArray) parser.parse(json);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (jArray != null){
//			json = jArray.get(0).toString();
//		}
//		ingredient = (Ingredient)mapToObject(json, Ingredient.class);
//		
//		return ingredient;
//	}
	
	public List<Map<String, Object>> mapListQuery(Connection conn, String sql){
		List<Map<String, Object>> mapList = null;
		
		try {
			mapList = queryRunner.query(conn, sql, new MapListHandler());
		} catch (SQLException e) {
			System.out.println("Unable to execute query: " + sql);
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		
		return mapList;
	}
	
	public String mapToJSON(Object object){
		
		String json = null;
		try {
			json = mapper.writeValueAsString(object);
			if (json == null){
				System.out.println("Result was empty");
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	private Object mapToObject(String json, Class cls){
		
		Object result = null;
		try {
			result = mapper.readValue(json, cls);
		
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Connection getConnection(){
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(config.DB_URL, config.USER, config.PASS);
			if (connection == null){
				throw new SQLException();
			}
		} catch (SQLException e) {
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		}
		return connection;
	}
}
