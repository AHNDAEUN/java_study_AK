package com.iu.home.bankBook;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.util.CommentPager;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@PostMapping("commentUpdate")
	@ResponseBody
	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		//System.out.println(bankBookCommentDTO.getContents());
		//System.out.println(bankBookCommentDTO.getNum());
	int result =bankBookService.setCommentUpdate(bankBookCommentDTO);
	return result; // result 값을 json으로 변환해서 보내자
	}
	
	@PostMapping("commentDelete")
	@ResponseBody
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception{
	
		int result = bankBookService.setDelete(bankBookCommentDTO);
		
		return result;
	}
	
	
//	@GetMapping("commentList.iu")
//	public ModelAndView getcommentList(CommentPager commentPager) throws Exception {
//	    ModelAndView mv = new ModelAndView();	
//		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
//		System.out.println("commentList");
//		System.err.println(ar.size());// 댓글목록 담겨 있음
//		mv.addObject("cmoomentList", ar);
//		mv.setViewName("common/commentList");
//		return mv;
//	}

	
	//comment
//	@PostMapping("commentAdd")
//	public ModelAndView setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception {
//		ModelAndView mv = new ModelAndView();
//	//	System.out.println(bankBookCommentDTO.getBookNum());
//	//	System.out.println(bankBookCommentDTO.getWriter());
//	//	System.out.println(bankBookCommentDTO.getContents());
//		int result = bankBookService.setCommentAdd(bankBookCommentDTO);
//		mv.addObject("result", result);
//		mv.setViewName("common/ajaxResult");
//		return mv;
//		
//	
//	}

		@GetMapping("commentList")
		@ResponseBody
		public Map<String, Object> getcommentList(CommentPager commentPager) throws Exception {
	    ModelAndView mv = new ModelAndView();	
		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
		System.out.println("commentList");
		System.err.println(ar.size());// 댓글목록 담겨 있음
		// json
		//DTO=={}
		//num =1 == {"num":1,"bookNum":123,"writer":"name" }
		//[{}]
		// \,"" 잊지말기..★
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", ar);
		map.put("pager", commentPager);
		
		return map;
	}
	
	@PostMapping("commentAdd")
	@ResponseBody
	//응답하는 jsp에 담지않고 리턴하는 데이터를 바로 응답 바디에 담아 바로 응답으로 내보냄(리턴)
	//json타입
	public String setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setCommentAdd(bankBookCommentDTO);
		//{}
		String jsonResult="{\"result\":\""+result+"\"}";
		return jsonResult;
		
	
	}	
	
	@RequestMapping(value = "delete.iu", method = RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = bankBookService.setDelete(bankBookDTO);
		mv.setViewName("redirect:./list.iu");
		return mv;		
	}
	
	@RequestMapping(value = "update.iu", method=RequestMethod.POST)
	public String update(BankBookDTO bankBookDTO)throws Exception{
		int result = bankBookService.setUpdate(bankBookDTO);
		
		return "redirect:./detail.iu?bookNum="+bankBookDTO.getBookNum();
		
	}
	
	
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model)throws Exception{
		System.out.println(bankBookDTO.getBookNum());
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
	}
	
	// /bankbook/add POST
	// name, rate
	@RequestMapping(value="add.iu", method=RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(bankBookDTO.getBookNum());
		System.out.println(bankBookDTO.getBookSale());
		System.out.println(bankBookDTO.getBookName());
		System.out.println(bankBookDTO.getBookRate());
		Calendar ca = Calendar.getInstance();
		bankBookDTO.setBookNum(ca.getTimeInMillis());
		int result = bankBookService.setBankBook(bankBookDTO);
		
		//등록후 list 페이지로 이동
		mv.setViewName("redirect:./list.iu");
		
		return mv;
	}
	
	// /bankbook/add GET /WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value="add.iu", method=RequestMethod.GET)
	public void add()throws Exception{
		System.out.println("add 실행");
		//return "bankbook/add";
	}
	
	@RequestMapping(value="list.iu", method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		//ModelAndView mv = new ModelAndView();
		System.out.println("list 실행");
		//DB 없으신 분들
		List<BankBookDTO> ar = bankBookService.getList();

		model.addAttribute("list", ar);
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("detail 실행");
		
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		//return "bankbook/detail";
		//DB가 없으신 분들

		mv.setViewName("bankbook/detail");
		mv.addObject("dto", bankBookDTO);
		
		return mv;
	}

}
