package com.jfb.hrworker.resource;

import com.jfb.hrworker.dto.WorkerDTO;
import com.jfb.hrworker.services.WorkerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

  private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

  @Autowired
  private Environment env;

  @Autowired
  private WorkerService service;

  @GetMapping(value = "/configs")
  public ResponseEntity<Void> getConfigs() {
    // logger.info("CONFIG: " + testConfig);
    return ResponseEntity.noContent().build();
  }

  @GetMapping
  public ResponseEntity<Page<WorkerDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
      @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
      @RequestParam(value = "direction", defaultValue = "ASC") String direction,
      @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
    PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

    Page<WorkerDTO> list = service.findAll(pageRequest);
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<WorkerDTO> findById(@PathVariable Long id) {

    // Test de Hystrix
    /* try {
      Thread.sleep(3000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } */

    logger.info("PORT = " + env.getProperty("local.server.port"));

    WorkerDTO dto = service.findById(id);
    return ResponseEntity.ok().body(dto);
  }

}
