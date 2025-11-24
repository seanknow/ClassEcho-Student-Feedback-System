import java.util.*;

// Simple class to represent feedback data (unchanged)
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
        return studentID;
     }
    public int getRating() {
         return rating; 
        }
    public String getComments() { 
        return comments; 
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Rating: " + rating + ", Comments: " + comments;
    }
}

public class Methods {
    private static Scanner sc = new Scanner(System.in);
    // Map to store feedback: key = subject name, value = list of Feedback objects
    private static Map<String, List<Feedback>> feedbackData = new HashMap<>();

    // Initialize the map with subjects (so we have lists ready)
    static {
        String[] subjects = {"Object Oriented Programming", "Advanced Computer Programming", 
                             "Database Management System", "Computer Networking", 
                             "Physics-Calculus Based", "Discrete Mathematics", 
                             "ASEAN Literature", "PATHFIT 3"};
        for (String subject : subjects) {
            feedbackData.put(subject, new ArrayList<>());
        }
    }

    public void adminPOV() {
        while (true) {
            System.out.println("======ADMINISTRATOR PORTAL=====");
            System.out.println("1. VIEW FEEDBACK");
            System.out.println("2. MANAGE SUBJECTS");
            System.out.println("3. EXIT");
            System.out.print("ENTER OPTION: ");
            int choice1 = sc.nextInt();

            switch (choice1) {
                case 1:
                    viewFeedback();
                    break;
                case 2:
                    manageSubjects();
                    break;
                case 3:
                    System.out.println("EXITING ADMINISTRATOR PORTAL. THANK YOU!");
                    return;
                default:
                    System.out.println("INVALID OPTION. PLEASE TRY AGAIN.");
                    break;
            }
        }
    }

    public void studentPOV(String studentID) {  // Accepts studentID
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
                    this.Oop(studentID);
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
                    return;
                default:
                    System.out.println("INVALID SUBJECT. PLEASE TRY AGAIN.");
                    break;
            }
        }
    }

    // Updated methods to accept studentID and save feedback
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

    // Helper method to collect and save feedback for a subject
    private void collectAndSaveFeedback(String subject, String studentID) {
        System.out.println("Providing feedback for " + subject + ".");
        System.out.println("Submitting feedback for Student ID: " + studentID);  // NEW: Display student ID for identification
        
        int rating = -1;  // Initialize to invalid value
        while (rating < 1 || rating > 5) {
            System.out.print("Enter your rating (1-5): ");
            if (sc.hasNextInt()) {
                rating = sc.nextInt();
                if (rating < 1 || rating > 5) {
                    System.out.println("Invalid rating. Please enter a number between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                sc.next();  // Consume the invalid input to avoid infinite loop
            }
        }
        
        sc.nextLine();  // Consume newline after nextInt()
        System.out.print("Enter your comments: ");
        String comments = sc.nextLine();

        // Create Feedback object and save to the map
        Feedback feedback = new Feedback(studentID, rating, comments);
        feedbackData.get(subject).add(feedback);
        System.out.println("Feedback for " + subject + " submitted and saved!");
    }

    // Admin method to view feedback (NOW INCLUDES INDIVIDUAL FEEDBACKS WITH STUDENT IDs)
    private void viewFeedback() {
        System.out.println("====== AGGREGATED FEEDBACK ======");
        for (Map.Entry<String, List<Feedback>> entry : feedbackData.entrySet()) {
            String subject = entry.getKey();
            List<Feedback> feedbacks = entry.getValue();
            if (feedbacks.isEmpty()) {
                System.out.println(subject + ": No feedback yet.");
            } else {
                double avgRating = feedbacks.stream().mapToInt(Feedback::getRating).average().orElse(0.0);
                System.out.println(subject + ": Average Rating: " + String.format("%.2f", avgRating) + ", Total Feedbacks: " + feedbacks.size());
                
                // NEW: List all individual feedbacks with student IDs for identification
                System.out.println("  Individual Feedbacks:");
                for (Feedback f : feedbacks) {
                    System.out.println("    " + f.toString());  // Shows Student ID, Rating, Comments
                }
            }
            System.out.println();  // Blank line for readability
        }
    }

    private void manageSubjects() {
        System.out.println("Managing subjects... (Feature not fully implemented. Add logic to add/remove subjects from the map.)");
    }
}
