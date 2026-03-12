package com.support.incident_api.service;

import com.support.incident_api.entity.Incident;
import com.support.incident_api.repository.IncidentRepository;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IncidentService{
private final IncidentRepository repository;

public IncidentService(IncidentRepository repository){

    this.repository=repository;

}

public Incident createIncident(Incident incident ){
    incident.setStatus("OPEN");
    return repository.save(incident);
}

public List<Incident> getAllIncidents()
{ return repository.findAll();}
}




