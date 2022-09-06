package com.iu.home.bankBook;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

@Repository
public class BankBookCommentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.home.bankBook.BankBookCommentDTO.";
	
	

	
	
 public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception{
	 
	 return sqlSession.insert(NAMESPACE+"setCommentAdd", bankBookCommentDTO);

 }
}
