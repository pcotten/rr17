package com.reciperex.service;

import com.reciperex.storage.service.DatabaseManagerOLD;

public class IdService {

	private static DatabaseManagerOLD dbManager = new DatabaseManagerOLD();
	
	public static Integer generateId(String idType){

		Integer nextId = dbManager.queryMaxIdNumber(idType);
		if (nextId == null){
			return 1;
		}
		else {
			return ++nextId;
		}
	}
}
