package com.lti.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/*This entity will store details of question excel file*/

@Entity
@Table(name="QUESTION_FILES" )
public class FileDetails 
{
	@Id
	@Column(name="FILE_ID")
	@SequenceGenerator(name="fileIdGen",sequenceName="fileId_seq",initialValue=1,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="fileIdGen")
	private int fileId;
	@Column(name="FILE_NAME")
	private String fileName;
	
	//Constructors
	public FileDetails() {}
	public FileDetails( String fileName) 
	{
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
