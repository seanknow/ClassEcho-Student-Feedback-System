import java.util.ArrayList;
import java.util.List;

/**
 * Class na nagha-hold ng pangalan ng subject at listahan ng Feedback nito.
 */
class Subject {
    private final String name; // Pangalan ng subject
    private final List<Feedback> feedbackList; // Listahan ng feedback para sa subject na ito

    public Subject(String name) {
        this.name = name;
        this.feedbackList = new ArrayList<>(); // Initialize ang listahan
    }

    public String getName() {
        return name;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList; // Ibalik ang buong listahan
    }
    
    // Para direktang makapag-add ng feedback
    public void addFeedback(Feedback feedback) {
        this.feedbackList.add(feedback); // Idagdag ang bagong feedback sa listahan
    }
}