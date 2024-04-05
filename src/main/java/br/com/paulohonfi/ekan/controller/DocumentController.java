package br.com.paulohonfi.ekan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulohonfi.ekan.model.entity.Document;
import br.com.paulohonfi.ekan.service.DocumentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/document")
@RequiredArgsConstructor
public class DocumentController {

	private final DocumentService service;

    @GetMapping
	public String getDocument(HttpServletRequest request) {
		final HttpSession session = request.getSession();
				      
		return "Funcionou";
	}

	@PostMapping
	public Document create(final Document document) {
		return service.create(document);
	} 
}
