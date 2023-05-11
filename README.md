# rnd-spring-boot-3

##General Info, this project using :
1. Java JDK 17.
2. Java Spring Boot 3.1.0-SNAPSHOT version.
3. Maven 3.9.1.

## Library :
1. Spring Web.
2. Spring Boot DevTools.
3. Lombok.
4. Spring Data JPA.
5. H2 Database.
6. Gson.
7. Apache POI.
8. openapi (swagger3).
9. jUnit5.

## Rules :
1. Import the postman collection from postman-collection folder in this project to your postman.
2. mvn spring-boot:run : Use this script for running this project using CMD / Terminal.
3. Open http://localhost:8080/h2-console in your browser for checking Memory databse.
4. Open http://localhost:8080/swagger-ui/index.html in your browser for opening swagger.
5. Open http://localhost:8080/api-docs in your browser for opening API docs.

## I provide some services:
1. Insert Car List into DB (http://localhost:8080/api/saveCars) -> using form-data, and you can upload the raw data in csv in raw-data folder)
2. Get Car List in DB (http://localhost:8080/api/getAllCar)
3. Generate Excel in Backgrond process (http://localhost:8080/report/generate)


# gRPC
## Library
1. GRPC Spring Boot Starter.
2. Grpc Stub.
3. Grpc Protobuf.
4. Javax Anotation.

Medium : https://medium.com/@septianrezaa/tutorial-membuat-grpc-crud-dengan-java-17-dan-springboot-3-127aefd9e742 
