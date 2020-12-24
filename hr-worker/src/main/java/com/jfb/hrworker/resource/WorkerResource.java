package com.jfb.hrworker.resource;

import java.util.List;

import com.jfb.hrworker.entities.Worker;
import com.jfb.hrworker.repositories.WorkerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

  @Autowired
  private WorkerRepository repository;

  @GetMapping
  @Transactional(readOnly = true)
  public ResponseEntity<List<Worker>> findAll() {
    List<Worker> list = repository.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Worker> findById(@PathVariable Long id) {
    Worker obj = repository.findById(id).get();
    return ResponseEntity.ok().body(obj);
  }

}
