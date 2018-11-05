package jdbc;

import oracle.sql.DATE;

import java.sql.Date;

public class Emp {
    private int number;
    private String name;
    private String job;
    private int mgr;
    private Date hiredate;
    private double sal;
    private double comm;
    private Dept dept;
    private static final double COMM_DEFAULT=0;
    public Emp(int number, String name, String job, int mgr, Date hiredate, double sal, double comm, Dept dept){
        this.number=number;
        this.name=name;
        this.job=job;
        this.mgr=mgr;
        this.hiredate=hiredate;
        this.sal=sal;
        this.comm=comm;
        this.dept=dept;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
