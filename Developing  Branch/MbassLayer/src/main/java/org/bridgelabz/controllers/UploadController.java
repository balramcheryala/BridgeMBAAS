package org.bridgelabz.controllers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.bridgelabz.dao.TableDao;
import org.bridgelabz.model.UploadedFile;
import org.bridgelabz.util.JSONUtils;
import org.bridgelabz.validator.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * The Class UploadController.
 */
@Controller("upload")
public class UploadController {

	/** The json util. */
	@Autowired
	JSONUtils jsonUtil;
	/** The file validator. */
	@Autowired
	FileValidator fileValidator;
	String name;
	/** The table dao. */
	@Autowired
	TableDao tableDao;

	public void getProjectName(String projectname) {
		name = projectname;
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView mBassHome() {
		String projectName = name;
		System.out.println("dashboardpage ");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("projectname", projectName);
		return new ModelAndView("databaseDashBoard", model);
	}

	@RequestMapping(value = "/fileUploadForm", method = RequestMethod.GET)
	public ModelAndView getUploadForm(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result) {
		System.out.println("upload json page open");
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("uploadForm", model);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView jsonInsertion() {
		System.out.println("insert json page open");
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("insertJson", model);
	}

	public void getDBSchema(String mSchemaName) {
		tableDao.getDBSchema(mSchemaName);
	}

	@RequestMapping("/jsonData")
	public ModelAndView insertJsonKeyValueFileUploaded(@ModelAttribute("jsonFile") UploadedFile uploadedFile,
			BindingResult result) throws Exception {
		InputStream inputStream = null;
		MultipartFile file = uploadedFile.getFile();
		inputStream = file.getInputStream();
		String json = " ";
		InputStreamReader ios = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(ios);
		String line;
		while ((line = br.readLine()) != null) {
			json += line + "\n";
		}
		fileValidator.validate(uploadedFile, result);
		if (result.hasErrors()) {
			return new ModelAndView("insertJson");
		}
		boolean jsonStringValid = JSONUtils.isJSONValid(json);
		if (jsonStringValid == false) {
			return new ModelAndView("invalidJson");
		}
		tableDao.insertJson(json, result);
		return new ModelAndView("successJson");
	}

	/**
	 * @param uploadedFile
	 * @param result
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/fileUpload")
	public String fileUploaded(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result)
			throws Exception {
		InputStream inputStream = null;
		MultipartFile file = uploadedFile.getFile();
		inputStream = file.getInputStream();
		String data = " ";
		InputStreamReader ios = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(ios);
		String line;
		while ((line = br.readLine()) != null) {
			data += line + "\n";
		}

		fileValidator.validate(uploadedFile, result);
		if (result.hasErrors()) {
			return ("uploadForm");
		}
		boolean jsonStringValid = JSONUtils.isJSONValid(data);
		if (jsonStringValid == false) {
			return "invalidJson";
		}
		tableDao.getFile(data, result);
		return ("showFile");
	}
}