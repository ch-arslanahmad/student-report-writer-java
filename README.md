# Student Report Writer

![Language](https://img.shields.io/badge/language-Java-blue.svg)
![Status](https://img.shields.io/badge/status-Project-brightgreen)
![License](https://img.shields.io/badge/license-MIT-lightgrey)
![Version](https://img.shields.io/badge/version-1.0-blue)

---

## Project Overview

Student Report Writer is a console-based application that generates comprehensive student reports/results with enhanced error handling and modular architecture.

## Project Structure

```sturcture
student-report-writer-java/
├── README.md
├── LICENSE
└── student-report-writer/
    ├── Main.java                 # Application entry point
    ├── model/
    │   └── Student.java          # Core data model with validation
    └── display/
        ├── Input.java            #  input validation system
        └── ReportWriter.java     # Modular report generation
```

---

### How it works?

- **Main.java** - Main workflow file
- **model/Student.java** - Core data model, student data, marks calculation, and percentage computation
- **display/Input.java** -  input validation system with comprehensive data validation
- **display/ReportWriter.java** - Modular report generation (Terminal/.TXT) with robust error handling and formatted output

---

## Project Algorithm

```text
1. Start
2. Program starts from main.java
3. Student.java: Methods that:
  - Inputs via Input.java
    - Student Details 
    - subject & marks
  - Calculates Percentages, Total Marks (total/obtained),
4. ReportWriter.java: Methods that:
  - Passes Student.java data(methods) to this file
  - Create a File
  - Write Formatted Report in the File
Alternatively, displaying the report directly in the console
5. End

```

---

## Requirements

### System Requirements

- **Java JDK 8+** - [Download here](https://www.oracle.com/java/technologies/downloads/?er=221886)
- **IDE** (recommended): [VS Code](https://code.visualstudio.com/download) or anything else like IntelliJ IDEA, or Eclipse etc.
- **Git** - [Download here](https://git-scm.com/downloads) (for cloning repository)

### Optional Tools

- Terminal/Command Prompt for compilation and execution
- Java Extension Pack for VS Code (if using VS Code then **necessary**)

---

## Running the Application

1. **Clone the Repository**

   ```bash
   git clone https://github.com/ch-arslanahmad/student-report-writer-java.git
   cd student-report-writer-java/student-report-writer
   ```

2. **Compile the Application**

   ```bash
   javac -cp . Main.java
   ```

3. **Run the Application**

   ```bash
   java Main
   ```

### Using an IDE

1. Open the project folder in your preferred IDE
2. Navigate to `student-report-writer/Main.java`
3. Run the Main class


## Sample Output

The output is at [Report-File](src/display/Report.txt).

---

## License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

---
