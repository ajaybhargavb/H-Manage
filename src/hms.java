
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * hms.java
 *
 * Created on 2 Apr, 2011, 10:22:45 AM
 */

/**
 *
 * @author ajay
 */
public class hms extends javax.swing.JFrame {
Connection con;
Statement stmt;
ResultSet res;
    /* Creates new form hms */
    public hms() {
        initComponents();
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //JOptionPane.showMessageDialog(this, "Driver Loaded Succesfully!");
        }
        catch(ClassNotFoundException E)
        {JOptionPane.showMessageDialog(this, "Driver Not Loaded");
        }
        try{
            con=DriverManager.getConnection("jdbc:odbc:oracledsn","system","oracle");
            //JOptionPane.showMessageDialog(this, "Connection Established!");
        }
        catch(SQLException E)
        {JOptionPane.showMessageDialog(this, "Connection Not Established");
        }
        r3.setVisible(false);
        r6.setVisible(false);
        r9.setVisible(false);
        r12.setVisible(false);
        r15.setVisible(false);
        r18.setVisible(false);

        try
        {
            String sql=("select * from staff_details");
            PreparedStatement psmt = con.prepareStatement(sql);
            res = psmt.executeQuery();
        while(res.next())
            {
                combo1.addItem(res.getString("sid"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
        try
        {
            String sql=("select * from staff_details where sid like 'D%'");
            PreparedStatement psmt = con.prepareStatement(sql);
            res = psmt.executeQuery();
        while(res.next())
            {
                combo2.addItem(res.getString("sid"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
        try
        {
            String sql=("select * from patient_entry");
            PreparedStatement psmt = con.prepareStatement(sql);
            res = psmt.executeQuery();
        while(res.next())
            {
                comb3.addItem(res.getString("pid"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
         try
        {
            String sql=("select * from patient_entry where ptype='in'");
            PreparedStatement psmt = con.prepareStatement(sql);
            res = psmt.executeQuery();
        while(res.next())
            {
                combo3.addItem(res.getString("pid"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }

         try
        {
            String sql=("select * from patient_admit");
            PreparedStatement psmt = con.prepareStatement(sql);
            res = psmt.executeQuery();
        while(res.next())
            {
                combo4.addItem(res.getString("pid"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }

         try
        {
            String sql=("select * from patient_entry");
            PreparedStatement psmt = con.prepareStatement(sql);
            res = psmt.executeQuery();
        while(res.next())
            {
                combo5.addItem(res.getString("pid"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
        clearall();

    }

    private void clear()
{
sid.setText(null);
sname.setText(null);// TODO add your handling code here:
sex.setText(null);
age.setText(null);
desig.setText(null);
dept.setText(null);
addr.setText(null);
ph.setText(null);
r3.doClick();
}
private void clear1()
{
    pid.setText(null);
    pname.setText(null);
    sex1.setText(null);
    age1.setText(null);
    bgroup.setText(null);
    ph1.setText(null);
    edate.setText(null);
    ptype.setText(null);
    reason.setText(null);
    did.setText(null);
    r6.doClick();
}
   private void clear2()
   {
       pid1.setText(null);
       bno.setText(null);
       adate.setText(null);

  }
   private void clear3()
   {
       pid2.setText(null);
       ddate.setText(null);
       xray.setText(null);
       usound.setText(null);
       btest.setText(null);
       ctscan.setText(null);
       r9.doClick();
       r12.doClick();
       r15.doClick();
       r18.doClick();

   }
private void clear4()
   {
       pid3.setText(null);
       pname3.setText(null);
       docfees.setText(null);
       diagfees.setText(null);
       medfees.setText(null);
       rent.setText(null);
       bdate.setText(null);
       tot.setText(null);
}
private void clearall()
{
    clear();
    clear1();
    clear2();
    clear3();
    clear4();
}
private String datereplace(String datee) {
        String day,month,year;
        year=datee.substring(0,4);
            month=datee.substring(4,8);
            day=datee.substring(8,10);
            if (month == null ? "-01-" == null : month.equals("-01-"))
                month=month.replace("01", "JAN");
            else if (month == null ? "-02-" == null : month.equals("-02-"))
                month=month.replace("02", "FEB");
            else if (month == null ? "-03-" == null : month.equals("-03-"))
                month=month.replace("03", "MAR");
            else if (month == null ? "-04-" == null : month.equals("-04-"))
                month=month.replace("04", "APR");
            else if (month == null ? "-05-" == null : month.equals("-05-"))
                month=month.replace("05", "MAY");
            else if (month == null ? "-06-" == null : month.equals("-06-"))
                month=month.replace("06", "JUN");
            else if (month == null ? "-07-" == null : month.equals("-07-"))
                month=month.replace("07", "JUL");
            else if (month == null ? "-08-" == null : month.equals("-08-"))
                month=month.replace("08", "AUG");
            else if (month == null ? "-09-" == null : month.equals("-09-"))
                month=month.replace("09", "SEP");
            else if (month == null ? "-10-" == null : month.equals("-10-"))
                month=month.replace("10", "OCT");
            else if (month == null ? "-11-" == null : month.equals("-11-"))
                month=month.replace("11", "NOV");
            else if (month == null ? "-12-" == null : month.equals("-12-"))
                month=month.replace("12", "DEC");
            return day+month+year;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sid = new javax.swing.JTextField();
        sname = new javax.swing.JTextField();
        sex = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        desig = new javax.swing.JTextField();
        dept = new javax.swing.JTextField();
        addr = new javax.swing.JTextField();
        ph = new javax.swing.JTextField();
        r1 = new javax.swing.JRadioButton();
        r2 = new javax.swing.JRadioButton();
        r3 = new javax.swing.JRadioButton();
        clear = new javax.swing.JButton();
        insert = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        combo1 = new javax.swing.JComboBox();
        comb1 = new javax.swing.JComboBox();
        comb2 = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        search1 = new javax.swing.JButton();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jLabel9 = new javax.swing.JLabel();
        pid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        sex1 = new javax.swing.JTextField();
        age1 = new javax.swing.JTextField();
        bgroup = new javax.swing.JTextField();
        ph1 = new javax.swing.JTextField();
        edate = new javax.swing.JTextField();
        ptype = new javax.swing.JTextField();
        reason = new javax.swing.JTextField();
        did = new javax.swing.JTextField();
        combo2 = new javax.swing.JComboBox();
        r4 = new javax.swing.JRadioButton();
        r5 = new javax.swing.JRadioButton();
        r6 = new javax.swing.JRadioButton();
        clear1 = new javax.swing.JButton();
        exit1 = new javax.swing.JButton();
        update1 = new javax.swing.JButton();
        insert1 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        search2 = new javax.swing.JButton();
        comb3 = new javax.swing.JComboBox();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        pid1 = new javax.swing.JTextField();
        bno = new javax.swing.JTextField();
        adate = new javax.swing.JTextField();
        insert2 = new javax.swing.JButton();
        delete1 = new javax.swing.JButton();
        update2 = new javax.swing.JButton();
        clear2 = new javax.swing.JButton();
        exit2 = new javax.swing.JButton();
        combo3 = new javax.swing.JComboBox();
        jLabel38 = new javax.swing.JLabel();
        search3 = new javax.swing.JButton();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        pid2 = new javax.swing.JTextField();
        ddate = new javax.swing.JTextField();
        r7 = new javax.swing.JRadioButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        r10 = new javax.swing.JRadioButton();
        r13 = new javax.swing.JRadioButton();
        r8 = new javax.swing.JRadioButton();
        r11 = new javax.swing.JRadioButton();
        r14 = new javax.swing.JRadioButton();
        r16 = new javax.swing.JRadioButton();
        r17 = new javax.swing.JRadioButton();
        xray = new javax.swing.JTextField();
        usound = new javax.swing.JTextField();
        btest = new javax.swing.JTextField();
        ctscan = new javax.swing.JTextField();
        r9 = new javax.swing.JRadioButton();
        r12 = new javax.swing.JRadioButton();
        r15 = new javax.swing.JRadioButton();
        r18 = new javax.swing.JRadioButton();
        insert3 = new javax.swing.JButton();
        update3 = new javax.swing.JButton();
        clear3 = new javax.swing.JButton();
        exit3 = new javax.swing.JButton();
        combo4 = new javax.swing.JComboBox();
        jLabel39 = new javax.swing.JLabel();
        search4 = new javax.swing.JButton();
        jInternalFrame5 = new javax.swing.JInternalFrame();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        pid3 = new javax.swing.JTextField();
        pname3 = new javax.swing.JTextField();
        docfees = new javax.swing.JTextField();
        diagfees = new javax.swing.JTextField();
        medfees = new javax.swing.JTextField();
        rent = new javax.swing.JTextField();
        bdate = new javax.swing.JTextField();
        combo5 = new javax.swing.JComboBox();
        insert4 = new javax.swing.JButton();
        update4 = new javax.swing.JButton();
        clear4 = new javax.swing.JButton();
        exit4 = new javax.swing.JButton();
        total = new javax.swing.JButton();
        tot = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        search5 = new javax.swing.JButton();
        report = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 0, 14));

        jLabel1.setText("Staff ID");

        jLabel2.setText("Name");

        jLabel3.setText("Sex");

        jLabel4.setText("Age");

        jLabel5.setText("Designation");

        jLabel6.setText("Department");

        jLabel7.setText("Address");

        jLabel8.setText("Phone");

        buttonGroup1.add(r1);
        r1.setText("Male");
        r1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r1MouseClicked(evt);
            }
        });

        buttonGroup1.add(r2);
        r2.setText("Female");
        r2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r2MouseClicked(evt);
            }
        });

        buttonGroup1.add(r3);
        r3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3ActionPerformed(evt);
            }
        });

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        insert.setText("Insert");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        exit.setBackground(new java.awt.Color(255, 51, 51));
        exit.setText("X");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        combo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
            }
        });

        comb1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "doctor", "nurse", "technician", "pharmacist", "service" }));
        comb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comb1ActionPerformed(evt);
            }
        });

        comb2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "general", "cardiology", "ent", "neurology", "nephrology", "pharmacy" }));
        comb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comb2ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Engravers MT", 1, 12));
        jLabel36.setForeground(new java.awt.Color(51, 51, 255));
        jLabel36.setText("STAFF DETAILS");

        search1.setText("Search");
        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(r3)
                .addContainerGap(405, Short.MAX_VALUE))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(89, 89, 89)
                                        .addComponent(ph, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(80, 80, 80)
                                        .addComponent(addr, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(62, 62, 62)
                                        .addComponent(dept, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(63, 63, 63)
                                        .addComponent(desig, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(8, 8, 8))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(105, 105, 105)
                                                .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(r1)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(r2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(92, 92, 92)
                                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                                .addComponent(sid, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                                .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(sname, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(111, 111, 111))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(insert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search1)
                        .addContainerGap())))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel36)
                .addContainerGap(223, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(346, Short.MAX_VALUE)
                .addComponent(exit)
                .addGap(122, 122, 122))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addComponent(exit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(r1)
                            .addComponent(r2)
                            .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(desig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(comb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(comb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(jLabel1))
                .addGap(35, 35, 35)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insert)
                    .addComponent(update)
                    .addComponent(delete)
                    .addComponent(clear)
                    .addComponent(search1))
                .addGap(48, 48, 48)
                .addComponent(r3))
        );

        jTabbedPane1.addTab("Staff", jInternalFrame1);

        jLabel9.setText("Patient ID");

        jLabel10.setText("Patient Name");

        jLabel11.setText("Sex");

        jLabel12.setText("Age");

        jLabel13.setText("Blood Group");

        jLabel14.setText("Phone");

        jLabel15.setText("Entry Date");

        jLabel16.setText("Patient Type");

        jLabel17.setText("Reason");

        jLabel18.setText("Doctor ID");

        combo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        combo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo2ActionPerformed(evt);
            }
        });

        buttonGroup2.add(r4);
        r4.setText("Male");
        r4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r4MouseClicked(evt);
            }
        });

        buttonGroup2.add(r5);
        r5.setText("Female");
        r5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r5MouseClicked(evt);
            }
        });

        buttonGroup2.add(r6);

        clear1.setText("Clear");
        clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear1ActionPerformed(evt);
            }
        });

        exit1.setBackground(new java.awt.Color(255, 51, 51));
        exit1.setText("X");
        exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit1ActionPerformed(evt);
            }
        });

        update1.setText("Update");
        update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update1ActionPerformed(evt);
            }
        });

        insert1.setText("Insert");
        insert1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert1ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Engravers MT", 1, 12));
        jLabel37.setForeground(new java.awt.Color(0, 0, 255));
        jLabel37.setText("PATIENT ENTRY");

        search2.setText("Search");
        search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search2ActionPerformed(evt);
            }
        });

        comb3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        comb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comb3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(exit1)
                .addGap(21, 21, 21))
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)))
                            .addComponent(jLabel9)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(r6)
                        .addGap(37, 37, 37)
                        .addComponent(insert1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(update1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(sex1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(r4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(r5))
                    .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame2Layout.createSequentialGroup()
                            .addComponent(did, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(reason, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ptype, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(edate, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ph1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bgroup, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(age1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(clear1)
                        .addGap(18, 18, 18)
                        .addComponent(search2))
                    .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame2Layout.createSequentialGroup()
                            .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comb3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(pname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(comb3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sex1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(r4)
                    .addComponent(r5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(age1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bgroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ph1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ptype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(did, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(r6))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(insert1)
                            .addComponent(clear1)
                            .addComponent(update1)
                            .addComponent(search2))))
                .addContainerGap())
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addComponent(exit1)
                .addContainerGap(354, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PEntry", jInternalFrame2);

        jLabel19.setText("Patient ID");

        jLabel20.setText("Bed Number");

        jLabel21.setText("Admit Date");

        insert2.setText("Insert");
        insert2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert2ActionPerformed(evt);
            }
        });

        delete1.setText("Delete");
        delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete1ActionPerformed(evt);
            }
        });

        update2.setText("Update");
        update2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update2ActionPerformed(evt);
            }
        });

        clear2.setText("Clear");
        clear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear2ActionPerformed(evt);
            }
        });

        exit2.setBackground(new java.awt.Color(255, 51, 51));
        exit2.setText("X");
        exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit2ActionPerformed(evt);
            }
        });

        combo3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        combo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo3ActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Engravers MT", 1, 12));
        jLabel38.setForeground(new java.awt.Color(0, 0, 255));
        jLabel38.setText("PATIENT ADMIT");

        search3.setText("Search");
        search3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(insert2)
                        .addGap(18, 18, 18)
                        .addComponent(delete1)
                        .addGap(18, 18, 18)
                        .addComponent(update2)
                        .addGap(18, 18, 18)
                        .addComponent(clear2)
                        .addGap(18, 18, 18)
                        .addComponent(search3))
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(45, 45, 45)
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(adate)
                            .addComponent(bno)
                            .addComponent(pid1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(combo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel38)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap(365, Short.MAX_VALUE)
                .addComponent(exit2)
                .addGap(28, 28, 28))
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel38)
                        .addGap(31, 31, 31)
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(pid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(bno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(adate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(exit2))
                .addGap(86, 86, 86)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete1)
                    .addComponent(update2)
                    .addComponent(clear2)
                    .addComponent(insert2)
                    .addComponent(search3))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PAdmit", jInternalFrame3);

        jLabel22.setText("Patient ID");

        jLabel23.setText("Diagnosis Date");

        buttonGroup3.add(r7);
        r7.setText("Positive");
        r7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r7MouseClicked(evt);
            }
        });

        jLabel24.setText("X - Ray");

        jLabel25.setText("U - Sound");

        jLabel26.setText("Blood Test");

        jLabel27.setText("CT Scan");

        buttonGroup4.add(r10);
        r10.setText("Positive");
        r10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r10MouseClicked(evt);
            }
        });
        r10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r10ActionPerformed(evt);
            }
        });

        buttonGroup5.add(r13);
        r13.setText("Positive");
        r13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r13MouseClicked(evt);
            }
        });

        buttonGroup3.add(r8);
        r8.setText("Negative");
        r8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r8MouseClicked(evt);
            }
        });

        buttonGroup4.add(r11);
        r11.setText("Negative");
        r11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r11MouseClicked(evt);
            }
        });

        buttonGroup5.add(r14);
        r14.setText("Negative");
        r14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r14MouseClicked(evt);
            }
        });

        buttonGroup6.add(r16);
        r16.setText("Positive");
        r16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r16MouseClicked(evt);
            }
        });

        buttonGroup6.add(r17);
        r17.setText("Negative");
        r17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r17MouseClicked(evt);
            }
        });

        buttonGroup3.add(r9);

        buttonGroup4.add(r12);

        buttonGroup5.add(r15);

        buttonGroup6.add(r18);

        insert3.setText("Insert");
        insert3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert3ActionPerformed(evt);
            }
        });

        update3.setText("Update");
        update3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update3ActionPerformed(evt);
            }
        });

        clear3.setText("Clear");
        clear3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear3ActionPerformed(evt);
            }
        });

        exit3.setBackground(new java.awt.Color(255, 51, 51));
        exit3.setText("X");
        exit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit3ActionPerformed(evt);
            }
        });

        combo4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        combo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo4ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Engravers MT", 1, 12));
        jLabel39.setForeground(new java.awt.Color(51, 0, 255));
        jLabel39.setText("DIAGNOSIS");

        search4.setText("Search");
        search4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ddate, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                            .addComponent(pid2)
                                            .addComponent(xray)
                                            .addComponent(usound)
                                            .addComponent(btest)
                                            .addComponent(ctscan))
                                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                                        .addComponent(r16)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(r17))
                                                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                                        .addComponent(r10)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(r11))
                                                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                                        .addComponent(r13)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(r14))
                                                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                                        .addComponent(r7)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(r8))
                                                    .addComponent(exit3, javax.swing.GroupLayout.Alignment.TRAILING)))
                                            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                                .addGap(62, 62, 62)
                                                .addComponent(combo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel39)))
                            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(r15)
                                    .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel22)
                                        .addComponent(insert3)
                                        .addComponent(jLabel23)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel26)
                                        .addComponent(jLabel27)))
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                        .addComponent(update3)
                                        .addGap(30, 30, 30)
                                        .addComponent(clear3)
                                        .addGap(29, 29, 29)
                                        .addComponent(search4))
                                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(r18))))))
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addComponent(r9)
                        .addGap(18, 18, 18)
                        .addComponent(r12)))
                .addGap(99, 99, 99))
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame4Layout.createSequentialGroup()
                .addComponent(exit3)
                .addGap(5, 5, 5)
                .addComponent(jLabel39)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(r7)
                                    .addComponent(r8))
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(r10)
                                    .addComponent(r11)
                                    .addComponent(usound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel26)
                                .addGap(50, 50, 50))
                            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(xray, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(r13)
                                    .addComponent(r14))
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ctscan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(r16)
                                    .addComponent(r17)
                                    .addComponent(jLabel27)))))
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(82, 82, 82)
                        .addComponent(jLabel24)))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insert3)
                    .addComponent(update3)
                    .addComponent(clear3)
                    .addComponent(search4))
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(r12)
                            .addComponent(r9))
                        .addGap(5, 5, 5))
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(r18)
                            .addComponent(r15)))))
        );

        jTabbedPane1.addTab("Diagnosis", jInternalFrame4);

        jLabel28.setText("Patient ID");

        jLabel29.setText("Patient Name");

        jLabel30.setText("Doctor Fees");

        jLabel31.setText("Diagnosis Fees");

        jLabel32.setText("Medicine Fees");

        jLabel33.setText("Rent");

        jLabel34.setText("Bill Date");

        combo5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        combo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo5ActionPerformed(evt);
            }
        });

        insert4.setText("Insert");
        insert4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert4ActionPerformed(evt);
            }
        });

        update4.setText("Update");
        update4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update4ActionPerformed(evt);
            }
        });

        clear4.setText("Clear");
        clear4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear4ActionPerformed(evt);
            }
        });

        exit4.setBackground(new java.awt.Color(255, 51, 51));
        exit4.setText("X");
        exit4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit4ActionPerformed(evt);
            }
        });

        total.setText("Calculate Total");
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        jLabel35.setText("Total Amount");

        jLabel40.setFont(new java.awt.Font("Engravers MT", 1, 12));
        jLabel40.setForeground(new java.awt.Color(51, 51, 255));
        jLabel40.setText("BILLING");

        search5.setText("Search");
        search5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search5ActionPerformed(evt);
            }
        });

        report.setText("Generate Report");
        report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame5Layout = new javax.swing.GroupLayout(jInternalFrame5.getContentPane());
        jInternalFrame5.getContentPane().setLayout(jInternalFrame5Layout);
        jInternalFrame5Layout.setHorizontalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame5Layout.createSequentialGroup()
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame5Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel40))
                    .addGroup(jInternalFrame5Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                                .addComponent(insert4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(update4)
                                .addGap(18, 18, 18)
                                .addComponent(clear4))
                            .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jInternalFrame5Layout.createSequentialGroup()
                                    .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel29)
                                        .addComponent(jLabel31)
                                        .addComponent(jLabel30)
                                        .addComponent(jLabel32)
                                        .addComponent(jLabel33)
                                        .addComponent(jLabel28)
                                        .addComponent(jLabel35))
                                    .addGap(68, 68, 68)
                                    .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tot)
                                        .addComponent(medfees, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(docfees, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rent, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(diagfees, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                        .addComponent(pname3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pid3, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addComponent(jLabel34))
                            .addComponent(report))
                        .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                                .addGap(18, 37, Short.MAX_VALUE)
                                .addComponent(combo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))
                            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(search5)
                                    .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(exit4)
                                        .addComponent(total)))))))
                .addGap(42, 42, 42))
        );
        jInternalFrame5Layout.setVerticalGroup(
            jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame5Layout.createSequentialGroup()
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pid3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(combo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel28))
                        .addGap(11, 11, 11)
                        .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29)
                            .addComponent(pname3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(docfees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(diagfees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(medfees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)))
                    .addComponent(exit4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(total)
                    .addComponent(tot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jInternalFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear4)
                    .addComponent(insert4)
                    .addComponent(update4)
                    .addComponent(search5))
                .addGap(12, 12, 12)
                .addComponent(report)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Billing", jInternalFrame5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void r1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r1MouseClicked
sex.setText("M");        // TODO add your handling code here:
    }//GEN-LAST:event_r1MouseClicked

    private void r2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r2MouseClicked
sex.setText("F");        // TODO add your handling code here:
    }//GEN-LAST:event_r2MouseClicked

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
clear();
    }//GEN-LAST:event_clearActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        try {
            String sql = "insert into staff_details values(?,?,?,?,?,?,?,?)"; // TODO add your handling code here:
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1,sid.getText());
            psmt.setString(2,sname.getText());
            psmt.setString(3,sex.getText());
            psmt.setString(4,age.getText());
            psmt.setString(5,desig.getText());
            psmt.setString(6,dept.getText());
            psmt.setString(7,addr.getText());
            psmt.setString(8,ph.getText());
            psmt.executeUpdate();
            JOptionPane.showMessageDialog(this,"INSERTION SUCCESSFUL!");
            String s=sid.getText();
            combo1.addItem(s);
            if(s.startsWith("D"))
            {
                combo2.addItem(s);
            }
            clear();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }

    }//GEN-LAST:event_insertActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
try{
            String sql=("delete from staff_details where sid='"+sid.getText()+"'");
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Employee Details for "+sid.getText()+" Deleted Successfully!!");
            String s=sid.getText();
            combo1.removeItem(s);
            if(s.startsWith("D"))
            {
                combo2.removeItem(s);
            }
            clear();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            //JOptionPane.showMessageDialog(this, ex.getMessage());
        }       // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
     try
       {
       String sql=("update staff_details set sname=?,sex=?,age=?,desig=?,dept=?,address=?,phno=? where sid=?");
       PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1,sname.getText());
        psmt.setString(2,sex.getText());
        psmt.setString(3,age.getText());
        psmt.setString(4,desig.getText());
        psmt.setString(5,dept.getText());
        psmt.setString(6,addr.getText());
        psmt.setString(7,ph.getText());
        psmt.setString(8,sid.getText());
        psmt.executeUpdate();
        JOptionPane.showMessageDialog(this,"UPDATION SUCCESSFUL!");
        clear();
       }
       catch(Exception ex){
           JOptionPane.showMessageDialog(this,ex.getMessage());
           }        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1ActionPerformed
String ssid = combo1.getSelectedItem().toString();
        sid.setText(ssid);        // TODO add your handling code here:
    }//GEN-LAST:event_combo1ActionPerformed

    private void combo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo2ActionPerformed
String sdid = combo2.getSelectedItem().toString();
did.setText(sdid);// TODO add your handling code here:
    }//GEN-LAST:event_combo2ActionPerformed

    private void r4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r4MouseClicked
sex1.setText("M");        // TODO add your handling code here:
    }//GEN-LAST:event_r4MouseClicked

    private void r5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r5MouseClicked
sex1.setText("F");        // TODO add your handling code here:
    }//GEN-LAST:event_r5MouseClicked

    private void clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear1ActionPerformed
     clear1();   // TODO add your handling code here:
    }//GEN-LAST:event_clear1ActionPerformed

    private void exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit1ActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_exit1ActionPerformed

    private void insert1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert1ActionPerformed
 try {
            String sql = "insert into patient_entry values(?,?,?,?,?,?,?,?,?,?)"; // TODO add your handling code here:
            // TODO add your handling code here:
            // TODO add your handling code here:
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1,pid.getText());
            psmt.setString(2,pname.getText());
            psmt.setString(3,sex1.getText());
            psmt.setString(4,age1.getText());
            psmt.setString(5,bgroup.getText());
            psmt.setString(6,ph1.getText());
            psmt.setString(7,edate.getText());
            psmt.setString(8,ptype.getText());
            psmt.setString(9,reason.getText());
            psmt.setString(10,did.getText());
            psmt.executeUpdate();
            String s=pid.getText();
            String t=ptype.getText();
            comb3.addItem(s);
            combo5.addItem(s);
            if(t.startsWith("i"))
            {
                combo3.addItem(s);
            }
            JOptionPane.showMessageDialog(this,"INSERTION SUCCESSFUL!");
            clear1();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }       // TODO add your handling code here:
    }//GEN-LAST:event_insert1ActionPerformed

    private void update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update1ActionPerformed
    try
       {
       String sql=("update patient_entry set pname=?,sex=?,age=?,bgroup=?,phno=?,edate=?,ptype=?,reason=?,did=? where pid=?");
       PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1,pname.getText());
        psmt.setString(2,sex1.getText());
        psmt.setString(3,age1.getText());
        psmt.setString(4,bgroup.getText());
        psmt.setString(5,ph1.getText());
        psmt.setString(6,edate.getText());
        psmt.setString(7,ptype.getText());
        psmt.setString(8,reason.getText());
        psmt.setString(9,did.getText());
       psmt.setString(10,pid.getText());
        psmt.executeUpdate();
        String s=pid.getText();
        String t=ptype.getText();
        if(t.startsWith("i"))
            {
                combo3.addItem(s);
            }
         if(t.startsWith("o"))
            {
                combo3.removeItem(s);
            }
        JOptionPane.showMessageDialog(this,"UPDATION SUCCESSFUL!");
        clear1();
       }
       catch(Exception ex){
           JOptionPane.showMessageDialog(this,ex.getMessage());
           }    // TODO add your handling code here:
    }//GEN-LAST:event_update1ActionPerformed

    private void insert2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert2ActionPerformed
        try {
            String sql = "insert into patient_admit values(?,?,?)"; // TODO add your handling code here:
            // TODO add your handling code here:
            // TODO add your handling code here:
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1,pid1.getText());
            psmt.setString(2,bno.getText());
            psmt.setString(3,adate.getText());
            psmt.executeUpdate();
            String s=pid1.getText();
            combo4.addItem(s);

            JOptionPane.showMessageDialog(this,"INSERTION SUCCESSFUL!");
            clear2();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_insert2ActionPerformed

    private void delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete1ActionPerformed
       try{
            String sql=("delete from patient_admit where pid='"+pid1.getText()+"'");
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.executeUpdate();
            String s=pid1.getText();
            combo4.removeItem(s);
            JOptionPane.showMessageDialog(this, "Patient Details for "+pid1.getText()+" Deleted Successfully!!");
            clear2();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            //JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_delete1ActionPerformed

    private void update2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update2ActionPerformed
      try
      {
        String sql=("update patient_admit set bno=?,adate=? where pid=?");
       PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1,bno.getText());
        psmt.setString(2,adate.getText());
        psmt.setString(3,pid1.getText());
        psmt.executeUpdate();
        
        JOptionPane.showMessageDialog(this,"UPDATION SUCCESSFUL!");
        clear2();
       }
       catch(Exception ex){
           JOptionPane.showMessageDialog(this,ex.getMessage());
           }    // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_update2ActionPerformed

    private void clear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear2ActionPerformed
clear2();
        // TODO add your handling code here:
    }//GEN-LAST:event_clear2ActionPerformed

    private void exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit2ActionPerformed
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_exit2ActionPerformed

    private void combo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo3ActionPerformed
       String spid = combo3.getSelectedItem().toString();
        pid1.setText(spid);
        // TODO add your handling code here:
    }//GEN-LAST:event_combo3ActionPerformed

    private void r7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r7MouseClicked
        // TODO add your handling code here:
        xray.setText("Positive");
    }//GEN-LAST:event_r7MouseClicked

    private void r8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r8MouseClicked
    xray.setText("Negative");
        // TODO add your handling code here:
    }//GEN-LAST:event_r8MouseClicked

    private void r10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r10MouseClicked
    usound.setText("positive");
        // TODO add your handling code here:
    }//GEN-LAST:event_r10MouseClicked

    private void r11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r11MouseClicked
    usound.setText("Negative");
            // TODO add your handling code here:
    }//GEN-LAST:event_r11MouseClicked

    private void r13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r13MouseClicked
    btest.setText("Positive");
            // TODO add your handling code here:
    }//GEN-LAST:event_r13MouseClicked

    private void r14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r14MouseClicked
    btest.setText("Negative");
        // TODO add your handling code here:
    }//GEN-LAST:event_r14MouseClicked

    private void r16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r16MouseClicked
    ctscan.setText("Positive");
        // TODO add your handling code here:
    }//GEN-LAST:event_r16MouseClicked

    private void r17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r17MouseClicked
    ctscan.setText("Negative");
        // TODO add your handling code here:
    }//GEN-LAST:event_r17MouseClicked

    private void insert3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert3ActionPerformed
 try {
            String sql = "insert into diagnosis values(?,?,?,?,?,?)"; // TODO add your handling code here:
            // TODO add your handling code here:
            // TODO add your handling code here:
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1,pid2.getText());
            psmt.setString(2,ddate.getText());
            psmt.setString(3,xray.getText());
            psmt.setString(4,usound.getText());
            psmt.setString(5,btest.getText());
            psmt.setString(6,ctscan.getText());
            psmt.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"INSERTION SUCCESSFUL!");
            clear3();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_insert3ActionPerformed

    private void update3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update3ActionPerformed
       try
      {
        String sql=("update diagnosis set ddate=?,xray=?,usound=?,btest=?,ctscan=? where pid=?");
       PreparedStatement psmt=con.prepareStatement(sql);
       psmt.setString(1,ddate.getText());
       psmt.setString(2,xray.getText());
       psmt.setString(3,usound.getText());
       psmt.setString(4,btest.getText());
       psmt.setString(5,ctscan.getText());
       psmt.setString(6,pid2.getText());
       psmt.executeUpdate();
        
        JOptionPane.showMessageDialog(this,"UPDATION SUCCESSFUL!");
        clear3();
       }
       catch(Exception ex){
           JOptionPane.showMessageDialog(this,ex.getMessage());
           }
        // TODO add your handling code here:
    }//GEN-LAST:event_update3ActionPerformed

    private void clear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear3ActionPerformed
clear3();

  // TODO add your handling code here:
    }//GEN-LAST:event_clear3ActionPerformed

    private void exit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit3ActionPerformed
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_exit3ActionPerformed

    private void r3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r3ActionPerformed

    private void combo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo4ActionPerformed
        String stid = combo4.getSelectedItem().toString();
        pid2.setText(stid);
        // TODO add your handling code here:
    }//GEN-LAST:event_combo4ActionPerformed

    private void comb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comb1ActionPerformed
       String stid = comb1.getSelectedItem().toString();
        desig.setText(stid); // TODO add your handling code here:
    }//GEN-LAST:event_comb1ActionPerformed

    private void comb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comb2ActionPerformed
        String stid = comb2.getSelectedItem().toString();
        dept.setText(stid); // TODO add your handling code here:
    }//GEN-LAST:event_comb2ActionPerformed

    private void combo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo5ActionPerformed
       String stid = combo5.getSelectedItem().toString();
        pid3.setText(stid);
        // TODO add your handling code here:
    }//GEN-LAST:event_combo5ActionPerformed

    private void insert4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert4ActionPerformed
       try {
            String sql = "insert into billing values(?,?,?,?,?,?,?,null)"; // TODO add your handling code here:
            // TODO add your handling code here:
            // TODO add your handling code here:
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1,pid3.getText());
            psmt.setString(2,pname3.getText());
            psmt.setString(3,docfees.getText());
            psmt.setString(4,diagfees.getText());
            psmt.setString(5,medfees.getText());
            psmt.setString(6,rent.getText());
            psmt.setString(7,bdate.getText());
            psmt.executeUpdate();
            //clear4();
            JOptionPane.showMessageDialog(this,"INSERTION SUCCESSFUL!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_insert4ActionPerformed

    private void update4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update4ActionPerformed
       try
      {
        String sql=("update billing set pname=?,docfees=?,diagfees=?,medfees=?,rent=?,billdate=? where pid=?");
       PreparedStatement psmt=con.prepareStatement(sql);
       psmt.setString(1,pname.getText());
       psmt.setString(2,docfees.getText());
       psmt.setString(3,diagfees.getText());
       psmt.setString(4,medfees.getText());
       psmt.setString(5,rent.getText());
       psmt.setString(6,bdate.getText());
       psmt.setString(7,pid3.getText());
       psmt.executeUpdate();
        //clear4();
        JOptionPane.showMessageDialog(this,"UPDATION SUCCESSFUL!");
       }
       catch(Exception ex){
           JOptionPane.showMessageDialog(this,ex.getMessage());
           }
        // TODO add your handling code here:
    }//GEN-LAST:event_update4ActionPerformed

    private void clear4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear4ActionPerformed
clear4();
        // TODO add your handling code here:
    }//GEN-LAST:event_clear4ActionPerformed

    private void exit4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit4ActionPerformed
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_exit4ActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
try
{
            CallableStatement cs1 = con.prepareCall( "begin totalcal (?); end;" );
            cs1.setString(1, pid3.getText());
            cs1.executeUpdate();
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            res=stmt.executeQuery("select * from billing where pid='"+pid3.getText()+"'");
            res.first();
            tot.setText(res.getString(8));
            JOptionPane.showMessageDialog(this," Total Calculated ");
        }
catch(Exception e)
{
    JOptionPane.showMessageDialog(this,e.getMessage());
}
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void r10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r10ActionPerformed

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
try{
        String sql = "SELECT * FROM staff_details WHERE sid = ?";

        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1,sid.getText());
        res = psmt.executeQuery();
        res.next();
        JOptionPane.showMessageDialog(this," Search Successful ");
        sid.setText(res.getString(1));
        sname.setText(res.getString(2));
        sex.setText(res.getString(3));
        age.setText(res.getString(4));
        desig.setText(res.getString(5));
        dept.setText(res.getString(6));
        addr.setText(res.getString(7));
        ph.setText(res.getString(8));
        
        }
        catch(SQLException ex){
        JOptionPane.showMessageDialog(this,ex.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_search1ActionPerformed

    private void search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search2ActionPerformed
     try{
        String sql = "SELECT * FROM patient_entry WHERE pid = ?";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1,pid.getText());
        res = psmt.executeQuery();
        res.next();
        JOptionPane.showMessageDialog(this," Search Successful ");
        pid.setText(res.getString(1));
        pname.setText(res.getString(2));
        sex1.setText(res.getString(3));
        age1.setText(res.getString(4));
        bgroup.setText(res.getString(5));
        ph1.setText(res.getString(6));
        String datee;
        datee=res.getString(7);
        datee=datereplace(datee);
        edate.setText(datee);
        ptype.setText(res.getString(8));
        reason.setText(res.getString(9));
        did.setText(res.getString(10));
        
        }
        catch(SQLException ex){
        JOptionPane.showMessageDialog(this,ex.getMessage());
        }          // TODO add your handling code here:
    }//GEN-LAST:event_search2ActionPerformed

    private void search3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search3ActionPerformed
        try{
        String sql = "SELECT * FROM patient_admit WHERE pid = ?";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1,pid1.getText());
        res = psmt.executeQuery();
        res.next();
        JOptionPane.showMessageDialog(this," Search Successful ");
        pid1.setText(res.getString(1));
        bno.setText(res.getString(2));
        String datee;
        datee=res.getString(3);
        datee=datereplace(datee);
        adate.setText(datee);
       
        }
        catch(SQLException ex){
        JOptionPane.showMessageDialog(this,ex.getMessage());
        }     // TODO add your handling code here:
    }//GEN-LAST:event_search3ActionPerformed

    private void search4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search4ActionPerformed
try{
        String sql = "SELECT * FROM diagnosis WHERE pid = ?";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1,pid2.getText());
        res = psmt.executeQuery();
        res.next();
        JOptionPane.showMessageDialog(this," Search Successful ");
        pid2.setText(res.getString(1));
        String datee;
        datee=res.getString(2);
        datee=datereplace(datee);
        ddate.setText(datee);
        xray.setText(res.getString(3));
        usound.setText(res.getString(4));
        btest.setText(res.getString(5));
        ctscan.setText(res.getString(6));
        
        }
        catch(SQLException ex){
        JOptionPane.showMessageDialog(this,ex.getMessage());
        }             // TODO add your handling code here:
    }//GEN-LAST:event_search4ActionPerformed

    private void search5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search5ActionPerformed
try{
        String sql = "SELECT * FROM billing WHERE pid = ?";

        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1,pid3.getText());
        res = psmt.executeQuery();
        res.next();
        JOptionPane.showMessageDialog(this," Search Successful ");
        pid3.setText(res.getString(1));
        pname3.setText(res.getString(2));
        docfees.setText(res.getString(3));
        diagfees.setText(res.getString(4));
        medfees.setText(res.getString(5));
        rent.setText(res.getString(6));
        String datee;
        datee=res.getString(7);
        datee=datereplace(datee);
        bdate.setText(datee);
        tot.setText(res.getString(8));
        
        }
        catch(SQLException ex){
        JOptionPane.showMessageDialog(this,ex.getMessage());
        }             // TODO add your handling code here:
    }//GEN-LAST:event_search5ActionPerformed

    private void comb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comb3ActionPerformed
String ppid = comb3.getSelectedItem().toString();
pid.setText(ppid);        // TODO add your handling code here:
    }//GEN-LAST:event_comb3ActionPerformed

    private void reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportActionPerformed
report f=new report();
f.show();        // TODO add your handling code here:
    }//GEN-LAST:event_reportActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adate;
    private javax.swing.JTextField addr;
    private javax.swing.JTextField age;
    private javax.swing.JTextField age1;
    private javax.swing.JTextField bdate;
    private javax.swing.JTextField bgroup;
    private javax.swing.JTextField bno;
    private javax.swing.JTextField btest;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.JButton clear;
    private javax.swing.JButton clear1;
    private javax.swing.JButton clear2;
    private javax.swing.JButton clear3;
    private javax.swing.JButton clear4;
    private javax.swing.JComboBox comb1;
    private javax.swing.JComboBox comb2;
    private javax.swing.JComboBox comb3;
    private javax.swing.JComboBox combo1;
    private javax.swing.JComboBox combo2;
    private javax.swing.JComboBox combo3;
    private javax.swing.JComboBox combo4;
    private javax.swing.JComboBox combo5;
    private javax.swing.JTextField ctscan;
    private javax.swing.JTextField ddate;
    private javax.swing.JButton delete;
    private javax.swing.JButton delete1;
    private javax.swing.JTextField dept;
    private javax.swing.JTextField desig;
    private javax.swing.JTextField diagfees;
    private javax.swing.JTextField did;
    private javax.swing.JTextField docfees;
    private javax.swing.JTextField edate;
    private javax.swing.JButton exit;
    private javax.swing.JButton exit1;
    private javax.swing.JButton exit2;
    private javax.swing.JButton exit3;
    private javax.swing.JButton exit4;
    private javax.swing.JButton insert;
    private javax.swing.JButton insert1;
    private javax.swing.JButton insert2;
    private javax.swing.JButton insert3;
    private javax.swing.JButton insert4;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JInternalFrame jInternalFrame5;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField medfees;
    private javax.swing.JTextField ph;
    private javax.swing.JTextField ph1;
    private javax.swing.JTextField pid;
    private javax.swing.JTextField pid1;
    private javax.swing.JTextField pid2;
    private javax.swing.JTextField pid3;
    private javax.swing.JTextField pname;
    private javax.swing.JTextField pname3;
    private javax.swing.JTextField ptype;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r10;
    private javax.swing.JRadioButton r11;
    private javax.swing.JRadioButton r12;
    private javax.swing.JRadioButton r13;
    private javax.swing.JRadioButton r14;
    private javax.swing.JRadioButton r15;
    private javax.swing.JRadioButton r16;
    private javax.swing.JRadioButton r17;
    private javax.swing.JRadioButton r18;
    private javax.swing.JRadioButton r2;
    private javax.swing.JRadioButton r3;
    private javax.swing.JRadioButton r4;
    private javax.swing.JRadioButton r5;
    private javax.swing.JRadioButton r6;
    private javax.swing.JRadioButton r7;
    private javax.swing.JRadioButton r8;
    private javax.swing.JRadioButton r9;
    private javax.swing.JTextField reason;
    private javax.swing.JTextField rent;
    private javax.swing.JButton report;
    private javax.swing.JButton search1;
    private javax.swing.JButton search2;
    private javax.swing.JButton search3;
    private javax.swing.JButton search4;
    private javax.swing.JButton search5;
    private javax.swing.JTextField sex;
    private javax.swing.JTextField sex1;
    private javax.swing.JTextField sid;
    private javax.swing.JTextField sname;
    private javax.swing.JTextField tot;
    private javax.swing.JButton total;
    private javax.swing.JButton update;
    private javax.swing.JButton update1;
    private javax.swing.JButton update2;
    private javax.swing.JButton update3;
    private javax.swing.JButton update4;
    private javax.swing.JTextField usound;
    private javax.swing.JTextField xray;
    // End of variables declaration//GEN-END:variables

}
