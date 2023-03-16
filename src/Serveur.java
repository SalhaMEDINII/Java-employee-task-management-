


import java.rmi.*;
import java.rmi.registry.LocateRegistry;


/**
 *
 * @author DELL
 */
public class Serveur {
	 public Serveur() {
		 
	 }
     public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(6000);
            //System.setSecurityManager(new RMISecurityManager()) ;
            Gestion taskManager = new Gestion();
            Naming.rebind("rmi://localhost:6000/TaskManager", taskManager);
            System.out.println("TaskManager bound in registry");
        } catch (Exception e) {
            System.out.println("Error binding TaskManager in registry: " + e);
        }
    }
    
}
