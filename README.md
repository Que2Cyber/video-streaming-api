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
- [Contributing](#contributing)
- [License](#license)

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
