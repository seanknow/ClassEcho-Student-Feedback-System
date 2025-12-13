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
        return studentID;  // kinukuha yung ID ng student
    }
    public int getRating() {
        return rating;  // kinukuha yung rating na ibinigay ng student
    }
    public String getComments() { 
        return comments;  // kinukuha yung comments na ibinigay ng student
    }

    @Override
    public String toString() {
        // ipi-print ang lahat ng detalye ng feedback
        return "Student ID: " + studentID + ", Rating: " + rating + ", Comments: " + comments;
    }
}

public class Methods {
    private static Scanner sc = new Scanner(System.in);
    // map para i-store yung feedback: key = subject, value = list ng Feedback objects
    private static Map<String, List<Feedback>> feedbackData = new HashMap<>();

    // initialize yung map with subjects para ready na yung list
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
            System.out.println("\n========================================");
            System.out.println("========= ADMINISTRATOR PORTAL =========");
            System.out.println("========================================");
            System.out.println("1. VIEW FEEDBACK");
            System.out.println("2. LOG OUT");
            System.out.print("ENTER OPTION: ");
            int choice1 = sc.nextInt();

            switch (choice1) {
                case 1:
                    viewFeedback(); // i-display lahat ng feedback
                    break;
                case 2:
                    System.out.println("EXITING ADMINISTRATOR PORTAL. THANK YOU!");
                    return; 
                default:
                    System.out.println("INVALID OPTION. PLEASE TRY AGAIN.");
                    break;
            }
        }
    }

    public void studentPOV(String studentID) {  
        // loop for student portal hanggang sa exit
        while (true) {
            System.out.println("\n========================================");
            System.out.println("========== STUDENT FEEDBACK ============");
            System.out.println("========================================");
            System.out.println("\nSELECT SUBJECT TO GIVE FEEDBACK:");
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
                    this.Oop(studentID); // tinatawag ang method para sa OOP feedback
                    break;
                case 2:
                    this.Acp(studentID);
                    break;
                case 3:
                    this.Dbms(studentID); 
                    break;
                case 4:
                    this.Cn(studentID); 
                    break;
                case 5:
                    this.Phy(studentID); 
                    break;
                case 6:
                    this.Dm(studentID); 
                    break;
                case 7:
                    this.Al(studentID);
                    break;
                case 8:
                    this.Pf3(studentID); 
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

    //methods para sa bawat subject
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

// helper method para mangolekta at mag-save ng feedback
    private void collectAndSaveFeedback(String subject, String studentID) {
        System.out.println();
        System.out.println("Course/Subject: " + subject);
        System.out.println("Student ID: " + studentID);

        // 5 rating questions
        String[] questions = {
            "1. Attending class on time",
            "2. Explains lessons clearly",
            "3. Well-prepared for class",
            "4. Encourages student participation",
            "5. Overall teaching effectiveness"
        };

        int[] ratings = new int[questions.length];
        int total = 0;

        System.out.println("\nRATE YOUR INSTRUCTOR");
        System.out.println("1 - LOWEST | 2 - POOR | 3 - AVERAGE | 4 - GOOD | 5 - EXCELLENT\n");

        // collect ratings for each question
        for (int i = 0; i < questions.length; i++) {
            int rate = -1;
            while (rate < 1 || rate > 5) {
                System.out.print(questions[i] + ": ");
                if (sc.hasNextInt()) {
                    rate = sc.nextInt();
                    if (rate < 1 || rate > 5) {
                        System.out.println("Invalid rating. Please enter 1–5 only.");
                    }
                } else {
                    System.out.println("Invalid input. Numbers only.");
                    sc.next(); // consume invalid input
                }
            }
            ratings[i] = rate;
            total += rate;
        }

        double averageRating = (double) total / ratings.length;
        sc.nextLine(); // consume newline

        System.out.print("\nEnter your comments: ");
        String comments = sc.nextLine();

        // Save feedback (using average rating)
        Feedback feedback = new Feedback(studentID, (int) Math.round(averageRating), comments);
        feedbackData.get(subject).add(feedback);

        System.out.println("\nFeedback submitted successfully!");
        System.out.println("Average Rating: " + String.format("%.2f", averageRating) + "\n");
    }


    // admin method para makita lahat ng feedback
    private void viewFeedback() {
        System.out.println("\n====== LIST FEEDBACK ======");
        for (Map.Entry<String, List<Feedback>> entry : feedbackData.entrySet()) {
            String subject = entry.getKey();
            List<Feedback> feedbacks = entry.getValue();
            if (feedbacks.isEmpty()) {
                System.out.println(subject + ": No feedback yet."); // Walang feedback pa
            } else {
                double avgRating = feedbacks.stream().mapToInt(Feedback::getRating).average().orElse(0.0);
                System.out.println(subject + ": Average Rating: " + String.format("%.2f", avgRating) + ", Total Feedbacks: " + feedbacks.size());
                
                // ipapakita lahat ng individual feedback kasama student IDs
                System.out.println("  Individual Feedbacks:");
                for (Feedback f : feedbacks) {
                    System.out.println("    " + f.toString());  // shows Student ID, Rating, Comments
                }
            }
            System.out.println();  // blank line para readable
        }
    
    }
}
