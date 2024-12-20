import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    // We can also use Arraylist to have all function already implemented

    public static void main(String[] args) {
        menu();
    }

    public static void storeScore(int nbStudents, int [] scoreTable) {
        for (int i = 0; i < nbStudents; i++) {
            System.out.print("Enter the score of student " + (i + 1) + ": ");
            scoreTable[i] = sc.nextInt();
            System.out.println("Score of student " + (i + 1) + " saved");
        }
    }

    public static int [] orderTable(int [] scoreTable) {
        return Arrays.stream(scoreTable).sorted().toArray();
    }

    public static void printScoreTable(int [] scoreTable) {
        for (int i = 0; i < scoreTable.length; i++) {
            System.out.println("score " + (i + 1) +  " : " + scoreTable[i] + " ");
        }
    }

    public static void printInOrder(int[] scoreTable) {
        for (int i = scoreTable.length - 1; i >= 0; i--) {
            System.out.println("score " + (i + 1) +  " : " + scoreTable[i] + " ");
        }
    }

    public static void printAdmitStudents(int[] scoreTable) {
        for (int j : scoreTable) {
            if (j > 10) {
                System.out.println("Admitted student: " + j + " ");
            }
        }
    }

    public static double scoreAverage(int[] scoreTable) {
        double average = 0;
        for (int j : scoreTable) {
            average += j;
        }
        average /= scoreTable.length;
        System.out.println("Average score: " + average + " ");
        return average;
    }

    public static void printScoreGreaterThanAverage(int[] scoreTable) {
        double average = scoreAverage(scoreTable);
        for (int j : scoreTable) {
            if (average < j) {
                System.out.println("Lesser than average score: " + j + " ");
            }
        }
    }

    public static void firstAndLastScore(int[] scoreTable){
        System.out.println("The first score is: "+ scoreTable[0]);
        System.out.println("The last score is: "+ scoreTable[scoreTable.length - 1]);
    }

    public static void menu () {
        int selectedOption;
        int end;
        System.out.println("Hello user! Enter the number of students: ");
        int nbStudents = sc.nextInt();
        int[] scoreTable = new int[nbStudents];
        storeScore(nbStudents, scoreTable );
        do {
            System.out.println("*******************************************************************************");
            System.out.println("Welcome to Java Rappels!");
            System.out.println("1. Ordered score");
            System.out.println("2. First and last score");
            System.out.println("3. Score > 10");
            System.out.println("4. Average score ");
            System.out.println("5. Score greater than average ");
            System.out.println("6. Exit");
            System.out.println("*******************************************************************************");
            System.out.println("Select an option: ");
            selectedOption = sc.nextInt();
            switch (selectedOption){
                case 1:
                    System.out.println("========== Ordered Score ==========");
                    printInOrder(orderTable(scoreTable));
                    System.out.println("===================================");
                    break;
                case 2:
                    System.out.println("========== First and last Score ==========");
                    firstAndLastScore(orderTable(scoreTable));
                    System.out.println("==========================================");
                    break;
                case 3:
                    System.out.println("========== Score > 10 ==========");
                    printAdmitStudents(scoreTable);
                    System.out.println("================================");
                    break;
                case 4:
                    System.out.println("========== Average Score ==========");
                    scoreAverage(scoreTable);
                    System.out.println("===================================");
                    break;
                case 5:
                    System.out.println("========== Score greater than average ==========");
                    printScoreGreaterThanAverage(scoreTable);
                    System.out.println("================================================");
                    break;
                case 6:
                    System.out.println("===================");
                    System.out.println("Thanks you user!!! ");
                    System.out.println("===================");
                    break;
                default:
                    System.out.println("You have selected an incorrect value!");
            }
            System.out.println("Do you want continue Yes(1)/No(0) ?");
            end = sc.nextInt();
        }while (end!=0);


    }
}