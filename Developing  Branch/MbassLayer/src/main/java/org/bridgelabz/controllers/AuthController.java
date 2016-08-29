package org.bridgelabz.controllers;

import java.util.HashMap;
import java.util.Map;

import org.bridgelabz.form.ClientCredentialsBean;
import org.bridgelabz.form.ClientDetailsBean;
import org.bridgelabz.methods.Prepairation;
import org.bridgelabz.model.ClientCredentialsModel;
import org.bridgelabz.model.ClientDetailsModel;
import org.bridgelabz.service.ClientCredentialservice;
import org.bridgelabz.service.ClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*Class AuthController.
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */

// AuthController
@Controller("authController")
public class AuthController {

	// @Autowired ClientDetailsService
	@Autowired
	private ClientDetails detailservice;

	/**
	 * @return the detailservice
	 */
	public ClientDetails getDetailservice() {
		return detailservice;
	}

	/**
	 * @return the credentialservice
	 */
	public ClientCredentialservice getCredentialservice() {
		return credentialservice;
	}

	// @Autowired ClientCredentialservice
	@Autowired
	private ClientCredentialservice credentialservice;

	// Class Object
	Prepairation preparation = new Prepairation();

	// twitterpost
	@RequestMapping(value = { "/twitterpost" }, method = RequestMethod.GET)
	public ModelAndView Post() {
		ModelAndView model = new ModelAndView();
		model.setViewName("uploadform");
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
	@RequestMapping(value = { "/mbaasprojects" }, method = RequestMethod.GET)
	public ModelAndView userpage() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", preparation.prepareListofBean(detailservice.listClientDetails()));
		model.put("title", "BRIDGEMBASS");
		return new ModelAndView("user", model);
	}

	// user page By controller
	@RequestMapping(value = { "/userpage", "/userinfo" }, method = RequestMethod.GET)
	public ModelAndView UserInfo() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students", preparation.prepareListofBean(detailservice.listClientDetails()));
		model.put("title", "BRIDGEMBASS");
		return new ModelAndView("userpage", model);
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
	@RequestMapping(value = { "/credentialadd" }, method = RequestMethod.GET)
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

	// deleteClientDetails controller
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute("command") ClientDetailsBean clientdetailsbean, BindingResult result) {
		System.out.println("delete entered");
		detailservice.deleteClientDetails(preparation.prepareModel(clientdetailsbean));
		return new ModelAndView("redirect:userpage");
	}

	// getClientDetails edit controller
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editdata(@ModelAttribute("command") ClientDetailsBean clientdetailsbean, BindingResult result) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("student", preparation.prepareCrudBean(detailservice.getClientDetails(clientdetailsbean.getId())));
		model.put("crud", preparation.prepareListofBean(detailservice.listClientDetails()));
		model.put("title", "BRIDGEMBASS");
		return new ModelAndView("editdetails", model);
	}

}
