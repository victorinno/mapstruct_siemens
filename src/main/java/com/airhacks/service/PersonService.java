package com.airhacks.service;

import com.airhacks.dto.PersonDto;
import com.airhacks.entity.Person;
import com.airhacks.mapper.PersonMapper;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.List;

@LocalBean
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PersonService extends BaseService<Person, PersonDto, Long, PersonMapper> {

    @Override
    protected Class<Person> inferClass() {
        return Person.class;
    }

    @Override
    protected PersonDto convertToDto(Person entity) {
        return mapper.toDto(entity);
    }

    @Override
    protected Person convertToEntity(PersonDto personDto) {
        return mapper.toEntity(personDto);
    }

    @Override
    protected List<PersonDto> convertToDto(List<Person> entity) {
        return mapper.toDto(entity);
    }

    @Override
    protected List<Person> convertToEntity(List<PersonDto> dto) {
        return mapper.toEntity(dto);
    }

    @Override
    protected void updateEntity(PersonDto dto, Person entity) {
        mapper.updatePersonFromPersonDto(dto, entity);
    }
}
