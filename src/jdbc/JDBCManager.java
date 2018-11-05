package jdbc;

import oracle.jdbc.pool.OracleDataSource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class JDBCManager {
    private String url="jdbc:oracle:thin:@DESKTOP-UHDGH05:1521:XE";
    private String userName="SYSTEM";
    private String password="123";
    private Connection connection;
    private OracleDataSource dataSource;
    private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    public JDBCManager(){
        try {
            Locale.setDefault(Locale.ENGLISH);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            dataSource=new OracleDataSource();
            dataSource.setDriverType("thin");
            dataSource.setServerName("DESKTOP-UHDGH05");
            dataSource.setPortNumber(1521);
            dataSource.setDatabaseName("XE");
            dataSource.setUser(userName);
            dataSource.setPassword(password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //todo сделать класс Emploee Deparrtment
    //todo datsourse
    public Emp getEmpInf(int id) {
        Dept dept;
        Emp emp;
        try {
            connection = dataSource.getConnection();
            String sql = "SELECT * FROM EMP, DEPT WHERE EMP.EMPNO=? AND EMP.deptno=DEPT.deptno";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                dept = new Dept(resultSet.getInt(9), resultSet.getString(10), resultSet.getString(11));
                emp = new Emp(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4), resultSet.getDate(5), resultSet.getDouble(6), resultSet.getDouble(7),
                        dept);
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return emp;
            } else {
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private boolean isNull(Emp emp){
        if (emp==null)
            return true;
        else return false;
    }
    public String eddEmp(Emp emp) {
        try {

            PreparedStatement preparedStatement;
            Emp checkEmp=getEmpInf(emp.getNumber());
            if (isNull(checkEmp)) {
                Emp mgr = getEmpInf(emp.getMgr());
                if (!isNull(mgr)) {
                    connection= dataSource.getConnection();
                    String sql="INSERT INTO EMP VALUES (?,?,?,?,?,?,?,?)";
                    preparedStatement=connection.prepareStatement(sql);
                    preparedStatement.setInt(1,emp.getNumber());
                    preparedStatement.setString(2,emp.getName());
                    preparedStatement.setString(3,emp.getJob());
                    preparedStatement.setInt(4,emp.getMgr());
                    preparedStatement.setDate(5,  emp.getHiredate());
                    preparedStatement.setDouble(6,emp.getSal());
                    preparedStatement.setDouble(7,emp.getComm());
                    preparedStatement.setInt(8,emp.getDept().getNumber());
                    preparedStatement.executeUpdate();
                } else return "Менеджера с данным номером не существует";
            }else return "Сотрудник с данным id уже существует";
            Emp getEmp = getEmpInf(emp.getNumber());
            if (!isNull(getEmp)) {
                preparedStatement.close();
                connection.close();
                return "Сотрудник добавлен";
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Сотрудник не добавлен";
    }
    public Dept getDept(int num){
        try {
            Dept dept;
            connection=dataSource.getConnection();
            String sql="SELECT *FROM DEPT WHERE DEPTNO=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,num);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                dept=new Dept(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return dept;
            }else{resultSet.close();
                preparedStatement.close();
                connection.close();
                return null;}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String deleteEmp(int id){
       Emp emp=getEmpInf(id);
        if (!isNull(emp)) {
            try {
                connection= dataSource.getConnection();
                String sql="DELETE  FROM EMP WHERE EMPNO=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,id);
                preparedStatement.executeUpdate();
                emp=getEmpInf(id);
                if (isNull(emp)){
                    preparedStatement.close();
                    connection.close();
                    return "Сотруднк удален";
                }else {
                    preparedStatement.close();
                    connection.close();
                    return "Сотрудник не удален";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else return "Сотрудник с таким id не найден";
        return "Сотрудник не удален";
    }
}
