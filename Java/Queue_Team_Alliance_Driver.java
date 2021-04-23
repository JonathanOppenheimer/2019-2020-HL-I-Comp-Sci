package Java;

import javax.swing.JOptionPane;

public class Queue_Team_Alliance_Driver {
    public static void main(String[] args) {
        int max_length = Integer.parseInt(JOptionPane.showInputDialog("How many total teams would you like to use?"));
        ;
        try {
            Queue_Team_Alliance_Client runner = new Queue_Team_Alliance_Client(max_length);
            JOptionPane.showMessageDialog(null, runner);
        } catch (Exception e) {
            System.out.println("Data entry failed or program was quit prematurely.");
            System.out.println("The error message was '" + e + "'");
        }

    }

}
