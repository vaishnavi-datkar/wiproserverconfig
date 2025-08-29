package com.wipro.subjectproducer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.subjectproducer.service.SubjectService;
@Service
public class SubjectServiceImpl implements SubjectService{
	@Autowired
	KafkaTemplate<String,String> kafkTemplate;

	@Override
	public void sendSubjectData(String subjectId, String subjectName) {
		// TODO Auto-generated method stub
		kafkTemplate.send("subjectId","subjectName");
	}
	
}
