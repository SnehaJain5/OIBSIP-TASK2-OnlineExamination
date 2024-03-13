// import java.sql.Time;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Exam {

    static Scanner sc = new Scanner(System.in);
    static String username = "User1";
    static String pass = "1234";
    static boolean timeout = false;
    static int score = 0;

    static boolean login() {
        Scanner loginsc = new Scanner(System.in);
        boolean correct = false;
        System.out.println("Enter username : ");
        String uname = loginsc.nextLine();
        System.out.println("Enter password : ");
        String pword = loginsc.nextLine();
        if (uname.equals(username) && pword.equals(pass)) {
            correct = true;
        }
        return correct;
    }

    static void update() {
        Scanner UpdateLogin = new Scanner(System.in);
        System.out.println("Enter new username: ");
        String Upname = UpdateLogin.nextLine();

        System.out.println("Enter new password: ");
        String Uppass = UpdateLogin.nextLine();

        username = Upname;
        pass = Uppass;
        System.out.println("Updated Credentials!");
    }

    static void exam() {
        Scanner ExamSc = new Scanner(System.in);
        Timer timeObj = new Timer();
        int delay = 10000;   // obj.schedule(FUNCTION(){} , TIME);
        timeObj.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!timeout) {
                    System.out.println("Timer expired, Your exam is over.");
                    System.out.println(
                            "----------------------------------------------------------------------------------------");
                    System.out.println("You scored: " + score + " marks! (Exam timed out)");
                    System.exit(0); // Terminate the program
                }
            }
        }, delay);

        System.out.println("\t\t EXAMINATION PAPER");
        System.out.println("Instructions: This paper will have 5 questions of 2 marks each");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("\t\tEnter answers in a b c d form");
        System.out.println("----------------------------------------------------------------------------------------");

        // int score = 0;
        boolean[] answered = new boolean[5]; // Flag to check if each question is answered

        String q1 = "What is the capital of France?";
        System.out.println(q1);
        String r1 = "a) London b) Paris c) New York d) Sydney";
        System.out.println(r1);
        System.out.println("Enter your answer ");
        String ans1 = ExamSc.nextLine();
        if (!timeout) {
            answered[0] = true;
        }
        if (!timeout && ans1.equalsIgnoreCase("b")) {
            score += 2;
        }

        String q2 = "Which planet is known as the \"Red Planet\"?";
        System.out.println(q2);
        String r2 = "a) Mars b) Earth c) Venus d) Uranus";
        System.out.println(r2);
        System.out.println("Enter your answer ");
        String ans2 = ExamSc.nextLine();
        if (!timeout) {
            answered[1] = true;
        }
        if (!timeout && ans2.equalsIgnoreCase("a")) {
            score += 2;
        }

        String q3 = "Who wrote the play \"Romeo and Juliet\"?";
        System.out.println(q3);
        String r3 = "a) Charles Dickens b) William Shakespeare c) Jane Austen d) Mark Twain";
        System.out.println(r3);
        System.out.println("Enter your answer ");
        String ans3 = ExamSc.nextLine();
        if (!timeout) {
            answered[2] = true;
        }
        if (!timeout && ans3.equalsIgnoreCase("b")) {
            score += 2;
        }

        String q4 = "What is the largest mammal on Earth?";
        System.out.println(q4);
        String r4 = "a) Elephant b) Blue Whale c) Giraffe d) Hippopotamus";
        System.out.println(r4);
        System.out.println("Enter your answer ");
        String ans4 = ExamSc.nextLine();
        if (!timeout) {
            answered[3] = true;
        }
        if (!timeout && ans4.equalsIgnoreCase("b")) {
            score += 2;
        }

        String q5 = "What is the currency of Japan?";
        System.out.println(q5);
        String r5 = "a) Dollar b) Euro c) Yen d) Yuan";
        System.out.println(r5);
        System.out.println("Enter your answer ");
        String ans5 = ExamSc.nextLine();
        if(!timeout){
            answered[4]=true;
        }
        if(!timeout && ans5.equalsIgnoreCase("c"))
        {
            score+= 2;
        }

        if (answered[0] && answered[1] && answered[2] && answered[3] && answered[4]) {
            timeObj.cancel(); // Cancel the timer since all questions are answered
            System.out.println(
                    "----------------------------------------------------------------------------------------");
            System.out.println("You have answered all questions within the time limit!");
            System.out.println("Your final score: " + score + " marks!");
            System.out.println(
                    "----------------------------------------------------------------------------------------");
            return; // Exit the method
        }

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Your exam is over.");
        System.out.println("You scored: " + score + " marks!");
        System.out.println("----------------------------------------------------------------------------------------");
    }

    static void working() {
        System.out.println("1. Update Credentials\n2. Proceed to Exam\n3. Logout");
        System.out.println("Enter your choice: ");
        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                update();
                System.out.println("Login Again!");
                login();

            case 2:
                exam();

            case 3:
                System.out.println("Thank you !");
                return;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    static boolean checkIfCorrect() {
        boolean right = false;
        if (login() == true) {
           right = true;
        }
        return right;
    }

    public static void main(String[] args) {
        if (login() == false) {
            System.out.println("Wrong Id or Password");
            System.out.println("Do you want to update your credentials?");
            System.out.println("Press 1 for Yes  and 2 for No.");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    update();
                    if(checkIfCorrect())
                    {
                        working();
                    }
                    else{
                    System.out.println("limit execeeded , try again later!");
                    }
                case 2:
                    return;
                default:
                    break;
            }
        } else {
            working();
        }
    }
}
