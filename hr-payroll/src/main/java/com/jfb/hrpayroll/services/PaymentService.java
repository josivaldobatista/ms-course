package com.jfb.hrpayroll.services;

import com.jfb.hrpayroll.entities.Payment;
import com.jfb.hrpayroll.entities.Worker;
import com.jfb.hrpayroll.feignclients.WorkerFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  @Autowired
  private WorkerFeignClient workerFeignClient;
  
  public Payment getPayment(long workerId, int days) {
    
    Worker worker = workerFeignClient.findById(workerId).getBody();
    return new Payment(worker.getName(), worker.getDailyIncome(), days);
  }

}
