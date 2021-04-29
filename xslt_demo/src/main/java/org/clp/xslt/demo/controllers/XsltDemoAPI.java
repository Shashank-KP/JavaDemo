package org.clp.xslt.demo.controllers;

import org.clp.xslt.demo.model.App;
import org.clp.xslt.demo.services.PojoService;
import org.greeneyed.summer.config.XsltConfiguration.XsltModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class XsltDemoAPI {

	private final PojoService pojoService;

	@RequestMapping(value = "/pullData")
	public ModelAndView testInterface() {
		App app = new App("Listing", pojoService.getPojos());
		return new XsltModelAndView("pojo-process", app);
	}
	
	@RequestMapping(value = "/pushData")
	public ModelAndView testInterface2() {
		App app = new App("Listing", pojoService.setPojos());
		return new XsltModelAndView("pojo-process", app);
	}
	
}
