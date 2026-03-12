package com.support.incident_api.entity;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Incident{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String serviceName;
    private String errorMessage;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    private String status; 

    private LocalDateTime createdAt;

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
    
    public String getStatus()
    {return status;}

    public LocalDateTime getCreatedAt(){
    return createdAt;   }

    //setters
    public void setServiceName(String serviceName)
   {this.serviceName=serviceName;}

    public void setErrorMessage(String errorMessage)
   {this.errorMessage=errorMessage;}

   public void setPriority(Priority priority)
   {this.priority=priority;}

   public void setStatus(String status)
   {this.status=status;}

  public void setCreatedAt(LocalDateTime createdAt)
    {this.createdAt=createdAt;}
}

