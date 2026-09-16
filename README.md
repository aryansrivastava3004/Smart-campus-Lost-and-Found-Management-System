# 🎓 Campus Lost & Found Management System

A Java-based command-line application designed to manage lost and found items within a college campus. The system allows students to report lost or found items, search records, identify possible matches, and manage claims.

---

## 📌 Overview

Losing personal belongings on a college campus is common, while found items often remain difficult to return to their owners.

The **Campus Lost & Found Management System** provides a centralized system for recording lost and found items and helps students identify potential matches using a rule-based matching system.

The application is developed using **Java, JDBC, Maven, and H2 Database** and follows an object-oriented and modular design.

---

## ✨ Features

- 👤 **Student Registration**
  - Register students with their basic details
  - Validate user information

- 📢 **Lost Item Reporting**
  - Report items that have been lost
  - Store item category, location, date and description

- 📦 **Found Item Reporting**
  - Record items that have been found on campus
  - Maintain the status of found items

- 🔍 **Item Search**
  - Search and view lost/found item records
  - Filter records based on item information

- 🤝 **Smart Matching**
  - Compare lost and found items
  - Generate a match score using:
    - Item title
    - Category
    - Location
    - Date
    - Description/keywords

- 📋 **Claim Management**
  - Submit claims for found items
  - Track claim status
  - Update item status after successful claims

- 💾 **Database Persistence**
  - Uses JDBC for database operations
  - H2 database stores users, items and claims

- 📄 **CSV Backup**
  - Export item records to CSV
  - Provides a simple backup mechanism

---

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java 17 | Core application development |
| JDBC | Database connectivity |
| H2 Database | Data persistence |
| Maven | Dependency and project management |
| CSV | Data backup/export |
| Git & GitHub | Version control |

---

## 🏗️ Project Structure

```text
CampusLostFound/
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── campuslostfound/
│                   ├── Main.java
│                   │
│                   ├── db/
│                   │   └── DatabaseManager.java
│                   │
│                   ├── exception/
│                   │   └── ValidationException.java
│                   │
│                   ├── model/
│                   │   ├── User.java
│                   │   ├── Student.java
│                   │   ├── Admin.java
│                   │   ├── Item.java
│                   │   ├── LostItem.java
│                   │   ├── FoundItem.java
│                   │   ├── Claim.java
│                   │   ├── ItemCategory.java
│                   │   ├── ItemStatus.java
│                   │   └── ClaimStatus.java
│                   │
│                   ├── service/
│                   │   ├── UserService.java
│                   │   ├── ItemService.java
│                   │   ├── MatchingService.java
│                   │   └── ClaimService.java
│                   │
│                   └── util/
│                       ├── InputValidator.java
│                       ├── CsvExporter.java
│                       └── BackupService.java
│
├── docs/
│   ├── Project_Report.md
│   ├── architecture.txt
│   ├── class-diagram.txt
│   ├── er-diagram.txt
│   ├── test-cases.md
│   ├── use-case.txt
│   └── workflow.txt
│
├── data/
├── pom.xml
├── README.md
├── statement.md
└── .gitignore
