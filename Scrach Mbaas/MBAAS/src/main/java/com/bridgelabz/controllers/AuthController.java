package com.bridgelabz.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.beans.ClientCredentialsBean;
import com.bridgelabz.beans.ClientDetailsBean;
import com.bridgelabz.model.ClientCredentialsModel;
import com.bridgelabz.model.ClientDetailsModel;
import com.bridgelabz.service.ClientCredentialservice;
import com.bridgelabz.service.ClientDetailsService;

@RestController
public class AuthController {

	@Autowired
	private ClientDetailsService cds;

	@Autowired
	private ClientCredentialservice ccs;

	@RequestMapping(value = { "/dashboard" }, method = RequestMethod.GET)
	public ModelAndView dashboard() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "BRIDGEMBASS");
		/* model.addObject("user", getUser()); */
		model.setViewName("dashboard");
		return model;
	}
	
	@RequestMapping(value = { "/testdemo" }, method = RequestMethod.GET)
	public ModelAndView testdemo() {
		ModelAndView model = new ModelAndView();
		model.setViewName("testdemo");
		return model;
	}

	// Sign in By
	@RequestMapping(value = { "/signinby" }, method = RequestMethod.GET)
	public ModelAndView signInBy() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "BRIDGEMBAAS");
		/* model.addObject("user", getUser()); */
		model.setViewName("sign-in");
		return model;
	}

	@RequestMapping(value = { "/userpage" }, method = RequestMethod.GET)
	public ModelAndView listStudents() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", prepareListofBean(cds.listClientDetails()));
		model.put("title", "BRIDGEMBASS");
		/* model.put("user", getUser()); */
		System.out.println(model.toString());
		return new ModelAndView("user", model);
	}

	@RequestMapping(value = { "/secureuser" }, method = RequestMethod.GET)
	public ModelAndView securepage() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", prepareListofCredentialsBean(ccs.listClientCredentialss()));
		System.out.println(ccs.listClientCredentialss().toString());
		model.put("title", "BRIDGEMBASS");
		model.put("url", "Set Redirect Uri as http://localhost:8081/projectname/__/auth/{provider}");
		/* model.put("user", getUser()); */
		System.out.println(model.toString());
		return new ModelAndView("secureuser", model);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute("command") ClientDetailsBean crudBean, BindingResult result) {
		ClientDetailsModel crud = prepareModel(crudBean);
		cds.addClientDetails(crud);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("title", "BRIDGEMBASS");
		/* model.put("user", getUser()); */
		return new ModelAndView("redirect:userpage");
	}

	@RequestMapping(value = "/credsave", method = RequestMethod.POST)
	public ModelAndView saveCredentials(@ModelAttribute("command") ClientCredentialsBean crudBean,
			BindingResult result) {
		ClientCredentialsModel crud = prepareModelforCredentialsBean(crudBean);
		ccs.addClientCredentials(crud);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("title", "BRIDGEMBASS");
		/* model.put("user", getUser()); */
		return new ModelAndView("redirect:secureuser");
	}

	// New User
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public ModelAndView newuser(@ModelAttribute("command") ClientDetailsBean crudBean, BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", prepareListofBean(cds.listClientDetails()));
		model.put("title", "BRIDGEMBASS");
		/* model.put("user", getUser()); */
		return new ModelAndView("newuser", model);
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public ModelAndView signinby(@ModelAttribute("command") ClientCredentialsBean crudBean, BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", prepareListofCredentialsBean(ccs.listClientCredentialss()));
		model.put("title", "BRIDGEMBASS");
		/* model.put("user", getUser()); */

		return new ModelAndView("credentials", model);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("command") ClientDetailsBean crudBean, BindingResult result) {

		ClientDetailsModel crud = prepareModel(crudBean);

		cds.addClientDetails(crud);

		return new ModelAndView("redirect:userpage");
	}

	@RequestMapping(value = "/credupdate", method = RequestMethod.POST)
	public ModelAndView credupdate(@ModelAttribute("command") ClientCredentialsBean crudBean, BindingResult result) {

		ClientCredentialsModel crud = prepareModelforCredentialsBean(crudBean);

		ccs.addClientCredentials(crud);

		return new ModelAndView("redirect:credentials");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editStudent(@ModelAttribute("command") ClientDetailsBean crudBean, BindingResult result) {
		System.out.println("delete entered");
		cds.deleteClientDetails(prepareModel(crudBean));
		return new ModelAndView("redirect:userpage");
	}

	@RequestMapping(value = "/creddelete", method = RequestMethod.GET)
	public ModelAndView deletecredentials(@ModelAttribute("command") ClientCredentialsBean crudBean,
			BindingResult result) {
		System.out.println("delete entered");
		ccs.deleteClientCredentials(prepareModelforCredentialsBean(crudBean));
		return new ModelAndView("redirect:credentials");
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@ModelAttribute("command") ClientDetailsBean crudBean, BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("student", prepareCrudBean(cds.getClientDetails(crudBean.getId())));
		model.put("crud", prepareListofBean(cds.listClientDetails()));
		model.put("title", "BRIDGEMBASS");
		/* model.put("user", getUser()); */
		return new ModelAndView("editstudent", model);
	}

	@RequestMapping(value = "/crededit", method = RequestMethod.GET)
	public ModelAndView editcredentials(@ModelAttribute("command") ClientCredentialsBean crudBean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("student", prepareCredentialsBean(ccs.getClientCredentials(crudBean.getId())));
		model.put("crud", prepareListofCredentialsBean(ccs.listClientCredentialss()));
		model.put("title", "BRIDGEMBASS");
		/* model.put("user", getUser()); */
		return new ModelAndView("editcredentials", model);
	}

	private ClientDetailsModel prepareModel(ClientDetailsBean crudBean) {

		ClientDetailsModel crud = new ClientDetailsModel();
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

	private ClientCredentialsModel prepareModelforCredentialsBean(ClientCredentialsBean crudBean) {

		ClientCredentialsModel crud = new ClientCredentialsModel();
		crud.setId(crudBean.getId());
		crud.setClientid(crudBean.getClientid());
		crud.setClientpassword(crudBean.getClientpassword());

		return crud;
	}

	private List<ClientDetailsBean> prepareListofBean(List<ClientDetailsModel> cruds) {
		List<ClientDetailsBean> beans = null;

		if (cruds != null && !cruds.isEmpty()) {
			beans = new ArrayList<ClientDetailsBean>();
			ClientDetailsBean bean = null;
			for (ClientDetailsModel crud : cruds) {
				bean = new ClientDetailsBean();
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

	private List<ClientCredentialsBean> prepareListofCredentialsBean(List<ClientCredentialsModel> cruds) {
		List<ClientCredentialsBean> beans = null;

		if (cruds != null && !cruds.isEmpty()) {
			beans = new ArrayList<ClientCredentialsBean>();
			ClientCredentialsBean bean = null;
			for (ClientCredentialsModel crud : cruds) {
				bean = new ClientCredentialsBean();
				bean.setId(crud.getId());
				bean.setClientid(crud.getClientid());
				bean.setClientpassword(crud.getClientpassword());
				System.out.println(bean);
			}
		}
		return beans;

	}

	private ClientDetailsBean prepareCrudBean(ClientDetailsModel crud) {

		ClientDetailsBean bean = new ClientDetailsBean();
		bean.setId(crud.getId());
		bean.setEmail(crud.getEmail());
		bean.setPassword(crud.getPassword());
		bean.setProviders(providers());
		bean.setCreated(date());
		bean.setSignedin(date());
		bean.setUseruid(randomUUID());
		return bean;
	}

	private ClientCredentialsBean prepareCredentialsBean(ClientCredentialsModel crud) {

		ClientCredentialsBean bean = new ClientCredentialsBean();
		bean.setId(crud.getId());
		bean.setClientid(crud.getClientid());
		bean.setClientpassword(crud.getClientpassword());

		return bean;
	}

	@SuppressWarnings("static-access")
	private UUID randomUUID() {
		UUID uid = UUID.fromString("12300000-1ab0-11bd-b23e-10b96e4ef00d");

		return uid.randomUUID();
	}

	private String providers() {

		String pattern = "LOCAL";
		return pattern;
	}

	private String date() {

		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		return date;
	}

	/*
	 * // getUser private String getUser() { String userName = null; // The
	 * simplest way to retrieve the currently authenticated principal is // via
	 * a static call to the SecurityContextHolder Object principal =
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 * System.out.println("Getting the username from Security Context Holder");
	 * if (principal instanceof UserDetails) { userName = ((UserDetails)
	 * principal).getUsername(); } else { userName = principal.toString(); }
	 * return userName; }
	 */

}
