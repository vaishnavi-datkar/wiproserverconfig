package com.wipro.letsgo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.letsgo.entity.LetsGo;

public interface LetsGoRepo extends JpaRepository<LetsGo, Long> {

}