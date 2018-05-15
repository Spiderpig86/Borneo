# Borneo

* A simple online shopping application.
* Note that DTO stands for Data Transfer Object and transfers data across servers.
* DAO stands for Data Access Objects for accessing data.
* DAOImpl will have classes that serve as the interfaces of our DAOs.

## H2 Database
* Driver class name: `org.h2.Driver`
* Database url: `jdbc:h2:tcp://localhost/~/borneodb`
* Username: `sa`
* Password: ``
* Hibernate will be used as middleware to allow us to store Java objects in a relational database.