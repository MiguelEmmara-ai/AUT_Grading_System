package Grading;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Miguel Emmara
 */
class Grades {
    private double points_given;
    private double total_points;

    public double getPoints_given() {
        return points_given;
    }

    public double getTotal_points() {
        return total_points;
    }

    public Grades invoke(Scanner scanner) {
        boolean stop = false;

        do {
            try {
                System.out.print("\n\tPoints Given: ");
                points_given = scanner.nextDouble();

                System.out.print("\tTotal Points Possible: ");
                total_points = scanner.nextDouble();

                scanner.nextLine();
                stop = true;

            } catch (InputMismatchException e) {
                System.err.println("Please Input Valid Number");
                scanner.nextLine();
            }
        } while (!stop);

        return this;
    }
}

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat df2 = new DecimalFormat("#.##");

    public static void main(String[] args) {
        System.out.println("# AUT Grading System Calculator #");
        runCalculator();

        boolean stop = false;
        do {
            try {
                System.out.print("\nWould you like to calculate again? (y/n): ");
                char str = scanner.next().toLowerCase().charAt(0);

                switch (str) {
                    case 'y':
                        runCalculator();
                        break;
                    case 'n':
                        System.out.println("\nThank You For Using The App");
                        stop = true;
                        break;
                    default:
                        System.out.println("Please Input A Valid Answer");

                }

            } catch (IllegalStateException e) {
                System.err.println("Please Input A Valid Answer");
                scanner.nextLine();
            }
        } while (!stop);
    }

    private static void runCalculator() {
        double points_given;
        double total_points;
        double result;
        Grades grades = new Grades().invoke(scanner);
        points_given = grades.getPoints_given();
        total_points = grades.getTotal_points();

        result = calculateGradePercentage(points_given, total_points);
        calculateLetterGrade(result);
    }

    private static double calculateGradePercentage(double points_given, double total_points) {
        double result = (points_given / total_points) * 100;

        System.out.println("\n# Calculated Results #");
        System.out.println("\nGrade Percentage: " + df2.format(result) + "%");
        return result;
    }

    private static void calculateLetterGrade(double result) {
        String letter_grade;
        if (result >= 89.50) {
            letter_grade = "A+";
        } else if (result <= 89.49 && result >= 84.50) {
            letter_grade = "A";
        } else if (result <= 84.49 && result >= 79.50) {
            letter_grade = "A-";
        } else if (result <= 79.49 && result >= 74.50) {
            letter_grade = "B+";
        } else if (result <= 74.49 && result >= 69.50) {
            letter_grade = "B";
        } else if (result <= 69.49 && result >= 64.50) {
            letter_grade = "B-";
        } else if (result <= 64.49 && result >= 59.50) {
            letter_grade = "C+";
        } else if (result <= 59.49 && result >= 54.50) {
            letter_grade = "C";
        } else if (result <= 54.49 && result >= 49.50) {
            letter_grade = "C-";
        } else {
            letter_grade = "D";
        }

        System.out.println("Letter Grade: " + letter_grade);
    }
}
