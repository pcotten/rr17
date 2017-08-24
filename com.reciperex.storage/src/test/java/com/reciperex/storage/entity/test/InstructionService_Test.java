package com.reciperex.storage.entity.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Before;
import org.junit.Test;

import com.reciperex.model.Instruction;
import com.reciperex.storage.entity.InstructionService;
import com.reciperex.storage.entity.impl.InstructionServiceImpl;
import com.reciperex.storage.service.DatabaseManager;

public class InstructionService_Test {
	
	DatabaseManager manager;
	InstructionService instructionService;
	Instruction instruction;

	@Before
	public void init(){
		manager = new DatabaseManager();
		instructionService = new InstructionServiceImpl();
		instruction = new Instruction();
		
		instruction.setOrderIndex(1);
		instruction.setText("Test text");
		instruction.setRecipeId(15);
		
	}
	
	@Test
	public void InstructionService_CRUD() throws SQLException {
		int result = 0;
		
		// Test create operation
		instruction = instructionService.insertNewInstruction(instruction);
		assertTrue(instruction.getId() != null); 
		
		// Test read operations
		
		instruction = instructionService.getInstructionById(instruction.getId());
		
		// Test update operation
		
		instruction.setOrderIndex(2);
		instruction.setText("Changed Text");
		
		result = instructionService.updateInstruction(instruction);
		assertTrue(result == 1);
		
		// Test delete operation
		result = -1;
		try {
			result = instructionService.deleteInstruction(instruction.getId());
//			result = userService.deleteUser(59);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertTrue(result != -1);
		
		// Check database for user
		Connection conn = manager.getConnection();
		
		Statement stmt = conn.createStatement();
		String sql = "SELECT COUNT(*) FROM instruction WHERE id = " + instruction.getId();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		assertTrue(rs.getInt("COUNT(*)") == 0);
		
	}

}
