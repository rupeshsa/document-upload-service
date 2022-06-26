# Document Upload Service
Application is created using MySql Database, following table need to created.

	CREATE TABLE files (
    		id varchar(200), 
		name varchar(200),
		type varchar(200), 
		data blob,
		user varchar(45),
		comment varchar(500),
		upload_date date
	);
# Database details
	spring.datasource.url= jdbc:mysql://localhost:3306/testdb?useSSL=false
	spring.datasource.username= root
	spring.datasource.password= 123456

# Sonar lint plugin for eclipse can be used to to check code quality.

## Run application
```
mvn spring-boot:run
```
