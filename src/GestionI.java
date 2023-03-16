
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author DELL
 */
public interface GestionI extends Remote {
    void addTask(Integer id,String desc, Integer empid) throws RemoteException;
    void UpdateTask(Integer id,String desc, Integer empid) throws RemoteException;
    void removeTask(Integer id) throws RemoteException ;
    String getTaskList() throws RemoteException;
    void addEmployee(Integer id, String  nom,String  prenom,String  adresse, String  grade,Integer numcompte, String  sup) throws RemoteException;
    void UpdateEmployee(Integer id, String  nom,String  prenom,String  adresse, String  grade,Integer numcompte, String  sup) throws RemoteException;
    void removeEmployee(Integer id) throws RemoteException ;
    String getEmployeeList() throws RemoteException;
    String getEmployeeById(Integer id) throws RemoteException;
    String getTaskById(Integer id) throws RemoteException;
    String getEmpbyName(String name) throws RemoteException ;
    
}
