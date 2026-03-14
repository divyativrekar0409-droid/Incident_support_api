package com.support.incident_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.support.incident_api.entity.Incident;
import com.support.incident_api.service.IncidentService;
import com.support.incident_api.entity.Status;
import com.support.incident_api.entity.Priority; 
       
@RestController
@RequestMapping("/api/incidents")

public class IncidentController{
    private final IncidentService service;

    public IncidentController(IncidentService service){

        this.service=service;  
    }
@PostMapping
public Incident createIncident(@RequestBody Incident incident){
return service.createIncident(incident);

}

@GetMapping
public List<Incident> getAllIncidents(){

    return service.getAllIncidents();
}
@PutMapping("/{id}/status/{status}")
public Incident updateIncidentStatus(@PathVariable Long id,@PathVariable Status status){

    return service.updateIncidentStatus(id, status);
}



@GetMapping("/status/{status}")
public List<Incident> getIncidentsByStatus(@PathVariable Status status)
{
    return service.getIncidentsByStatus(status);
}

@GetMapping("/{id}")
public Incident getIncidentById(@PathVariable Long id){
    return service.getIncidentById(id);
}
@GetMapping("/priority/{priority}")
public List<Incident> getIncidentsByPriority(@PathVariable Priority priority){  
    return service.getIncidentsByPriority(priority);                                        


}
}
