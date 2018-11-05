package rmi.client;

import rmi.server.AddTask;
import rmi.server.Task;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        AddTask addTask;
        Registry registry;
        registry = LocateRegistry.getRegistry(1225);
        addTask = (AddTask) registry.lookup("AddTask");
        System.out.println("Client: ok");
        Task task=new Task(7,5);
        System.out.println("opA:"+task.getOpA());
        System.out.println("opB:"+task.getOpB());
        System.out.println(addTask.getResult(task));
    }
}
