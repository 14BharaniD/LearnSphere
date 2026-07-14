# 🎓 LearnSphere - Learning Management System

> A full-stack Learning Management System (LMS) built with Spring Boot, Spring Security, Thymeleaf, and MySQL. LearnSphere enables Trainers to manage courses and lessons while Students can enroll, purchase courses, watch video lessons, and interact through comments.

---

## 🌐 Live Demo

🔗 **Application URL:**  
https://learnsphere-production-9045.up.railway.app

---

## 📌 Features

### 👨‍🏫 Trainer Module
- Trainer Login
- Add Course
- Edit Course
- Delete Course
- Add Lesson
- Edit Lesson
- Delete Lesson
- View All Lessons

### 👨‍🎓 Student Module
- Student Registration
- Student Login
- View Available Courses
- Purchase Course
- View Purchased Courses
- Watch Course Videos
- Add Comments on Lessons
- View Comments

### 🔐 Security
- Spring Security Authentication
- Role-Based Login (Trainer / Student)
- Custom UserDetailsService
- Session Management

---

## 🛠️ Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security
- Hibernate

### Frontend
- Thymeleaf
- HTML5
- CSS3
- Bootstrap 5

### Database
- MySQL
- Railway Cloud MySQL

### Tools & Platforms
- Eclipse IDE
- Maven
- Git
- GitHub
- Railway

---

## 📂 Project Structure

```
LearnSphere
│
├── controller
├── service
├── repository
├── entity
├── security
├── config
│
├── templates
├── application.properties
│
└── pom.xml
```

---

## 🚀 Deployment

The application is deployed on **Railway** using:

- GitHub Integration
- Railway Cloud MySQL
- Environment Variables
- Spring Boot Executable JAR

---

## 🔑 Environment Variables

```properties
PORT
DB_URL
DB_USERNAME
DB_PASSWORD
```

Local development uses fallback values configured in `application.properties`.

---

## 💻 Running Locally

### Clone Repository

```bash
git clone https://github.com/14BharaniD/LearnSphere.git
```

### Navigate

```bash
cd LearnSphere
```

### Configure Database

Create a MySQL database named:

```
learnsphere
```

Update:

```
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:mysql://localhost/learnsphere
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

### Run

```bash
mvn spring-boot:run
```

or run the project directly from Eclipse.

---

## 📸 Screenshots

> *(Add screenshots here after uploading them to GitHub)*

### 🏠 Home Page

*(Screenshot)*

### 🔑 Login Page

*(Screenshot)*

### 👨‍🏫 Trainer Dashboard

*(Screenshot)*

### 👨‍🎓 Student Dashboard

*(Screenshot)*

### 📚 Course Management

*(Screenshot)*

### 🎥 Lesson Page

*(Screenshot)*

---

## 📈 Future Enhancements

- Password Encryption using BCrypt
- Embedded Video Player
- Payment Gateway Integration
- Email Notifications
- Certificate Generation
- Search & Filter Courses
- User Profile Management
- Course Progress Tracking
- Admin Dashboard

---

## 🧠 Key Learning Outcomes

- Spring Boot Application Development
- Spring Security Authentication
- Role-Based Authorization
- REST & MVC Architecture
- Hibernate & JPA
- MySQL Database Design
- Cloud Deployment with Railway
- Version Control using Git & GitHub

---

## 👨‍💻 Author

**Bharani Dangeti**

📧 Email: *(bharani965276@gmail.com)*

🔗 GitHub: https://github.com/14BharaniD

🔗 LinkedIn: *(https://www.linkedin.com/in/bharani-mbu/)*

---

## ⭐ If you like this project

Please consider giving this repository a **Star ⭐**.
