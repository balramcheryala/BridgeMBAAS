package com.bridgelabz.bridgembass.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.bridgembass.database.model.Crud;
import com.bridgelabz.bridgembass.dto.CrudBean;
import com.bridgelabz.bridgembass.service.CrudService;

@RestController
public class CrudController {

	@Autowired
	private CrudService crudService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute("command") CrudBean crudBean, BindingResult result) {

		Crud crud = prepareModel(crudBean);

		crudService.addStudent(crud);

		return new ModelAndView("regsuc");
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editStudent1(@ModelAttribute("command") CrudBean crudBean, BindingResult result) {

		Crud crud = prepareModel(crudBean);

		crudService.addStudent(crud);

		return new ModelAndView("editsuc");
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ModelAndView listStudents() {

		Map<String, Object> model = new HashMap<String, Object>();

		model.put("students", prepareListofBean(crudService.listStudents()));

		return new ModelAndView("user", model);
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateStudents() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", prepareListofBean(crudService.listStudents()));
		return new ModelAndView("update", model);
	}

	@RequestMapping(value = "/deleteop", method = RequestMethod.GET)
	public ModelAndView delete() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", prepareListofBean(crudService.listStudents()));
		return new ModelAndView("delete", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addStudent(@ModelAttribute("command") CrudBean crudBean, BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", prepareListofBean(crudService.listStudents()));

		return new ModelAndView("addStudent", model);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {

		return new ModelAndView("index");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editStudent(@ModelAttribute("command") CrudBean crudBean, BindingResult result) {
		System.out.println("delete entered");
		crudService.deleteStudent(prepareModel(crudBean));
		System.out.println("deleted");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("student", null);
		model.put("students", prepareListofBean(crudService.listStudents()));
		/* return new ModelAndView("addStudent", model); */
		return new ModelAndView("delsuc", model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@ModelAttribute("command") CrudBean crudBean, BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("student", prepareStudentBean(crudService.getStudent(crudBean.getId())));
		model.put("students", prepareListofBean(crudService.listStudents()));
		return new ModelAndView("editstudent", model);
	}

	private Crud prepareModel(CrudBean crudBean) {

		Crud crud = new Crud();
		crud.setId(crudBean.getId());
		crud.setEmail(crudBean.getEmail());
		crud.setProviders(crudBean.getProviders());
		crud.setSignedin(crudBean.getSignedin());
		crud.setCreated(crudBean.getCreated());
		crud.setUseruid(crudBean.getUseruid());
		crudBean.setId(null);
		return crud;
	}

	private List<CrudBean> prepareListofBean(List<Crud> cruds) {
		List<CrudBean> beans = null;

		if (cruds != null && !cruds.isEmpty()) {
			beans = new ArrayList<CrudBean>();
			CrudBean bean = null;
			for (Crud crud : cruds) {
				bean = new CrudBean();
				bean.setId(crud.getId());
				bean.setEmail(crud.getEmail());
				bean.setProviders(crud.getProviders());
				bean.setCreated(crud.getCreated());
				bean.setSignedin(crud.getSignedin());
				bean.setUseruid(crud.getUseruid());
				beans.add(bean);
			}
		}
		return beans;
	}

	private CrudBean prepareStudentBean(Crud crud) {

		CrudBean bean = new CrudBean();
		bean.setId(crud.getId());
		bean.setEmail(crud.getEmail());
		bean.setProviders(crud.getProviders());
		bean.setCreated(crud.getCreated());
		bean.setSignedin(crud.getSignedin());
		bean.setUseruid(crud.getUseruid());
		return bean;
	}
}
