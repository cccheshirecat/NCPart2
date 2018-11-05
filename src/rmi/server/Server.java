package rmi.server;

import rmi.server.AddTask;
import rmi.server.AddTaskImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    private  static final int PORT=1225;
    private static Registry registry;
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        /*registry= LocateRegistry.createRegistry(PORT);
        registry.bind("AddTaskImpl",new AddTaskImpl());*/
        AddTask addTask=new AddTaskImpl();
            registry=LocateRegistry.createRegistry(PORT);
            registry.rebind("AddTask",addTask);
           // Naming.rebind("rmi://192.168.101.02:1099/AddTask",addTask);
            System.out.println("Server: ok");

    }
}
