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
git clone <your-repo-url>
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

## Screenshots
*(Console-based application - text output examples in documentation)*

## Non-Functional Requirements
- **Performance**: Responds within 1 second for all operations
- **Usability**: Simple menu-driven interface
- **Reliability**: Data persists across sessions
- **Maintainability**: Modular code with clear separation of concerns

## Future Enhancements
- GUI interface using JavaFX
- Database integration (MySQL/PostgreSQL)
- Advanced analytics and visualizations
- Export reports to PDF
- Multi-user support with authentication