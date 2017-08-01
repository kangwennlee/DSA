/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author B1
 */
public class MainMenu extends JFrame {

    JLabel title = new JLabel("Welcome to TARUC Security System!");
    JButton[] jbtModuleArr = new JButton[4];
    JPanel panel = new JPanel();
    JFrame[] ScreenArr = new JFrame[4];
    ButtonListener buttonListener = new ButtonListener();

    private MainMenu() {
        initializeMainMenu();
        add(panel);
        //Display the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(350, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }

    private void initializeMainMenu() {
        title.setPreferredSize(new Dimension(210, 30));
        jbtModuleArr[0] = new JButton("Maintain user/guard");
        jbtModuleArr[1] = new JButton("Maintain Emergency Service");
        jbtModuleArr[2] = new JButton("Maintain Task Assignment");
        jbtModuleArr[3] = new JButton("Reporting");
        panel.add(title);
        for (int i = 0; i < jbtModuleArr.length; i++) {
            jbtModuleArr[i].setPreferredSize(new Dimension(200, 50));
            jbtModuleArr[i].addActionListener(buttonListener);
            panel.add(jbtModuleArr[i]);
        }
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.print("button pressed!");
            ScreenArr[0] = new JFrame();
            ScreenArr[0].add(panel);
            ScreenArr[0].setSize(300, 500);
            ScreenArr[0].setVisible(true);
        }
    }
}
