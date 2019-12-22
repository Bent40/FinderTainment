package app;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Main {

    private JFrame frmA;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.frmA.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Main() {
        initialize();
    }

    public void setFrmA(JFrame frmA) {
        this.frmA = frmA;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmA = new JFrame();
        frmA.getContentPane().setBackground(Color.MAGENTA);
        frmA.setTitle("Home\r\n");
        frmA.setForeground(Color.BLACK);
        frmA.setBounds(100, 100, 450, 300);
        frmA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmA.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.setBounds(10, 28, 136, 46);
        frmA.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Guest Login");
        btnNewButton_1.setBounds(10, 85, 136, 46);
        frmA.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Register");
        btnNewButton_2.setBounds(10, 142, 136, 46);
        btnNewButton_2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame	frmb = new JFrame();
                frmb=new Register().getFrmRegister();
                frmb.setVisible(true);

            }
        });
        frmA.getContentPane().add(btnNewButton_2);


	}
}