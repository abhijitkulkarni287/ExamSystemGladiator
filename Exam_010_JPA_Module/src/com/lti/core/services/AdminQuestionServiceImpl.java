package com.lti.core.services;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.lti.core.daos.ExamDao;
import com.lti.core.daos.FileDao;
import com.lti.core.daos.QuestionsDao;
import com.lti.core.entities.ExaminationDetails;
import com.lti.core.entities.FileDetails;
import com.lti.core.entities.QuestionDetails;

public class AdminQuestionServiceImpl implements AdminQuestionService 
{
	@Autowired
	private ExamDao examDao;
	private QuestionsDao questionDao;
	private FileDao fileDao;
	
	@Override
	public void addQuestionsFromFile() 
	{
		//1) Extraction of data from excel file
		try 
		{
			//excel file location
			String filePath="C:/Users/AE103_PC2/Desktop/AB NOTES/EmployeeDetails.xlsx";
			FileInputStream file = new FileInputStream(filePath);
			//getting workbook
			XSSFWorkbook questionWorkbook = new XSSFWorkbook(file);
			//getting the specific sheet in the workbook
			XSSFSheet questionSheet= questionWorkbook.getSheetAt(0);
			//creating an array list for employee details
			List<QuestionDetails> questionList = new ArrayList<QuestionDetails>();
			//extracting record from every row and inserting it into the list
			for(int i=questionSheet.getFirstRowNum()+1;i<=questionSheet.getLastRowNum();i++)
			{
				//autowire this later
				QuestionDetails questions = new QuestionDetails();
				
				
				Row row = questionSheet.getRow(i);
				System.out.println();
				for(int j=row.getFirstCellNum();j<row.getLastCellNum();j++)
				{
						Cell cell = row.getCell(j);	
							//numeric cell type
							if(cell.getCellType()==0)
							{
								//correct option can be numeric
								if(cell.getColumnIndex()==1){questions.setCorrectOption(Double.toString(cell.getNumericCellValue()));}
								
								//for adding choices if numeric
								
							}
							//alpha numeric cell type
							else
							{
								//for setting question
								if(cell.getColumnIndex()==0){questions.setQuestion(cell.getStringCellValue());}
								//for setting correctOption
								if(cell.getColumnIndex()==1){questions.setCorrectOption(cell.getStringCellValue());}
								
								//for adding choices if string
								
							}
					
				}
			}
			file.close();
			
			//printing employee list
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ExaminationDetails> showExamList() 
	{
		return examDao.fetchExamDetails();
	}

	@Override
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
