package org.clp.xslt.demo.services;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Arrays;
import java.util.List;

import org.clp.xslt.demo.model.MyPojo;
import org.clp.xslt.demo.soap.config.SoapClient;
import org.clp.xslt.demo.soap.config.SoapClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.raps.code.generate.ws.Article;
import com.raps.code.generate.ws.GetArticleRequest;
import com.raps.code.generate.ws.GetArticleResponse;

import org.clp.xslt.demo.source.adms.*;
import org.clp.xslt.demo.dest.oop.*;

@Service
public class PojoService {
	@Autowired
	private PullDataRepository pullDataRepository;
	@Autowired
	private PushDataRepository pushDataRepository;
	
	public List<MyPojo> getPojos() {
		List<MyPojo> result = new ArrayList<>();
		List<PullData> records = new ArrayList<>();
		/*
		 * pullDataRepository.findAll().forEach(records::add); // transform here if
		 * needed for(PullData record : records){ result.add(new
		 * MyPojo(record.getId().toString(), record.getName())); } return result;
		 */
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SoapClientConfig.class);
		SoapClient articleClient = annotationConfigApplicationContext.getBean(SoapClient.class);
		Article article=articleClient.getArticle("1").getArticle();
		result.add(new MyPojo(article.getId(), article.getName()));
		System.out.println(article.getId() + "-------" +  article.getName());
		//return Arrays.asList(new MyPojo("anId", "aName"), new MyPojo("anotherId", "anotherName"));
		return result;
	}
	
	public List<MyPojo> setPojos() {
		List<MyPojo> result = new ArrayList<>();
		List<PushData> records = new ArrayList<>();		
		// pretending the transformation is taken care by Dell Boomi...
		records.add(new PushData(4, "Push Object 4"));
		records.add(new PushData(5, "Push Object 5"));
		pushDataRepository.save(records);
		for(PushData record : records){
            result.add(new MyPojo(record.getId().toString(), record.getName()));
        }
		return result;
		//return Arrays.asList(new MyPojo("anId", "aName"), new MyPojo("anotherId", "anotherName"));
	}
}
