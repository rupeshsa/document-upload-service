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


## Run application
```
mvn spring-boot:run
```
