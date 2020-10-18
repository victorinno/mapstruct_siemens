package com.airhacks.mapper;

import com.airhacks.dto.PersonDto;
import com.airhacks.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface PersonMapper {
    PersonDto toDto(Person person);

    Person toEntity(PersonDto personDto);

    void updatePersonFromPersonDto(PersonDto personDto, @MappingTarget Person person);

    List<PersonDto> toDto(List<Person> person);

    List<Person> toEntity(List<PersonDto> personDto);
}
