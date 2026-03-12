package com.support.incident_api.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.support.incident_api.entity.Incident;
import java.util.List;


public interface IncidentRepository extends JpaRepository<Incident,Long>
{
    List<Incident> findByStatus(String status);
}

