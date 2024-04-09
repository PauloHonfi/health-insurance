package br.com.paulohonfi.ekan.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.paulohonfi.ekan.model.dto.BeneficiaryDTO;
import br.com.paulohonfi.ekan.model.entity.Beneficiary;

@Mapper
public interface BeneficiaryMapper {

    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    @Mapping(source = "documents", target = "documents")
    Beneficiary dtoToEntity(final BeneficiaryDTO dto);

    BeneficiaryDTO entityToDto(final Beneficiary entity);
}
