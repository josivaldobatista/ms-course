package com.jfb.hrworker.services;

import java.util.Optional;

import com.jfb.hrworker.dto.WorkerDTO;
import com.jfb.hrworker.entities.Worker;
import com.jfb.hrworker.repositories.WorkerRepository;
import com.jfb.hrworker.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WorkerService {

  @Autowired
  private WorkerRepository repository;

  @Transactional(readOnly = true)
  public Page<WorkerDTO> findAll(PageRequest pageRequest) {
    Page<Worker> list = repository.findAll(pageRequest);
    return list.map(x -> new WorkerDTO(x));
  }

  @Transactional(readOnly = true)
  public WorkerDTO findById(Long id) {
    Optional<Worker> obj = repository.findById(id);
    Worker entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada!"));
    return new WorkerDTO(entity);
  }
}
