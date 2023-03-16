import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
	   private ClientJava client;

	    private JFrame frame;
	    private JPanel taskPanel;
	    private JPanel employeePanel;

	    private JLabel taskLabel;
	    private JTextField taskIdField, taskDescField, taskEmpIdField;
	    private JTextArea taskListLabel, empListLabel;
	    private JButton addTaskButton, removeTaskButton, updateTaskButton, getTaskListButton, getEmployeebyName;
	   

	    private JLabel employeeLabel;
	    private JTextField employeeIdField, employeeNomField, employeePrenomField, employeeAdresseField, employeeGradeField, employeeNumcompteField, employeeSupField;
	    private JButton addEmployeeButton, removeEmployeeButton, updateEmployeeButton, getEmployeeListButton, getEmployeeById, getTaskById;
	    
	    

    public Main() {
        client = new ClientJava();
      
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

     
        JPanel panel = new JPanel();
       
        panel.setLayout(new GridLayout(6,4));
        add(panel);
        panel.setPreferredSize(new Dimension(700, 500));
        panel.add(Box.createVerticalStrut(2));
        
        //panel.add(Box.createVerticalStrut(1));
      
        Font titleFont = new Font("Arial", Font.BOLD, 25); 
        Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Employee & Task Manager", TitledBorder.CENTER, TitledBorder.TOP, titleFont); 
        panel.setBorder(border);
        JButton button1 = new JButton("Task Management ");
        //button1.setSize(50, 50);

        panel.add(button1);
       panel.add(Box.createVerticalStrut(5));
  

        
        button1.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {

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
               
                
                 taskListLabel =  new JTextArea ();
       
               



                taskPanel = new JPanel();
               // setSize(500, 400);
                taskPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Task Management"));
                taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
                taskPanel.setPreferredSize(new Dimension(700, 500));
                taskPanel.add(taskListLabel);
                taskListLabel.setEditable(false);
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
                taskPanel.add(Box.createVerticalStrut(20));
            

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
//****************************************************************************************************************************
                getTaskListButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	
                    	
                    	String taskList = client.getTaskeList(); 
                    	taskList = taskList.replaceAll("\\\\n", "\n"); 
                    	taskListLabel.setText(taskList); 

                    
                     
                    }
                });
                getTaskById.addActionListener(new ActionListener() {
                	   public void actionPerformed(ActionEvent e) {
                		   Integer id = Integer.parseInt(taskIdField.getText());
                           String res= client.getTaskById(id);
                           res = res.replaceAll("\\\\n", "\n"); 
                       	taskListLabel.setText(res);
                       }
                });
                frame = new JFrame("Employee Task Management System");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
                frame.add(taskPanel);
                
                frame.pack();
                JScrollPane scrollPane = new JScrollPane(taskPanel);
                frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            
                frame.setVisible(true);
                
            }
        });

      
        JButton button2 = new JButton("Employee Management");
        panel.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           

                // Employee panel
            
                employeeLabel = new JLabel("Employee:");
               
            	empListLabel = new JTextArea ();
                
           
             
            
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
                getEmployeebyName = new JButton("Get Employee by Name");
                employeePanel = new JPanel();
                employeePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Employee Management"));
                employeePanel.setLayout(new BoxLayout(employeePanel, BoxLayout.Y_AXIS));
                employeePanel.setPreferredSize(new Dimension(800, 750));
                employeePanel.add(employeeLabel);
                employeePanel.add(empListLabel);
                empListLabel.setEditable(false);
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
                employeePanel.add(Box.createVerticalStrut(20));
                employeePanel.add(getEmployeebyName); 
                
                
                

                getEmployeebyName.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	
                    	 String nom = employeeNomField.getText();
                    	String Emplist = client.getEmpbyName(nom); 
                    	Emplist = Emplist.replaceAll("\\\\n", "\n"); 
                    	empListLabel.setText(Emplist); 

                    
                     
                    }
                });
               // setSize(800, 400);
                JScrollPane scrollPane = new JScrollPane(employeePanel);

           
                

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
                        
                        String emplist = client.getEmployeeList(); 
                        emplist = emplist.replaceAll("\\\\n", "\n"); 
                    	empListLabel.setText(emplist); 
                    }
                });
                //GET by id hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
                getEmployeeById.addActionListener(new ActionListener() {
             	   public void actionPerformed(ActionEvent e) {
             		   Integer id = Integer.parseInt(employeeIdField.getText());
                        String res = client.getEmployeeById(id);
                        
                       
                    	empListLabel.setText(res); 
                        
                    }
             });
                // Main aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                frame = new JFrame("Employee Task Management System");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
                frame.add(employeePanel);
                frame.pack();
                JScrollPane scrollPanel = new JScrollPane(employeePanel);
                frame.getContentPane().add(scrollPanel, BorderLayout.CENTER);
                frame.setVisible(true);
      
            
                
            }
        });
        
        
        
        
        
        JScrollPane scrollPane = new JScrollPane(employeePanel);

        setVisible(true); 
    }

    public static void main(String[] args) {
        new Main();
    }
}
