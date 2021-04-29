package org.clp.xslt.demo.soap.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;


@Configuration
public class SoapClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("com.raps.code.generate.ws");
        return jaxb2Marshaller;
    }

    @Bean
    public SoapClient articleClient(Jaxb2Marshaller jaxb2Marshaller) {
        SoapClient articleClient = new SoapClient();
        articleClient.setDefaultUri("http://localhost:9092/ws/mock");
        articleClient.setMarshaller(jaxb2Marshaller);
        articleClient.setUnmarshaller(jaxb2Marshaller);
        return articleClient;
    }
}