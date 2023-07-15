package com.spring.ormEx;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ormDAO.BDAO;
import com.spring.ormDAO.BbsDAO;
import com.spring.ormVO.BVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	BbsDAO bbsdao;
	
	// 가져오기 :  <beans:bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
	@Autowired
	private SqlSession sqlSession;   
	
	
	// SqlSessionTemplate 을 사용하면서 필요없어짐.
//	@Autowired
//	public void setBbsDAO(BbsDAO bbsdao){
//		this.bbsdao = bbsdao;
//	}
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	/** 
	 *  회원목록 조회 접속 URL : http://localhost:8080/ormEx/list
	 *  
	 *  */
	@RequestMapping("/list")
	public String list(Model model){
		System.out.println("list() 호출");
//		ArrayList<BVO> bvos = bbsdao.list();
		BDAO bdao = sqlSession.getMapper(BDAO.class);
		model.addAttribute("list", bdao.list());
//		model.addAttribute("list", bvos);
		
		
		return "/list";
	}	
	

	/** 
	 *  회원등록 화면 접속 URL : http://localhost:8080/ormEx/writeForm
	 *  
	 *  */
	@RequestMapping("/writeForm")
	public String writeForm(){		
		return "/writeForm";
	}
	@RequestMapping("/writeOk")
	public String writeOk(HttpServletRequest req, Model model){
		BDAO bdao = sqlSession.getMapper(BDAO.class);
//		bbsdao.writeOk(req.getParameter("name"), req.getParameter("bContent") );
		bdao.writeOk(req.getParameter("name"), req.getParameter("bContent") );
		
		return "redirect:list";
	}
	
	/** 
	 *  회원 삭제 접속 URL :  http://localhost:8080/ormEx/delete
	 *  
	 *  */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest req, Model model){
		BDAO bdao = sqlSession.getMapper(BDAO.class);
		bdao.delete(req.getParameter("bId"));
		return "redirect:list";
	}
	
}
