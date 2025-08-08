package com.wipro.letsgo.service;

import com.wipro.letsgo.entity.LetsGo;
import java.util.List;

public interface LetsGoService {
    LetsGo saveMovement(LetsGo letsGo);
    List<LetsGo> findAll();
	
}
