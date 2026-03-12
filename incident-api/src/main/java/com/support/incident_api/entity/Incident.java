package com.support.incident_api.entity;
import jakarta.persistence.Entity;
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
    private String priority;
    private String status;

    public Long getId()
    {return id;}

    public String getServiceName()
    { return serviceName;}

    public String getErrorMessage()
    { return errorMessage; }

    public String getPriority()
    {return priority; }
    
    public String getStatus()
    {return status;}

    public void setServiceName(String serviceName)
   {this.serviceName=serviceName;}

    public void setErrorMessage(String errorMessage)
   {this.errorMessage=errorMessage;}

   public void setPriority(String priority)
   {this.priority=priority;}

   public void setStatus(String status)
   {this.status=status;}

}

