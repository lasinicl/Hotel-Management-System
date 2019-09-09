/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sealine.catering;

import DBConnect.DBConnect;
//
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.*;
/**
 *
 * @author charith ellawala
 */
public class MenuSelection extends javax.swing.JFrame {

     DBConnect connect=new DBConnect();
     Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    Statement st = null;
    /**
     * Creates new form AddItem
     */
    public MenuSelection() {
         
        initComponents();
        fillCombo();
    }

   
    
    
     private void fillCombo(){
         try{
            
            Class.forName("com.mysql.jdbc.Driver");
            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
            st=conn.createStatement();
//            JOptionPane.showConfirmDialog(null, "Connection Successfully Completed");
            System.out.println("Connection Successfully Completed");
           }catch (Exception ex){
        //System.out.println("Error :" +ex);
        JOptionPane.showMessageDialog(null,"couldn't connect to database");
        }
     
         try{
             String query="select menu_name from menu";
     
            pst=conn.prepareStatement(query);
     
           rs=pst.executeQuery();
           
        
             while(rs.next()){
                 String menu_name=rs.getString("menu_name");
               //  System.out.println(menu_name);
                 cmb_menuname.addItem(menu_name);
             }
             
         }
         catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Exception 1 -> "+ex);
         }
         
     
     }
     
     private void fillItemCombo(){
        //    cmb_item.setSelectedIndex(0);
            String tmp=(String)cmb_menuname.getSelectedItem();
        //      DefaultListModel dlm = new DefaultListModel();
           try {
            String sql = "select itemList from itemlist where not menuname='"+ tmp +"' ";
            connect.rs = connect.st.executeQuery(sql);
            while (connect.rs.next()) {
                String items = connect.rs.getString("itemList");
                cmb_item.addItem(items);
               
            }
            
            
        } catch (Exception ex) {
        //    ex.printStackTrace();
                System.out.println(ex);

        
        }
     
     
     
     
     }
     
     
     
    
     private void fillList(){    
             
         
          try{
            
            Class.forName("com.mysql.jdbc.Driver");
            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
            st=conn.createStatement();
//            JOptionPane.showConfirmDialog(null, "Connection Successfully Completed");
            System.out.println("Connection Successfully Completed");
           }catch (Exception ex){
        //System.out.println("Error :" +ex);
        JOptionPane.showMessageDialog(null,"couldn't connect to database");
        }
     
         String tmp=(String)cmb_menuname.getSelectedItem();
              DefaultListModel dlm = new DefaultListModel();
          
      
        
            try {
            String sql = "select itemList from itemlist where menuname='"+ tmp +"' ";
            connect.rs = connect.st.executeQuery(sql);
            while (connect.rs.next()) {
                String items = connect.rs.getString("itemList");
             //   lbl_menuprice.setText(item);
                dlm.addElement(items);
            }
             //   itemList.setModel(dlm);
            
             itemList.setModel(dlm);
        } catch (Exception ex) {
        //    ex.printStackTrace();
                System.out.println(ex);

        
        }
        
         // filllable();    
             
     }
     
    private void filllable(){   
         
        String tmp=(String)cmb_menuname.getSelectedItem();
        
            try {
            String sql = "select menu_price from menu where menu_name='"+tmp+"' ";
            connect.rs = connect.st.executeQuery(sql);
            while (connect.rs.next()) {
                String item = connect.rs.getString("menu_price");
                lbl_menuprice.setText(item);
            }
        } catch (Exception ex) {
        //    ex.printStackTrace();
                System.out.println(ex);

        }     
    
    }
    
     private void addprice(){            
           
                String tmp=(String)cmb_item.getSelectedItem();
                Double original_price=Double.parseDouble(lbl_menuprice.getText());
                                         
                Double tmp_price=Double.parseDouble(lbl_itemprice.getText());
                System.out.println(tmp_price);
                lbl_upprice.setText(Double.toString(original_price + tmp_price));
        
            
      
        
    }
     
     private void setItemprice(){
     
     try{
         String tmp=(String)cmb_item.getSelectedItem();
         String sql = "select itemprice from itemlist where itemList='"+tmp+"' ";
            connect.rs = connect.st.executeQuery(sql);
            while (connect.rs.next()) {
                String item = connect.rs.getString("itemprice");
                  lbl_itemprice.setText(item);
                }
     
     
     }
     catch(Exception e){
             System.out.println(e);
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

        jPanel1 = new javax.swing.JPanel();
        menuSelectionPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmb_menuname = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemList = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        cmb_item = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lbl_menuprice = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_upprice = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbl_itemprice = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuSelectionPanel.setPreferredSize(new java.awt.Dimension(768, 620));
        menuSelectionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Menu");
        menuSelectionPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 90, 30));

        cmb_menuname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_menuname.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmb_menunamePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cmb_menuname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_menunameActionPerformed(evt);
            }
        });
        menuSelectionPanel.add(cmb_menuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 110, 30));

        itemList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(itemList);

        menuSelectionPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 210, 340));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Remove");
        menuSelectionPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 93, 160, 40));

        cmb_item.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_item.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmb_itemPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        menuSelectionPanel.add(cmb_item, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 120, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        menuSelectionPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 120, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Original Menu Price");
        menuSelectionPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 150, 30));
        menuSelectionPanel.add(lbl_menuprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 120, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Updated Menu Price");
        menuSelectionPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 414, 140, 30));
        menuSelectionPanel.add(lbl_upprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, 130, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Payments");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        menuSelectionPanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 140, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Item price");
        menuSelectionPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 264, 130, 30));
        menuSelectionPanel.add(lbl_itemprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, 90, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );

        menuSelectionPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 610));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );

        menuSelectionPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 450, 610));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(menuSelectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuSelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 800, 660));

        jMenu3.setText("Menu");
        jMenu3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Menu Selection");
        jMenu4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Payments");
        jMenu5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        jMenu7.setText("Item");
        jMenu7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu7);

        jMenu8.setText("Reports");
        jMenu8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_menunameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_menunameActionPerformed
        
    }//GEN-LAST:event_cmb_menunameActionPerformed

    private void cmb_menunamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmb_menunamePopupMenuWillBecomeInvisible
//       
        filllable();
              fillList();
              fillItemCombo();
              //     filllable();
    
    }//GEN-LAST:event_cmb_menunamePopupMenuWillBecomeInvisible

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            addprice();
            String tmp=(String)cmb_item.getSelectedItem();
              DefaultListModel dlm = new DefaultListModel();
            //  System.out.println("ggg");
              dlm.addElement(tmp);
               itemList.setModel(dlm);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmb_itemPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmb_itemPopupMenuWillBecomeInvisible
        
        setItemprice();
    }//GEN-LAST:event_cmb_itemPopupMenuWillBecomeInvisible

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           
        Payments pay=new Payments();
          pay.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        MenuAdd item=new MenuAdd();
         item.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        ItemAdd item=new ItemAdd();
         item.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
         PaymentRecords pay=new PaymentRecords();
          pay.setVisible(true);
          this.dispose();
    }//GEN-LAST:event_jMenu5MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MenuSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuSelection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmb_item;
    private javax.swing.JComboBox cmb_menuname;
    private javax.swing.JList itemList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_itemprice;
    private javax.swing.JLabel lbl_menuprice;
    public static javax.swing.JLabel lbl_upprice;
    private javax.swing.JPanel menuSelectionPanel;
    // End of variables declaration//GEN-END:variables
}
