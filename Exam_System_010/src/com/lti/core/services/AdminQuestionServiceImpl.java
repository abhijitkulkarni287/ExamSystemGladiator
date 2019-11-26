package com.lti.core.services;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.core.daos.ExamDao;
import com.lti.core.daos.FileDao;
import com.lti.core.daos.QuestionsDao;
import com.lti.core.entities.ExaminationDetails;
import com.lti.core.entities.FileDetails;
import com.lti.core.entities.QuestionDetails;
import com.lti.core.entities.QuestionOptions;

@Service("adminService")
public class AdminQuestionServiceImpl implements AdminQuestionService 
{
	@Autowired
	private ExamDao examDao;
	@Autowired
	private QuestionsDao questionDao;
	@Autowired
	private FileDao fileDao;
	
	@Override
	@Transactional
	public void addQuestionsFromFile(String path) 
	{
		List<QuestionDetails> questionList = new ArrayList<QuestionDetails>();
		List<QuestionOptions> questionOptionsList= new ArrayList<QuestionOptions>();	
		System.out.println(path);
		FileDetails fileDetails = new FileDetails( "abaaac.xlsx");
		ExaminationDetails examDetails = new ExaminationDetails(113, "dbms", 60, 40);
		
		//1) Extraction of data from excel file
		//excel file location
		try {
			
		String filePath=path;
		FileInputStream file = new FileInputStream(filePath);
		//getting workbook
		XSSFWorkbook questionWorkbook = new XSSFWorkbook(file);
		//getting the specific sheet in the workbook
		XSSFSheet questionSheet= questionWorkbook.getSheetAt(0);

		String questionStr="";
		String correctOption="";
		String option="";
		
		//extracting record from every row and inserting it into the list
		for(int i=questionSheet.getFirstRowNum()+1;i<=questionSheet.getLastRowNum();i++)
		{
			QuestionDetails questionDetails = new QuestionDetails();
			questionDetails.setExam(examDetails);
			questionDetails.setFileDetails(fileDetails);
				
			Row row = questionSheet.getRow(i);
			System.out.println();
			for(int j=row.getFirstCellNum();j<row.getLastCellNum();j++)
			{			
					QuestionOptions questionOption = new QuestionOptions();
					Cell cell = row.getCell(j);			
					
						if(cell.getCellType()==0)        //numeric cell type
						{							
							if(cell.getColumnIndex()==1)       //correct option can be numeric
							{
								correctOption = Double.toString(cell.getNumericCellValue());	
								questionDetails.setCorrectOption(correctOption);
							}													
							if(cell.getColumnIndex()>1)        	//for adding choices if numeric
							{
								option = Double.toString(cell.getNumericCellValue());
								questionOption.setOption(option);
								questionOption.setQuestionDetails(questionDetails);
							}							
						}
						
						else       //alpha numeric cell type
						{							
							if(cell.getColumnIndex()==0)      //for setting question
							{
								//questionStr = cell.getStringCellValue();		
								questionDetails.setQuestion( cell.getStringCellValue() );
							}							
							if(cell.getColumnIndex()==1)        //for setting correctOption
							{
								questionDetails.setCorrectOption( cell.getStringCellValue() );								
							}														
							if(cell.getColumnIndex()>1)     //for adding choices if string
							{
								option = cell.getStringCellValue();
								questionOption.setOption(option);
								questionOption.setQuestionDetails(questionDetails);
							}								
						}	
						questionOptionsList.add(questionOption);
			}
			questionList.add(questionDetails);
			
		}
		file.close();			
		
	}    
	catch(Exception e) 
	{
		e.printStackTrace();
	}
	
	   questionDao.insertQuestions(examDetails, fileDetails, questionList, questionOptionsList );
		
}

	@Override
	public List<ExaminationDetails> showExamList() 
	{
		return examDao.fetchExamDetails();
	}

	@Override
	@Transactional
	public void removeQuestionsFromFile(String fileName) 
	{
		questionDao.deleteQuestions(fileName);
	}

	@Override
	public List<FileDetails> showFileList() 
	{
		return fileDao.fetchFileDetails();
	}

}
