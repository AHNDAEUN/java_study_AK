package com.iu.home.bankBook;

import org.springframework.beans.factory.annotation.Autowired;

import com.iu.home.MyAbstractTest;

public class BankBookCommentDAoTest extends MyAbstractTest{

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO
	
	@test
	public void setCommentAddTest()throws Exception {
		BankBookCommentDTO bankBookCommentDTO =new BankBookCommentDTO();
		bankBookCommentDTO.setWriter("reply");
		
		int result = 
	
	}
}
