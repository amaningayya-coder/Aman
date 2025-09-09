# reqres API Management


## Overview

This project is a **Rest Assured API Automation Framework** using **TestNG** for testing RESTful web services.  
It supports:
- GET, POST, PUT, DELETE HTTP requests
- Authentication (x-api key)
- JSON validation
- Data-driven testing(Created Pojo class)
- Logging and reporting with Extent Reports
## Features

- **ReqResp API**: Users can create, update, delete, and retrieve details.
- **User Authentication**: Includes x-API key functionalities.


## Technologies

-RestAssured io using BDD keyword 
-Extent reports generated using aventstack reports
-Listerns used to generate the reports



## Getting Started


###Prerequisites
- Java 11 or 17
- Maven 3.x
- IDE: Eclipse / IntelliJ IDEA
- TestNG
- Rest Assured
- Optional: Allure / Extent Reports

### Installation

1. Clone the repository:
    ```bash
    git https://github.com/amaningayya-coder/Aman.git
    ```

2. run the required json file:

    ```cmd
      json-server store.json
    ```


    ```

2. The API will be available at `https://reqres.in/api`

### API Endpoints

- ResResp API Management

    - POST /users: Create a new request.
    - PUT /users/{id}: Update a request by ID.
    - DELETE /users/{id}: Delete a request by ID.
    - GET /users?page=2: Get page 2 response.

- Health Check
    - GET /health: Check the health of the API.

Run tests with Maven:

mvn clean test

Run a specific suite with TestNG:

mvn -Dtestng.xml suite.xml test

#Contributing

Fork the repository

Create a new branch (git checkout -b feature-name)

Commit your changes (git commit -m "message")

Push to branch (git push origin feature-name)

Create a Pull Request



# Aman
