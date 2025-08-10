package com.wipro.subjectproducerms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.subjectproducerms.entity.Subject;
import com.wipro.subjectproducerms.service.SubjectProducerService;
@RestController
@RequestMapping("/subject")
public class SubjectProducerController {
	@Autowired
	SubjectProducerService subjectProducerService;
	
//	@PostMapping
//	public void sendLearnSubjectData(@RequestParam String subjectCode, @RequestParam String subject) {
//		SubjectProducerService.sendSubjectData(subjectCode, subject);
//	}
	
	@PostMapping
	public void sendsubjectProducerService(@RequestBody Subject subject) {
		subjectProducerService.sendsubjectProducerServiceData(subject);
	}

}
