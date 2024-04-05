package br.com.paulohonfi.ekan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @GetMapping
	public String getDocument(HttpServletRequest request) {
		final HttpSession session = request.getSession();
		
		// if(session.getAttribute("cart") == null) {
		// 	session.setAttribute("cart", new Cart());  
		// }
        
		return "Funcionou"; //(Cart) session.getAttribute("cart");
	}
}
