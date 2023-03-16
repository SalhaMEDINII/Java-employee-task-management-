import javax.swing.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.*;

public class ClientGUI {

    private ClientJava client;

    private JFrame frame;
    private JPanel taskPanel;
    private JPanel employeePanel;

    private JLabel taskLabel;
    private JTextField taskIdField, taskDescField, taskEmpIdField;
    private JButton addTaskButton, removeTaskButton, updateTaskButton, getTaskListButton;

    private JLabel employeeLabel;
    private JTextField employeeIdField, employeeNomField, employeePrenomField, employeeAdresseField, employeeGradeField, employeeNumcompteField, employeeSupField;
    private JButton addEmployeeButton, removeEmployeeButton, updateEmployeeButton, getEmployeeListButton, getEmployeeById, getTaskById;

    public ClientGUI() {
        client = new ClientJava();

        // Task panel
        taskLabel = new JLabel("Task:");
        taskIdField = new JTextField(10);
        taskDescField = new JTextField(10);
        taskEmpIdField = new JTextField(10);
        addTaskButton = new JButton("Add");
        removeTaskButton = new JButton("Remove");
        updateTaskButton = new JButton("Update");
        getTaskListButton = new JButton("Get List");
        getTaskById = new JButton("Get Task By Id");

        taskPanel = new JPanel();
        taskPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Task Management"));
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        taskPanel.add(taskLabel);
        taskPanel.add(new JLabel("Id:"));
        taskPanel.add(taskIdField);
        taskPanel.add(new JLabel("Description:"));
        taskPanel.add(taskDescField);
        taskPanel.add(new JLabel("Employee Id:"));
        taskPanel.add(taskEmpIdField);
        taskPanel.add(Box.createVerticalStrut(20));
        taskPanel.add(addTaskButton);
        taskPanel.add(Box.createVerticalStrut(20));
        taskPanel.add(removeTaskButton);
        taskPanel.add(Box.createVerticalStrut(20));
        taskPanel.add(updateTaskButton);
        taskPanel.add(Box.createVerticalStrut(20));
        taskPanel.add(getTaskListButton);
        taskPanel.add(Box.createVerticalStrut(20));
        taskPanel.add(getTaskById); 

        addTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = Integer.parseInt(taskIdField.getText());
                String desc = taskDescField.getText();
                Integer empid = Integer.parseInt(taskEmpIdField.getText());
                client.addTask(id, desc, empid);
            }
        });

        removeTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = Integer.parseInt(taskIdField.getText());
                client.removeTask(id);
            }
        });

        updateTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = Integer.parseInt(taskIdField.getText());
                String desc = taskDescField.getText();
                Integer empid = Integer.parseInt(taskEmpIdField.getText());
                client.UpdateTask(id, desc, empid);
            }
        });

        getTaskListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                client.getTaskeList();
            }
        });
        getTaskById.addActionListener(new ActionListener() {
        	   public void actionPerformed(ActionEvent e) {
        		   Integer id = Integer.parseInt(taskIdField.getText());
                   client.getTaskById(id);
               }
        });

        // Employee panel
        employeeLabel = new JLabel("Employee:");
        employeeIdField = new JTextField(10);
        employeeNomField = new JTextField(10);
        employeePrenomField = new JTextField(10);
        employeeAdresseField = new JTextField(10);
        employeeGradeField = new JTextField(10);
        employeeNumcompteField = new JTextField(10);
        employeeSupField = new JTextField(10);
        addEmployeeButton= new JButton("Add");
        removeEmployeeButton = new JButton("Remove");
        updateEmployeeButton = new JButton("Update");
        getEmployeeListButton = new JButton("Get List");
        getEmployeeById  = new JButton("Get Employee By Id");
        employeePanel = new JPanel();
        employeePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Employee Management"));
        employeePanel.setLayout(new BoxLayout(employeePanel, BoxLayout.Y_AXIS));
        employeePanel.add(employeeLabel);
        employeePanel.add(new JLabel("Id:"));
        employeePanel.add(employeeIdField);
        employeePanel.add(new JLabel("First Name:"));
        employeePanel.add(employeeNomField);
        employeePanel.add(new JLabel("Last Name:"));
        employeePanel.add(employeePrenomField);
        employeePanel.add(new JLabel("Address:"));
        employeePanel.add(employeeAdresseField);
        employeePanel.add(new JLabel("Degree:"));
        employeePanel.add(employeeGradeField);
        employeePanel.add(new JLabel("Account Num:"));
        employeePanel.add(employeeNumcompteField);
        employeePanel.add(new JLabel("Supervisor Id:"));
        employeePanel.add(employeeSupField);
        employeePanel.add(Box.createVerticalStrut(20));
        employeePanel.add(addEmployeeButton);
        employeePanel.add(Box.createVerticalStrut(20));
        employeePanel.add(removeEmployeeButton);
        employeePanel.add(Box.createVerticalStrut(20));
        employeePanel.add(updateEmployeeButton);
        employeePanel.add(Box.createVerticalStrut(20));
        employeePanel.add(getEmployeeListButton);
        employeePanel.add(Box.createVerticalStrut(20));
        employeePanel.add(getEmployeeById);
        

        addEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = Integer.parseInt(employeeIdField.getText());
                String nom = employeeNomField.getText();
                String prenom = employeePrenomField.getText();
                String adresse = employeeAdresseField.getText();
                String grade = employeeGradeField.getText();
                String numcompte = employeeNumcompteField.getText();
                Integer supid = Integer.parseInt(employeeSupField.getText());
                client.addEmployee(id, nom, prenom, adresse, grade, supid, numcompte);
            }
        });

        removeEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = Integer.parseInt(employeeIdField.getText());
                client.removeEmployee(id);
            }
        });

        updateEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id = Integer.parseInt(employeeIdField.getText());
                String nom = employeeNomField.getText();
                String prenom = employeePrenomField.getText();
                String adresse = employeeAdresseField.getText();
                String grade = employeeGradeField.getText();
                String numcompte = employeeNumcompteField.getText();
                Integer supid = Integer.parseInt(employeeSupField.getText());
                client.UpdateEmployee(id, nom, prenom, adresse, grade, supid, numcompte);
            }
        });

        getEmployeeListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                client.getEmployeeList();
            }
        });
        getEmployeeById.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent e) {
     		   Integer id = Integer.parseInt(employeeIdField.getText());
                client.getEmployeeById(id);
            }
     });
        // Main frame
        frame = new JFrame("Employee Task Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(taskPanel);
        frame.add(employeePanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ClientGUI();
    }
}
