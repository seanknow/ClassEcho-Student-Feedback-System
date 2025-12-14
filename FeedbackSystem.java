// FeedbackSystem.java (Consolidated Manager: Controller, Service, at Repository)
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// consolidated class na humahawak sa lahat ng logic

public class FeedbackSystem {
    private final Scanner sc;
    // Data Storage (Repository logic): Listahan na nagho-hold ng Subject objects
    private final List<Subject> subjectData = new ArrayList<>(); 
    
    private final List<String> subjectNames = List.of(
        "Object Oriented Programming", "Advanced Computer Programming", 
        "Database Management System", "Computer Networking", 
        "Physics-Calculus Based", "Discrete Mathematics", 
        "ASEAN Literature", "PATHFIT 3"
    );

    public FeedbackSystem(Scanner sc) {
        this.sc = sc;
        //i-initialize ang lahat ng Subject objects
        for (String name : subjectNames) {
            subjectData.add(new Subject(name)); // ginagawa ang Subject object at idadagdag sa listahan
        }
    }

    // =========================
    // Repository Methods (Data Access)

    
    // Naghahanap ng Subject object gamit ang pangalan

    private Subject findSubjectByName(String name) {
        for (Subject s : subjectData) {
            if (s.getName().equals(name)) {
                return s;
                // Kapag nahanap, ibabalik ang Subject object
            }
        }
        return null;
    }
    
    // Ibalik ang listahan ng subject names
    public List<String> getAllSubjectNames() {
        return subjectNames;
    }
    
    // Ibalik ang listahan ng Subject objects (kasama ang feedbacks)
    private List<Subject> getAllSubjects() {
        return subjectData;
    }


    // =========================
    // Service Methods
  
    
    /**
     * Nagpo-process ng ratings, kinakalkula ang average, at nagse-save ng feedback.
     */
    private double processAndSaveFeedback(String subjectName, String studentID, int[] ratings, String comments) {
        int total = 0;
        for (int rating : ratings) {
            total += rating; // Kinukuha ang total ng lahat ng rating
        }
        double averageRating = (double) total / ratings.length; // Kinakalkula ang average

        Subject subjectToUpdate = findSubjectByName(subjectName); // Hahanapin ang tamang Subject

        if (subjectToUpdate != null) {
            // Gumawa ng bagong Feedback object. Ang rating ay iro-round-off (Math.round).
            Feedback feedback = new Feedback(studentID, (int) Math.round(averageRating), comments);
            
            // I-save ang feedback sa Subject object
            subjectToUpdate.addFeedback(feedback);
        }

        return averageRating; // Ibalik ang average para ma-display sa user
    }
    
    // =========================
    // Admin Logic (loops at interaction)

    
    public void adminPOV() {
        while (true) {
            System.out.println("\n========================================");
            System.out.println("========= ADMINISTRATOR PORTAL =========");
            System.out.println("========================================");
            System.out.println("1. VIEW FEEDBACK");
            System.out.println("2. LOG OUT");
            System.out.print("ENTER OPTION: ");
            
            int choice1 = -1;
            if (sc.hasNextInt()) {
                choice1 = sc.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
                continue;
            }
            
            switch (choice1) {
                case 1:
                    viewFeedback(); // I-display ang feedback
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

    // I-display ang lahat ng feedback para sa bawat subject, dito sinave
    private void viewFeedback() {
        System.out.println("\n====== LIST FEEDBACK ======");
        // kukunin ang lahat ng data mula sa sariling repository logic
        List<Subject> subjects = getAllSubjects();
        
        for (Subject subject : subjects) {List<Feedback> feedbacks = subject.getFeedbackList();
            
        if (feedbacks.isEmpty()) {
            System.out.println(subject.getName() + ": No feedback yet.");
        } else {
                // Kalkulasyon ng average rating (gamit ang Stream API)
            double avgRating = feedbacks.stream().mapToInt(Feedback::getRating).average().orElse(0.0);                             
            System.out.println(subject.getName() + ": Average Rating: " + String.format("%.2f", avgRating) 
            + ", Total Feedbacks: " + feedbacks.size());
            System.out.println("  Individual Feedbacks:");
                for (Feedback f : feedbacks) {
                    System.out.println("    " + f.toString());
                }
            }
            System.out.println();
        }
    }

    // =========================
    // Student Logic (sama as admin))

    public void studentPOV(String studentID) { 
        while (true) {
            System.out.println("\n========================================");
            System.out.println("========== STUDENT FEEDBACK ============");
            System.out.println("========================================");
            System.out.println("\nSELECT SUBJECT TO GIVE FEEDBACK:");
            
            // Gumagawa ng menu gamit ang subject names
            for (int i = 0; i < subjectNames.size(); i++) {
                System.out.println((i + 1) + ". " + subjectNames.get(i).toUpperCase());
            }
            System.out.println((subjectNames.size() + 1) + ". EXIT");
            System.out.print("ENTER SUBJECT: ");
            
            int choice = -1;
             if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); 
                continue;
            }

            if (choice == subjectNames.size() + 1) {
                System.out.println("EXITING FEEDBACK SYSTEM. THANK YOU!\n");
                return;
            }
            
            if (choice >= 1 && choice <= subjectNames.size()) {
                String selectedSubject = subjectNames.get(choice - 1);
                collectAndSaveFeedback(selectedSubject, studentID); // Tatawagin ang input collection method
            } else {
                System.out.println("INVALID SUBJECT. PLEASE TRY AGAIN.");
            }
        }
    }

    // Ito ang feedback collection method mula sa student, 
    private void collectAndSaveFeedback(String subjectName, String studentID) {
        System.out.println();
        System.out.println("Course/Subject: " + subjectName);
        System.out.println("Student ID: " + studentID);

        String[] questions = {
            "1. Attending class on time",
            "2. Explains lessons clearly",
            "3. Well-prepared for class",
            "4. Encourages student participation",
            "5. Overall teaching effectiveness"
        };

        int[] ratings = new int[questions.length]; // Dito iimbak ang raw ratings
        
        System.out.println("\nRATE YOUR INSTRUCTOR");
        System.out.println("1 - LOWEST | 2 - POOR | 3 - AVERAGE | 4 - GOOD | 5 - EXCELLENT\n");

        // Loop para mangolekta ng 5 ratings
        for (int i = 0; i < questions.length; i++) {
            int rate = -1;
            while (rate < 1 || rate > 5) {
                System.out.print(questions[i] + ": ");
                if (sc.hasNextInt()) {
                    rate = sc.nextInt();
                    if (rate < 1 || rate > 5) {
                        System.out.println("Invalid rating. Please enter 1-5 only.");
                    }
                } else {
                    System.out.println("Invalid input. Numbers only.");
                    sc.next();
                }
            }
            ratings[i] = rate; // I-save ang valid rating
        }

        if (sc.hasNextLine()) sc.nextLine(); 

        System.out.print("\nEnter your comments: ");
        String comments = sc.nextLine();

        // I-pa-process ang data sa service logic (internal method)
        double averageRating = processAndSaveFeedback(subjectName, studentID, ratings, comments);

        System.out.println("\nFeedback submitted successfully!");
        System.out.println("Average Rating: " + String.format("%.2f", averageRating) + "\n");
    }
}