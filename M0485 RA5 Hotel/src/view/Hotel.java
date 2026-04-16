package view;

// APP
import static app.Main.*;

// JAVA SWING
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

// MODEL
import model.Room;
import static model.FileManager.*;
import static model.LogicManager.*;

// JAVA IO
import java.io.IOException;

// JAVA UTIL
import java.util.ArrayList;
import java.util.Set;

public class Hotel extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Hotel.class.getName());
    public Hotel()throws IOException {
        initComponents();
        this.setVisible(true);
        this.UpdateRoomList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAdd = new javax.swing.JButton();
        jButtonSearch = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonOpen = new javax.swing.JButton();
        jButtonDisponible = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListRooms = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonAdd.setText("ADD");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonSearch.setText("SEARCH");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jButtonDelete.setText("DELETE");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonOpen.setText("OPEN");
        jButtonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenActionPerformed(evt);
            }
        });

        jButtonDisponible.setText("CHANGE DISPONIBLE");
        jButtonDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisponibleActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListRooms);

        jLabel1.setText("                            ROOM MANAGER");

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDisponible, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                        .addComponent(jButtonOpen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDisponible)
                        .addGap(5, 5, 5)
                        .addComponent(jButtonSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDelete)))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        try {
           RoomCard RC = new RoomCard(0);
           RC.setVisible(true);
           RC.setLocationRelativeTo(this);
           this.dispose();
        } catch (IOException ex) {
            System.getLogger(Hotel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }           
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenActionPerformed
        try {
            String R = jListRooms.getSelectedValue();
            if(R==null){
               RoomCard RC = new RoomCard(0);
               RC.setVisible(true);
               RC.setLocationRelativeTo(this);
               this.dispose();
               return;
            }
            String[]room = R.split(" / ");
            System.out.println(room[0]);
            RoomCard RC = new RoomCard(StringToInt(room[0]));
            RC.setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            System.getLogger(Hotel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_jButtonOpenActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
       try {
            String input = JOptionPane.showInputDialog(this,"Room to Seach?");
            if(input == null){return;}
            if(IsStringLoad(input)){
                LoadRooms();
                this.UpdateRoomList();
                return;
            }
            if(existIDInFile(FILE,input)){
                RoomCard R = new RoomCard(StringToInt(input));
                R.setVisible(true);
                R.setLocationRelativeTo(this);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this,"Room "+input+" does not exists");
            }
            
        } catch (IOException ex) {
            System.getLogger(Hotel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        try {
            String R = jListRooms.getSelectedValue();
            if(R==null){return;}
            String[]room = R.split(" / ");
            System.out.println(room[0]);
            String[]r = getByIDFromFile(FILE,room[0],"1000");
            if(r==null){return;}
            Room NR = new Room(StringToInt(r[0]),r[1],StringToInt(r[2]),StringToBoolean(r[3]));
            NR.delete();
            this.UpdateRoomList();
        } catch (IOException ex) {
            System.getLogger(Hotel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
            
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisponibleActionPerformed
        try {
            String R = jListRooms.getSelectedValue();
            if(R==null){return;}
            String[]room = R.split(" / ");
            System.out.println(room[0]);
            String[]r = getByIDFromFile(FILE,room[0],"1000");
            Room SC = new Room(StringToInt(r[0]),r[1],StringToInt(r[2]),StringToBoolean(r[3]));
            
            if(SC.getDisponible()){
                SC.delete();
                SC.setDisponible(false);
                SC.create();
                this.UpdateRoomList();
            }
            else{
                SC.delete();
                SC.setDisponible(true);
                SC.create();
                this.UpdateRoomList();
            }
            
        } catch (IOException ex) {
            System.getLogger(Hotel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }//GEN-LAST:event_jButtonDisponibleActionPerformed

    public void UpdateRoomList()throws IOException{
        DefaultListModel<String> D = new DefaultListModel();
        ArrayList<String[]> fileContent = getAllFileContent(FILE);
        for(String[] F : fileContent){
            Room R = new Room(StringToInt(F[0]),F[1],StringToInt(F[2]),StringToBoolean(F[3]));
            D.addElement(R.toJList());
        }
        jListRooms.setModel(D);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonDisponible;
    private javax.swing.JButton jButtonOpen;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JList<String> jListRooms;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
