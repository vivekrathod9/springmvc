package com.indexial.mvc.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indexial.mvc.bean.EmpBean;
import com.indexial.mvc.daoimpl.EmpDaoImpl;
import com.indexial.mvc.entity.EmpEntity;
import com.indexial.mvc.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	public EmpDaoImpl daoImpl;
	
	@Override
	public boolean addEmp(EmpBean bean) {
		return daoImpl.insertEmp(beanToEntity(bean));	
	}

	private EmpEntity beanToEntity(EmpBean bean) {
		EmpEntity entity=new EmpEntity();
		entity.setEmpId(bean.getEmpId());
		entity.setEmpName(bean.getEmpName());
		entity.setEmpAge(bean.getEmpAge());
		entity.setEmpAddress(bean.getEmpAddress());
		return entity;
	}
	
	public List<EmpBean> getAllProduct() {
		return entitiesToBeans(daoImpl.getAllProduct());
	}

	private List<EmpBean> entitiesToBeans(List<EmpEntity> allProduct) {
		List<EmpBean> beans = new ArrayList<EmpBean>();
		for(EmpEntity entity : allProduct) {
				beans.add(entityToBean(entity));
		}
		return beans;
	}

	@Override
	public EmpBean getEmp(int empId) {
	return	entityToBean(daoImpl.fetchEmp(empId));
	}

	private EmpBean entityToBean(EmpEntity empEntity) {
	return new EmpBean(empEntity.getEmpId(), empEntity.getEmpName(), empEntity.getEmpAge(), empEntity.getEmpAddress());
	
	}
}
