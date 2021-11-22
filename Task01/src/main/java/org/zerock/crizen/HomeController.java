package org.zerock.crizen;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	

	@RequestMapping(value = "/hello.do", method = RequestMethod.GET)
	public String home() {
	
//		Date date = new Date();
//		DateFormat dateFormat = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss");
		
//		int hour = date.getHours();
//		String comment = hour>=0 && hour<12 ? "좋은 아침!" : hour>=12 && hour<18? "활기찬 오후!" : "잘자요!";  
	
//		String formattedDate = dateFormat.format(date);
//		model.addAttribute("serverTime", formattedDate );
//		model.addAttribute("comment", comment );		
		return "hello";	
	}
	
}
