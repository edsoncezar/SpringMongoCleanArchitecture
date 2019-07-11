Simple Application Microservices and MongoDB using Clean Architecture





Created in mid-2012 by Robert Cecil Martin ("Uncle Bob"), Clean Architecture has as main purposes to be independent of frameworks, easily testable, regardless of the user interface, that is, the user interface can change at will without this reflects in the rest of the system, be independent of database, since it maintains all business rules in the application itself and, finally, be independent of any external agent, and the business rules do not "see" the " outside world ".



For start my application I studied some frameworks before choose some, at the end the choose was not for performance, just for an example I choose the fasted way to developed, easy understand, easy codification and quick production instead of best performance.







You can ask me, why I would choose facility instead of performance ?


First question, do you really need a truck to load a grain of sand ? because it would support too much weight ? 







Second question , do you really need a large dam capable of damming a river for only small drops of water ? because it would be really faster?









Third question, the two above are really necessary because it would add more some grains of sand and drops of water in the future ?



Fourth question, tests are necessary ? the obviously answer is yes, because how do you would know if your program is able to run in production without a simple test in the code before ?  your code always need to be tested it would minimize all your problems with bugs







That's what I choose:



• Spring Framework



The Spring Framework is an application framework and inversion of control container for the Java platform. The framework's core features can be used by any Java application, but there are extensions for building web applications on top of the Java EE platform.



• Spring Boot



Spring Boot helps you accelerate and facilitate application development. As you read more Spring Getting Started guides, you will see more use cases for Spring Boot. It is meant to give you a quick taste of Spring Boot. If you want to create your own Spring Boot-based project, visit Spring Initializr, fill in your project details, pick your options, and you can download either a Maven build file, or a bundled up project as a zip file.



• Project Lombok



Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java, never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.



• Gatling



Over the years, Gatling has become a major reference in load testing, reaching more than 3 million downloads and hundreds of thousands of companies using our solutions.



• Docker



Docker is a set of coupled software-as-a-service and platform-as-a-service products that use operating-system-level virtualization to develop and deliver software in packages called containers.The software that hosts the containers is called Docker Engine.It was first started in 2013 and is developed by Docker, Inc.[8] The service has both free and premium tiers.





• AES 





AES (acronym of Advanced Encryption Standard) is a symmetric encryption algorithm. The algorithmwas developed by two Belgian cryptographer Joan Daemen and Vincent Rijmen. AES was designed to be efficient in both hardware and software, and supports a block length of 128 bits and key lengths of 128, 192, and 256 bits.





• MongoDB



MongoDB is a cross-platform document-oriented database program. Classified as a NoSQL database program, MongoDB uses JSON-like documents with schema. MongoDB is developed by MongoDB Inc. and licensed under the Server Side Public License (SSPL).



• JaCoCo Java Code Coverage Library



JaCoCo is a free code coverage library for Java, which has been created by the EclEmma team based on the lessons learned from using and integration existing libraries for many years.



Here some interesting links and tutorials:





https://www.baeldung.com/jacoco



https://gatling.io/docs/2.3/quickstart/



https://spring.io/guides/gs/spring-boot/



https://projectlombok.org/





Let's start about my application, just a simple project, the basic Idea is to create a micro-service to save a user and password encrypted in a NOSQL database.



I didn't create a view application, that's just a back-end service.



Like I’m using Linux Mint 19, here an introduction about how to install Docker:



https://computingforgeeks.com/install-docker-and-docker-compose-on-linux-mint-19/



And here a tutorial about how to use it with mongo:



https://hub.docker.com/_/mongo



To simplify I'm using these commands to start mongodb:



sudo docker run --name mongo -p 27017:27017 -d mongo

sudo docker exec -it mongo /bin/bash

mongo



If you need to delete the containers just open these commands in any text editor and save as file.sh and run it:





#!/bin/bash

docker stop $(docker ps -aq)

docker rm $(docker ps -aq)

docker rmi $(docker images -q)



Like I’m using REST I choose postman for the tests:



https://www.getpostman.com/



https://nationbuilder.com/how_to_test_your_app_through_postman





For start my application you just need use your preferred IDE, I’m using Eclipse, just click in the main class UsersApplication











And test it using postman and this simple json:



{

  "users":[

            {

              "user":"edson",

              "password":"123test"

            }

          ]

}





Thats the post:



http://localhost:8080/v1/users/











That’s a get example:



http://localhost:8080/v1/users/listAll







For mongodb management I’m using Robo3T https://robomongo.org/ :



