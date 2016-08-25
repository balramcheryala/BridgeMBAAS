package com.bridgelabz.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.bridgelabz.beans.ClientCredentialsBean;
import com.bridgelabz.beans.ClientDetailsBean;
import com.bridgelabz.methods.Prepairation;
import com.bridgelabz.model.ClientCredentialsModel;
import com.bridgelabz.model.ClientDetailsModel;
import com.bridgelabz.service.ClientCredentialservice;
import com.bridgelabz.service.ClientDetailsService;

/**
 * @author bridgelabz
 *
 */
// AuthController
@RestController
public class AuthController {

	// @Autowired ClientDetailsService
	@Autowired
	private ClientDetailsService detailservice;

	// @Autowired ClientCredentialservice
	@Autowired
	private ClientCredentialservice credentialservice;

	// Class Objects
	Prepairation preparation = new Prepairation();

	// Dashboard controller
	@RequestMapping(value = { "/dashboard" }, method = RequestMethod.GET)
	public ModelAndView dashboard() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "BRIDGEMBASS");

		model.setViewName("dashboard");
		return model;
	}

	// test demo controller
	@RequestMapping(value = { "/testdemo" }, method = RequestMethod.GET)
	public ModelAndView testdemo() {
		ModelAndView model = new ModelAndView();
		model.setViewName("testdemo");
		return model;
	}

	// Sign in By controller
	@RequestMapping(value = { "/signinby" }, method = RequestMethod.GET)
	public ModelAndView signInBy() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "BRIDGEMBAAS");

		model.setViewName("sign-in");
		return model;
	}

	// user page By controller
	@RequestMapping(value = { "/userpage" }, method = RequestMethod.GET)
	public ModelAndView userpage() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", preparation.prepareListofBean(detailservice.listClientDetails()));
		model.put("title", "BRIDGEMBASS");
		return new ModelAndView("user", model);
	}

	// secureuser page By controller
	@RequestMapping(value = { "/secureuser" }, method = RequestMethod.GET)
	public ModelAndView securepage() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", preparation.prepareListofCredentialsBean(credentialservice.listClientCredentialss()));
		System.out.println(credentialservice.listClientCredentialss().toString());
		model.put("title", "BRIDGEMBASS");
		model.put("url", "Set Redirect Uri as http://localhost:8081/projectname/auth/{provider}");

		System.out.println(model.toString());
		return new ModelAndView("secureuser", model);
	}

	// save addClientDetails page By controller
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView ClientDetailsave(@ModelAttribute("command") ClientDetailsBean clientdetailsbean,
			BindingResult result) {
		ClientDetailsModel clientdetailmodel = preparation.prepareModel(clientdetailsbean);
		detailservice.addClientDetails(clientdetailmodel);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("title", "BRIDGEMBASS");

		return new ModelAndView("redirect:userpage");
	}

	// clientcredential save page By controller
	@RequestMapping(value = "/credentialsave", method = RequestMethod.POST)
	public ModelAndView ClientCredentialsave(@ModelAttribute("command") ClientCredentialsBean credentialbean,
			BindingResult result) {
		ClientCredentialsModel clientcredentialmodel = preparation.prepareModelforCredentialsBean(credentialbean);
		credentialservice.addClientCredentials(clientcredentialmodel);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("title", "BRIDGEMBASS");

		return new ModelAndView("redirect:secureuser");
	}

	// New User controller
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public ModelAndView newuser(@ModelAttribute("command") ClientDetailsBean clientdetailsbean, BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", preparation.prepareListofBean(detailservice.listClientDetails()));
		model.put("title", "BRIDGEMBASS");

		return new ModelAndView("newuser", model);
	}

	// display add controller
	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public ModelAndView ClientCredentialsadd(@ModelAttribute("command") ClientCredentialsBean credentialbean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("crud", preparation.prepareListofCredentialsBean(credentialservice.listClientCredentialss()));
		model.put("title", "BRIDGEMBASS");
		System.out.println(model.toString());
		return new ModelAndView("credentials", model);
	}

	// update addClientDetails controller
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView ClientDetailsupdate(@ModelAttribute("command") ClientDetailsBean clientdetailsbean,
			BindingResult result) {
		ClientDetailsModel clientdetailmodel = preparation.prepareModel(clientdetailsbean);
		detailservice.addClientDetails(clientdetailmodel);
		return new ModelAndView("redirect:userpage");
	}

	// addClientCredentials update Controller
	@RequestMapping(value = "/credupdate", method = RequestMethod.POST)
	public ModelAndView credupdate(@ModelAttribute("command") ClientCredentialsBean credentialbean,
			BindingResult result) {

		ClientCredentialsModel clientcredentialmodel = preparation.prepareModelforCredentialsBean(credentialbean);
		credentialservice.addClientCredentials(clientcredentialmodel);
		return new ModelAndView("redirect:credentials");
	}

	// deleteClientDetails controller
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editStudent(@ModelAttribute("command") ClientDetailsBean clientdetailsbean,
			BindingResult result) {
		System.out.println("delete entered");
		detailservice.deleteClientDetails(preparation.prepareModel(clientdetailsbean));
		return new ModelAndView("redirect:userpage");
	}

	// deleteClientCredentials controller
	@RequestMapping(value = "/creddelete", method = RequestMethod.GET)
	public ModelAndView deletecredentials(@ModelAttribute("command") ClientCredentialsBean credentialbean,
			BindingResult result) {
		System.out.println("delete entered");
		credentialservice.deleteClientCredentials(preparation.prepareModelforCredentialsBean(credentialbean));
		return new ModelAndView("redirect:credentials");
	}

	// getClientDetails edit controller
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@ModelAttribute("command") ClientDetailsBean clientdetailsbean,
			BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("student", preparation.prepareCrudBean(detailservice.getClientDetails(clientdetailsbean.getId())));
		model.put("crud", preparation.prepareListofBean(detailservice.listClientDetails()));
		model.put("title", "BRIDGEMBASS");
		return new ModelAndView("editstudent", model);
	}

	// getClientCredentials edit controller
	@RequestMapping(value = "/crededit", method = RequestMethod.GET)
	public ModelAndView editcredentials(@ModelAttribute("command") ClientCredentialsBean credentialbean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("student",
				preparation.prepareCredentialsBean(credentialservice.getClientCredentials(credentialbean.getId())));
		model.put("crud", preparation.prepareListofCredentialsBean(credentialservice.listClientCredentialss()));
		model.put("title", "BRIDGEMBASS");
		return new ModelAndView("editcredentials", model);
	}

}