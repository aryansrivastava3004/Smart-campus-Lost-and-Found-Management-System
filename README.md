# Campus Lost & Found Management System

A command-line Java 17 application for managing lost and found items on a college campus.

## Features
- Student registration
- Report lost/found items
- Search records
- Rule-based possible-match scoring
- Claim management
- JDBC + H2 persistence
- CSV backup using Java I/O
- Background backup using Thread
- Validation and custom exception handling

## Requirements
- JDK 17+
- Maven 3.8+
- Git (for GitHub)

## Run
```bash
mvn clean compile
mvn exec:java
```
The H2 database is created automatically under `data/`.

## Suggested demo
Register two students, report a lost item and a similar found item, run matching, submit a claim, approve it, then run backup.

## Structure
`model` = domain classes/enums; `service` = business/database operations; `db` = JDBC setup; `util` = validation, CSV and threading; `Main` = CLI.

See `statement.md`, `docs/test-cases.md` and `docs/Project_Report.md`.
