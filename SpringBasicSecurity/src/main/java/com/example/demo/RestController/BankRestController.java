package com.example.demo.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankRestController {


	@GetMapping("/")
	public String welcomePage() {
		return "Welcome to ICICI Bank";
	}
	
	
	@GetMapping("/about")
	public ResponseEntity<String> readAbout(){
		String about="ITARIUM Technologies India Pvt. Ltd. focuses on digitization, "
				+ "provides the technology platform and services to build software solutions for various business needs. "
				+ "We aim to simplify businesses by leveraging innovative products and solutions, "
				+ "solving the complex problems of our clients."
				+ " The company is led by highly experienced professionals from renowned Global Information Technology and product companies."
				+ " Drawing upon a combined professional experience of more than 45 years, "
				+ "our directors take a very hands-on approach to the business."
				+ " ITARIUM team works closely and meticulously with clients,"
				+ " to ensure we achieve an end result, that we and our clients will be proud with. "
				+ "ITARIUM has strengths in but not limited to technologies. "
				+ "Coupled with technical skills ITARIUM follows best practices in Project Management and execution, "
				+ "ensuring highest level of client satisfaction.";
		return ResponseEntity.ok(about);
	}
	//localhost:8080/login/vikashkgupta01
	/*{
	    "login": "login"
	}*/

	@GetMapping("/checkBalance")
	public String checkBalance() {
		return "Balance amount is :: 100000INR";
	}
	
	@PostMapping("/login/{useName}") 
	public ResponseEntity<HttpStatus> login(@PathVariable String useName, @RequestBody String login){
	  if(login.equals(login) && useName.equals("vikashkgupta01"))
		 return ResponseEntity.ok(HttpStatus.OK); 
	  else 
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); //(HttpStatus.OK);
	  }
	 
	@PostMapping("/transfer")
	public String fundTransfer() {
		return "Transfer initiated successfully!!!!";
	}
	
	
	/*
	 * @PostMapping("/login")
	 */
	/*
	//IMPORTANT: TWO REQUEST BODY CANNOT BE THERE< BETTER CREATE ENTITY AND BIND THEM
	public ResponseEntity<HttpStatus> login(@RequestBody String useName, @RequestBody String login){
		if(login.equals(login) && useName.equals("vikashkgupta01"))
			return ResponseEntity.ok(HttpStatus.OK);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		//(HttpStatus.OK);
	}*/
	
	@PostMapping("/check")
	public String toCheck() {
		return "all Good";
	}
}
