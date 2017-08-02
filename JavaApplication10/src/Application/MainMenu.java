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

    JPanel[] panel = new JPanel[5];
    ButtonListener buttonListener = new ButtonListener();
    Integer choice = null;

    private MainMenu() {
        initializeMainMenu(-1);
        
        //Display the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(350, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }

    private void initializeMainMenu(int toRemove) {
        JLabel title = new JLabel();
        JButton[] jbtModuleArr = new JButton[4];
        title.setText("Welcome to TARUC Security System!");
        title.setPreferredSize(new Dimension(210, 30));
        jbtModuleArr[0] = new JButton("Maintain user/guard");
        jbtModuleArr[1] = new JButton("Maintain Emergency Service");
        jbtModuleArr[2] = new JButton("Maintain Task Assignment");
        jbtModuleArr[3] = new JButton("Reporting");
        panel[0] = new JPanel();
        panel[0].add(title);
        for (int i = 0; i < jbtModuleArr.length; i++) {
            jbtModuleArr[i].setName(String.valueOf(i));
            jbtModuleArr[i].setPreferredSize(new Dimension(200, 50));
            jbtModuleArr[i].addActionListener(buttonListener);
            panel[0].add(jbtModuleArr[i]);
        }
        moduleSelection(toRemove,0);
    }

    private void initializeModule1(int toRemove) {
        JLabel title = new JLabel();
        JButton[] jbtModuleArr = new JButton[5];
        title.setText("User/Guard Module");
        title.setPreferredSize(new Dimension(210, 30));
        jbtModuleArr[0] = new JButton("Add user");
        jbtModuleArr[1] = new JButton("Print User");
        jbtModuleArr[2] = new JButton("Add Guard");
        jbtModuleArr[3] = new JButton("Print Guard");
        jbtModuleArr[3] = new JButton("Back to main menu");
        panel[1] = new JPanel();
        panel[1].add(title);
        for (int i = 0; i < jbtModuleArr.length; i++) {
            jbtModuleArr[i].setName(String.valueOf(i));
            jbtModuleArr[i].setPreferredSize(new Dimension(200, 50));
            jbtModuleArr[i].addActionListener(buttonListener);
            panel[1].add(jbtModuleArr[i]);
        }
        moduleSelection(toRemove,0);
    }

    private void moduleSelection(int toRemove, int toAdd) {
        setVisible(false);
        if (toRemove != -1) {
            remove(panel[toRemove]);
        }
        add(panel[toAdd]);
        setSize(300, 500);
        setVisible(true);
    }
    

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                choice = Integer.parseInt(((JButton) e.getSource()).getName());
                System.out.println("button pressed!" + choice);
            }
            if (choice == 0)
                initializeModule1(0);
        }
    }
}
