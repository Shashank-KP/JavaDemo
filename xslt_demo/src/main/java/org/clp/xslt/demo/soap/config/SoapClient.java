package org.clp.xslt.demo.soap.config;


import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.raps.code.generate.ws.GetArticleRequest;
import com.raps.code.generate.ws.GetArticleResponse;

public class SoapClient extends WebServiceGatewaySupport {

    public GetArticleResponse getArticle(String id){
        GetArticleRequest getArticleRequest = new GetArticleRequest();
        getArticleRequest.setId(id);
        return (GetArticleResponse) getWebServiceTemplate().marshalSendAndReceive(getArticleRequest);
    }
}