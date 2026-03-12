package com.support.incident_api.service;

import com.support.incident_api.entity.Incident;
import com.support.incident_api.repository.IncidentRepository;
import org.springframework.stereotype.Service;


//import org.springframework.data.repository.support.Repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
//import java.util.Optional;
import java.util.List;




@Service
public class IncidentService{
private final IncidentRepository repository;
private static final Logger logger=
                        LoggerFactory.getLogger(IncidentService.class);

public IncidentService(IncidentRepository repository){

    this.repository=repository;

}

public Incident createIncident(Incident incident ){
   
    logger.info("creating incident for service:{}",incident.getServiceName());
    incident.setStatus("OPEN");
    incident.setCreatedAt(LocalDateTime.now());

    return repository.save(incident);
}

public List<Incident> getAllIncidents()
{ return repository.findAll();}



public Incident updateStatus(Long id,String status){
    logger.info("Updating status for incident id  {}",id );
Incident incident=repository.findById(id)
.orElseThrow(()-> new RuntimeException("Incident not found"));

incident.setStatus(status);
logger.info("Incident {} updated to status {}",id,status);
return repository.save(incident);

}

public List<Incident> getIncidentsByStatus(String status){

return repository.findByStatus(status);
}
}




