package com.wipro.subjectproducer.controller;


import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.subjectproducer.service.SubjectService;

	@RestController
	@RequestMapping("/subject")
	public class SubjectProducerController {
		@Autowired
		SubjectService subjectService;
		
		@PostMapping
		void sendSubjectData(@RequestBody Subject subject)
		{
			subjectService.sendSubjectData(suject);
		}

	}

