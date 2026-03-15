package com.support.incident_api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.support.incident_api.entity.Incident;
import com.support.incident_api.entity.Priority;
import com.support.incident_api.entity.Status;
import com.support.incident_api.repository.IncidentRepository;

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
    if(incident.getStatus()==null){
        incident.setStatus(Status.OPEN);
    }
   // incident.setCreatedAt(LocalDateTime.now());

    return repository.save(incident);
}

public List<Incident> getAllIncidents(){
     return repository.findAll();
     }



@SuppressWarnings("static-access")
public Incident updateIncidentStatus(Long id,Status status){
    logger.info("Updating status for incident id  {}",id );
    Incident incident=repository.findById(id)
        .orElseThrow(()-> new RuntimeException("Incident not found: "+ id));
    if(incident.getStatus()==status.RESOLVED){
        logger.warn("Incident {} is already resolved",id);
        throw new RuntimeException("Incident is already resolved: "+ id);
    }   
    incident.setStatus(status);
    logger.info("Incident {} updated to status {}",id,status);

    return repository.save(incident);

}

public List<Incident> getIncidentsByStatus(Status status){
    List<Incident> list=repository.findByStatus(status);
    logger.info("Incidents found with status: {}",status);
    if(list.isEmpty()){
        logger.info("No incidents found with status: {}",status);
     throw new RuntimeException("No incidents found with status: "+status);  
      }
     

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


public Page<Incident> getAllIncidents(Pageable pageable){
    logger.info("Retrieving all incidents with pagination: page {}, size {}", pageable.getPageNumber(), pageable.getPageSize());
    return repository.findAll(pageable);
}


public Incident assignEngineerIncident(Long id,String assignedEngineer)
{
    Incident incident=repository.findById(id)
    .orElseThrow(()-> new RuntimeException("Incident not found: "+ id));    
    incident.setAssignedEngineer(assignedEngineer.toUpperCase());
    logger.info("Incident {} assigned to engineer {}",id,assignedEngineer); 
    return repository.save(incident);
}

public List<Incident> getIncidentsByEngineer(String assignedEngineer){
    logger.info("Incidents found assigned to engineer: {}",assignedEngineer);
    List<Incident> list=repository.findByAssignedEngineer(assignedEngineer);
    if(list.isEmpty()){
        throw new RuntimeException("No incidents found assigned to engineer: "+assignedEngineer);
    }
    return list;
}
}