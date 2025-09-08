# reqres API

## Overview

This project is a simple reqresp API. It allows users to Create reques and perform user authentication, including x-api functionalities. The API uses x-api key for securing endpoints related to reqresp creation and use store.json file to verify the response.

## Features

- **ReqResp API**: Users can create, update, delete, and retrieve details.
- **User Authentication**: Includes x-API key functionalities.


## Technologies

-RestAssured io using BDD keyword 
-Extent reports generated using aventstack reports
-Listerns used to generate the reports



## Getting Started

### Prerequisites

**Java 17+** installed → [Download Java](https://adoptium.net/)
- **Maven** installed → [Download Maven](https://maven.apache.org/download.cgi)

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

- Book Management

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



# Aman
