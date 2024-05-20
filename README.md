

---

# Learning Management System (LMS) API

Welcome to the Learning Management System (LMS) API! This API empowers educational institutions to efficiently manage exams, subjects, and students. With its intuitive endpoints and powerful features, educators can focus on delivering exceptional learning experiences.

## 🚀 Endpoints

### Students 📚

- **GET /students**: Retrieve a list of all students enrolled in the system.
  - **Description**: This endpoint returns a list of all students currently registered within the LMS.
- **GET /students/{registrationId}**: Get details of a specific student by their unique registration ID.
  - **Description**: Retrieve detailed information about a particular student using their unique registration ID.
- **POST /students**: Create a new student and add them to the system.
  - **Description**: Register a new student into the LMS by providing necessary details such as name, registration ID, etc.
- **PUT /students/{registrationId}**: Update information for an existing student.
  - **Description**: Modify the details of a student, such as their name or enrolled subjects, using their registration ID.
- **DELETE /students/{registrationId}**: Remove a student from the system.
  - **Description**: Delete a student from the LMS based on their registration ID.
- **POST /students/{registrationId}/enroll/{subjectId}**: Enroll a student in a specific subject.
  - **Description**: Add a student to a particular subject's enrollment list using their registration ID and the subject's ID.
- **POST /students/{registrationId}/register/{examId}**: Register a student for a specific exam.
  - **Description**: Register a student for a particular exam using their registration ID and the exam's ID.

### Subjects 📖

- **GET /subjects**: Explore a catalog of available subjects within the LMS.
  - **Description**: Retrieve a list of all subjects offered by the educational institution.
- **GET /subjects/{subjectId}**: Get details of a specific subject by its unique ID.
  - **Description**: Retrieve detailed information about a specific subject using its unique ID.
- **POST /subjects**: Add a new subject to the curriculum.
  - **Description**: Create a new subject and include it in the educational curriculum of the institution.
- **DELETE /subjects/{subjectId}**: Remove a subject from the curriculum.
  - **Description**: Delete a subject from the curriculum based on its unique ID.

### Exams 📝

- **GET /exams**: View all scheduled exams within the LMS.
  - **Description**: Retrieve a list of all exams scheduled within the educational institution.
- **GET /exams/{examId}**: Get details of a specific exam by its unique ID.
  - **Description**: Retrieve detailed information about a specific exam using its unique ID.
- **POST /exams**: Schedule a new exam within the LMS.
  - **Description**: Create a new exam and add it to the examination schedule of the institution.
- **DELETE /exams/{examId}**: Cancel a scheduled exam.
  - **Description**: Remove a scheduled exam from the examination schedule based on its unique ID.
- **POST /exams/{examId}/registerStudent/{registrationId}**: Register a student for a specific exam.
  - **Description**: Enroll a student for a particular exam using their registration ID and the exam's ID.

### Hidden Feature 🎉

- **GET /hidden-features/{number}**: Uncover the hidden feature! Receive intriguing facts about any number you choose.
  - **Description**: Experience a unique hidden feature of the LMS API. Discover fascinating facts about any number by simply making a request to this endpoint.

## 🛠️ Tech Stack

- **Java**: Programming language for backend development.
- **Spring Boot**: Framework for building robust and scalable Java applications.
- **MySQL**: Relational database management system for data storage.
- **Gradle**: Build automation tool for managing dependencies and building the project.
- **Postman**: API development and testing tool for testing endpoints.

## 🌟 Get Started

To start using the LMS API:

1. **Clone** this repository.
2. **Set up** your local environment with JDK, Gradle, and MySQL.
3. **Configure** application properties in `src/main/resources/application.properties`.
4. **Build and run** the application using Gradle or your preferred IDE.
5. **Access** the API endpoints using tools like Postman or your web browser.

---

