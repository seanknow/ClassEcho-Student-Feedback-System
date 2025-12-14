
class Feedback {
    private final String studentID; // ID ng estudyante (Hindi na mababago)
    private final int rating;     // Na-average na rating (1–5)
    private final String comments; // Comments o puna

    public Feedback(String studentID, int rating, String comments) {
        this.studentID = studentID;
        this.rating = rating;
        this.comments = comments;
    }
// (Encapsulation)
    // getters para makuha ang value ng private fields 
    public String getStudentID() { return studentID; }
    public int getRating() { return rating; }
    public String getComments() { return comments; }

    @Override
    public String toString() {
        // Para mas madaling i-display ang impormation ng feedback
        return "Student ID: " + studentID + ", Rating: " + rating + ", Comments: " + comments;
    }
}