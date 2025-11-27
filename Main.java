import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Methods methods = new Methods();
        int choice = 0;

        while (true) {
            System.out.println("====== STUDENT FEEDBACK SYSTEM =====");
            System.out.println("1. ADMINISTRATOR");
            System.out.println("2. STUDENT");
            System.out.println("3. EXIT");
            System.out.print("ENTER OPTION: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Admin Code: ");
                    String adminCode = sc.next();
                    System.out.print("Enter Admin Password: ");
                    String adminPassword = sc.next();

                    if (adminCode.equals("CICS") && adminPassword.equals("CICS2025")) {
                        methods.adminPOV();
                    } else {
                        System.out.println("ACCESS DENIED.");
                    }
                    break;
                case 2:
                    System.out.println();
                    System.out.print("ENTER UNIVERSITY SRCODE: ");
                    String studentID = sc.next();
                    System.out.println();
                    methods.studentPOV(studentID);  // Pass studentID
                    break;
                case 3:
                    System.out.println("EXITING SYSTEM...");
                    sc.close();  // Close scanner here
                    System.exit(0);
                    break;
                default:
                    System.out.println("INVALID OPTION. PLEASE TRY AGAIN.");
            }
        }
    }
}
//update 