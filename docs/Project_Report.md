# Campus Lost & Found Management System – Project Report

## 1. Introduction
A command-line Java application that centralizes lost/found records, search, matching and claims for a college campus.

## 2. Problem Statement
Informal messages can make lost-item discovery and claim tracking difficult. The system provides structured persistent records.

## 3. Objectives
- Centralize lost and found records.
- Provide search and rule-based possible matching.
- Track claims.
- Demonstrate OOP, inheritance, polymorphism, exceptions, Collections, I/O, multithreading and JDBC.

## 4. Functional Requirements
Student registration; lost/found reporting; search; possible-match detection; claims; JDBC persistence; CSV backup.

## 5. Non-Functional Requirements
Usability, reliability, maintainability, portability, resource efficiency and validation.

## 6. Architecture
CLI -> Service Layer -> JDBC -> H2 Database. CSV backup is handled by a utility and can run in a separate thread.

## 7. Design Diagrams
Use the editable diagrams in `docs/`.

## 8. Matching Algorithm
Category +30, location +30, meaningful keyword +5 each, same date +15, within 2 days +10, within 7 days +5; maximum 100. Scores of 50+ are displayed.

## 9. Implementation
The model package contains domain objects/enums. Services implement business logic and JDBC CRUD. Utility classes handle validation, CSV export and background backup.

## 10. Testing
See `docs/test-cases.md`. Capture actual terminal screenshots after running the program.

## 11. Results
Insert your own screenshots of registration, item reporting, matching, claim approval and backup.

## 12. Challenges
JDBC connection, inheritance design, validation, matching score and multithreaded backup.

## 13. Learnings
The project demonstrates practical use of Java OOP, JDBC, exception handling, collections, I/O and threads.

## 14. Future Enhancements
Authentication, GUI/web interface, notifications, image uploads, stronger matching and automated tests.

## 15. References
CSE2006 Programming in Java syllabus; VITyarthi Build Your Own Project guidelines; Herbert Schildt, Java: The Complete Reference; Oracle Java/JDBC documentation; H2 documentation.
