// Customer Feedback Analysis System By Ayush kumar-10341


interface Reportable {
    void generateReport();
}

class InvalidScoreException extends Exception {
    InvalidScoreException(String msg) {
        super(msg);
    }
}

abstract class User {
    protected String name;

    User(String name) {
        this.name = name;
    }

    abstract void display();
}


class Customer extends User {

    Customer(String name) {
        super(name);
    }


    void display() {
        System.out.println("Customer: " + name);
    }
}


class Feedback {

    private int score;
    private String comment;

    Feedback(int score, String comment)
            throws InvalidScoreException {

        if(score < 1 || score > 5) {
            throw new InvalidScoreException(
                    "Score must be between 1 and 5");
        }

        this.score = score;
        this.comment = comment;
    }

    public int getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}


class Analyzer implements Reportable {

    final String COMPANY = "CustomerCare Ltd";


    double calculateAverage(Feedback[] feedbacks) {

        int sum = 0;

        for(int i = 0; i < feedbacks.length; i++) {
            sum += feedbacks[i].getScore();
        }

        return (double)sum / feedbacks.length;
    }

    double calculateAverage(int total, int count) {
        return (double) total / count;
    }

    String getSentiment(double avg) {

        if(avg >= 4.5)
            return "Excellent";
        else if(avg >= 3.5)
            return "Good";
        else if(avg >= 2.5)
            return "Average";
        else
            return "Poor";
    }

    public void generateReport() {
        System.out.println("Report Generated Successfully");
    }
}

public class Main {

    public static void main(String[] args) {

        try {

            Customer c1 = new Customer("Ayush");
            c1.display();

            // Array of Objects
            Feedback[] data = new Feedback[5];

            data[0] = new Feedback(5, "Excellent Service");
            data[1] = new Feedback(4, "Very Good");
            data[2] = new Feedback(3, "Average");
            data[3] = new Feedback(5, "Loved It");
            data[4] = new Feedback(4, "Nice Experience");

            Analyzer obj = new Analyzer();

            double avg =
                    obj.calculateAverage(data);

            String sentiment =
                    obj.getSentiment(avg);

            StringBuilder report =
                    new StringBuilder();

            report.append("\n===== CUSTOMER FEEDBACK REPORT =====\n");

            for(Feedback f : data) {

                report.append("Score: ")
                      .append(f.getScore())
                      .append(" | Comment: ")
                      .append(f.getComment())
                      .append("\n");
            }

            report.append("\nAverage Rating: ")
                  .append(avg);

            report.append("\nSentiment: ")
                  .append(sentiment);

            System.out.println(report);

            obj.generateReport();

            int roundedAvg = (int)avg;

            switch(roundedAvg) {
                case 5:
                    System.out.println("Outstanding Feedback");
                    break;

                case 4:
                    System.out.println("Good Feedback");
                    break;

                case 3:
                    System.out.println("Average Feedback");
                    break;

                default:
                    System.out.println("Needs Improvement");
            }

        }

        catch(InvalidScoreException e) {
            System.out.println("Error: "
                    + e.getMessage());
        }

        catch(Exception e) {
            System.out.println("Unexpected Error");
        }

        finally {
            System.out.println("Program Executed Successfully");
        }
    }
}
