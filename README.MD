# 🎮 Lab 7 - Game Catalog Management System

วิชา: CP353002 Principles of Software Design
เรื่อง: การเชื่อมต่อฐานข้อมูลด้วย Spring Boot + JPA + JDBC + PostgreSQL
รูปแบบ: ทำเดี่ยว

---

## 📖 Project Overview

The application demonstrates:

- Spring Boot MVC
- Spring Data JPA
- PostgreSQL Database
- Thymeleaf Template Engine
- CRUD Operations
- Strategy Design Pattern
- Layered Architecture
- Dependency Injection (Constructor Injection)
- SOLID Principles
- GRASP Patterns

---

## 🚀 Features

- 📋 Display all games
- ➕ Add a new game
- ✏️ Edit game information
- 🗑️ Delete a game
- 💰 Calculate discounted price using Strategy Pattern
- 🗄️ Store data in PostgreSQL

---

## 🏗️ Project Structure

```text
src
└── main
    ├── java
    │   └── com.example.demo
    │       ├── controller
    │       │     └── GameController.java
    │       ├── model
    │       │     └── Game.java
    │       ├── repository
    │       │     └── GameRepository.java
    │       ├── service
    │       │     └── GameService.java
    │       ├── strategy
    │       │     ├── DiscountStrategy.java
    │       │     ├── DiscountContext.java
    │       │     ├── NoDiscountStrategy.java
    │       │     ├── StudentDiscountStrategy.java
    │       │     └── SeasonalSaleStrategy.java
    │       └── DemoApplication.java
    │
    └── resources
        ├── static
        │     └── css
        │           └── style.css
        │
        ├── templates
        │     └── games
        │           ├── list.html
        │           ├── add.html
        │           ├── edit.html
        │           └── delete.html
        │
        └── application.properties
```

---

## 🛠 Technologies Used

- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- PostgreSQL
- Thymeleaf
- Maven
- Bootstrap 5

---

## 🗄 Database

Database: **PostgreSQL**

Example configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/lab7
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🎯 Strategy Pattern

The project uses the Strategy Design Pattern for discount calculation.

Available strategies:

| Strategy | Description |
|----------|-------------|
| NoDiscountStrategy | No discount |
| StudentDiscountStrategy | 10% Student Discount |
| SeasonalSaleStrategy | 20% Seasonal Sale Discount |

The `DiscountContext` selects the appropriate strategy based on the selected discount type.

---

## 🧩 Layered Architecture

```text
Browser
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
PostgreSQL
```

Each layer has a single responsibility, making the application easier to maintain and extend.

---

## ▶️ Running the Project

### 1. Clone Repository

```bash
git clone https://github.com/chidchanok23/lab7-673380033-9-sec1.git
```

### 2. Open the Project

Open the project in Visual Studio Code or IntelliJ IDEA.

### 3. Configure PostgreSQL

Create a database named:

```text
lab7demo
```

Update `application.properties` with your PostgreSQL username and password.

### 4. Run the Application

Using Maven Wrapper:

```bash
./mvnw spring-boot:run
```

On Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

---

## 🌐 Application URL

Open your browser and visit:

```text
http://localhost:8080/games
```

---

## 📚 Software Design Concepts

This project applies the following software engineering concepts:

- GRASP Patterns
  - Controller
  - Information Expert
  - High Cohesion
  - Low Coupling
  - Indirection

- SOLID Principles
  - Single Responsibility Principle (SRP)
  - Open/Closed Principle (OCP)
  - Liskov Substitution Principle (LSP)
  - Interface Segregation Principle (ISP)
  - Dependency Inversion Principle (DIP)

- Strategy Design Pattern

- Dependency Injection (Constructor Injection)

