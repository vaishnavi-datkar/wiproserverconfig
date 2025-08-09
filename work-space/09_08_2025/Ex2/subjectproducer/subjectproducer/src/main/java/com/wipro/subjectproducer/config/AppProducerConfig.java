package com.wipro.subjectproducer.config;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.Subject;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class AppProducerConfig {
	
	
	//@Bean
   // public ProducerFactory<String, String> producerFactory() {
    //    Map<String, Object> props = new HashMap<>();
    //.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
     //   props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
     //   props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
      //  return new DefaultKafkaProducerFactory<>(props);
    //}

  //  @Bean
  //  public KafkaTemplate<String, String> kafkaTemplate() {
      //  return new KafkaTemplate<>(producerFactory());
    //}
	@Bean
    public ProducerFactory<String, Subject> producerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String, Subject> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}