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
   
<img width="242" height="61" alt="image" src="https://github.com/user-attachments/assets/6e18b82f-62a4-4d86-8f14-a3b441b21044" />

3. Download Git and IDE (VSCode, Eclipse, etc.)
4. Add extension of Java (if needed)
5. After Downloading, Open CMD pormot or Terminal.
6. Clone this repository:

```bash
  git clone https://github.com/seanknow/ClassEcho-Student-Feedback-System`
```

9. Open the ClassEcho: Student Feedback System folder in your IDE
10. Select the folder and wait for loading.
11. Run the program.


# Sample Ouput

## ADMIN
<img width="404" height="1044" alt="Image" src="https://github.com/user-attachments/assets/02fd0b95-ee64-4488-bf80-5cda71dc3ef7" />
<img width="367" height="348" alt="Image" src="https://github.com/user-attachments/assets/d18ff04d-cc70-43d1-a8a6-1bc2d8f7e089" />

## STUDENT
<img width="524" height="923" alt="Image" src="https://github.com/user-attachments/assets/08f244b0-0fe0-4480-bf93-fc79983021a5" />
<img width="381" height="514" alt="Image" src="https://github.com/user-attachments/assets/91d51650-d5a4-4b47-9375-0972f347bae0" />


# Future Enhancement
- ## GUI (Graphical User Interface) - Replacing the text-based command-line interface (CLI) with a visual interface (using tools like Swing, JavaFX, or a web framework).
- ## Database Management - Transitioning from the current in-memory data storage (using ArrayList<Subject>) to a persistent database (e.g., MySQL, PostgreSQL, or SQLite).
- ## Logic - Expanding the logic to include more sophisticated processing.
- ## Security - Strengthening protection measures beyond the hardcoded admin login. This includes implementing proper user authentication (for admin access) and ensuring data transmission security.

# Authors 
- Pe Benito, Ballian Roi
- Mendoza, Sean Rain
- Pabellano, Shawn Vincent

# Acknowledgement 


# OOP Instructor: Mr. Juriel Comia 
