
PRESTA WORKFLOW AUTOMATOR API
--------------------------

INTRODUCTION
-------------

This API Has Two Microservices. 
The main microservice is Workflow-Automator and listens on port 8081
The ApprovalInitiator which listens on port 8090 Microservice Receives Approral responses when an Approval is made from

This API is built based on the technical question No. 1 whose problem statement is to implement 
a solution that manages Approval Work Flows in a Maker-Checker set up.

Technologies and Frameworks used in building the Software are:
---------------------------------------------------------------
1. Java Spring Boot - Well organised into controllers, entity, repositories with separation of concerns in the code. This makes
the code easily readable, debuggable and maintainable.
 - Moreover there is effective creation and destruction of objects in the Spring Boot Framework through Dependency Injection.
3. Postgresql - This is an open source scalable database engine that makes it easy and seamless to persist data
4. Java 8 and above features to make the code readable and easily maintainable and null-safe (i.e lambda expressions)
5. Java - Using a Functional Programming approach that makes the code more precise.
6. Java Persistence API - This Feature makes it seamles and relatively easy to connect to postgresql database server, 
define tables and relationships without having to worry too much about RAW SQL statements.

7. Lombok - This tool is very much effective in reducing boiler plate code like creation of getters and setters, constructors etc. 
- Hence Reduces time taken to write code signficantly so that one can focus more on the business logic and problem solving.

8. JUNIT and MOCKITO - These tools are very important in writing UNIT Tests to test whether the logic of the lines of code work as expected.

8. Swagger - This tool is very handy in exposing the endpoints of the API for testing purposes 
9. Docker - An Amazing tool for shipment and deployment of Software.
    (Built Image using command "mvn spring-boot:build-image")





Implementation of the Solution
------------------------------

The System has the following functionaliy
1. Create Document Types e.g Customer Registration Form
2. Read Document Types
3. Create Approvers
4. Filter Approvers based on Document Types
5. Publish Approval requests
6. View  Approval Requests
7. Filter Approval Requests
8. Approve or Reject an Request.




To Run the Application
-----------------------
1. First Create Document Types 
2. Create Approvers
3. FIlter Approvers
4. Filter Approval Requests
5. Publish Approval
6. Approve/ Reject
NOTE//
Clone the Repo, Run the application from the IDE and go to http://localhost:8081/swagger-ui.html to access the API.





