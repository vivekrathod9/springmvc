package com.indexial.mvc.dao;

import com.indexial.mvc.entity.EmpEntity;

public interface EmpDao {

	public boolean insertEmp(EmpEntity entity);
	public EmpEntity fetchEmp(int empId);
	
}
;