# Student Report Writer

![Language](https://img.shields.io/badge/language-Java-blue.svg)
![Status](https://img.shields.io/badge/status-Project-brightgreen)
![License](https://img.shields.io/badge/license-MIT-lightgrey)

---

## Project Overview
Student report writer is a console based application through which you can generate a Student Report/Result.\
It will have 4 java classes:
- **Main.java** - Calls methods and navigates the files
- **Student.java** - Takes input of `name`, `age`, `gradeYr`, `subjects` and their `marks` and `total marks`, calculates `percentages`.
<!--Add character grade in the future-->
- **ReportWriter.java** - Creates file, and generates formatted txt _result report_ on it .
---

## Project Algorithm
```text
1. Start
2. Program starts from main()
3. Student.java: Methods that:
  - Inputs Student Details
  - Inputs subject & marks
  - Calculates Percentages, Total Marks (total/obtained),
4. ReportWriter.java: Methods that:
  - Passes Student.java data(methods) to this file
  - Create a File
  - Write Formatted Report in the File
5. End
```

---


## Requirenments
Either:
- [JAVA JDK](https://www.oracle.com/java/technologies/downloads/?er=221886) and an IDE for example., [VS CODE](https://code.visualstudio.com/download)
- [Git](https://git-scm.com/downloads) - easier & faster (recommended)

---

## Running the App
After fulfiling the requirenments:
 - Open Git bash.
 - Clone the repo using the following command:
```
git clone https://github.com/ch-arslanahmad/student-report-writer-java.git
```
Then,
```
cd student-report-writer-java
ls
```
Now compile and run the program if using,
```
javac Main.java
java Main
```
Use IDE if you do not want to use Bash or terminal.


---
<!--
Suggestion on improvements to add:
- Add grade letter based on percentage.
- Move to more used formats
  - md
  - pdf (preferably)
- Update values i.e, subject name, marks etc
-->

## License

This project has `MIT license` hence anyone can use it.

---
