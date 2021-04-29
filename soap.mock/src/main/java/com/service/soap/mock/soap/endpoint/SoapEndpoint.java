package com.service.soap.mock.soap.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.clp.code.generate.ws.Article;
import com.clp.code.generate.ws.GetArticleRequest;
import com.clp.code.generate.ws.GetArticleResponse;
import com.clp.code.generate.ws.ObjectFactory;

@Endpoint
public class SoapEndpoint {

	@ResponsePayload
    @PayloadRoot(namespace = "https://medium.com/article", localPart = "getArticleRequest")
    public GetArticleResponse addition(@RequestPayload GetArticleRequest input){
        System.out.println("Request received for addition with input "+input);
        ObjectFactory objectFactory = new ObjectFactory();
        GetArticleResponse output = objectFactory.createGetArticleResponse();
        Article ob=objectFactory.createArticle();
        ob.setId("12");
        ob.setName("CLP");
        output.setArticle(ob);
        return output;
    }
}
