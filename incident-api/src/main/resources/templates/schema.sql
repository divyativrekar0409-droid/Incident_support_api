DROP TABLE IF EXISTS INCIDENT;

CREATE TABLE INCIDENT (
    id INT AUTO_INCREMENT PRIMARY KEY,
    service_name VARCHAR(255),  -- For 'payment-service'
    error_message VARCHAR(255), -- For '500 error'
    priority VARCHAR(50)        -- For 'HIGH'
);

INSERT INTO INCIDENT(SERVICE_NAME, ERROR_MESSAGE, PRIORITY) 
VALUES ('payment-service', '500 error', 'HIGH');

SELECT * FROM INCIDENT;

