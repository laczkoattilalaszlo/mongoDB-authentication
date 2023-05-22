# Spring Data MongoDB with Authentication

### About the project
This is a demo project for representing how to connect mongoDB with authentication to a Kotlin Spring Boot application.
* Dependencies used: Spring Web (Spring MVC), Spring Data MongoDB
* The application uses docker-compose.yaml file to deploy a mongoDB instance.
* The application uses authentication to acces the mongoDB.

### Build and Run
1. Run docker-compose.yaml file to build up a mongoDB service with an admin user!
2. Run createMongoDbUser.sh file to create a user to be able to login with Spring Boot!
3. Run the Spring Boot application!
4. Read/Write data to/from the database with the help of the EmployeeController class!