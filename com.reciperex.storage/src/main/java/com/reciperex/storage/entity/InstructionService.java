package com.reciperex.storage.entity;

import java.sql.SQLException;

import com.reciperex.model.Instruction;

public interface InstructionService {

	public Instruction insertNewInstruction(Instruction instruction) throws SQLException;
	
	public int updateInstruction(Instruction instruction) throws SQLException;
	
	public int deleteInstruction(Integer id) throws SQLException;

	public Instruction getInstructionById(Integer id);
	
}
