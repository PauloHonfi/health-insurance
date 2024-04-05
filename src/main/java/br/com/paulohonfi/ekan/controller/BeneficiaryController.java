package br.com.paulohonfi.ekan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulohonfi.ekan.model.dto.BeneficiaryDTO;
import br.com.paulohonfi.ekan.model.mapper.BeneficiaryMapper;
import br.com.paulohonfi.ekan.service.BeneficiaryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/beneficiary")
@RequiredArgsConstructor
public class BeneficiaryController {

    private final BeneficiaryService service;

	private final BeneficiaryMapper mapper;

    @GetMapping("/{id}")
	public BeneficiaryDTO getBeneficiary(@PathVariable final Long id) {
				      
		return mapper.entityToDto(service.findById(id));
	}

	@PostMapping
	public BeneficiaryDTO create(@RequestBody final BeneficiaryDTO dto) {
		return mapper.entityToDto(service.create(mapper.dtoToEntity(dto)));
	} 
}
