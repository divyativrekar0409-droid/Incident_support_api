package com.support.incident_api.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.support.incident_api.entity.Incident;

public interface IncidentRepository extends JpaRepository<Incident,Long>
{
}

