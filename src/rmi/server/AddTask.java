package rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddTask extends Remote {
    public double getResult(Task task) throws RemoteException;
}
