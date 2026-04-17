// Customer Feedback Analysis System

// Feedback Class 
class Feedback {
    int score;
    String comment;

    // Constructor using 'this' keyword
    Feedback(int score, String comment) {
        this.score = score;
        this.comment = comment;
    }

    // Getter methods (Behavior)
    int getScore() {
        return score;
    }

    String getComment() {
        return comment;
    }
}

// Analyzer Class (Logic Processing)
class Analyzer {

    // how to calculate average
    double calculateAverage(Feedback[] feedbacks) {
        int sum = 0;

        for (int i = 0; i < feedbacks.length; i++) {
            sum += feedbacks[i].getScore();
        }

        return (double) sum / feedbacks.length;
    }

    // use of switch case
    String getSentiment(double avg) {
        int value = (int) avg;

        switch (value) {
            case 5:
                return "Excellent";
            case 4:
                return "Good";
            case 3:
                return "Average";
            default:
                return "Poor";
        }
    }
}

// Main Class 
public class main {

    public static void main(String[] args) {

        // Array of objects
        Feedback[] data = new Feedback[3];

        // Object creation (Constructor call)
        data[0] = new Feedback(5, "Great");
        data[1] = new Feedback(4, "Good");
        data[2] = new Feedback(4, "Good");

        // Analyzer 
        Analyzer obj = new Analyzer();

        // Logic used in this project
        double avg = obj.calculateAverage(data);
        String result = obj.getSentiment(avg);

        // for Output
        System.out.println("Average Rating: " + avg);
        System.out.println("Customer Sentiment: " + result);
    }
}