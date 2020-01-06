package com.bean;

import org.apache.axis2.databinding.types.soapencoding.Base64Binary;

public class DocUploadDTO {

	private String SourceId;
	private String RegistrationId;
	private String EntityName;
	private String Category;
	private String FileId;
	private String FileName;
	private String  FileDescription;
	private String SourceFileName;
	private Base64Binary fileBinary;
	public String getSourceId() {
		return SourceId;
	}
	public void setSourceId(String sourceId) {
		SourceId = sourceId;
	}
	public String getRegistrationId() {
		return RegistrationId;
	}
	public void setRegistrationId(String registrationId) {
		RegistrationId = registrationId;
	}
	public String getEntityName() {
		return EntityName;
	}
	public void setEntityName(String entityName) {
		EntityName = entityName;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getFileId() {
		return FileId;
	}
	public void setFileId(String fileId) {
		FileId = fileId;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getFileDescription() {
		return FileDescription;
	}
	public void setFileDescription(String fileDescription) {
		FileDescription = fileDescription;
	}
	public String getSourceFileName() {
		return SourceFileName;
	}
	public void setSourceFileName(String sourceFileName) {
		SourceFileName = sourceFileName;
	}
	public Base64Binary getFileBinary() {
		return fileBinary;
	}
	public void setFileBinary(Base64Binary fileBinary) {
		this.fileBinary = fileBinary;
	}
	
}
