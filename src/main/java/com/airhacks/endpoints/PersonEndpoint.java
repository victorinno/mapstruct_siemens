package com.airhacks.endpoints;

import com.airhacks.dto.PersonDto;
import com.airhacks.service.PersonService;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("persons")
@Api(value = "Persons Api")
@Produces(value = {MediaType.APPLICATION_JSON})
@Consumes(value = {MediaType.APPLICATION_JSON})
public class PersonEndpoint extends BaseEndpoint {

    @Inject
    private PersonService personService;

    @POST
    public PersonDto persist(PersonDto personDto) {
        return personService.persist(personDto);
    }

    @PUT
    public PersonDto merge(PersonDto personDto) {
        return personService.merge(personDto);
    }

    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") Long id) {
        personService.remove(id);
    }

    @GET
    @Path("/{id}")
    public PersonDto findById(@PathParam("id") Long id) {
        return personService.findById(id);
    }

    @GET
    public List<PersonDto> findByAll() {
        return personService.findByAll();
    }
}
