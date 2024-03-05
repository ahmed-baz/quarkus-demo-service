package org.demo.app.mapper;


import org.mapstruct.MappingTarget;

import java.util.List;


public interface BaseMapper<E, DTO> {

    List<DTO> entityListToDtoList(List<E> entityList);

    DTO entityToDto(E e);

    E dtoToEntity(DTO dto);

    void updateEntityFromDto(DTO dto, @MappingTarget E e);

    List<E> dtoListToEntityList(List<DTO> list);

}
