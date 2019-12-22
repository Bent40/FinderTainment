package app;

import okhttp3.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
public class Register {

    private JFrame frmRegister;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    /////////////////////////////////////////////
    private final OkHttpClient httpClient = new OkHttpClient();
    private Register obj ;




    /**
     * Create the application.
     */
    public Register() {
        initialize();

    }




    public JFrame getFrmRegister() {
        return frmRegister;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmRegister = new JFrame();
        frmRegister.getContentPane().setBackground(SystemColor.info);
        frmRegister.setTitle("Register");
        frmRegister.setBounds(100, 100, 450, 300);
        frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmRegister.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Username\r\n");
        lblNewLabel.setBounds(0, 35, 91, 22);
        lblNewLabel.setFont(new Font("David", Font.PLAIN, 18));
        frmRegister.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(96, 35, 169, 22);
        frmRegister.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Password");
        lblNewLabel_1.setBounds(0, 62, 91, 22);
        lblNewLabel_1.setFont(new Font("David", Font.PLAIN, 18));
        frmRegister.getContentPane().add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(96, 62, 169, 22);
        frmRegister.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Date of birth\r\n");
        lblNewLabel_2.setBounds(0, 89, 91, 22);
        lblNewLabel_2.setFont(new Font("David", Font.PLAIN, 18));
        frmRegister.getContentPane().add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setBounds(96, 89, 169, 22);
        frmRegister.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(0, 116, 91, 24);
        lblEmail.setFont(new Font("David", Font.PLAIN, 18));
        frmRegister.getContentPane().add(lblEmail);

        textField_3 = new JTextField();
        textField_3.setBounds(96, 116, 169, 24);
        frmRegister.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        JButton btnNewButton = new JButton("Submit");
        btnNewButton.setBounds(96, 145, 169, 52);
        btnNewButton.setFont(new Font("David", Font.PLAIN, 20));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                obj = new Register();
                String user="";
                String pass="";
                System.out.println(user);
                user=lblNewLabel.getText();
                pass=lblNewLabel_1.getText();
                try {
                    obj.sendPost(user,pass);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        frmRegister.getContentPane().add(btnNewButton);

    }
    public void sendPost(String username,String pass) throws Exception {

        // form parameters
        RequestBody formBody = new FormBody.Builder()
                .add("username", "omer")
                .add("password", "4353")
                .build();

        Request request = new Request.Builder()
                .url("http://localhost:3000/register")//POST URL
                .post(formBody)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        }

    }
}