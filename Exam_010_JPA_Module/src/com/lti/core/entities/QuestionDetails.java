package com.lti.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * 1.) This entity is used for storing details of every question
 * 2.) These details will be extracted from the excel file that
 * 		 the admin will upload
 * 3.) It is mapped with ExaminationDetails Table
 * 
 * CREATE TABLE QUESTIONS(
    QUESTION_ID NUMBER CONSTRAINT PK_QUESTIONS_QUESTIONID PRIMARY KEY, 
    EXAM_ID NUMBER CONSTRAINT FK_QUESTIONS_EXAMID REFERENCES EXAM(EXAM_ID),
    FILE_ID NOT NULL CONSTRAINT FK_QUESTIONS_FILEID REFERENCES QUESTION_FILES(FILE_ID),
    QUESTION VARCHAR2(100) NOT NULL, 
    ANSWER VARCHAR2(20) NOT NULL,
    DELETED VARCHAR2(20) DEFAULT 'NO'
);
 * 
 * 
 * 
 */

@Entity
@Table(name="QUESTIONS")
public class QuestionDetails 
{
	//attributes for the entity
	@Id
	@Column(name="QUESTION_ID")
	int questionId;
	@Column(name="QUESTION")
	String question;
	@Column(name="ANSWER")
	String correctOption;
	@Column(name="DELETED")
	String deleted;

	//mapping attributes
	//1)ExaminationDetails table exam_id
	@OneToOne
	@JoinColumn(name="EXAM_ID")
	ExaminationDetails exam;

	//2)File table 
	@ManyToOne
	@JoinColumn(name="FILE_ID")
	FileDetails fileDetails;
	
	//Constructors
	public QuestionDetails() {}

	public QuestionDetails(int questionId, String question, String correctOption,ExaminationDetails exam, FileDetails fileDetails) {
		this.questionId = questionId;
		this.question = question;
		this.correctOption = correctOption;
		this.exam = exam;
		this.fileDetails = fileDetails;
	}
	

}
