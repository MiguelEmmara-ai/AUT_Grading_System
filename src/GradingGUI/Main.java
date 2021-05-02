package GradingGUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Miguel Emmara
 */
public class Main extends JFrame {
    public Main() {
        AppPanel appPanel = new AppPanel("Tatakae!");

        //get the size of the screen
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        this.setSize(500, 500);

        //Calculate the frame location
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;

        appPanel.setLocation(10, 50);
        this.getContentPane().add(appPanel);
        this.setLocation(x, y);
        this.setTitle("AUT Grading System Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
