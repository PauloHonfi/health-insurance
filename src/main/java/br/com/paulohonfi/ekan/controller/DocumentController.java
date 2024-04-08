package br.com.paulohonfi.ekan.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulohonfi.ekan.model.dto.DocumentDTO;
import br.com.paulohonfi.ekan.model.mapper.DocumentMapper;
import br.com.paulohonfi.ekan.service.DocumentService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/document")
@RequiredArgsConstructor
public class DocumentController {

	private final DocumentService service;

    private final DocumentMapper mapper;

    @GetMapping("/{id}")
	public DocumentDTO getDocument(@PathVariable final Long id) {
		return mapper.entityToDto(service.findById(id));
	}

	@GetMapping("/beneficiary/{id}")
	public List<DocumentDTO> getDocumentByBeneficiaryId(@PathVariable final Long id) {
		return service.findByBeneficiaryId(id).stream().map( beneficiary ->
			mapper.entityToDto(beneficiary)).collect(Collectors.toList());
	}
}
