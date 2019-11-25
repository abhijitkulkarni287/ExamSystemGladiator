package com.lti.core.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
Entity for storing quetionId and its options
*/

@Entity
@Table(name="QUESTIONS_CHOICES")
public class QuestionOptions 
{
	@Id
	@SequenceGenerator(name="optionIdGen",sequenceName="optionId_seq",initialValue=1,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="optionIdGen")
	@Column(name="OPTION_ID")
	private int optionId; 
	
	@Column(name="OPTIONS")
	private String option;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="QUESTION_ID")
	private QuestionDetails questionDetails;

	// Constructors
	public QuestionOptions() {
		super();
	}
	public QuestionOptions(String option) {
		this.option = option;
	}
	
	
	public QuestionOptions(String option, QuestionDetails questionDetails) {
		super();
		this.option = option;
		this.questionDetails = questionDetails;
	}
	//Getter and setter methods
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public QuestionDetails getQuestionDetails() {
		return questionDetails;
	}
	public void setQuestionDetails(QuestionDetails questionDetails) {
		this.questionDetails = questionDetails;
	}

}

