# springboot-mysql-hibernate-rest
# property manager web application using Spring Boot

A simple property manager application using Spring Boot with the following options:

- Spring JPA and MySQL for data persistence
- Spring MVC for the rendering.

To build and run the sample from a fresh clone of this repo:

## Configure MySQL

1. Create a database in your MySQL instance "properties_db".
2. Update the application.properties file in the `src/main/resources` folder with the URL, username and password for your MySQL instance.


## Build and run the sample

1.Open a web browser to http://localhost:8080

2. create some property by create property link

3. create some owner. to add the owner you should insert the property_id of the property which the owner owns in the property_id field

4. you can edit/delete both properties and owners

5. you can see the list of properties and list of owners
