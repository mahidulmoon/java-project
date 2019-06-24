
package welcome;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;


public class Mainbord extends javax.swing.JFrame {

    String id, name, age, department,faculty,gender,religion,marital,email,blood,contactnumber;
 
    Update up = new Update(this);
    Search searchframe = new Search();
    //Database connection 
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst = null;
    String path="jdbc:mysql://localhost:3306/student_information?useSSL=false";
    String user="root";
    String pass="1114012833m";

    public void show_data_in_table_from_database(){
         
         String sql="select * from student order by id asc";
       try{
           Class.forName("com.mysql.jdbc.Driver");
           con= DriverManager.getConnection(path,user,pass);
           pst= con.prepareStatement(sql);
           rs = pst.executeQuery();
           table1.setModel(DbUtils.resultSetToTableModel(rs));     
       }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Error");
       }
    }
     
    public void delete_data_from_database(){
         try{
           Class.forName("com.mysql.jdbc.Driver");
           con= DriverManager.getConnection(path,user,pass);
           String sql="DELETE FROM student WHERE id=?"; 
           pst = con.prepareStatement(sql);
           pst.setString(1,id);
           pst.execute();
           JOptionPane.showMessageDialog(null, "Delete Successfull.");
       }catch(HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Error");
       }
    }
          
    public String idpass() {
        TableModel model = table1.getModel();
        int index = table1.getSelectedRow();
        id = model.getValueAt(index, 0).toString();
        up.catchID=id;
        return id;
    }

    public String namepass() {
        TableModel model = table1.getModel();
        int index = table1.getSelectedRow();
        name = model.getValueAt(index, 1).toString();
        return name;
    }

    public String agepass() {
        TableModel model = table1.getModel();
        int index = table1.getSelectedRow();
        age = model.getValueAt(index, 2).toString();
        return age;
    }

    public String departmentpass() {
        TableModel model = table1.getModel();
        int index = table1.getSelectedRow();
        department = model.getValueAt(index, 3).toString();
        return department;
    } 
    public String facultypass(){
        TableModel model = table1.getModel();
        int index = table1.getSelectedRow();
        faculty = model.getValueAt(index, 4).toString();
        return faculty;
    }
    public String genderpass(){
        TableModel model = table1.getModel();
        int index = table1.getSelectedRow();
        gender = model.getValueAt(index, 5).toString();
        return gender;
    }
    public String religionpass(){
        TableModel model = table1.getModel();
        int index = table1.getSelectedRow();
        religion = model.getValueAt(index, 6).toString();
        return religion;
    }
    public String maritalpass(){
        TableModel model = table1.getModel();
        int index = table1.getSelectedRow();
        marital = model.getValueAt(index, 7).toString();
        return marital;
    }
    public String emailpass(){
        TableModel model = table1.getModel();
        int index = table1.getSelectedRow();
        email = model.getValueAt(index, 8).toString();
        return email;
    }
    public String bloodpass(){
        TableModel model = table1.getModel();
        int index = table1.getSelectedRow();
        blood = model.getValueAt(index, 9).toString();
        return blood;
    }
    public String contactnumberpass(){
        TableModel model = table1.getModel();
        int index = table1.getSelectedRow();
        contactnumber = model.getValueAt(index, 10).toString();
        return contactnumber;
    }
    public Mainbord() {
        initComponents();
        show_data_in_table_from_database();
        this.setLocationRelativeTo(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        searchfield = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        refresh = new javax.swing.JButton();
        update = new javax.swing.JButton();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setForeground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Information Table");
        jLabel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        exit.setBackground(new java.awt.Color(204, 0, 51));
        exit.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("X");
        exit.setToolTipText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        searchfield.setBackground(new java.awt.Color(255, 255, 255));
        searchfield.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        searchfield.setForeground(new java.awt.Color(0, 0, 51));
        searchfield.setText("Search");
        searchfield.setToolTipText("Search by ID");
        searchfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchfield.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        searchfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchfieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(359, 359, 359)
                        .addComponent(exit))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(336, 336, 336))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(exit)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        table1.setBackground(new java.awt.Color(0, 0, 51));
        table1.setForeground(new java.awt.Color(255, 255, 255));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Full Name", "Age", "Department", "Faculty", "Gender", "Religion", "Meritial Status", "Blood Group", "Email", "Contract Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));
        jPanel2.setForeground(new java.awt.Color(0, 0, 51));

        refresh.setBackground(new java.awt.Color(0, 0, 51));
        refresh.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        refresh.setForeground(new java.awt.Color(255, 255, 255));
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(0, 0, 51));
        update.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        add.setBackground(new java.awt.Color(0, 0, 51));
        add.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(0, 0, 51));
        delete.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        logout.setBackground(new java.awt.Color(0, 0, 51));
        logout.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(refresh)
                .addGap(18, 18, 18)
                .addComponent(update)
                .addGap(18, 18, 18)
                .addComponent(add)
                .addGap(18, 18, 18)
                .addComponent(delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logout)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1017, 529));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel1AncestorAdded

    }//GEN-LAST:event_jLabel1AncestorAdded

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        Add adds = new Add();
        adds.show();
        this.hide();
    }//GEN-LAST:event_addActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed

        table1.clearSelection();
        this.hide();
        show_data_in_table_from_database();
        this.show();
    }//GEN-LAST:event_refreshActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        Login login=new Login();
        this.hide();
        login.show();
    }//GEN-LAST:event_logoutActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        if (table1.getSelectedRow() == -1) {
            if (table1.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Table is empty,Insert first.");
            } 
            else {
                JOptionPane.showMessageDialog(null, "You must select a row.");
            }
          }
        else {
          
            int response = JOptionPane.showConfirmDialog(null, "Do you want to Update Data?", "Confirm",
           JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
          if (response == JOptionPane.NO_OPTION) {
          //CLOSE POP UP MENU ...
            }
          else if (response == JOptionPane.YES_OPTION)//WILL RUN FOR UPADTE DATA ....
         {
             this.hide();
            up.show();
            up.idfield.setText(id);
            up.namefield.setText(name);
            up.agefield.setText(age);
            up.departmentcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{department, "CSE", "BBA", "Textile", "EEE", "SWE"}));
            up.facultycombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{faculty, "FSIT", "FBE", "FE", "FAHS","FHSS"}));
            up.gendercombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{gender, "Male", "Female", "Others"}));
            up.religioncombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{religion, "Islam", "Hindu", "Buddho", "Christian"}));
            up.emailfield.setText(email);
            up.bloodgroupcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{blood, "A+", "A-", "AB+", "AB-","B+","B-","O+","O-"}));
            up.contactnumfield.setText(contactnumber);
            if(marital=="Married"){
                up.married.setSelected(true);
                up.unmarried.setSelected(false);
            }
            else{
                 up.unmarried.setSelected(true);
            }
//JOptionPane.showMessageDialog(null,"id is "+up.catchID);
        }     
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        if (table1.getSelectedRow() == -1) {
            if (table1.getRowCount() == 0) {
              JOptionPane.showMessageDialog(null, "Table is empty,Insert first.");
            } else {
                 JOptionPane.showMessageDialog(null, "You must select a row.");
            }
        } else {
            
            int response = JOptionPane.showConfirmDialog(null, "Do you want to Delete?", "Confirm",
           JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
          if (response == JOptionPane.NO_OPTION) {
          //CLOSE POP UP MENU ...
            }
          else if (response == JOptionPane.YES_OPTION)//WILL RUN FOR DELETE DATA ....
         {
              model.removeRow(table1.getSelectedRow());
             delete_data_from_database(); 
        }    
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        this.idpass();
        this.namepass();
        this.agepass();
        this.departmentpass();
        this.facultypass();
        this.genderpass();
        this.religionpass();
        this.maritalpass();
        this.emailpass();
        this.bloodpass();
        this.contactnumberpass();
    }//GEN-LAST:event_table1MouseClicked

    private void searchfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchfieldKeyPressed

       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
    try{
        String sql = "select * from student where id=?";
        pst = con.prepareStatement(sql);
        pst.setString(1, searchfield.getText());
        rs=pst.executeQuery();
 
 if(rs.next())
{  
    searchframe.show();
  String showid = rs.getString("id"); 
 searchframe.idfield.setText(showid);
 String showname = rs.getString("name"); 
 searchframe.namefield.setText(showname);
 String showage = rs.getString("age"); 
 searchframe.agefield.setText(showage);
 String showdepartment = rs.getString("department"); 
 searchframe.departmentfield.setText(showdepartment);
 
 String showfaculty = rs.getString("faculty"); 
 searchframe.facultyfield.setText(showfaculty);
 String shoegender = rs.getString("gender"); 
 searchframe.genderfield.setText(shoegender);
 String showreligion = rs.getString("religion"); 
 searchframe.religionfield.setText(showreligion);
 String showmartial = rs.getString("martial"); 
 searchframe.martialfield.setText(showmartial);
 String showemail = rs.getString("email"); 
 searchframe.emailfield.setText(showemail);
 String showblood = rs.getString("blood"); 
 searchframe.bloodfield.setText(showblood);
 String showcontactnumber = rs.getString("contactnumber"); 
 searchframe.contactnumberfield.setText(showcontactnumber);
  this.hide();
 
}
 else{
     JOptionPane.showMessageDialog(null,"Not Found");
 }
}catch(     HeadlessException | SQLException e){}}
    }//GEN-LAST:event_searchfieldKeyPressed

    
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
            java.util.logging.Logger.getLogger(Mainbord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainbord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainbord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainbord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Mainbord().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField searchfield;
    public javax.swing.JTable table1;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
