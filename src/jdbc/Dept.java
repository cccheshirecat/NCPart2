package jdbc;

public class Dept {
    private int number;
    private String name;
    private String loc;
    public Dept(int number, String name, String loc){
        this.name=name;
        this.loc=loc;
        this.number=number;
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

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
