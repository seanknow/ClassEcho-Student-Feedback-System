# ClassEcho: Student Feedback System

The ClassEcho: Student Feedback System is a Java console program designed to give students a voice 
in evaluating their instructors performance to ensure the student recieves quality education.
It allows user to input their feedback and ratings based on various aspect of teaching.

# OOP Concepts
The program uses classes and objects to organize the student feedback system. The Feedback class stores information about each feedback entry, 
like the student ID, rating, and comments, while the Methods class manages the programs functions, such as collecting and showing feedback. 
The Main class runs the program and lets users choose between the student or administrator portal. Each Feedback object holds one students response, 
and the program can handle many feedback entries at the same time.

***Encapsulation*** Encapsulation is the bundling of data (attributes) and the methods that operate on that data into a single unit (a class). 
Crucially, it involves restricting direct access to the internal state of an object, protecting it from unintended changes

Purpose of this is to ensure data integrity (the data remains valid and consistent). By using the private keyword, we prevent external parts of the program (like Main.java) from directly modifying the feedback records or the internal list of subjects.

<img width="462" height="116" alt="Image" src="https://github.com/user-attachments/assets/8d669aa9-e0a7-4ade-b318-0559a3807dfd" />

***Abstraction***Abstraction is the process of showing only essential information to the user and hiding the complex implementation details.
It allows users to interact with high-level functions without needing to understand the underlying code.

Purpoe of this is to simplify the application's external interface. The main application only needs to know what the system does, not how it does the necessary steps 
(calculating averages, looking up subjects, validating input).

<img width="443" height="108" alt="Image" src="https://github.com/user-attachments/assets/5dd3c70c-3f7a-4ad1-a98a-a0b72d29166f" />

***List and ArrayList***
- Iterates through all subjects and prints all feedback.
<img width="387" height="51" alt="Image" src="https://github.com/user-attachments/assets/3e3ca4f5-f951-478a-8b5e-546277059481" />

# Program Structured

The program is organized using three main classes: Main, Methods, and Feedback. Each class has a specific role in the ClassEcho: Student Feedback System.

***Main Class*** - This is the driver class that runs the program. It displays the main menu (basic login system) and lets users choose whether they are a student or an administrator. 

<img width="402" height="250" alt="Image" src="https://github.com/user-attachments/assets/4d168d0e-0270-4773-8bc0-fc9240588527" />

***Methods Class*** - This class acts as the controller of the program. It contains the logic for both student and administrator portals. For students, 
it displays the subject menu and collects feedback, storing it in a data structure. For administrators, it displays all feedback, calculates average ratings, and provides a summary. 

<img width="433" height="250" alt="Image" src="https://github.com/user-attachments/assets/709f0396-df45-4f5f-9f61-8c9ee9215a71" />

# How the program works?
This is the simple flow chart of how the program works
<img width="1118" height="639" alt="Image" src="https://github.com/user-attachments/assets/a3059359-88b9-4032-a02d-471f883504ea" />


# Sample Ouput

## ADMIN
<img width="404" height="1044" alt="Image" src="https://github.com/user-attachments/assets/02fd0b95-ee64-4488-bf80-5cda71dc3ef7" />
<img width="367" height="348" alt="Image" src="https://github.com/user-attachments/assets/d18ff04d-cc70-43d1-a8a6-1bc2d8f7e089" />

## STUDENT
<img width="524" height="923" alt="Image" src="https://github.com/user-attachments/assets/08f244b0-0fe0-4480-bf93-fc79983021a5" />
<img width="381" height="514" alt="Image" src="https://github.com/user-attachments/assets/91d51650-d5a4-4b47-9375-0972f347bae0" />


# Future Enhancement
- GUI
- Database Management
- Logic
- Interactive Feedback
- Security

Student Dev:
- Pe Benito, Ballian Roi
- Mendoza, Sean Rain
- Pabellano, Shawn Vincent

OOP Instructor: Mr. Juriel Comia 
