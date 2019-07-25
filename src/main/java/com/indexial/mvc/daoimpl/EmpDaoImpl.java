package com.indexial.mvc.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.indexial.mvc.dao.EmpDao;
import com.indexial.mvc.entity.EmpEntity;
@Repository
public class EmpDaoImpl implements EmpDao{

	@Autowired
	SessionFactory sfactory;
	
	@Override
	public boolean insertEmp(EmpEntity entity) {
		
		Session session=sfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(entity);
		tr.commit();
		return true;
	}

	@Override
	public EmpEntity fetchEmp(int empId) {
		Session session=sfactory.openSession();
		Transaction tr=session.beginTransaction();
		return  session.get(EmpEntity.class, empId);
	}

	public List<EmpEntity> getAllProduct() {
		Session session=sfactory.openSession();
		Transaction tr=session.beginTransaction();
		return session.createCriteria(EmpEntity.class).list();
	}
	
}
