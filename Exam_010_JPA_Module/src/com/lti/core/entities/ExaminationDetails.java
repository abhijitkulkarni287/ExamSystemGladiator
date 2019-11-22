package com.lti.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
This entity will store details of test subjects
 */

@Entity
@Table(name="EXAM")
public class ExaminationDetails 
{
	//Attributes for entity
	@Id
	@Column(name="EXAM_ID")
	private int examId;
	@Column(name="SUBJECT")
	private String examName;
	@Column(name="EXAM_DURATION")
	private int examDuration;
	@Column(name="NO_OF_QUESTIONS")
	private int numberOfQuestions;
	
	//Constructors
	public ExaminationDetails() {}
	public ExaminationDetails(int examId, String examName, int examDuration, int numberOfQuestions) 
	{
		this.examId = examId;
		this.examName = examName;
		this.examDuration = examDuration;
		this.numberOfQuestions = numberOfQuestions;
	}
	
	//Getters and Setters
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public int getExamDuration() {
		return examDuration;
	}
	public void setExamDuration(int examDuration) {
		this.examDuration = examDuration;
	}
	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}
	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}
	
}
