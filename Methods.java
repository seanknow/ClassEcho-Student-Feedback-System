import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Feedback {
    private String studentID;
    private int rating;
    private String comments;

    public Feedback(String studentID, int rating, String comments) {
        this.studentID = studentID;
        this.rating = rating;
        this.comments = comments;
    }

    public String getStudentID() { 
        return studentID;  // Kinukuha yung ID ng student
    }
    public int getRating() {
        return rating;  // Kinukuha yung rating na ibinigay ng student
    }
    public String getComments() { 
        return comments;  // Kinukuha yung comments na ibinigay ng student
    }

    @Override
    public String toString() {
        // Ipi-print ang lahat ng detalye ng feedback
        return "Student ID: " + studentID + ", Rating: " + rating + ", Comments: " + comments;
    }
}

public class Methods {
    private static Scanner sc = new Scanner(System.in);
    // Map para i-store yung feedback: key = subject, value = list ng Feedback objects
    private static Map<String, List<Feedback>> feedbackData = new HashMap<>();

    // I-initialize yung map with subjects para ready na yung list
    static {
        String[] subjects = {"Object Oriented Programming", "Advanced Computer Programming", 
                             "Database Management System", "Computer Networking", 
                             "Physics-Calculus Based", "Discrete Mathematics", 
                             "ASEAN Literature", "PATHFIT 3"};
        for (String subject : subjects) {
            feedbackData.put(subject, new ArrayList<>()); // Lahat ng subjects may empty list sa simula
        }
    }

    public void adminPOV() {
        // Loop ng admin portal hanggang sa exit
        while (true) {
            System.out.println("======ADMINISTRATOR PORTAL=====");
            System.out.println("1. VIEW FEEDBACK");
            System.out.println("2. LOG OUT");
            System.out.print("ENTER OPTION: ");
            int choice1 = sc.nextInt();

            switch (choice1) {
                case 1:
                    viewFeedback(); // I-display lahat ng feedback
                    break;
                case 2:
                    System.out.println("EXITING ADMINISTRATOR PORTAL. THANK YOU!");
                    return; // Exit ng admin portal
                default:
                    System.out.println("INVALID OPTION. PLEASE TRY AGAIN.");
                    break;
            }
        }
    }

    public void studentPOV(String studentID) {  
        // Loop ng student portal hanggang sa exit
        while (true) {
            System.out.println("======STUDENT FEEDBACK=====");
            System.out.println("1. OBJECT ORIENTED PROGRAMMING");
            System.out.println("2. ADVANCED COMPUTER PROGRAMMING");
            System.out.println("3. DATABASE MANAGEMENT SYSTEM");
            System.out.println("4. COMPUTER NETWORKING");
            System.out.println("5. PHYSICS-CALCULUS BASED");
            System.out.println("6. DISCRETE MATHEMATICS");
            System.out.println("7. ASEAN LITERATURE");
            System.out.println("8. PATHFIT 3");
            System.out.println("9. EXIT");
            System.out.print("ENTER SUBJECT: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    this.Oop(studentID); // Tumatawag ng method para sa OOP feedback
                    break;
                case 2:
                    this.Acp(studentID); // Tumatawag ng method para sa ACP feedback
                    break;
                case 3:
                    this.Dbms(studentID); // Tumatawag ng method para sa DBMS feedback
                    break;
                case 4:
                    this.Cn(studentID); // Tumatawag ng method para sa CN feedback
                    break;
                case 5:
                    this.Phy(studentID); // Tumatawag ng method para sa Physics feedback
                    break;
                case 6:
                    this.Dm(studentID); // Tumatawag ng method para sa DM feedback
                    break;
                case 7:
                    this.Al(studentID); // Tumatawag ng method para sa ASEAN Literature feedback
                    break;
                case 8:
                    this.Pf3(studentID); // Tumatawag ng method para sa PATHFIT 3 feedback
                    break;
                case 9:
                    System.out.println("EXITING FEEDBACK SYSTEM. THANK YOU!");
                    return; // Exit ng student feedback portal
                default:
                    System.out.println("INVALID SUBJECT. PLEASE TRY AGAIN.");
                    break;
            }
        }
    }

    // Methods para sa bawat subject, tinatawag yung helper method
    public void Oop(String studentID) {
        collectAndSaveFeedback("Object Oriented Programming", studentID);
    }

    public void Acp(String studentID) {
        collectAndSaveFeedback("Advanced Computer Programming", studentID);
    }

    public void Dbms(String studentID) {
        collectAndSaveFeedback("Database Management System", studentID);
    }

    public void Cn(String studentID) {
        collectAndSaveFeedback("Computer Networking", studentID);
    }

    public void Phy(String studentID) {
        collectAndSaveFeedback("Physics-Calculus Based", studentID);
    }

    public void Dm(String studentID) {
        collectAndSaveFeedback("Discrete Mathematics", studentID);
    }

    public void Al(String studentID) {
        collectAndSaveFeedback("ASEAN Literature", studentID);
    }

    public void Pf3(String studentID) {
        collectAndSaveFeedback("PATHFIT 3", studentID);
    }

    // Helper method para mangolekta at mag-save ng feedback
    private void collectAndSaveFeedback(String subject, String studentID) {
        System.out.println("Providing feedback for " + subject + ".");
        System.out.println("Submitting feedback for Student ID: " + studentID);  // Ipakita yung student ID

        int rating = -1;  // Simula ng invalid value
        while (rating < 1 || rating > 5) {
            System.out.print("Enter your rating (1-5): ");
            if (sc.hasNextInt()) {
                rating = sc.nextInt();
                if (rating < 1 || rating > 5) {
                    System.out.println("Invalid rating. Please enter a number between 1 and 5."); // Check kung valid rating
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 5."); // Kung hindi number
                sc.next();  // Kainin yung invalid input para maiwasan infinite loop
            }
        }
        
        sc.nextLine();  // Kainin yung newline pagkatapos ng nextInt()
        System.out.print("Enter your comments: ");
        String comments = sc.nextLine();

        // Gumawa ng Feedback object at i-save sa map
        Feedback feedback = new Feedback(studentID, rating, comments);
        feedbackData.get(subject).add(feedback);
        System.out.println("Feedback for " + subject + " submitted and saved!");
    }

    // Admin method para makita lahat ng feedback
    private void viewFeedback() {
        System.out.println("====== AGGREGATED FEEDBACK ======");
        for (Map.Entry<String, List<Feedback>> entry : feedbackData.entrySet()) {
            String subject = entry.getKey();
            List<Feedback> feedbacks = entry.getValue();
            if (feedbacks.isEmpty()) {
                System.out.println(subject + ": No feedback yet."); // Walang feedback pa
            } else {
                double avgRating = feedbacks.stream().mapToInt(Feedback::getRating).average().orElse(0.0);
                System.out.println(subject + ": Average Rating: " + String.format("%.2f", avgRating) + ", Total Feedbacks: " + feedbacks.size());
                
                // Ipakita lahat ng individual feedback kasama student IDs
                System.out.println("  Individual Feedbacks:");
                for (Feedback f : feedbacks) {
                    System.out.println("    " + f.toString());  // Shows Student ID, Rating, Comments
                }
            }
            System.out.println();  // Blank line para readable
        }
    
    }
}
