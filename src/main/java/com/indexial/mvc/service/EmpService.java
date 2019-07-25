package com.indexial.mvc.service;

import com.indexial.mvc.bean.EmpBean;

public interface EmpService {

	public boolean addEmp(EmpBean bean);
	public EmpBean getEmp(int empId);
	
}
