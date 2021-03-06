package com.lti.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*This entity will store details of question excel file*/

@Entity
@Table(name="QUESTION_FILES" )
public class FileDetails 
{
	@Id
	@Column(name="FILE_ID")
	int fileId;
	@Column(name="FILE_NAME")
	String fileName;
	
	
	//Constructors
	public FileDetails() {}
	public FileDetails(int fileId, String fileName) 
	{
		this.fileId = fileId;
		this.fileName = fileName;
	}
	
	//Getter setter method
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
