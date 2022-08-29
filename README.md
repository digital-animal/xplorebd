# Instruction to run the application

    Project Name - EXPLORE BANGLADESH


## project demonstration video url

    - https://drive.google.com/file/d/1dLuwr59uUkT5YJzJxaMmUUVQHgUuuSBg/view?usp=sharing

## frameworks and tools used

    - Backend
        - SpringBoot
        - Spring Data JPA
        - Spring Security
    
    - Frontend
        - HTML, CSS
        - Thymeleaf (Template Engine)
    
    - Database
        - MySQL

## project intro presentation

    - https://docs.google.com/presentation/d/1TaOwHMjIMG9a9SC9qnaHMUJEnD8rxZ_-2XoX7uj2LuA/edit?usp=sharing

## mockui link
    
    - https://docs.google.com/presentation/d/1MyagvYjJ3x6GckQBS_1mEDIxnBzBxgJm94OVIjFR504/edit?usp=sharing

## entity relationship diagram link

    - https://drive.google.com/file/d/17kvKcsaBvpnZW3t2870zkJHnzWS0STRk/view?usp=sharing

## class diagram link

    - https://drive.google.com/file/d/1UGkmkzdAxoIavtaIO_BYK2Opzt71eN2E/view?usp=sharing

## run the following command on terminal to check java version

    java --version

## change java version in pom.xml accordingly

    <java.version>{java-version-on-system}</java.version>

## create a MySQL database connection with the following required credentials

    Connection Name: xplorebd
    Username: {your-username}
    Password: {your-password}

## browse to application.properties and edit the following fields with proper credentials

    spring.datasource.url=jdbc:mysql://localhost:3306/xplorebd
    spring.datasource.username={your-user-name}
    spring.datasource.password={your-password}

## if maven installed on system then run the following command

    mvn spring-boot:run

## if maven not installed on system then run the following command (unix)

    ./mvnw spring-boot:run

## if maven not installed on system then run the following command (windows)

    mvnw spring-boot:run

## preview project on browser by pasting the following url

    localhost:8080

## modules implemented

    - Account (Profile)
    - Tours
    - Places

## modules yet to be implemented

    - Blog (Tour Library)
    - Hotels/Restaurants