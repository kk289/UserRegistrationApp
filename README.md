# User Registation Application

This Java Web Application program is written in Spring IDE (STS 4). This program is able to register the user information using their first name, last name, email ID, and user ID information. After signing up, users can return to page by using their credential informations such as User ID and Password. By the way, all users' password are encrypted and restored in MySQL database.

Lets start with a new Spring Starter Project using Maven Type and Java Language. We used java version 11 in this program. The Spring boot version is 2.4.2. For this project, we used following dependencies: 

1. MySQL Driver - To store user database.

2. Spring Boot DevTools - It help to improve the development time while working with the Spring Boot application. It pick up the changes and the restart the application.

3. Spring Data JPA - It helps to access and persist data between java object/class and relational database.

4. Spring boot Web - It is better use if we want to develop a simple Spring-based application or RESTful services. 

5. Spring Security - Its operation to handle authentication and authorization at the Web request level as well as the method invocation level.

6. Thymeleaf - Java based library to create a web application.

Since we chose the following dependencies, the [pom.xml](https://github.com/kk289/UserRegistrationApp/blob/main/pom.xml) file is as follow: 

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.4.2</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.example</groupId>
	<artifactId>UserApp</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>UserApp</name>
	<description>User Registration </description>

	<properties>
		<java.version>11</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.thymeleaf.extras</groupId>
			<artifactId>thymeleaf-extras-springsecurity5</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
```

## Create Database

Setup the MySQL server and create a database to store the users information.

<p align="center">
	<img width="700px" src="screenshot/mysql.png" align="center"/>
</p>

<br>

