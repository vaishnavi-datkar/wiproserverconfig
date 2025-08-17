package com.wipro.subjectproducerms.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.subjectproducerms.entity.Subject;
import com.wipro.subjectproducerms.service.SubjectProducerService;

@Service
public class SubjectPreducerServiceImpl implements SubjectProducerService{
	@Autowired
	KafkaTemplate<String, Subject> kafkaTemplate;

	@Override
	public void sendsubjectProducerServiceData(Subject subject) {
		// TODO Auto-generated method stub
		kafkaTemplate.send("learn-subject", subject);
	}

	
}
