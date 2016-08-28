package org.bridgelabz.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import org.bridgelabz.model.UploadedFile;

public class FileValidator implements Validator {

	 public boolean supports(@SuppressWarnings("rawtypes") Class arg0) {
	 
	  return false;
	 }
	 public void validate(Object uploadedFile, Errors errors) {

	  UploadedFile file = (UploadedFile) uploadedFile;

	  if (file.getFile().getSize() == 0) {
	   errors.rejectValue("file", "uploadForm.salectFile",
	     "Please select a JSON file..!");
	  }
	}
	 
}