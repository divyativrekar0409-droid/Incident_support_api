package com.support.incident_api.controller;

import com.support.incident_api.entity.Incident;
import com.support.incident_api.service.IncidentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")

public class IncidentController{
    private final IncidentService service;

    public IncidentController(IncidentService service){

        this.service=service;  
    }
@PostMapping
public Incident CreateIncident(@RequestBody Incident incident){
return service.createIncident(incident);

}

@GetMapping
public List<Incident> getAllIncidents(){

    return service.getAllIncidents();
}

}


