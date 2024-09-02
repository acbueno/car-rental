# Car Rental CQRS Example

This project demonstrates a car rental management system implemented using the CQRS (Command Query Responsibility Segregation) pattern. It illustrates how to build a scalable and maintainable application with separate models for read and write operations.

## Overview

CQRS is a pattern that separates the data modification (commands) from the data retrieval (queries). This separation allows for optimized and scalable architecture, particularly in complex systems. This project uses Spring Boot and other technologies to illustrate the implementation of CQRS in a car rental application.

## Features

- **CQRS Implementation**: Separation of command and query responsibilities.
- **Command Handling**: Handles commands related to car rental operations.
- **Query Handling**: Handles queries for retrieving car information.
- **DTOs**: Usage of Data Transfer Objects (DTOs) for communication.
- **Mappers**: Conversion between entities and DTOs.
- **Integration Testing**: Includes unit and integration tests to ensure reliability.

## Technologies Used

- **Java**: Core programming language.
- **Spring Boot**: Framework for building the application.
- **CQRS Pattern**: Command Query Responsibility Segregation.
- **JUnit**: Framework for testing.
- **Mockito**: Framework for mocking dependencies in tests.
- **H2 Database**: In-memory database for testing.
- **Maven**: Build and dependency management.

## Project Structure

- **Command Service**: Handles commands related to car rental operations.
- **Query Service**: Handles queries for retrieving car information.
- **Repository**: Interfaces for data access.
- **DTOs**: Data Transfer Objects used to pass data between layers.
- **Mapper**: Converts between entities and DTOs.
- **Controller**: Exposes RESTful APIs for interacting with the application.

## Installation

1. **Clone the repository**:

    ```bash
    git clone https://github.com/acbueno/car-rental.git
    cd car-rental
    ```

2. **Build the project**:

    Ensure you have Maven installed. Run the following command to build the project:

    ```bash
    mvn clean install
    ```

3. **Run the application**:

    You can run the application using the Spring Boot Maven plugin:

    ```bash
    mvn spring-boot:run
    ```

## Configuration

- **Database**: The application uses an H2 in-memory database for testing. To configure a different database, modify the `src/main/resources/application.properties` file.

- **Properties**: Application configuration is found in `src/main/resources/application.properties`.

## Usage

Once the application is running, you can interact with it via RESTful APIs:

- **Commands**:
  - **Create Car**: `POST /api/commands/cars`
  - **Update Car**: `PUT /api/commands/cars/{id}`

- **Queries**:
- **Get All Cars**: Retrieve a list of all cars.
  - **Endpoint**: `GET /api/queries/cars`
  
- **Get Car by ID**: Retrieve details of a specific car by its ID.
  - **Endpoint**: `GET /api/queries/cars/{id}`

- **Get Cars by Type**: Retrieve a list of cars filtered by their type (e.g., SUV, Sedan).
  - **Endpoint**: `GET /api/queries/type/{type}`
  
- **Get Cars by Category**: Retrieve a list of cars filtered by their category (e.g., A, B, C, D).
  - **Endpoint**: `GET /api/queries/category/{category}`
  
- **Get Cars by Availability**: Retrieve a list of cars based on their availability status (e.g., available, not available).
  - **Endpoint**: `GET /api/queries/availability/{availability}`

## Running Tests

To execute the unit and integration tests, use:

```bash
mvn test
