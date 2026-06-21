/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leavemanagementsystem;
import java.sql.*;

import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.concurrent.TimeUnit;
import javax.swing.table.DefaultTableModel;
import database.DBConnection;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author New
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    
   Connection con = null;
int selectedUserId;
Statement stmt = null;

ResultSet result = null;

int currentUserId;

String currentFullName;

String currentRole;

int currentBalance;

  int selectedLeaveId;



int selectedDays;
    public MainForm() {
int currentUserId;

String currentFullName;

String currentRole;

int currentBalance;
    initComponents();
Load_Statistics();
jTabbedPane2.setEnabledAt(0,true);

jTabbedPane2.setEnabledAt(1,true);

jTabbedPane2.setEnabledAt(2,true);

jTabbedPane2.setEnabledAt(3,false);

jTabbedPane2.setEnabledAt(4,false);

jTabbedPane2.setEnabledAt(5,false);
jTabbedPane2.setEnabledAt(6,false);
jTabbedPane2.setEnabledAt(7,false);
}
    
    public MainForm(
int userId,
String fullName,
int balance)
{
    initComponents();

    currentUserId = userId;

    currentFullName = fullName;

    currentBalance = balance;

  
    NameText.setText(fullName);

    balanceText.setText(
    String.valueOf(balance));
}
public void Load_Leaves()
{
    try
    {
        Class.forName(
        "com.microsoft.sqlserver.jdbc.SQLServerDriver");

        con =
        DBConnection.getConnection();

        stmt =
        con.createStatement();

        String query =
        "SELECT * FROM leaves";

        result =
        stmt.executeQuery(query);

        DefaultTableModel model =

        (DefaultTableModel)
        leaveTable.getModel();

        model.setRowCount(0);

        while(result.next())
        {
            model.addRow(new Object[]
            {
                result.getInt("leave_id"),

                result.getString("full_name"),

                result.getString("leave_type"),

                result.getDate("start_date"),

                result.getDate("end_date"),

                result.getInt("days"),

                result.getString("status")
            });
        }

    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(this,
        ex.getMessage());
    }
}
public void Load_Statistics()
{
    try
    {
        Class.forName(
        "com.microsoft.sqlserver.jdbc.SQLServerDriver");

        con =
        DBConnection.getConnection();

        stmt =
        con.createStatement();

        //--------------------------------------------------
        // TOTAL EMPLOYEES
        //--------------------------------------------------

        String totalQuery =

        "SELECT COUNT(*) AS total "
        + "FROM users";

        result =
        stmt.executeQuery(totalQuery);

        if(result.next())
        {
            totalEmployeesText.setText(

            result.getString("total"));
        }

        //--------------------------------------------------
        // MAX DAYS
        //--------------------------------------------------

        String maxQuery =

        "SELECT MAX(days) AS max_days "
        + "FROM leaves";

        result =
        stmt.executeQuery(maxQuery);

        if(result.next())
        {
            maxLeaveText.setText(

            result.getString("max_days"));
        }

        //--------------------------------------------------
        // MIN DAYS
        //--------------------------------------------------

        String minQuery =

        "SELECT MIN(days) AS min_days "
        + "FROM leaves";

        result =
        stmt.executeQuery(minQuery);

        if(result.next())
        {
            minLeaveText.setText(

            result.getString("min_days"));
        }

        //--------------------------------------------------
        // PENDING REQUESTS
        //--------------------------------------------------

        String pendingQuery =

        "SELECT COUNT(*) AS pending_count "

        + "FROM leaves "

        + "WHERE status='Pending'";

        result =
        stmt.executeQuery(pendingQuery);

        if(result.next())
        {
            pendingText.setText(

            result.getString(
            "pending_count"));
        }

    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(this,
        ex.getMessage());
    }
}

public void Load_MyRequests()
{
    try
    {
        con =
        DBConnection.getConnection();

        stmt =
        con.createStatement();

        String query =

        "SELECT leave_type,"
        + "start_date,"
        + "end_date,"
        + "days,"
        + "status "

        + "FROM leaves "

        + "WHERE user_id="
        + currentUserId;

        result =
        stmt.executeQuery(query);

        DefaultTableModel model =

        (DefaultTableModel)
        myRequestsTable.getModel();

        model.setRowCount(0);

        while(result.next())
        {
            model.addRow(new Object[]
            {
                result.getString("leave_type"),

                result.getDate("start_date"),

                result.getDate("end_date"),

                result.getInt("days"),

                result.getString("status")
            });
        }
    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(this,
        ex.getMessage());
    }
}

public void Load_Users()
{
    try
    {
        con =
        DBConnection.getConnection();

        stmt =
        con.createStatement();

        String query =
        "SELECT * FROM users";

        result =
        stmt.executeQuery(query);

        DefaultTableModel model =

        (DefaultTableModel)
        usersTable.getModel();

        model.setRowCount(0);

        while(result.next())
        {
            model.addRow(new Object[]
            {
                result.getInt("user_id"),

                result.getString("full_name"),

                result.getString("username"),

                result.getString("role_name")
            });
        }
    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(this,
        ex.getMessage());
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        passwordText = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fullNameText = new javax.swing.JTextField();
        registerUsernameText = new javax.swing.JTextField();
        registerPasswordText = new javax.swing.JTextField();
        confirmPasswordText = new javax.swing.JTextField();
        registerBtn = new javax.swing.JButton();
        departmentCombo = new javax.swing.JComboBox<>();
        emailText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        applyButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        NameText = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        balanceText = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        startDateText = new javax.swing.JTextField();
        endDateText = new javax.swing.JTextField();
        leaveTypeCombo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        reasonText = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        approveBtn = new javax.swing.JButton();
        rejectBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        leaveTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        totalEmployeesText = new javax.swing.JTextField();
        maxLeaveText = new javax.swing.JTextField();
        minLeaveText = new javax.swing.JTextField();
        pendingText = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        myRequestsTable = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        roleCombo = new javax.swing.JComboBox<>();
        updateRoleBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));

        jTabbedPane2.setMinimumSize(new java.awt.Dimension(800, 500));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        jLabel15.setBackground(new java.awt.Color(204, 204, 0));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Welcome To Leave Managment System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Home", jPanel2);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Username");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Password");

        usernameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextActionPerformed(evt);
            }
        });

        loginBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 51, 51));
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(247, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Login", jPanel3);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Full Name ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Password ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Confirm Password ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Department ");

        registerUsernameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerUsernameTextActionPerformed(evt);
            }
        });

        registerBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        registerBtn.setForeground(new java.awt.Color(255, 0, 0));
        registerBtn.setText("Register");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        departmentCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HR", "IT", "Finance", "Sales" }));
        departmentCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Email");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(emailText, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(confirmPasswordText, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(registerPasswordText)
                                    .addComponent(registerUsernameText)
                                    .addComponent(fullNameText)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(141, 141, 141)
                                .addComponent(departmentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(386, 386, 386))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(emailText)
                        .addGap(9, 9, 9)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerUsernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(confirmPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentCombo, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(jLabel7))
                .addGap(29, 29, 29)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Registeration", jPanel4);

        applyButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        applyButton.setForeground(new java.awt.Color(255, 51, 51));
        applyButton.setText("Submit Request");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("Reason ");

        NameText.setEditable(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 0, 51));
        jLabel13.setText("Name");

        balanceText.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Remaining Leave Balance");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 0, 51));
        jLabel9.setText("Start Date ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 51));
        jLabel12.setText(" End Date");

        endDateText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateTextActionPerformed(evt);
            }
        });

        leaveTypeCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        leaveTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Annual Leave", "Sick Leave", "Casual Leave", "Emergency Leave" }));

        reasonText.setColumns(20);
        reasonText.setRows(5);
        jScrollPane1.setViewportView(reasonText);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setText(" Leave Type");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(endDateText, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel10)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(129, 129, 129))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                            .addGap(26, 26, 26)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(startDateText, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(leaveTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(balanceText, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14))
                .addContainerGap(250, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(balanceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(startDateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(endDateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(leaveTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)))
                .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Leave Request", jPanel5);

        jPanel12.setBackground(new java.awt.Color(204, 204, 255));

        approveBtn.setText("Approv");
        approveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveBtnActionPerformed(evt);
            }
        });

        rejectBtn.setText("Reject");
        rejectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectBtnActionPerformed(evt);
            }
        });

        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        leaveTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Leave ID", "Emplyee", "Leave Type", "Stsrt Date", "End Date", "Days", "Status"
            }
        ));
        leaveTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leaveTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(leaveTable);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(approveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rejectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(157, 157, 157))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(approveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rejectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Manage Leaves", jPanel6);

        jLabel17.setBackground(new java.awt.Color(204, 204, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 255));
        jLabel17.setText("Max Leave Days");

        jLabel18.setBackground(new java.awt.Color(204, 204, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 255));
        jLabel18.setText("MIN Leave Days");

        jLabel19.setBackground(new java.awt.Color(204, 204, 255));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setText("Pending Requests");

        totalEmployeesText.setEditable(false);
        totalEmployeesText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalEmployeesTextActionPerformed(evt);
            }
        });

        maxLeaveText.setEditable(false);
        maxLeaveText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxLeaveTextActionPerformed(evt);
            }
        });

        minLeaveText.setEditable(false);
        minLeaveText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minLeaveTextActionPerformed(evt);
            }
        });

        pendingText.setEditable(false);

        jLabel20.setBackground(new java.awt.Color(204, 204, 255));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 255));
        jLabel20.setText("Total Employees");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16))
                        .addGap(78, 78, 78)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(minLeaveText, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(maxLeaveText)
                    .addComponent(totalEmployeesText)
                    .addComponent(pendingText))
                .addContainerGap(449, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(totalEmployeesText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(20, 20, 20)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxLeaveText, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minLeaveText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pendingText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(177, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Statistics", jPanel7);

        myRequestsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "| Leave Type ", "Start Date", "End Date", "Days", "Status"
            }
        ));
        jScrollPane3.setViewportView(myRequestsTable);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("My Requests", jPanel13);

        jPanel14.setMinimumSize(new java.awt.Dimension(800, 0));

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Full Name", "Username", "Role"
            }
        ));
        usersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(usersTable);

        roleCombo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        roleCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employee", "HR", "Admin" }));

        updateRoleBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateRoleBtn.setText("Update Role");
        updateRoleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRoleBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(269, Short.MAX_VALUE)
                .addComponent(updateRoleBtn)
                .addGap(199, 199, 199)
                .addComponent(roleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateRoleBtn)
                    .addComponent(roleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Manage Users", jPanel14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        try
{
    Class.forName(
    "com.microsoft.sqlserver.jdbc.SQLServerDriver");

    con =
    DBConnection.getConnection();

    stmt =
    con.createStatement();

    String query =

    "DELETE FROM leaves "
    + "WHERE leave_id="
    + selectedLeaveId;

    stmt.executeUpdate(query);

    JOptionPane.showMessageDialog(this,
    "Request Deleted");

    Load_Leaves();
}
catch(Exception ex)
{
    JOptionPane.showMessageDialog(this,
    ex.getMessage());
}
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
        Load_Leaves();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void rejectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectBtnActionPerformed
        // TODO add your handling code here:
        try
{
    Class.forName(
    "com.microsoft.sqlserver.jdbc.SQLServerDriver");

    con =
    DBConnection.getConnection();

    stmt =
    con.createStatement();

    String query =

    "UPDATE leaves "

    + "SET status='Rejected' "

    + "WHERE leave_id="
    + selectedLeaveId;

    stmt.executeUpdate(query);

    JOptionPane.showMessageDialog(this,
    "Request Rejected");

    Load_Leaves();
}
catch(Exception ex)
{
    JOptionPane.showMessageDialog(this,
    ex.getMessage());
}
    }//GEN-LAST:event_rejectBtnActionPerformed

    private void approveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBtnActionPerformed
        // TODO add your handling code here:
        try
{
    Class.forName(
    "com.microsoft.sqlserver.jdbc.SQLServerDriver");

    con =
    DBConnection.getConnection();

    stmt =
    con.createStatement();

    //--------------------------------------------------
    // GET USER ID
    //--------------------------------------------------

    String getUserQuery =

    "SELECT user_id FROM leaves "
    + "WHERE leave_id="
    + selectedLeaveId;

    result =
    stmt.executeQuery(getUserQuery);

    if(result.next())
    {
        selectedUserId =
        result.getInt("user_id");
    }

    //--------------------------------------------------
    // UPDATE STATUS
    //--------------------------------------------------

    String query =

    "UPDATE leaves "
    + "SET status='Approved' "
    + "WHERE leave_id="
    + selectedLeaveId;

    stmt.executeUpdate(query);

    //--------------------------------------------------
    // UPDATE BALANCE
    //--------------------------------------------------

    String balanceQuery =

    "UPDATE users "

    + "SET leave_balance="
    + "(leave_balance-"
    + selectedDays
    + ") "

    + "WHERE user_id="
    + selectedUserId;

    stmt.executeUpdate(balanceQuery);

    JOptionPane.showMessageDialog(this,
    "Request Approved");

    Load_Leaves();
}
catch(Exception ex)
{
    JOptionPane.showMessageDialog(this,
    ex.getMessage());
}
    }//GEN-LAST:event_approveBtnActionPerformed

    private void endDateTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDateTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endDateTextActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        // TODO add your handling code here:
        String leaveType =

        leaveTypeCombo
        .getSelectedItem()
        .toString();

        String startDate =
        startDateText.getText();

        String endDate =
        endDateText.getText();

        String reason =
        reasonText.getText();

        if(startDate.isEmpty())
        {
            JOptionPane.showMessageDialog(this,
                "Enter Start Date");

            return;
        }

        if(endDate.isEmpty())
        {
            JOptionPane.showMessageDialog(this,
                "Enter End Date");

            return;
        }

        if(reason.isEmpty())
        {
            JOptionPane.showMessageDialog(this,
                "Enter Reason");

            return;
        }

        try
        {
            SimpleDateFormat sdf =

            new SimpleDateFormat(
                "yyyy-MM-dd");

            Date d1 =
            sdf.parse(startDate);

            Date d2 =
            sdf.parse(endDate);

            long diff =
            d2.getTime()
            - d1.getTime();

            long days =
            TimeUnit.DAYS.convert(
                diff,
                TimeUnit.MILLISECONDS);

            days += 1;

            if(days <= 0)
            {
                JOptionPane.showMessageDialog(this,
                    "Invalid Dates");

                return;
            }

            if(days > currentBalance)
            {
                JOptionPane.showMessageDialog(this,
                    "Insufficient Leave Balance");

                return;
            }

            Class.forName(
                "com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con =
            DBConnection.getConnection();

            stmt =
            con.createStatement();

            String query =

            "INSERT INTO leaves "

            + "(user_id,full_name,"
            + "leave_type,start_date,"
            + "end_date,reason,"
            + "status,days)"

            + " VALUES("

            + currentUserId

            + ",'"

            + currentFullName

            + "','"

            + leaveType

            + "','"

            + startDate

            + "','"

            + endDate

            + "','"

            + reason

            + "','Pending',"

            + days

            + ")";

            int rows =
            stmt.executeUpdate(query);

            if(rows > 0)
            {
                JOptionPane.showMessageDialog(this,
                    "Leave Request Submitted");

                startDateText.setText("");

                endDateText.setText("");

                reasonText.setText("");
                Load_MyRequests();
            }

        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,
                ex.getMessage());
        }
    }//GEN-LAST:event_applyButtonActionPerformed

    private void departmentComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departmentComboActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        // TODO add your handling code here:

        String fullName =
        fullNameText.getText();

        String username =
        registerUsernameText.getText();

        String password =
        registerPasswordText.getText();

        String confirmPassword =
        confirmPasswordText.getText();

        String email =
        emailText.getText();

        String department =
        departmentCombo
        .getSelectedItem()
        .toString();

        String role = "Employee";

        //--------------------------------------------------
        // VALIDATION
        //--------------------------------------------------

        if(fullName.isEmpty())
        {
            JOptionPane.showMessageDialog(this,
                "Enter Full Name");

            return;
        }

        if(username.isEmpty())
        {
            JOptionPane.showMessageDialog(this,
                "Enter Username");

            return;
        }

        if(password.isEmpty())
        {
            JOptionPane.showMessageDialog(this,
                "Enter Password");

            return;
        }

        if(confirmPassword.isEmpty())
        {
            JOptionPane.showMessageDialog(this,
                "Confirm Password");

            return;
        }

        if(!password.equals(confirmPassword))
        {
            JOptionPane.showMessageDialog(this,
                "Password Not Match");

            return;
        }

        if(email.isEmpty())
        {
            JOptionPane.showMessageDialog(this,
                "Enter Email");

            return;
        }

        try
        {
            Class.forName(
                "com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DBConnection.getConnection();

            stmt = con.createStatement();

            //--------------------------------------------------
            // CHECK USERNAME
            //--------------------------------------------------

            String checkQuery =

            "SELECT * FROM users "
            + "WHERE username='"
            + username + "'";

            result =
            stmt.executeQuery(checkQuery);

            if(result.next())
            {
                JOptionPane.showMessageDialog(this,
                    "Username Already Exists");

                return;
            }

            //--------------------------------------------------
            // INSERT USER
            //--------------------------------------------------

            String query =

            "INSERT INTO users "
            + "(full_name,username,"
            + "user_password,email,"
            + "department,role_name,"
            + "leave_balance)"

            + " VALUES('"

            + fullName

            + "','"

            + username

            + "','"

            + password

            + "','"

            + email

            + "','"

            + department

            + "','"

            + role

            + "',30)";

            int affectedRows =
            stmt.executeUpdate(query);

            if(affectedRows > 0)
            {
                JOptionPane.showMessageDialog(this,
                    "Registration Successful");

                fullNameText.setText("");

                registerUsernameText.setText("");

                registerPasswordText.setText("");

                confirmPasswordText.setText("");

                emailText.setText("");
            }

        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,
                ex.getMessage());
        }
    }//GEN-LAST:event_registerBtnActionPerformed

    private void registerUsernameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerUsernameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerUsernameTextActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
        String username = usernameText.getText();

        String password = passwordText.getText();

        if(username.isEmpty())
        {
            JOptionPane.showMessageDialog(this,
                "Enter Username");

            return;
        }

        if(password.isEmpty())
        {
            JOptionPane.showMessageDialog(this,
                "Enter Password");

            return;
        }

        Check_Login(username,password);
    }//GEN-LAST:event_loginBtnActionPerformed

    private void usernameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextActionPerformed

    private void leaveTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leaveTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model =

(DefaultTableModel)
leaveTable.getModel();

int row =
leaveTable.getSelectedRow();

selectedLeaveId =

Integer.parseInt(
model.getValueAt(row,0)
.toString());

selectedDays =

Integer.parseInt(
model.getValueAt(row,5)
.toString());
    }//GEN-LAST:event_leaveTableMouseClicked

    private void minLeaveTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minLeaveTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minLeaveTextActionPerformed

    private void maxLeaveTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxLeaveTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxLeaveTextActionPerformed

    private void totalEmployeesTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalEmployeesTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalEmployeesTextActionPerformed

    private void updateRoleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRoleBtnActionPerformed
        // TODO add your handling code here:
        try
{
    con =
    DBConnection.getConnection();

    stmt =
    con.createStatement();

    String role =

    roleCombo
    .getSelectedItem()
    .toString();

    String query =

    "UPDATE users "

    + "SET role_name='"

    + role

    + "' WHERE user_id="

    + selectedUserId;

    stmt.executeUpdate(query);

    JOptionPane.showMessageDialog(this,
    "Role Updated");

    Load_Users();
}
catch(Exception ex)
{
    JOptionPane.showMessageDialog(this,
    ex.getMessage());
}
    }//GEN-LAST:event_updateRoleBtnActionPerformed

    private void usersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model =

(DefaultTableModel)
usersTable.getModel();

int row =
usersTable.getSelectedRow();

selectedUserId =

Integer.parseInt(
model.getValueAt(row,0)
.toString());
    }//GEN-LAST:event_usersTableMouseClicked

    /**
     * @param args the command line arguments
     */
public boolean Check_Login(String username,String password)
{
    Connection con = null;

    Statement stmt = null;

    ResultSet result = null;

    boolean flag = false;

    try
    {
        con =
        DBConnection.getConnection();

        stmt =
        con.createStatement();

        String query =

        "SELECT * FROM users "
        + "WHERE username='"

        + username +

        "' AND user_password='"

        + password + "'";

        result =
        stmt.executeQuery(query);

        //--------------------------------------------------
        // LOGIN SUCCESS
        //--------------------------------------------------

        if(result.next())
        {
            currentRole =

            result.getString("role_name");

            currentUserId =

            result.getInt("user_id");

            currentFullName =

            result.getString("full_name");

            currentBalance =

            result.getInt("leave_balance");

            //--------------------------------------------------
            // SET USER DATA
            //--------------------------------------------------

            NameText.setText(
            currentFullName);

            balanceText.setText(

            String.valueOf(
            currentBalance));

            //--------------------------------------------------
            // LOAD USER REQUESTS
            //--------------------------------------------------

            Load_MyRequests();

            //--------------------------------------------------
            // OPEN TABS
            //--------------------------------------------------

            jTabbedPane2.setEnabled(true);

            jTabbedPane2.setEnabledAt(2,true);

            jTabbedPane2.setEnabledAt(3,true);

            jTabbedPane2.setEnabledAt(6,true);

            //--------------------------------------------------
            // EMPLOYEE
            //--------------------------------------------------

            if(currentRole.equals("Employee"))
            {
                jTabbedPane2.setEnabledAt(4,false);

                jTabbedPane2.setEnabledAt(5,false);

                jTabbedPane2.setEnabledAt(7,false);
            }

            //--------------------------------------------------
            // ADMIN / HR
            //--------------------------------------------------

            else
            {
                jTabbedPane2.setEnabledAt(4,true);

                jTabbedPane2.setEnabledAt(5,true);

                jTabbedPane2.setEnabledAt(7,true);

                Load_Users();
            }

            //--------------------------------------------------
            // OPEN Leave Request
            //--------------------------------------------------
  JOptionPane.showMessageDialog(this,
            "Welcome " + currentFullName);
            jTabbedPane2.setSelectedIndex(3);

          

            flag = true;
        }

        //--------------------------------------------------
        // LOGIN FAILED
        //--------------------------------------------------

        else
        {
            JOptionPane.showMessageDialog(this,
            "Invalid Username or Password");

            flag = false;
        }
    }

    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(this,
        ex.getMessage());
    }

    finally
    {
        if(con != null)
        {
            try{ con.close(); }
            catch(Exception ex){}
        }

        if(stmt != null)
        {
            try{ stmt.close(); }
            catch(Exception ex){}
        }

        if(result != null)
        {
            try{ result.close(); }
            catch(Exception ex){}
        }
    }

    return flag;
}
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NameText;
    private javax.swing.JButton applyButton;
    private javax.swing.JButton approveBtn;
    private javax.swing.JTextField balanceText;
    private javax.swing.JTextField confirmPasswordText;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox<String> departmentCombo;
    private javax.swing.JTextField emailText;
    private javax.swing.JTextField endDateText;
    private javax.swing.JTextField fullNameText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable leaveTable;
    private javax.swing.JComboBox<String> leaveTypeCombo;
    private javax.swing.JButton loginBtn;
    private javax.swing.JTextField maxLeaveText;
    private javax.swing.JTextField minLeaveText;
    private javax.swing.JTable myRequestsTable;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JTextField pendingText;
    private javax.swing.JTextArea reasonText;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField registerPasswordText;
    private javax.swing.JTextField registerUsernameText;
    private javax.swing.JButton rejectBtn;
    private javax.swing.JComboBox<String> roleCombo;
    private javax.swing.JTextField startDateText;
    private javax.swing.JTextField totalEmployeesText;
    private javax.swing.JButton updateRoleBtn;
    private javax.swing.JTextField usernameText;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
