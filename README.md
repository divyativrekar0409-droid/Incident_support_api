# Incident Management API

Spring Boot REST API for managing production incidents in microservices.

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Swagger OpenAPI

## Features
- Create Incident
- Get All Incidents
- Update Incident Status
- API Documentation with Swagger
- In-memory H2 database

## API Endpoints

POST /api/incidents  
Create new incident

GET /api/incidents  
Get all incidents

PUT /api/incidents/{id}  
Update incident status

## Run Application

./mvnw spring-boot:run

## Swagger UI

/swagger-ui/index.html

## H2 Console

/h2-console