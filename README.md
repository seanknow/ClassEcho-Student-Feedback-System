# ClassEcho: Student Feedback System

The ClassEcho: Student Feedback System is a Java console program designed to give students a voice 
in evaluating their instructors performance to ensure the student recieves quality education.
It allows user to input their feedback and ratings based on various aspect of teaching.

# OOP Concepts
The program uses classes and objects to organize the student feedback system. The Feedback class stores information about each feedback entry, 
like the student ID, rating, and comments, while the Methods class manages the programs functions, such as collecting and showing feedback. 
The Main class runs the program and lets users choose between the student or administrator portal. Each Feedback object holds one students response, 
and the program can handle many feedback entries at the same time.

***Encapsulation*** is used by keeping the data in the Feedback class private and only allowing access through public methods. 
This keeps the student information safe and prevents accidental changes.

<img width="633" height="302" alt="Image" src="https://github.com/user-attachments/assets/f5aeede0-2474-4eb7-be0f-9cfff530d9f5" />

***Abstraction*** is applied by hiding the details of how feedback is collected and stored. 
Students only need to choose a subject, give a rating, and write comments, while the program handles the rest. 
Administrators can see all feedback without worrying about how it is saved or calculated.

<img width="309" height="107" alt="Image" src="https://github.com/user-attachments/assets/50dee4cc-aa87-43c2-8fdc-d6d6d7742a4e" />


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

Future Enhancement
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
