# Video Streaming API

This Java backend application provides an API for a video streaming platform. It allows users to publish videos, manage video metadata, track user engagement, and more.

## Table of Contents
- [Requirements](#requirements)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Building and Running](#building-and-running)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Documentation](#documentation)
- [Assumptions](#assumptions)

## Requirements
- Java Development Kit (JDK) 17 or higher
- Spring Boot 2.7 or higher
- Maven or Gradle for dependency management
- Database or datastore (e.g., MySQL, H2) for data persistence

## Getting Started

1. Clone this repository:

   ```sh
   git@github.com:Que2Cyber/video-streaming-api.git
   cd video-streaming-api

1. Set up your database:
If using H2 (in-memory database), no additional setup is required.
If using MySQL or another database, create a database and update the configuration in src/main/resources/application.properties.

## Configuration
Database Configuration: Update the database connection details in src/main/resources/application.properties.

Logging Configuration: Adjust logging levels in src/main/resources/application.properties to suit your needs.

## Building and Running
Using Maven
To compile and run the application using Maven:

1. Navigate to the project directory.
2. Run the following command:
   mvn spring-boot:run
The application will start on port 8080 by default.

Using Gradle
To compile and run the application using Gradle:

1. Navigate to the project directory.
2. Run the following command:
   ./gradlew bootRun
The application will start on port 8080 by default.

## API Endpoints
- /api/videos/publish: POST request to publish a new video.
- /api/videos/edit/{videoId}: PUT request to edit video metadata.
- /api/videos/delist/{videoId}: DELETE request to soft delete a video.
- /api/videos/load/{videoId}: GET request to load video metadata and content.
- /api/videos/play/{videoId}: GET request to play a video.
- /api/videos/list: GET request to list all available videos.
- /api/videos/search: GET request to search for videos by criteria.
- /api/videos/engagement/{videoId}: GET request to retrieve engagement statistics for a video.

## Testing
We use JUnit and Mockito for unit testing and H2 (in-memory database) for database integration testing. To run the tests:

- For unit tests:
mvn test
- For integration tests:
  mvn test -P integration-tests

## Assumptions
To provide context and clarify certain aspects of this project, I have made the following assumptions during development:

1. Authentication and Authorization: I assumed that authentication and authorization mechanisms are handled by an external system (e.g., OAuth or Single Sign-On). The API endpoints do not include authentication and authorization logic. Please integrate the appropriate security measures as needed.

2. Database Choice: I assumed that you have configured an appropriate database for the application, such as H2, MySQL, or another compatible database system. The application's database schema will be automatically updated if using H2 with the provided configuration.

3. Deployment Environment: I assumed that you will deploy this application in a suitable environment for a production-ready solution. Make sure to consider factors like server resources, load balancing, and scalability.

4. Error Handling: While I have implemented basic error handling, I assumed that it will be extended according to specific error reporting and logging requirements.

5. User Interface (UI): This project focuses on the backend API. I assume that a separate frontend application will interact with this API to provide a user interface for content managers and users.

6. Performance Testing: Performance testing and optimization are beyond the scope of this project. I recommend conducting thorough performance tests in a production environment to ensure the system meets  performance requirements.

7. Data Volume: This application is designed for moderate data volumes. If you expect high data volumes, consider additional optimizations and database scaling.

8. Data Security: Data encryption and security measures are not explicitly addressed in this project's scope. One should implement encryption and security protocols appropriate for their use case.

9. Monitoring and Alerting: I assumed there is a monitoring and alerting system in place to detect and respond to issues in a production environment.
