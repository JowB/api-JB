package com.jb.apijb.generic;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenericMappingService<DTO, ENTITY> {

    private final ModelMapper modelMapper;

    public GenericMappingService(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    protected ENTITY mapToEntity(DTO dto, Class<ENTITY> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    protected DTO mapToDto(ENTITY entity, Class<DTO> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    protected List<DTO> mapListToDto(List<ENTITY> entityList, Class<DTO> dtoClass) {
        return entityList
                .stream()
                .map(element -> modelMapper.map(element, dtoClass))
                .collect(Collectors.toList());
    }

}
