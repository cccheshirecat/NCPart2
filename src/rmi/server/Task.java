package rmi.server;

import java.io.Serializable;

public class Task implements Serializable {
    private double opA;
    private double opB;
    private static final String MATH_OPERATION="+";

    public Task(double opA,double opB){
        this.opA=opA;
        this.opB=opB;
    }

    public void setOpA(double opA) {
        this.opA = opA;
    }

    public void setOpB(double opB) {
        this.opB = opB;
    }

    public double getOpA() {
        return opA;
    }

    public double getOpB() {
        return opB;
    }

    public String getMATH_OPERATION() {
        return MATH_OPERATION;
    }
    public String toString(){
        return String.format("%s (%f.2 %s %f.2)", this.getClass().getSimpleName(), this.opA, this.MATH_OPERATION, this.opB);

    }
}
