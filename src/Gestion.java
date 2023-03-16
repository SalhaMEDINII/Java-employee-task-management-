

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class Gestion extends UnicastRemoteObject implements GestionI {
    
   
    Connection connection;
    public Gestion() throws RemoteException {
        try{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/projet0101", "root", "");
        
        }catch(SQLException e){
            System.out.println(e);
        }
       
    }

 
    public void addTask(Integer id,String desc, Integer empid) throws RemoteException {
        try{
            
            
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/projet0101", "root", "");
                
                String sql = "INSERT INTO task (id, des, employee_id) VALUES (?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);

             
                statement.setInt(1, id);
                statement.setString(2, desc);
                statement.setInt(3, empid);
             

                
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                  System.out.println("Un nouvel task a été ajouté avec succès!");
                }
              } catch (SQLException ex) {
                ex.printStackTrace();
              } 
    }PreparedStatement pstmt;
    
    //mmmmmmmm
    public void UpdateTask(Integer id, String desc, Integer empid) throws RemoteException {
    	
    	 
  try{  
                 connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/projet0101", "root", "");
                 
                 String sql = "UPDATE task SET des = ?, employee_id = ? WHERE id = ?";
                  pstmt = connection.prepareStatement(sql);

                 
                 pstmt.setString(1, desc);
                 pstmt.setInt(2, empid);
                 pstmt.setInt(3, id);

                
                 int rowsUpdated = pstmt.executeUpdate();
                 System.out.println(rowsUpdated + " tâche(s) mise(s) à jour");
             } catch (SQLException e) {
                 System.out.println("Erreur de mise à jour de la tâche: " + e.getMessage());
             } finally {
               
                 try {
                     if (pstmt != null) pstmt.close();
                     if (connection != null) connection.close();
                 } catch (SQLException e) {
                     System.out.println("Erreur lors de la fermeture des ressources: " + e.getMessage());
                 }
             }
    }
    public void removeTask(Integer id) throws RemoteException {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/projet0101", "root", "");

            String sql = "DELETE FROM task WHERE id = ?";
            pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();
            System.out.println(rowsDeleted + "REMOVED !");
        } catch (SQLException e) {
            System.out.println("Error while deleting " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error while ress : " + e.getMessage());
            }
        }
    }

    public String getTaskList() throws RemoteException {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/projet0101", "root", "");
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM task");

            StringBuilder sb = new StringBuilder();
            sb.append("------+----------------------------------------+------------+\n");
            sb.append("| ID   | Description                            | EmployeeID |\n");
            sb.append("+------+----------------------------------------+------------+\n");
            while (res.next()) {
                String id = res.getString("id");
                String des = res.getString("des");
                String employeeId = res.getString("employee_id");
                sb.append(String.format("| %-4s | %-38s | %-10s |\n", id, des, employeeId));
            }
            sb.append("+------+----------------------------------------+------------+\n");
            
            connection.close();
            return sb.toString();
        } catch (Exception e) {
            System.out.println(e);
            return "Erreur lors de l'exécution de la requête.";
        }
    }
    
    
    //*********************************************************************************************************************************************
    public String getTaskById(Integer id) throws RemoteException {
        String result = "";
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/projet0101", "root", "");
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM task WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet res = pstmt.executeQuery();
            result += "ID\tDescription\tEmployee ID\n";
            result += "------------------------------------------------------------------------------------------------------------------\n";
            while (res.next()) {
                Integer column1 = res.getInt("id");
                String column2 = res.getString("des");
                Integer column4 = res.getInt("employee_id");
                result += column1 + "\t" + column2 + "\t" + column4  + "\n";
            }
            connection.close();
        } catch(Exception e) { 
            System.out.println(e);
        }
        return result;
    }

    public String getEmployeeById(Integer id) throws RemoteException {
        String result = "";
            
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/projet0101", "root", "");
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM employee WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet res = pstmt.executeQuery();

            result += "ID\tNom\tPrénom\tAdresse\tGrade\tNuméro de compte\tSuperviseur";
            result += "--------------------------------------------------------------------------------------------------------------------------\n";

            while (res.next()) {
                Integer column0 = res.getInt("id");
                String column1 = res.getString("nom");
                String column2 = res.getString("prenom");
                String column3 = res.getString("adresse");
                Integer column4 = res.getInt("numcompte");
                String column5 = res.getString("grade");
                String column6 = res.getString("sup");

                result += column0 + "\t" + column1 + " " + column2 + "\t" + column3 + "\t" + column4 + "\t" + column5 + "\t" + column6 + "\n";
            }

            connection.close();
        } catch(Exception e) { 
            System.out.println(e);
        } 

        return result;
    }
    
    public String getEmpbyName(String name) throws RemoteException {
        String result = "";
            
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/projet0101", "root", "");
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM employee WHERE nom = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet res = pstmt.executeQuery();

            result += "ID\tNom\tPrénom\tAdresse\tGrade\tNuméro de compte\tSuperviseur";
            result += "--------------------------------------------------------------------------------------------------------------------------\n";

            while (res.next()) {
                Integer column0 = res.getInt("id");
                String column1 = res.getString("nom");
                String column2 = res.getString("prenom");
                String column3 = res.getString("adresse");
                Integer column4 = res.getInt("numcompte");
                String column5 = res.getString("grade");
                String column6 = res.getString("sup");

                result += column0 + "\t" + column1 + " " + column2 + "\t" + column3 + "\t" + column4 + "\t" + column5 + "\t" + column6 + "\n";
            }

            connection.close();
        } catch(Exception e) { 
            System.out.println(e);
        } 

        return result;
    }
    

    public void addEmployee(Integer id, String  nom,String  prenom,String  adresse, String  grade,Integer numcompte, String  sup) throws RemoteException {
            try{
            
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/projet0101", "root", "");
               
          
             String sql = "INSERT INTO employee (id, nom, prenom, adresse, grade, numcompte, sup) VALUES (?, ?, ?, ?, ?, ?, ?)";
             PreparedStatement statement = connection.prepareStatement(sql);

   
             statement.setInt(1, id);
             statement.setString(2, nom);
             statement.setString(3, prenom);
             statement.setString(4, adresse);
             statement.setString(5, grade);
             statement.setInt(6, numcompte);
             statement.setString(7, sup);

         
             int rowsInserted = statement.executeUpdate();
             if (rowsInserted > 0) {
               System.out.println("Un nouvel employé a été ajouté avec succès!");
             }
           } catch (SQLException ex) {
             ex.printStackTrace();
           } 
       
    }
        

    public void UpdateEmployee(Integer id, String  nom,String  prenom,String  adresse, String  grade,Integer numcompte, String  sup) throws RemoteException {
            try{   connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/projet0101", "root", "");
                
            String sql = "UPDATE employee SET nom = ?, prenom = ?, adresse = ?, grade = ?, numcompte = ?, sup = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setString(3, adresse);
            statement.setString(4, grade);
            statement.setInt(5, numcompte);
            statement.setString(6, sup);
            statement.setInt(7, id);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }
    
    
    Statement stmt=null ;
 
    public void removeEmployee(Integer id) throws RemoteException {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/projet0101", "root", "");

            String sql = "DELETE FROM employee WHERE id = ?";
            pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();
            System.out.println(rowsDeleted + "REMOVED !");
        } catch (SQLException e) {
            System.out.println("Error while deleting " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error while ress : " + e.getMessage());
            }
      
        
        }}


    public String getEmployeeList() throws RemoteException {
        StringBuilder sb = new StringBuilder();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/projet0101", "root", "");

            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM employee");

            String[] header = {"ID", "Nom", "Prénom", "Adresse", "Grade", "Numéro de compte", "Superviseur"};

            int[] columnWidths = {5, 15, 15, 20, 10, 20, 20};

            // Print header
            for (int i = 0; i < header.length; i++) {
                sb.append(String.format("%-" + columnWidths[i] + "s", header[i]));
            }
            sb.append("\n");

            // Print separator
            for (int i = 0; i < columnWidths.length; i++) {
                for (int j = 0; j < columnWidths[i]; j++) {
                    sb.append("-");
                }
            }
            sb.append("\n");

            // Print data
            while (res.next()) {
                String id = Integer.toString(res.getInt("id"));
                String nom = res.getString("nom");
                String prenom = res.getString("prenom");
                String adresse = res.getString("adresse");
                String grade = res.getString("grade");
                String numcompte = Integer.toString(res.getInt("numcompte"));
                String sup = res.getString("sup");

                String[] row = {id, nom, prenom, adresse, grade, numcompte, sup};

                for (int i = 0; i < row.length; i++) {
                    sb.append(String.format("%-" + columnWidths[i] + "s", row[i]));
                }
                sb.append("\n");
            }

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return sb.toString();
    }


    
      public static void main ( String [] args ){
    	  try{
    		  Connection connection;
    	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/projet0101", "root", "");
    	        System.out.println("DONE ");
    	      
    	      
    	     
    	        
    	        }catch(SQLException e){
    	            System.out.println(e);
    	        }
    	       
      }
      
      
    
}
