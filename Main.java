// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        // Initialize the core system logic once
        FeedbackSystem system = new FeedbackSystem(sc);
        int choice = 0;
        
    System.out.println("\n======== WELCOME CICS STUDENT! =========");
    System.out.println();
        
    while (true) {
    System.out.println("========================================");
    System.out.println("======= STUDENT FEEDBACK SYSTEM ========");
    System.out.println("========================================");
    System.out.println();
    System.out.println("1. ADMINISTRATOR");
    System.out.println("2. STUDENT");
    System.out.println("3. EXIT");
    System.out.print("ENTER OPTION: ");        
    if (sc.hasNextInt()) {
    choice = sc.nextInt();
        System.out.println("\n========================================");
        } else {
            System.out.println("\n========================================");
            System.out.println("INVALID INPUT. PLEASE ENTER A NUMBER.");
            sc.next(); // Consume invalid input
            continue;
        }

    switch (choice) {
        case 1:
        System.out.println("\n===== ADMINISTRATOR LOGIN =====");
        System.out.print("Enter Admin Code: ");
        String adminCode = sc.next();
        System.out.print("Enter Admin Password: ");
        String adminPassword = sc.next();

        if (adminCode.equals("CICS") && adminPassword.equals("CICS2025")) {
        system.adminPOV(); // Call method in FeedbackSystem
        } else {
            System.out.println("ACCESS DENIED.");
        } break;
        case 2:
            System.out.println("\n===== STUDENT FEEDBACK PORTAL =====");
            System.out.println();
            System.out.print("ENTER UNIVERSITY SRCODE: ");
            String studentID = sc.next();
            System.out.println();
            system.studentPOV(studentID); // Call method in FeedbackSystem
            break;
        case 3:
            System.out.println("          EXITING SYSTEM...");
            System.out.println("========================================");
            sc.close();
            System.exit(0);
        default:
            System.out.println("INVALID OPTION. PLEASE TRY AGAIN.");
            
            }
        }
    }
}