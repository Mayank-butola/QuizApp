Quiz and Question Microservices with API Gateway
Overview
This repository contains two microservices, "quiz-service" and "question-service," as well as an "api-gateway" that together form a quiz application using microservices architecture.

Technologies Used
Java
Spring Boot
Spring Cloud
Eureka Server
Feign for HTTP communication
API Gateway
MySQL (or your preferred database)
Other relevant libraries and tools
Microservices
1. quiz-service
Responsible for managing quizzes.
Provides APIs for creating, retrieving, and managing quizzes.
Communicates with "question-service" to fetch questions for quizzes.
2. question-service
Responsible for managing questions.
Provides APIs for creating, retrieving, and managing questions.
Stores questions in the database and associates them with quizzes.
3. api-gateway
Acts as an entry point to the microservices.
Handles routing, load balancing, and service discovery for client requests.
Provides a unified API for the quiz and question microservices.
Setup Instructions
Clone this repository to your local machine.
Make sure you have Java and Maven installed.
Set up a MySQL database and configure the database connection in each microservice's application.properties or application.yml.
Build and run the "quiz-service," "question-service," and "api-gateway" microservices.
Configure and start the Eureka Server for service registration and discovery.
Access the microservices through the API Gateway for load balancing and service discovery.
Configuration
Configure database properties, such as URL, username, and password in the application.properties files.
Configure Eureka server URL in the microservices' properties for service registration and discovery.
Customize API Gateway routing and configuration in its properties file.
Usage
Use the provided APIs to create quizzes and questions.
Interact with the services through the API Gateway for load balancing and service discovery.
Deployment
Deploy the microservices, API Gateway, and the Eureka Server to your preferred cloud or on-premises environment.
Consider containerization using Docker and orchestration with Kubernetes if needed.
Testing
Run unit and integration tests to ensure the functionality of each microservice.
Use tools like Postman or Swagger for API testing.
