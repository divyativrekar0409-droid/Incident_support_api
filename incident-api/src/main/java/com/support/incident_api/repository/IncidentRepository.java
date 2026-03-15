package com.support.incident_api.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.support.incident_api.entity.Incident;
import com.support.incident_api.entity.Priority;
import com.support.incident_api.entity.Status;

public interface IncidentRepository extends JpaRepository<Incident,Long>
{
    List<Incident> findByStatus(Status status);
    List<Incident> findByPriority(Priority priority);
    @Override
    Page<Incident> findAll(Pageable pageable);
    List<Incident> findByAssignedEngineer(String assignedEngineer);
}

