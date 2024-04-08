package br.com.paulohonfi.ekan.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
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
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/beneficiary")
@RequiredArgsConstructor
public class BeneficiaryController {

    private final BeneficiaryService service;

	private final BeneficiaryMapper mapper;
	
	@GetMapping()
	public List<BeneficiaryDTO> getBeneficiaries() {
		return service.findAll().stream().map(mapper::entityToDto).collect(Collectors.toList());
	}

    @GetMapping("/{id}")
	public BeneficiaryDTO getBeneficiary(@PathVariable final Long id) {
		return mapper.entityToDto(service.findById(id));
	}

	@PostMapping
	public BeneficiaryDTO create(@RequestBody final BeneficiaryDTO dto) {
		return mapper.entityToDto(service.create(mapper.dtoToEntity(dto)));
	}

	@PutMapping
	public BeneficiaryDTO update(@RequestBody final BeneficiaryDTO dto) {
		return mapper.entityToDto(service.update(mapper.dtoToEntity(dto)));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable final Long id) {
		service.delete(id);
	}
}
