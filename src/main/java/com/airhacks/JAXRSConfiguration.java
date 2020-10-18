package com.airhacks;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures a JAX-RS endpoint. Delete this class, if you are not exposing
 * JAX-RS resources in your application.
 *
 * @author airhacks.com
 */
@ApplicationPath("api")
@SwaggerDefinition(info = @Info(
        title = "Mapstruct Example Service",
        description = "A simple example of mapstruct",
        version = "1.0.0",
        contact = @Contact(
                name = "Floriano Peixoto"
        )
)
)
public class JAXRSConfiguration extends Application {

}
