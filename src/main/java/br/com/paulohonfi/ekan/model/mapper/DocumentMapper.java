package br.com.paulohonfi.ekan.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.paulohonfi.ekan.model.dto.DocumentDTO;
import br.com.paulohonfi.ekan.model.entity.Document;

@Mapper
public interface DocumentMapper {

    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    @Mapping(target = "beneficiary", ignore = true)
    Document dtoToEntity(final DocumentDTO dto);

    DocumentDTO entityToDto(final Document entity);
}
