# Student Grade Management System

## Overview
A simple console-based Java application for managing student information and their grades. The system allows adding students, recording grades, calculating statistics, and generating reports.

## Features
- **Student Management**: Add, view, and search students
- **Grade Recording**: Record grades for different subjects
- **Report Generation**: View individual reports and class statistics
- **Data Persistence**: Save and load data from files
- **Input Validation**: Error handling for invalid inputs

## Technologies Used
- Java 11+
- File I/O for data persistence
- Object-Oriented Programming principles
- Collections Framework

## Project Structure
```
StudentGradeSystem/
├── src/
│   ├── models/
│   │   ├── Student.java
│   │   └── Grade.java
│   ├── services/
│   │   ├── StudentService.java
│   │   ├── GradeService.java
│   │   └── ReportService.java
│   ├── utils/
│   │   ├── FileHandler.java
│   │   └── Validator.java
│   └── Main.java
├── data/
│   └── students.txt
├── README.md
├── statement.md
└── docs/
    └── diagrams/
```

## Installation & Setup

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Git

### Steps to Run
1. Clone the repository:
```bash
git clone https://github.com/AzhaanGlitch/VITyarthi-Project.git
cd StudentGradeSystem
```

2. Compile the project:
```bash
javac -d bin src/**/*.java src/*.java
```

3. Run the application:
```bash
java -cp bin Main
```

## How to Use
1. Launch the application
2. Choose from the menu:
   - Add new student
   - Add grades for a student
   - View student report
   - View class statistics
   - Exit

## Testing
- Manual testing through console interface
- Test with various input scenarios:
  - Valid student data
  - Invalid inputs (negative grades, empty names)
  - Edge cases (maximum/minimum grades)

## Project Diagrams

### System Architecture
![Architecture](/docs/diagrams/04-architecture-diagram.png)

### Use Case Diagram
![Use Case](/docs/diagrams/01-use-case-diagram.png)

### Class Diagram
![Class Diagram](/docs/diagrams/02-class-diagram.png)

## Screenshots

### Main Menu
![Main Menu](/docs/screenshots/01-main-menu.png)

### Student Report
![Student Report](/docs/screenshots/04-student-report.png)

### Class Statistics
![Class Statistics](docs/screenshots/05-class-statistics.png)

## Non-Functional Requirements
- **Performance**: Responds within 1 second for all operations
- **Usability**: Simple menu-driven interface
- **Reliability**: Data persists across sessions
- **Maintainability**: Modular code with clear separation of concerns
