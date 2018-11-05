package rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddTaskImpl extends UnicastRemoteObject implements AddTask {
    public AddTaskImpl()throws RemoteException{}
    @Override
    public double getResult(Task task) throws RemoteException {
        double opA=task.getOpA();
        double opB=task.getOpB();
        return opA+opB;
    }
}
