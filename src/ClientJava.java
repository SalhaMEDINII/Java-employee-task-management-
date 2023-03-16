
import java.rmi.*;



/**
 *
 * @author DELL
 */
public class ClientJava {
  

    private GestionI taskManager;

    public ClientJava() {
        try {
            
            taskManager = (GestionI) Naming.lookup("rmi://localhost:6000/TaskManager");
            System.out.println("TaskManager found in registry");
        } catch (Exception e) {
            System.out.println("TaskManager not found: " + e);
        }
    }
    
    
    
    
    
    String rez;
    public String getTaskById(Integer id) {
        try {
          rez= taskManager.getTaskById(id);
        } catch (Exception e) {
            System.out.println("Error getting task ! " + e);
            
        }
        return rez;
       
        
        
        
       
    }
    public String getEmployeeById(Integer id) {
        try {
          rez = taskManager.getEmployeeById(id);
        } catch (Exception e) {
            System.out.println("Error getting employee !  " + e);
            
        }
        return rez;
       
        
        
        
       
    }
    
    
    
    public String getEmpbyName(String name) {
        try {
          rez = taskManager.getEmpbyName(name);
        } catch (Exception e) {
            System.out.println("Error getting employee !  " + e);
            
        }
        return rez;
       
        
        
        
       
    }
	String res;
    
    public String getTaskeList() {
    
        try {
           res=taskManager.getTaskList();
        } catch (Exception e) {
            System.out.println("Error getting task list: " + e);
            
        }
        return res;
       
        
        
        
       
    }
    


    public void addTask(Integer id,String desc, Integer empid) {
        try {
            taskManager.addTask(id, desc, empid);
            
     
        } catch (Exception e) {
            System.out.println("Error adding task: " + e);
        }
        System.out.printf("Task added!!!");
    }
    
    
    
    

    public void removeTask(Integer id) {
        try {
           taskManager.removeTask(id);
          
        } catch (Exception e) {
            System.out.println("Error removing task: " + e);
        }
        System.out.println("Task removed: " );
    }
    
    
    
       public void UpdateTask(Integer id, String desc, Integer empid) {
        try {
           taskManager.UpdateTask(id, desc, empid);
         
        } catch (Exception e) {
            System.out.println("Error updating task: " + e);
        }
        System.out.println("Task updated");
    }
    

       
       
    public String getEmployeeList() {
        try {
         res = taskManager.getEmployeeList();
        } catch (Exception e) {
            System.out.println("Error getting employees list: " + e);
            
        }
        return res;
    
    }
     
        public void addEmployee(Integer id, String  nom,String  prenom,String  adresse, String  grade,Integer numcompte, String  sup) {
        try {
            taskManager.addEmployee(id, nom, prenom, adresse, grade, numcompte, sup);
          
     
        } catch (Exception e) {
            System.out.println("Error adding employee: " + e);
        }
        System.out.println("Employee added!!! \n  ");
    }

        
        
        
    public void removeEmployee(Integer id) {
        try {
            taskManager.removeEmployee(id);
           
           
        } catch (Exception e) {
            System.out.println("Error removing employee  : " + e);
        }
        System.out.println("Employee removed: ");
    }
    
    
       public void UpdateEmployee(Integer id, String  nom,String  prenom,String  adresse, String  grade,Integer numcompte, String  sup) {
        try {
           taskManager.UpdateEmployee(id, nom, prenom, adresse, grade, numcompte, sup);
            System.out.println("Employee updated");
        } catch (Exception e) {
            System.out.println("Error updating Employee: " + e);
        }
    }
    


    public static void main(String[] args) {

        ClientJava client = new ClientJava();
        
        //client.addEmployee(16, "MEDINI1", "salha1", "Tunis1", "EMPLOYEE", 198753698, "superier de salha ajouté par RMI pour la deuxiéme fois..");
        //client.addTask(75, "Task ajouté par l'application RMI", 12);
        //client.UpdateTask(74, "Modifié", 12);
        //client.UpdateEmployee(16, "nom modifié", "prenom", "adresse", "grade", 141414, "sup modifié ");
        //client.removeEmployee(2);
        //client.removeTask(10);
        //client.getEmployeeList();
        //client.getTaskeList();
        
   
    }
}

    
