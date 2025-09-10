**This is the Spring Boot backend service for the Quiz Application. It provides RESTful APIs for managing quizzes and questions, including:**

1) Creating and storing quizzes with multiple questions.
2) Fetching quiz questions based on categories and difficulty levels.
3) Submitting quiz responses and calculating user scores.
4) Data persistence with PostgreSQL (or configured database).
5) Basic exception handling and response management.

**Technologies Used**

1) Java 17
2) Spring Boot 3.x
3) Spring Data JPA with PostgreSQL
4) Maven build tool
5) REST API design principles
6)Lombok for reducing boilerplate code

**Features**

1) CRUD operations for quiz and question management.
2) Randomized question selection by category.
3) Graceful error responses and HTTP status codes.
4) Easily extensible for features like authentication and analytics.


**STEP BY STEP GUIDE**
----------------------

**Prerequisites**
a) Java JDK 17 or higher installed (check with java -version)
b) Maven installed (check with mvn -v)
c) PostgreSQL or configured database running locally or accessible remotely
d) Optional: An IDE like IntelliJ IDEA for easier development

Step 1: **Clone the Repository**
git clone https://github.com/<your-username>/quiz-app-backend.git
cd quiz-app-backend

Step 2: **Configure Database**
a) Install and start PostgreSQL (or your used DB).
b) Create a database, **e.g., questiondb**.
c) Update **src/main/resources/application.properties** with your DB connection details:

spring.datasource.url=jdbc:postgresql://localhost:5432/questiondb
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Step 3: **Build and Run the App**
./mvnw spring-boot:run
(on Windows, use mvnw.cmd spring-boot:run)

Step 4: **Verify the Backend**
a) Backend runs by default on **http://localhost:8080**
b) Test endpoints in browser or tools like Postman:
Example: http://localhost:8080/quiz/get/1

Step 5: **Connect Frontend**
Update Angular frontend's API URL (in quiz.service.ts) to point to your backend URL, e.g., http://localhost:8080/quiz.

**Troubleshooting**
Ensure PostgreSQL is running and accessible.
Check for firewall or port conflicts.
Consult logs for errors (console or logs folder).



**POSTGRESQL queries**
1)**Create Database** 
CREATE DATABASE quizdb;
2) **Connect to database**
\c quizdb;
3) **Create table**
CREATE TABLE questions (
    id SERIAL PRIMARY KEY,
    category VARCHAR(100) NOT NULL,
    difficulty_level VARCHAR(50) NOT NULL,
    option1 VARCHAR(255) NOT NULL,
    option2 VARCHAR(255) NOT NULL,
    option3 VARCHAR(255) NOT NULL,
    correct_answer VARCHAR(255) NOT NULL
);
4)**Insert questions **
INSERT INTO questions (question_title, category, difficulty_level, option1, option2, option3, correct_answer)
VALUES
-- Basic
('What type of programming does Java follow?', 'Java', 'Basic', 'Object-Oriented Programming', 'Functional Programming', 'Procedural Programming', 'Object-Oriented Programming'),
('What does JVM do in Java?', 'Java', 'Basic', 'JVM executes bytecode', 'JDK is only for running Java programs', 'JRE contains compiler', 'JVM executes bytecode'),
('Which is true about String in Java?', 'Java', 'Basic', 'String is immutable', 'String is mutable', 'StringBuilder is immutable', 'String is immutable'),
('Which of these is a primitive type in Java?', 'Java', 'Basic', 'int is primitive', 'Integer is primitive', 'char is non-primitive', 'int is primitive'),
('Which of the following is true about constructors?', 'Java', 'Basic', 'Constructor has no return type', 'Constructor can return values', 'Constructor is a normal method', 'Constructor has no return type'),

-- Advanced
('Which is true about HashMap in Java?', 'Java', 'Advanced', 'HashMap allows one null key', 'HashSet allows duplicate elements', 'TreeMap allows multiple null keys', 'HashMap allows one null key'),
('What does polymorphism mean in Java?', 'Java', 'Advanced', 'Polymorphism = Same name, different forms', 'Encapsulation exposes data directly', 'Inheritance prevents reuse', 'Polymorphism = Same name, different forms'),
('What is the role of Garbage Collector in Java?', 'Java', 'Advanced', 'Garbage collector manages memory', 'Programmer explicitly frees memory in Java', 'Memory is never freed', 'Garbage collector manages memory'),
('Which is true about abstract classes in Java?', 'Java', 'Advanced', 'Abstract class can have both abstract and concrete methods', 'Interface cannot have default methods', 'Abstract class cannot have variables', 'Abstract class can have both abstract and concrete methods'),
('Which keyword is used for thread safety in Java?', 'Java', 'Advanced', 'Synchronized keyword is used for thread safety', 'Threads never need synchronization', 'Java does not support multithreading', 'Synchronized keyword is used for thread safety');

5**)Verify inserted data **
SELECT * FROM questions;







