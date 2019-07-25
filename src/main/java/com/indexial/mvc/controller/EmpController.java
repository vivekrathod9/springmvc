package com.indexial.mvc.controller;

import java.util.HashMap;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.indexial.mvc.bean.EmpBean;
import com.indexial.mvc.entity.EmpEntity;
import com.indexial.mvc.serviceimpl.EmpServiceImpl;

@Controller


public class EmpController {
	
	
	@Autowired
	public EmpServiceImpl empImpl;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute("empbean") EmpBean bean) {
	empImpl.addEmp(bean);
	return new ModelAndView("redirect:/add");
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView navigateToAddProductPage() {

		HashMap<String, Object> model = new HashMap<String, Object>();
		model.put("empbean", new EmpBean()); 	
		model.put("emploees", empImpl.getAllProduct());
		return new ModelAndView("employee", model);

	}
}

