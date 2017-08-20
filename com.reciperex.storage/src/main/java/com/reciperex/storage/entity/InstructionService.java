package com.reciperex.storage.entity;

import java.sql.SQLException;

import com.reciperex.model.Instruction;

public interface InstructionService {

	public int insertNewInstruction(Instruction instruction);
	
	public int updateInstruction(Instruction instruction);
	
	public int deleteInstruction(Integer id) throws SQLException;
	
}
