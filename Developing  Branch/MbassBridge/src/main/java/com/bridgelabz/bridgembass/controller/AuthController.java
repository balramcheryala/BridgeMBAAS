package com.bridgelabz.bridgembass.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.bridgembass.database.model.Credentials;
import com.bridgelabz.bridgembass.database.model.Crud;
import com.bridgelabz.bridgembass.dto.CredentialsBean;
import com.bridgelabz.bridgembass.dto.CrudBean;
import com.bridgelabz.bridgembass.service.Credentialservice;
import com.bridgelabz.bridgembass.service.CrudService;

/**
 * The Class CrudController.
 */
@RestController
public class AuthController {

	/**
	 * Dashboard.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = { "/dashboard" }, method = RequestMethod.GET)
	public ModelAndView dashboard() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "BRIDGEMBASS");
		model.addObject("user", getUser());
		model.setViewName("dashboard");
		return model;
	}

	/**
	 * Sign in by.
	 *
	 * @return the model and view
	 */
	// Sign in By
	@RequestMapping(value = { "/signinby" }, method = RequestMethod.GET)
	public ModelAndView signInBy() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "BRIDGEMBAAS");
		model.addObject("user", getUser());
		model.setViewName("sign-in");
		return model;
	}

	/** The crud service. */
	@Autowired
	private CrudService crudService;

	@Autowired
	private Credentialservice credentialservice;

	/**
	 * List students.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = { "/userpage" }, method = RequestMethod.GET)
	public ModelAndView listStudents() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", prepareListofBean(crudService.listStudents()));
		model.put("title", "BRIDGEMBASS");
		model.put("user", getUser());
		System.out.println(model.toString());
		return new ModelAndView("user", model);
	}

	@RequestMapping(value = { "/secureuser" }, method = RequestMethod.GET)
	public ModelAndView securepage() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", prepareListofCredentialsBean(credentialservice.listStudents()));
		System.out.println(credentialservice.listStudents().toString());
		model.put("title", "BRIDGEMBASS");
		model.put("url", "Set Redirect Uri as http://localhost:8081/projectname/__/auth/{provider}");
		model.put("user", getUser());
		System.out.println(model.toString());
		return new ModelAndView("secureuser", model);
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
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("title", "BRIDGEMBASS");
		model.put("user", getUser());
		return new ModelAndView("redirect:userpage");
	}
	@RequestMapping(value = "/credsave", method = RequestMethod.POST)
	public ModelAndView saveCredentials(@ModelAttribute("command") CredentialsBean crudBean, BindingResult result) {
		Credentials crud = prepareModelforCredentialsBean(crudBean);
		credentialservice.addStudent(crud);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("title", "BRIDGEMBASS");
		model.put("user", getUser());
		return new ModelAndView("redirect:secureuser");
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
		model.put("title", "BRIDGEMBASS");
		model.put("user", getUser());
		return new ModelAndView("newuser", model);
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public ModelAndView signinby(@ModelAttribute("command") CredentialsBean crudBean, BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", prepareListofCredentialsBean(credentialservice.listStudents()));
		model.put("title", "BRIDGEMBASS");
		model.put("user", getUser());

		return new ModelAndView("credentials", model);
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
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("command") CrudBean crudBean, BindingResult result) {

		Crud crud = prepareModel(crudBean);

		crudService.addStudent(crud);

		return new ModelAndView("redirect:userpage");
	}

	@RequestMapping(value = "/credupdate", method = RequestMethod.POST)
	public ModelAndView credupdate(@ModelAttribute("command") CredentialsBean crudBean, BindingResult result) {

		Credentials crud = prepareModelforCredentialsBean(crudBean);

		credentialservice.addStudent(crud);

		return new ModelAndView("redirect:credentials");
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
		return new ModelAndView("redirect:userpage");
	}

	@RequestMapping(value = "/creddelete", method = RequestMethod.GET)
	public ModelAndView deletecredentials(@ModelAttribute("command") CredentialsBean crudBean, BindingResult result) {
		System.out.println("delete entered");
		credentialservice.deleteStudent(prepareModelforCredentialsBean(crudBean));
		return new ModelAndView("redirect:credentials");
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
		model.put("student", prepareCrudBean(crudService.getStudent(crudBean.getId())));
		model.put("crud", prepareListofBean(crudService.listStudents()));
		model.put("title", "BRIDGEMBASS");
		model.put("user", getUser());
		return new ModelAndView("editstudent", model);
	}

	@RequestMapping(value = "/crededit", method = RequestMethod.GET)
	public ModelAndView editcredentials(@ModelAttribute("command") CredentialsBean crudBean, BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("student", prepareCredentialsBean(credentialservice.getStudent(crudBean.getId())));
		model.put("crud", prepareListofCredentialsBean(credentialservice.listStudents()));
		model.put("title", "BRIDGEMBASS");
		model.put("user", getUser());
		return new ModelAndView("editcredentials", model);
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
		crud.setPassword(crudBean.getPassword());
		crud.setProviders(providers());
		crud.setSignedin(date());
		crud.setCreated(date());
		crud.setUseruid(randomUUID());
		crudBean.setId(null);
		return crud;
	}

	private Credentials prepareModelforCredentialsBean(CredentialsBean crudBean) {

		Credentials crud = new Credentials();
		crud.setId(crudBean.getId());
		crud.setClientid(crudBean.getClientid());
		crud.setClientpassword(crudBean.getClientpassword());
		
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
				bean.setPassword(crud.getPassword());
				bean.setEmail(crud.getEmail());
				bean.setProviders(providers());
				bean.setCreated(date());
				bean.setSignedin(date());
				bean.setUseruid(randomUUID());
				beans.add(bean);
			}
		}
		return beans;
	}

	private List<CredentialsBean> prepareListofCredentialsBean(List<Credentials> cruds) {
		List<CredentialsBean> beans = null;

		if (cruds != null && !cruds.isEmpty()) {
			beans = new ArrayList<CredentialsBean>();
			CredentialsBean bean = null;
			for (Credentials crud : cruds) {
				bean = new CredentialsBean();
				bean.setId(crud.getId());
				bean.setClientid(crud.getClientid());
				bean.setClientpassword(crud.getClientpassword());
				System.out.println(bean);
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
	private CrudBean prepareCrudBean(Crud crud) {

		CrudBean bean = new CrudBean();
		bean.setId(crud.getId());
		bean.setEmail(crud.getEmail());
		bean.setPassword(crud.getPassword());
		bean.setProviders(providers());
		bean.setCreated(date());
		bean.setSignedin(date());
		bean.setUseruid(randomUUID());
		return bean;
	}

	private CredentialsBean prepareCredentialsBean(Credentials crud) {

		CredentialsBean bean = new CredentialsBean();
		bean.setId(crud.getId());
		bean.setClientid(crud.getClientid());
		bean.setClientpassword(crud.getClientpassword());

		return bean;
	}

	/**
	 * Random UUID.
	 *
	 * @return the uuid
	 */
	@SuppressWarnings("static-access")
	private UUID randomUUID() {
		UUID uid = UUID.fromString("12300000-1ab0-11bd-b23e-10b96e4ef00d");

		return uid.randomUUID();
	}

	
	/**
	 * Providers.
	 *
	 * @return the string
	 */
	private String providers() {
		
		String pattern = "LOCAL";
		return pattern;
	}
	/**
	 * Date.
	 *
	 * @return the string
	 */
	private String date() {

		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		return date;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	// getUser
	private String getUser() {
		String userName = null;
		// The simplest way to retrieve the currently authenticated principal is
		// via a static call to the SecurityContextHolder
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("Getting the username from Security Context Holder");
		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}
