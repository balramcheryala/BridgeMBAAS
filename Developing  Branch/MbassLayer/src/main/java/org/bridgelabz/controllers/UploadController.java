package org.bridgelabz.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class UploadController.
 */
@Controller("abc")
public class UploadController {

	/** The json util. */
	@Autowired
	JSONUtils jsonUtil;

	/** The file validator. */
	@Autowired
	FileValidator fileValidator;

	/** The table dao. */
	@Autowired
	TableDao tableDao;

	/**
	 * M bass home.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView mBassHome() {
		System.out.println("dashboard json page open");
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("databaseDashBoard", model);
	}

	/**
	 * Gets the upload form.
	 *
	 * @param uploadedFile
	 *            the uploaded file
	 * @param result
	 *            the result
	 * @return the upload form
	 */
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
	@RequestMapping(value = "/selectIdPage", method = RequestMethod.GET)
	public ModelAndView jsonDisplay() throws ClassNotFoundException, IOException {
		System.out.println("select json page open");
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("Provide", model);
	}
	@RequestMapping(value = "/idSelect", method = RequestMethod.POST)
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException{
		String tableName=request.getParameter("tableName");
		String column_Field=request.getParameter("columnFieldName");
		String column_Field_Value=request.getParameter("columnFieldValue");
		tableDao.getId(tableName, column_Field, column_Field_Value);
		ServletOutputStream out= response.getOutputStream();
		out.println(tableDao.getId(tableName, column_Field, column_Field_Value)+" inserted record id fetched from database.");
		
	}
	@RequestMapping(value="/specific",method=RequestMethod.GET)
	public ModelAndView displaySpecific()
	{
		return new ModelAndView("specificRecord");
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public ModelAndView deleteRecord()
	{
		System.out.println("delete json page open");
		return new ModelAndView("delete");
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/columnRowId",method=RequestMethod.POST,headers="Accept=application/json")
	public String displaySpecificRecordDetail(HttpServletRequest request)throws ServletException,IOException, ClassNotFoundException
		{
			System.out.println("specific record url match here");
			String tableName=request.getParameter("tableName");
			String column_Field=request.getParameter("columnFieldName");
			String rowIdValue=request.getParameter("rowId");
			ArrayList team=new ArrayList();
			team=tableDao.specificRecordDisplay(tableName,column_Field,rowIdValue);
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(team);	
		
	}
	@RequestMapping("/jsonData")
	public ModelAndView jsonKeyValueFileUploaded(@ModelAttribute("jsonFile") UploadedFile uploadedFile,
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
	public ModelAndView fileUploaded(@ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result)
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
			return new ModelAndView("uploadForm");
		}
		boolean jsonStringValid = JSONUtils.isJSONValid(data);
		if (jsonStringValid == false) {
			return new ModelAndView("invalidJson");
		}
		tableDao.getFile(data, result);
		return new ModelAndView("showFile");
	}
}