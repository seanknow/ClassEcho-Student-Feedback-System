# ClassEcho: Student Feedback System

The ClassEcho: Student Feedback System is a Java console program designed to give students a voice 
in evaluating their instructors performance to ensure the student recieves quality education.
It allows user to input their feedback and ratings based on various aspect of teaching.

# OOP Concepts
The program uses classes and objects to organize the student feedback system. The Feedback class stores information about each feedback entry, 
like the student ID, rating, and comments, while the Methods class manages the programs functions, such as collecting and showing feedback. 
The Main class runs the program and lets users choose between the student or administrator portal. Each Feedback object holds one students response, 
and the program can handle many feedback entries at the same time.

## ***Encapsulation*** is the bundling of data (attributes) and the methods that operate on that data into a single unit (a class). Crucially, it involves restricting direct access to the internal state of an object, protecting it from unintended changes

Purpose of this is to ensure data integrity (the data remains valid and consistent). By using the private keyword, we prevent external parts of the program (like Main.java) from directly modifying the feedback records or the internal list of subjects.

<img width="462" height="116" alt="Image" src="https://github.com/user-attachments/assets/8d669aa9-e0a7-4ade-b318-0559a3807dfd" />

## ***Abstraction*** is the process of showing only essential information to the user and hiding the complex implementation details.It allows users to interact with high-level functions without needing to understand the underlying code.

Purpoe of this is to simplify the application's external interface. The main application only needs to know what the system does, not how it does the necessary steps 
(calculating averages, looking up subjects, validating input).

<img width="443" height="108" alt="Image" src="https://github.com/user-attachments/assets/5dd3c70c-3f7a-4ad1-a98a-a0b72d29166f" />

## Additional OOP Principle
***Constructor***
- Its primary purpose is to initialize (create) a new, valid Feedback object.
<img width="573" height="110" alt="image" src="https://github.com/user-attachments/assets/b2b5b9e7-359a-42a8-a752-04dfb49aa147" />

***List and ArrayList***
- Iterates through all subjects and prints all feedback.
<img width="387" height="51" alt="Image" src="https://github.com/user-attachments/assets/3e3ca4f5-f951-478a-8b5e-546277059481" />

# Program Structured

The program is organized using four main classes: Main, Methods, Subject, and FeedbackSystem. Each class has a specific role in the ClassEcho: Student Feedback System.

<img width="116" height="32" alt="Image" src="https://github.com/user-attachments/assets/2b0acc01-0293-4a23-839b-91122c317164" /> - Responsible for program startup, managing the scanner resource, and handling the initial user login/role selection.
- To serve as the application's entry point and orchestrate the calls to the high-level methods (adminPOV, studentPOV) provided by FeedbackSystem.

<img width="131" height="32" alt="Image" src="https://github.com/user-attachments/assets/a3148af6-30c5-469d-951e-5201ffa6c37e" /> - Defines the structure for a single, immutable feedback record. It demonstrates Encapsulation by protecting its data using the private final keywords.
- To model the data (Student ID, Rating, Comments) and provide controlled, read-only access via public getter methods.

<img width="119" height="28" alt="Image" src="https://github.com/user-attachments/assets/311c4a49-a188-4198-ac18-f40e6c6806ba" /> - It is an encapsulated container that bundles a subject name with a dynamic list of its corresponding Feedback objects.
- To efficiently organize feedback by subject name using a List-based approach, ensuring that feedback is always associated with the correct subject.

<img width="166" height="31" alt="Image" src="https://github.com/user-attachments/assets/7f2670d5-7a07-4e04-acbf-8819c9b48d92" /> - This class handles everything: system initialization, input validation, business logic (average calculation), data storage, and the admin/student views. It heavily uses Abstraction to hide the complex calculations and data management from the main application flow.
- To act as the single point of contact for the Main class, providing the adminPOV and studentPOV interfaces.


# How the program works?

This is the simple flow chart of how the program works

<img width="1118" height="639" alt="Image" src="https://github.com/user-attachments/assets/a3059359-88b9-4032-a02d-471f883504ea" />

## Java Setup 
1. Install Java Development Kit (JDK) - Download and install the latest stable version of the JDK (Java 17 or newer recommended)
2. Verify Installation: Open your command prompt (CMD/Terminal) and type:
   
```bash
java --version
javac --version
```

3. Download Git and IDE (VSCode, Eclipse, etc.)
4. Add extension of Java (if needed)
5. After Downloading, Open CMD pormot or Terminal.
6. Clone this repository:

```bash
  git clone https://github.com/seanknow/ClassEcho-Student-Feedback-System`
```

7. Open the ClassEcho: Student Feedback System folder in your IDE
8. Select the folder and wait for loading.
9. Run the program.


# Sample Ouput

## ADMINISTRATOR

### MAIN
<img width="398" height="251" alt="image" src="https://github.com/user-attachments/assets/9097d819-d0a5-4ed1-8335-a86411c0796b" />

### ADMINISTRATOR PORTAL
<img width="404" height="294" alt="image" src="https://github.com/user-attachments/assets/4b12835b-e0f9-4864-95ed-142f453d5eb4" />

### ADMIN ACCESS (VIEW FEEDBACK W/O FEEDBACK)
<img width="448" height="532" alt="image" src="https://github.com/user-attachments/assets/6dd2f9bc-4fe6-4c6f-87bb-de6a8ef8662c" />

### VIEW FEEDBACK (FEEDBACK STORE)
<img width="683" height="733" alt="image" src="https://github.com/user-attachments/assets/15145d1c-a912-4daa-9101-eebae954982e" />


## STUDENT

### STUDENT PORTAL
<img width="401" height="329" alt="image" src="https://github.com/user-attachments/assets/59849cb7-7195-4711-aae0-0300b60cbb40" />

### STUDENT FEEDBACK (SELECTION)
<img width="416" height="357" alt="image" src="https://github.com/user-attachments/assets/b86ced58-9c17-4705-aa03-6b192262f5dd" />

### EVALUATION FORM (W/O FEEDBACK)
<img width="594" height="389" alt="image" src="https://github.com/user-attachments/assets/d9ae22fa-d560-4fa1-a4ff-c117b1a47507" />

### EVAULATION (FEEDBACK STORE)
<img width="584" height="377" alt="image" src="https://github.com/user-attachments/assets/f2ca7c4f-53dd-48ac-828b-7c653024166b" />



# Future Enhancement
- **GUI (Graphical User Interface)** - Replacing the text-based command-line interface (CLI) with a visual interface (using tools like Swing, JavaFX, or a web framework).
- **Database Management** - Transitioning from the current in-memory data storage (using ArrayList<Subject>) to a persistent database (e.g., MySQL, PostgreSQL, or SQLite).
- **Logic** - Expanding the logic to include more sophisticated processing.
- **Security** - Strengthening protection measures beyond the hardcoded admin login. This includes implementing proper user authentication (for admin access) and ensuring data transmission security.

# Authors 
## **Pe Benito, Ballian Roi**
- Implemented the OOP abstraction principles to encapsulate and hide the internal processes of the feedback system, ensuring a clean and maintainable design.
- Batangas State University TNEU Alangilan Campus | BS Information Technology (Second Year)
- roipebenito@gmail.com
  
## **Mendoza, Sean Rain**
- Led the conceptualization of the project. He initiated the main program and designed the overall structure, workflow, and core logic of the system.
- Batangas State University TNEU Alangilan Campus | BS Information Technology (Second Year)
- seanrainbmendoza@gmail.com
  
## **Pabellano, Shawn Vincent**
- Managed the application of Object-Oriented Programming (OOP) principles. He developed the class implementations and handled the internal logic of the system.
- Batangas State University TNEU Alangilan Campus | BS Information Technology (Second Year)
- vincentpabellano13@gmail.com

# Acknowledgement 
We would like to sincerely thank our instructor, **Mr. Juriel Comia**, for their unwavering guidance, patience, and support throughout this project. Their insightful feedback and encouragement were essential to the successful completion of our work.

# References
- ## **BSU Portal** - PERFORMANCE EVALUATION INSTRUMENT FOR TEACHING EFFECTIVENESS BY THE STUDENTS
```bash
https://dione.batstate-u.edu.ph/student/#/dashboard
```
<img width="1223" height="166" alt="image" src="https://github.com/user-attachments/assets/d8e42d1c-7e88-46c0-92b9-98dfa3f5d01f" />

- ## **CICS Feedback Form** - Suggestion for improvement in CICS
``` 
https://docs.google.com/forms/d/e/1FAIpQLScmo6Nb6JMj5Xw8rL2iVc8ORSqon-5mo8qwuGerNAawoJUYlQ/closedform
```
<img width="694" height="868" alt="image" src="https://github.com/user-attachments/assets/8d6e6fe8-324e-4861-b7d4-6389944e94ab" />
<img width="1024" height="158" alt="image" src="https://github.com/user-attachments/assets/903c8937-70c7-4101-a97c-0f1e24f1978f" />

- ## **W3School** Java Tutorial and Reference

```
- https://www.w3schools.com/java/default.asp
- https://www.irejournals.com/formatedpaper/1700576.pdf
```
