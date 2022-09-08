package com.iu.home.bankBook;

import java.util.List;

import javax.swing.event.ListSelectionListener;

import org.apache.ibatis.ognl.ASTSelectLast;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.bankMembers.BankMembersDTO;
import com.iu.home.util.CommentPager;

@Repository
public class BankBookCommentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.home.bankBook.BankBookCommentDTO.";
	
	
	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO)throws Exception {
		return sqlSession.update(NAMESPACE+"setCommentUpdate", bankBookCommentDTO);
	}
	public Long getCommentListTotalCount( CommentPager commentPager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getCommentListTotalCount",commentPager);
	}
 public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception{
	 
	 return sqlSession.insert(NAMESPACE+"setCommentAdd", bankBookCommentDTO);

 }
 
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager) throws Exception{
		
	 return sqlSession.selectList(NAMESPACE+"getCommentList", commentPager);
	}

}
