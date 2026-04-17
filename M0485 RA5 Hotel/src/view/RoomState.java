package view;

// APP
import static app.Main.*;

// MODEL
import model.Room;
import static model.LogicManager.*;
import static model.FileManager.*;

import java.io.IOException;

public class RoomState extends javax.swing.JDialog {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RoomState.class.getName());
    
    public String FILE = System.getProperty("user.dir")+"\\data\\rooms.txt";
    public Room SelectedRoom =  null;
    
    public RoomState(int number)throws IOException {
        String[]r = GetByIDFromFile(FILE,IntToString(number),"1000");
        SelectedRoom = new Room(StringToInt(r[0]),r[1],StringToInt(r[2]),StringToBoolean(r[3]));
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonYes = new javax.swing.JButton();
        jButtonNo = new javax.swing.JButton();
        jImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonYes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/YesComrade.png"))); // NOI18N
        jButtonYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonYesActionPerformed(evt);
            }
        });

        jButtonNo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/YesComrade.png"))); // NOI18N
        jButtonNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNoActionPerformed(evt);
            }
        });

        jImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/trabajar.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonYes)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonNo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jImage)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jImage, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonYes)
                    .addComponent(jButtonNo))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNoActionPerformed
        try {
            SelectedRoom.delete();
            SelectedRoom.setDisponible(false);
            SelectedRoom.create();
            RoomCard R = new RoomCard(SelectedRoom.getNumber());
            R.setVisible(true);
            R.setLocationRelativeTo(this);
            this.dispose();
        } catch (IOException ex) {
            System.getLogger(RoomState.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_jButtonNoActionPerformed

    private void jButtonYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonYesActionPerformed
        try {
            SelectedRoom.delete();
            SelectedRoom.setDisponible(true);
            SelectedRoom.create();
            RoomCard R = new RoomCard(SelectedRoom.getNumber());
            R.setVisible(true);
            R.setLocationRelativeTo(this);
            this.dispose();
        } catch (IOException ex) {
            System.getLogger(RoomState.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_jButtonYesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonNo;
    private javax.swing.JButton jButtonYes;
    private javax.swing.JLabel jImage;
    // End of variables declaration//GEN-END:variables
}
