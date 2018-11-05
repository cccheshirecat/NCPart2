package jdbc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;

public class WorkWithDB extends JFrame {
    private boolean isNull(Emp emp){
        if (emp==null)return true;
        else return false;
    }
    public void createDWidow() {
        JPanel getEmpInf = new JPanel();
        JPanel empInf = new JPanel();
        JTextField idEmpTf = new JTextField();
        JButton getInfBut = new JButton("Найти");
        JPanel deptP = new JPanel();
        JPanel empP = new JPanel();
        JLabel number = new JLabel("Номер");
        JLabel name = new JLabel("Имя");
        JLabel job = new JLabel("Должность");
        JLabel mgr = new JLabel("Менеджер");
        JLabel hireDate = new JLabel("Дата поступления");
        JLabel sal = new JLabel("Зарплата");
        JLabel comm = new JLabel("Комиссионные");
        JLabel deptNo = new JLabel("Номер");
        JLabel dName = new JLabel("Название");
        JLabel loc = new JLabel("Местоположение");
        JLabel empNo = new JLabel();
        JLabel empName = new JLabel();
        JLabel empJob = new JLabel();
        JLabel empMgr = new JLabel();
        JLabel empHireDate = new JLabel();
        JLabel empSal = new JLabel();
        JLabel empComm = new JLabel();
        JLabel empDeptNo = new JLabel();
        JLabel empDName = new JLabel();
        JLabel empLoc = new JLabel();
        JLabel errorMsg = new JLabel();
        JPanel deleteP = new JPanel();
        JLabel deleteL = new JLabel("Номер сотрудника");
        JTextField deleteField = new JTextField();
        JButton deleteBut = new JButton("Удалить");
        GroupLayout deleteLayout = new GroupLayout(deleteP);
        deleteP.setLayout(deleteLayout);
        deleteLayout.setHorizontalGroup(deleteLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(deleteL)
                .addComponent(deleteField, 100, 100, 100)
                .addComponent(deleteBut));
        deleteLayout.setVerticalGroup(deleteLayout.createSequentialGroup()
                .addComponent(deleteL)
                .addGap(10)
                .addComponent(deleteField, 25, 25, 25)
                .addGap(10)
                .addComponent(deleteBut));
        deleteP.setBorder(BorderFactory.createTitledBorder("Удаление сотрудника"));
        getEmpInf.setBorder(BorderFactory.createTitledBorder("Найти информацию о сотруднике по Id"));
        empInf.setBorder(BorderFactory.createTitledBorder("Информация о сотруднике"));
        deptP.setBorder(BorderFactory.createTitledBorder("Департамент сотрудника"));
        empP.setBorder(BorderFactory.createTitledBorder("Личная информация"));
        JPanel addEmpP = new JPanel();
        addEmpP.setBorder(BorderFactory.createTitledBorder("Добавить сотрудника"));
        JLabel empNumNew = new JLabel("Номер");
        JLabel empNameNew = new JLabel("Имя");
        JLabel empJobNew = new JLabel("Должность");
        JLabel empMgrNew = new JLabel("Менеджер");
        JLabel empHireDateNew = new JLabel("Дата поступления");
        JLabel empSalNew = new JLabel("Зарплата");
        JLabel empCommNew = new JLabel("Коммисионные");
        JLabel empDeptNoNew = new JLabel("Номер департамента");
        JTextField numberNew = new JTextField();
        JTextField nameNew = new JTextField();
        JTextField jobNew = new JTextField();
        JTextField mgrNew = new JTextField();
        JTextField hireDateNew = new JTextField();
        JTextField salNew = new JTextField();
        JTextField commNew = new JTextField();
        commNew.setText("0");
        JTextField deptNoNew = new JTextField();
        JButton addBut = new JButton("Добавить");
        //----
        GroupLayout addEmpLayout = new GroupLayout(addEmpP);
        addEmpP.setLayout(addEmpLayout);
        addEmpLayout.setHorizontalGroup(addEmpLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(addEmpLayout.createSequentialGroup()
                        .addGroup(addEmpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(empNumNew)
                                .addComponent(numberNew, 60, 60, 60))
                        .addGap(5)
                        .addGroup(addEmpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(empNameNew)
                                .addComponent(nameNew, 110, 110, 110))
                        .addGap(5)
                        .addGroup(addEmpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(empJobNew)
                                .addComponent(jobNew, 70, 70, 110))
                        .addGap(5)
                        .addGroup(addEmpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(empMgrNew)
                                .addComponent(mgrNew, 90, 90, 90))
                        .addGap(5)
                        .addGroup(addEmpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(empHireDateNew)
                                .addComponent(hireDateNew, 110, 110, 110))
                        .addGap(5)
                        .addGroup(addEmpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(empSalNew)
                                .addComponent(salNew, 70, 70, 70))
                        .addGap(5)
                        .addGroup(addEmpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(empCommNew)
                                .addComponent(commNew, 90, 90, 90))
                        .addGap(5)
                        .addGroup(addEmpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(empDeptNoNew)
                                .addComponent(deptNoNew, 100, 100, 100)))
                .addGroup(addEmpLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(addBut))
        );
        addEmpLayout.setVerticalGroup(addEmpLayout.createSequentialGroup()
                .addGroup(addEmpLayout.createSequentialGroup()
                        .addGroup(addEmpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(empNumNew)
                                .addComponent(empNameNew)
                                .addComponent(empJobNew)
                                .addComponent(empMgrNew)
                                .addComponent(empHireDateNew)
                                .addComponent(empSalNew)
                                .addComponent(empCommNew)
                                .addComponent(empDeptNoNew))
                        .addGroup(addEmpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(numberNew, 25, 25, 25)
                                .addComponent(nameNew, 25, 25, 25)
                                .addComponent(jobNew, 25, 25, 25)
                                .addComponent(mgrNew, 25, 25, 25)
                                .addComponent(hireDateNew, 25, 25, 25)
                                .addComponent(salNew, 25, 25, 25)
                                .addComponent(commNew, 25, 25, 25)
                                .addComponent(deptNoNew, 25, 25, 25)))
                .addGap(5)
                .addGroup(addEmpLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(addBut))
        );
        //---------------
        GroupLayout getInfLayout = new GroupLayout(getEmpInf);
        getEmpInf.setLayout(getInfLayout);
        getInfLayout.setHorizontalGroup(getInfLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(idEmpTf, GroupLayout.Alignment.CENTER)
                .addComponent(getInfBut, GroupLayout.Alignment.CENTER));
        getInfLayout.setVerticalGroup(getInfLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idEmpTf, 30, 30, 30)
                .addGap(10)
                .addComponent(getInfBut)
                .addGap(10));
        //---------
        GroupLayout empPLayout = new GroupLayout(empP);
        empP.setLayout(empPLayout);
        empPLayout.setHorizontalGroup(empPLayout.createSequentialGroup()
                .addGroup(empPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(number)
                        .addComponent(name)
                        .addComponent(job)
                        .addComponent(mgr)
                        .addComponent(hireDate)
                        .addComponent(sal)
                        .addComponent(comm))
                .addContainerGap(5, 5)
                .addGroup(empPLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(empNo)
                        .addComponent(empName)
                        .addComponent(empJob)
                        .addComponent(empMgr)
                        .addComponent(empHireDate)
                        .addComponent(empSal)
                        .addComponent(empComm)));
        empPLayout.setVerticalGroup(empPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(empPLayout.createSequentialGroup()
                        .addComponent(number)
                        .addGap(5)
                        .addComponent(name)
                        .addGap(5)
                        .addComponent(job)
                        .addGap(5)
                        .addComponent(mgr)
                        .addGap(5)
                        .addComponent(hireDate)
                        .addGap(5)
                        .addComponent(sal)
                        .addGap(5)
                        .addComponent(comm))
                .addGroup(empPLayout.createSequentialGroup()
                        .addComponent(empNo)
                        .addGap(5)
                        .addComponent(empName)
                        .addGap(5)
                        .addComponent(empJob)
                        .addGap(5)
                        .addComponent(empMgr)
                        .addGap(5)
                        .addComponent(empHireDate)
                        .addGap(5)
                        .addComponent(empSal)
                        .addGap(5)
                        .addComponent(empComm)));
        //----
        GroupLayout deptPLayout = new GroupLayout(deptP);
        deptP.setLayout(deptPLayout);
        deptPLayout.setHorizontalGroup(deptPLayout.createSequentialGroup()
                .addGroup(deptPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(deptNo)
                        .addComponent(dName)
                        .addComponent(loc))
                .addContainerGap(5, 5)
                .addGroup(deptPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(empDeptNo)
                        .addComponent(empDName)
                        .addComponent(empLoc)));
        deptPLayout.setVerticalGroup(deptPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(deptPLayout.createSequentialGroup()
                        .addComponent(deptNo)
                        .addGap(5)
                        .addComponent(dName)
                        .addGap(5)
                        .addComponent(loc))
                .addGroup(deptPLayout.createSequentialGroup()
                        .addComponent(empDeptNo)
                        .addGap(5)
                        .addComponent(empDName)
                        .addGap(5)
                        .addComponent(empLoc)));
        //--------
        GroupLayout empInfLayout = new GroupLayout(empInf);
        empInf.setLayout(empInfLayout);
        empInfLayout.setHorizontalGroup(empInfLayout.createSequentialGroup()
                .addComponent(empP, 300, 300, 300)
                .addGap(5)
                .addComponent(deptP, 300, 300, 300));
        empInfLayout.setVerticalGroup(empInfLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(empP, 200, 200, 200)
                .addComponent(deptP, 200, 200, 200));
        //---------------------
        GroupLayout contentPaneLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(getEmpInf, 250, 250, 250)
                        .addGap(30)
                        .addComponent(empInf))
                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(addEmpP)
                        .addGap(5)
                        .addComponent(deleteP, GroupLayout.Alignment.CENTER, 150, 150, 150)
                        .addGap(5)
                        .addComponent(errorMsg)));
        contentPaneLayout.setVerticalGroup(contentPaneLayout.createSequentialGroup()
                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(getEmpInf)
                        .addComponent(empInf))
                .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(addEmpP)
                        .addGap(15)
                        .addComponent(deleteP)
                        .addComponent(errorMsg)));
        deleteBut.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                errorMsg.setText("");
                JDBCManager jdbcManager = new JDBCManager();
                String stat = jdbcManager.deleteEmp(Integer.parseInt(deleteField.getText()));
                errorMsg.setForeground(Color.RED);
                errorMsg.setText(stat);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        addBut.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                errorMsg.setText("");
                JDBCManager jdbcManager = new JDBCManager();
                Dept dept=jdbcManager.getDept(Integer.parseInt(deptNoNew.getText()));
                Emp emp = new Emp(Integer.parseInt(numberNew.getText()),nameNew.getText(),jobNew.getText(),Integer.parseInt(mgrNew.getText()),Date.valueOf(hireDateNew.getText()),
                        Double.parseDouble(salNew.getText()),Double.parseDouble(commNew.getText()),dept);
                String stat = jdbcManager.eddEmp(emp);
                errorMsg.setForeground(Color.RED);
                errorMsg.setText(stat);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        getInfBut.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                errorMsg.setText("");
                JDBCManager jdbcManager = new JDBCManager();
                Emp emp = jdbcManager.getEmpInf(Integer.parseInt(idEmpTf.getText()));
                if (!isNull(emp)) {
                    empNo.setText(""+emp.getNumber());
                    empName.setText(emp.getName());
                    empJob.setText(emp.getJob());
                    empMgr.setText(""+emp.getMgr());
                    empHireDate.setText(""+emp.getHiredate());
                    empSal.setText(""+emp.getSal());
                    empComm.setText(""+emp.getComm());
                    empDeptNo.setText(""+emp.getDept().getNumber());
                    empDName.setText(emp.getDept().getName());
                    empLoc.setText(emp.getDept().getLoc());
                } else {
                    errorMsg.setForeground(Color.RED);
                    errorMsg.setText("Сотрудника с данным id не найдено");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        setSize(1000, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        WorkWithDB dWindow = new WorkWithDB();
        dWindow.createDWidow();
    }
}
