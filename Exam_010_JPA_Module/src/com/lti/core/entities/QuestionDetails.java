package com.lti.core.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
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
	@SequenceGenerator(name="qidGen",sequenceName="qid_seq",initialValue=1,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="qidGen")
	@Column(name="QUESTION_ID")
	private int questionId;
	@Column(name="QUESTION")
	private String question;
	@Column(name="ANSWER")
	private String correctOption;
	@Column(name="DELETED")
	private String deleted;

	//mapping attributes
	//1)ExaminationDetails table exam_id
	@OneToOne( cascade=CascadeType.ALL)
	@JoinColumn(name="EXAM_ID")
	private ExaminationDetails exam;

	//2)File table 
	@ManyToOne( cascade=CascadeType.ALL)
	@JoinColumn(name="FILE_ID")
	private FileDetails fileDetails;
	
	//Constructors
	public QuestionDetails() {}

	public QuestionDetails(String question, String correctOption,ExaminationDetails exam, FileDetails fileDetails) {
		//this.questionId = questionId;
		this.question = question;
		this.correctOption = correctOption;
		this.exam = exam;
		this.fileDetails = fileDetails;
	}	

}

