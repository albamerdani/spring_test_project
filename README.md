# spring_test_project

SpringBoot REST API(POST, PUT, GET, DELETE) with CRUD (create, read, update, delete) functionalities for two entities/tables related with each-other that works for authorized users.
Organized with packages: model (for entities), controller (for CRUD), repository (for service), config (for swagger documentation and security configurations).
It is used MySQL database 5.7. All properties for datasource, jpa, logs, security, actuator endpoints are set in application.properties file.

To be able to containerize the springboot application it is included a Dockerfile with needed steps and commands.
We can use docker build -t image_name to build the docker image and then docker run image_name to run the application in container.
