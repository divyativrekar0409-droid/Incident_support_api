package com.support.incident_api.entity;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
@Entity
public class Incident{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String serviceName;
    private String errorMessage;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;

    private String assignedEngineer;

    //constructor
    public Incident(){}

    //getters
    public Long getId()
    {return id;}

    public String getServiceName()
    { return serviceName;}

    public String getErrorMessage()
    { return errorMessage; }

    public Priority getPriority()
    {return priority; }
    
    public Status getStatus()
    {return status;}

    public LocalDateTime getCreatedAt(){
    return createdAt;   }

    public String getAssignedEngineer(){
        return assignedEngineer;
    }   

    //setters
    public void setServiceName(String serviceName)
   {this.serviceName=serviceName;}

    public void setErrorMessage(String errorMessage)
   {this.errorMessage=errorMessage;}

   public void setPriority(Priority priority)
   {this.priority=priority;}

   public void setStatus(Status status)
   {this.status=status;}
    @PrePersist
    public void setCreatedAt()
    {this.createdAt=LocalDateTime.now();}

    public void setAssignedEngineer(String assignedEngineer){
        this.assignedEngineer=assignedEngineer == null ? null : assignedEngineer.trim().toUpperCase()  ;
    }
}

