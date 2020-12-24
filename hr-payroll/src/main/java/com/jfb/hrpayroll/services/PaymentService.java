package com.jfb.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import com.jfb.hrpayroll.entities.Payment;
import com.jfb.hrpayroll.entities.Worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

  @Value("${hr-worker.host}")
  private String workerHost;

  @Autowired
  private RestTemplate restTemplate;
  
  public Payment getPayment(long workerId, int days) {
    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("id", ""+workerId); // <- ;P rss

    Worker worker =  restTemplate.getForObject(workerHost + "/workers/{id}",
      Worker.class, uriVariables);
    return new Payment(worker.getName(), worker.getDailyIncome(), days);
  }

}
