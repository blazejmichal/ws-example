package com.example.configuration;

import com.example.service.PersonServiceImpl;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.apache.cxf.jaxws.EndpointImpl;

@Configuration
@ImportResource({"classpath:META-INF/cxf/cxf.xml" })
public class CxfWebServiceConfig {

    @Autowired
    private Bus cxfBus;

    @Bean
    public ServletRegistrationBean cxfServlet(
        @Value("${url-mapping}") String urlMapping
    ) {
        CXFServlet cxfServlet = new CXFServlet();
        ServletRegistrationBean servletDef = new ServletRegistrationBean<>(
            cxfServlet,
            urlMapping
        );
        servletDef.setLoadOnStartup(1);
        return servletDef;
    }
 
    @Bean
    public Endpoint personService(
        PersonServiceImpl personService
    ) {
        EndpointImpl endpoint = new EndpointImpl(
            this.cxfBus,
            personService
        );
        endpoint.setAddress("/person");
        endpoint.publish();
        return endpoint;
    }

}