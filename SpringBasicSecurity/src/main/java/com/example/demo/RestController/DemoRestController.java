package com.example.demo.RestController;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoRestController {
	
	//http://localhost:8080/showMsg/chote
	//http://localhost:8080/showMsg/chote/good
	@GetMapping("/showMsg/{message}/{notice}")
	public ResponseEntity<?> getWelcomeMessage(@PathVariable String message, @PathVariable String notice) {
		
		String msg="Hi  ::"+message;
		String txt="Notice of the Day  ::"+notice;
		
		LocalDateTime ldt=LocalDateTime.now();
		System.out.println("ldt "+ldt);
		
		return ResponseEntity.ok(msg+" "+txt);
	//return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/test")
	public String getMessage() {
		return "testing git";
	}
	
	@GetMapping("/success")
	public String showText() {
		return "testing second changes";
	}
	
	//http://localhost:8080/searchDAta?searchText=vikash
	//http://localhost:8080/searchDAta?searchText=vikash&searchId=1
	@GetMapping("/searchDAta")
	public ResponseEntity<String> getGreeting(@RequestParam(value="searchText") String searchText,
			@RequestParam(value="searchId") Integer id){
		String display="Search text is ::"+searchText+" id id ::"+id;
		return ResponseEntity.ok(display);
	}
}
