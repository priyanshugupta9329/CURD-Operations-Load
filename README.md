
# Project Title

This is a sample Java / Maven / Spring Boot application that can be used as a starter for creating a microservice complete with built-in health check, metrics and much more. I hope it helps you.

## How to Run
This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the java -jar command.

### Clone this repository
Make sure you are using JDK 1.8 and Maven 3.x
You can build the project and run the tests by running mvn clean package.

### Pre requisites
 => Java 17

 => PostrgeSQL (16)

Create database with name load


### Setup Guide

 1. Login to your postrege terminal and create mysql database with following command :

  
  ```http
    create database load;
  ```

2. Clone the repo and change the application.properties file


 - Change the <username> to your postrge Username

 - Change the <password> to your postrege Password

 3. Go to root directory that is ~/spring-boot-crud and run the following command

  
  ```http
    ./mvnw spring-boot:run
  ```
  

If Step 1 and 2 are properly configured, you will see Tomcat started on port(s): 8080. Now use the Postman collection mentioned at bottom to explore the APIs.
## API Reference

#### Post load

```http
  Post /load

  {
      "loadingPoint" : "delhi",
      "unloadingPoint": "jaipur",
      "productType" : "chemicals",
      "truckType": "canter",
      "noOfTrucks" :  1,
      "weight" :  "100",
      "comment" :  "  ",
      "shipperId" : "123",
      "Date" : "dd-mm-yyyy"
  }
```

| Body | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `load` | `json` | **Required**. load json |

#### Get load By LoadId

```http
  Get load/${loadId}
```

| PathVariable | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `loadId`      | `Long` | **Required**. loadId of item to fetch |


#### GET  load By shipperId

```http
  Get load/${loadId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `shipperId`      | `String` | **Required**. shipperId of load to fetch |


#### PUT - load By shipperId

```http
  Put load/${loadId}

  {
    "loadingPoint" : "alwar",
    "unloadingPoint": "jaipur",
    "productType": "chemicals",
    "truckType" : "canter",
    "noOfTrucks" :  1,
    "weight" :  "100",
    "comment" :  "  ",
    "shipperId" : "shipper:<UUID>",
    "Date" : "dd-mm-yyyy"
  }
```

| PathVariable | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `loadId`      | `String` | **Required**. loadId of load to fetch |



| Body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `load`      | `json` | **Required**. load json updated body |



#### Delete - load By loadId

```http
  Put load/${loadId}
```

| PathVariable | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `loadId`      | `String` | **Required**. loadId of load to delete |
