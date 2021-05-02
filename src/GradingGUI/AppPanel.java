package GradingGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Created by Miguel Emmara
 */
public class AppPanel extends JPanel {
    private static final DecimalFormat df2 = new DecimalFormat("#.##");
    private final JLabel grade_percentage_label;
    private final JLabel grade_letter_label;
    private final JTextField point_given_field, point_possible_field;
    private final JButton button;

    public AppPanel(String title) {
        ButtonListener listener = new ButtonListener();
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(title));

        // Button and Label
        JLabel point_given_label = new JLabel("Points Given ");
        point_given_label.setLocation(10, 20);
        point_given_label.setSize(200, 50);
        this.add(point_given_label);

        JLabel point_possible_label = new JLabel("Total Points Possible ");
        point_possible_label.setLocation(10, 50);
        point_possible_label.setSize(200, 50);
        this.add(point_possible_label);

        JLabel result_label = new JLabel("# Calculated Results #");
        result_label.setLocation(180, 180);
        result_label.setSize(200, 50);
        this.add(result_label);

        grade_percentage_label = new JLabel("Grade Percentage: ");
        grade_percentage_label.setLocation(50, 210);
        grade_percentage_label.setSize(200, 50);
        this.add(grade_percentage_label);

        grade_letter_label = new JLabel("Letter Grade: ");
        grade_letter_label.setLocation(50, 250);
        grade_letter_label.setSize(200, 50);
        this.add(grade_letter_label);

        button = new JButton("Calculate Grade");
        button.setLocation(170, 130);
        button.setSize(150, 30);
        button.setFocusable(false);
        button.addActionListener(listener);
        this.add(button);

        // Fields
        point_given_field = new JTextField();
        point_given_field.setLocation(150, 25);
        point_given_field.setSize(200, 30);
        this.add(point_given_field);

        point_possible_field = new JTextField();
        point_possible_field.setLocation(150, 60);
        point_possible_field.setSize(200, 30);
        this.add(point_possible_field);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                if (point_given_field.getText().isEmpty() || point_possible_field.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(), "Please Fill Out Both Field", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    double result = calculateGradePercentage();
                    calculateLetterGrade(result);
                }
            }
        }

        private double calculateGradePercentage() {
            String points_given = point_given_field.getText();
            String total_points = point_possible_field.getText();

            double tempPointsGiven = Double.parseDouble(points_given);
            double tempTotalPoints = Double.parseDouble(total_points);

            double result = (tempPointsGiven / tempTotalPoints) * 100;

            grade_percentage_label.setText("Grade Percentage: " + df2.format(result) + "%");
            return result;
        }

        private void calculateLetterGrade(double result) {
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

            grade_letter_label.setText("Letter Grade: " + letter_grade);
        }
    }
}