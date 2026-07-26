# 🏪 Store Management System

A full-stack Store Management System built using **Java, Spring Boot, Spring MVC, Spring Data JPA, JSP, and PostgreSQL**. The application helps businesses efficiently manage inventory, sales, and store operations through a secure and scalable platform.

## 🚀 Features

* Secure store-based admin authentication
* Item Management (Add, Update, Delete, View)
* Search, Pagination, and Sorting support
* Real-time inventory updates during sales
* Low-stock detection and monitoring
* RESTful APIs for store and item operations
* Global exception handling using `@ControllerAdvice`
* Optimized data retrieval with `Pageable` and `Sort`
* JPA entity relationships with cascade operations

## 🛠️ Tech Stack

| Technology      | Usage                 |
| --------------- | --------------------- |
| Java            | Backend Development   |
| Spring Boot     | Application Framework |
| Spring MVC      | Web Layer             |
| Spring Data JPA | Database Operations   |
| Hibernate       | ORM                   |
| JSP             | Frontend Views        |
| PostgreSQL      | Database              |
| Maven           | Dependency Management |

## 📂 Project Structure

```text
src/
├── main/
│   ├── java/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── entity/
│   │   └── exception/
│   ├── resources/
│   └── webapp/
│       └── WEB-INF/views/
└── test/
```

## ⚙️ Installation & Setup

### Prerequisites

* Java 17+
* Maven
* PostgreSQL

### Clone Repository

```bash
git clone https://github.com/your-username/store-management-system.git
cd store-management-system
```

### Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/storedb
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Run Application

```bash
mvn spring-boot:run
```

Application will start at:

```text
http://localhost:8080
```

## 📸 Key Modules

### Inventory Management

* Add products
* Update product details
* Delete products
* View product catalog

### Sales Management

* Record sales transactions
* Automatic stock deduction
* Inventory synchronization

### Store Administration

* Secure login
* Session management
* Store-specific access control

## 🏗️ Architecture

The application follows the **MVC (Model-View-Controller)** architecture:

```text
Client
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
PostgreSQL Database
```

## 🔮 Future Enhancements

* Role-Based Access Control (RBAC)
* Sales analytics dashboard
* Email notifications for low stock
* Barcode/QR code support
* Docker deployment
* CI/CD pipeline integration

## 🤝 Contributing

Contributions, suggestions, and improvements are welcome. Feel free to fork the repository and submit a pull request.

## 📄 License

This project is licensed under the MIT License.

---

⭐ If you found this project useful, consider giving it a star on GitHub!
