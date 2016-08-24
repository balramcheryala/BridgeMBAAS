package com.bridgelabz.bridgembass.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.bridgembass.database.model.Crud;
import com.bridgelabz.bridgembass.dto.CrudBean;
import com.bridgelabz.bridgembass.service.CrudService;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudController.
 */
@RestController
public class CrudController {

	/** The crud service. */
	@Autowired
	private CrudService crudService;

	/**
	 * List students.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = { "/userpage" }, method = RequestMethod.GET)
	public ModelAndView listStudents() {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", prepareListofBean(crudService.listStudents()));

		return new ModelAndView("user", model);
	}

	/**
	 * Save student.
	 *
	 * @param crudBean
	 *            the crud bean
	 * @param result
	 *            the result
	 * @return the model and view
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute("command") CrudBean crudBean, BindingResult result) {

		Crud crud = prepareModel(crudBean);

		crudService.addStudent(crud);

		return new ModelAndView("redirect:userpage");
	}

	/**
	 * Newuser.
	 *
	 * @param crudBean
	 *            the crud bean
	 * @param result
	 *            the result
	 * @return the model and view
	 */
	// New User
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public ModelAndView newuser(@ModelAttribute("command") CrudBean crudBean, BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", prepareListofBean(crudService.listStudents()));

		return new ModelAndView("newuser", model);
	}

	/**
	 * Edits the student 1.
	 *
	 * @param crudBean
	 *            the crud bean
	 * @param result
	 *            the result
	 * @return the model and view
	 */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editStudent1(@ModelAttribute("command") CrudBean crudBean, BindingResult result) {

		Crud crud = prepareModel(crudBean);

		crudService.addStudent(crud);

		return new ModelAndView("redirect:signinby");
	}

	/**
	 * Adds the student.
	 *
	 * @param crudBean
	 *            the crud bean
	 * @param result
	 *            the result
	 * @return the model and view
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addStudent(@ModelAttribute("command") CrudBean crudBean, BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", prepareListofBean(crudService.listStudents()));

		return new ModelAndView("addStudent", model);
	}

	/**
	 * Welcome.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {

		return new ModelAndView("index");
	}

	/**
	 * Edits the student.
	 *
	 * @param crudBean
	 *            the crud bean
	 * @param result
	 *            the result
	 * @return the model and view
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editStudent(@ModelAttribute("command") CrudBean crudBean, BindingResult result) {
		System.out.println("delete entered");
		crudService.deleteStudent(prepareModel(crudBean));
		/* return new ModelAndView("addStudent", model); */
		return new ModelAndView("redirect:userpage");
	}

	/**
	 * Delete student.
	 *
	 * @param crudBean
	 *            the crud bean
	 * @param result
	 *            the result
	 * @return the model and view
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@ModelAttribute("command") CrudBean crudBean, BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("student", prepareStudentBean(crudService.getStudent(crudBean.getId())));
		model.put("crud", prepareListofBean(crudService.listStudents()));
		return new ModelAndView("editstudent", model);
	}

	/**
	 * Prepare model.
	 *
	 * @param crudBean
	 *            the crud bean
	 * @return the crud
	 */
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

	/**
	 * Prepare listof bean.
	 *
	 * @param cruds
	 *            the cruds
	 * @return the list
	 */
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

	/**
	 * Prepare student bean.
	 *
	 * @param crud
	 *            the crud
	 * @return the crud bean
	 */
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
