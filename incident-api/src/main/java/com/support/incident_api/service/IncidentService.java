package com.support.incident_api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.support.incident_api.entity.Incident;
import com.support.incident_api.repository.IncidentRepository;
import com.support.incident_api.entity.Status;
import com.support.incident_api.entity.Priority;

//import jakarta.annotation.Priority;




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
    incident.setStatus(Status.OPEN);
    incident.setCreatedAt(LocalDateTime.now());

    return repository.save(incident);
}

public List<Incident> getAllIncidents(){
     return repository.findAll();
     }



public Incident updateIncidentStatus(Long id,Status status){
    logger.info("Updating status for incident id  {}",id );
    Incident incident=repository.findById(id)
        .orElseThrow(()-> new RuntimeException("Incident not found"+ id));

    incident.setStatus(status);
    logger.info("Incident {} updated to status {}",id,status);

    return repository.save(incident);

}

public List<Incident> getIncidentsByStatus(Status status){
    List<Incident> list=repository.findByStatus(status);
    logger.info("Incidents found with status: {}",status);
    if(list.isEmpty()){
     throw new RuntimeException("No incidents found with status: "+status);   }
     logger.info("No incidents found with status: {}",status);

    return list;
    
}
public Incident getIncidentById(Long id){
    logger.info("Incident found with id: {}",id);
    return repository.findById(id)
    .orElseThrow(()-> {
        logger.error("Incident not found with id: {}",id);
        return new RuntimeException("Incident not found with id: "+id);
    });
}

public List<Incident> getIncidentsByPriority(Priority priority){
        logger.info("Incidents found with priority: {}",priority);
        List<Incident> list=repository.findByPriority(priority);
        if(list.isEmpty()){
            throw new RuntimeException("No incidents found with priority: "+priority);
                
    }
    return list;
}
}