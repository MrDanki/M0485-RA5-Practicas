package view;

// CONTROLLER
import static controller.Main.*;

// MODEL
import model.Vehicle;
import static model.FileManager.*;
import static model.LogicManager.*;

// JAVA IO
import java.io.IOException;

// JAVA UTIL
import java.util.ArrayList;

// JAVA SWING
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Concesionario extends javax.swing.JDialog {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Concesionario.class.getName());
    public Concesionario()throws IOException{
        initComponents();
        this.setVisible(true);
        this.UpdateVehiclesList();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonOpen = new javax.swing.JButton();
        jLabelTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListVehicles = new javax.swing.JList<>();
        jButtonSearch = new javax.swing.JButton();
        jLabelCount = new javax.swing.JLabel();
        jButtonDelete = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonOpen.setText("OPEN");
        jButtonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenActionPerformed(evt);
            }
        });

        jLabelTitle.setText("                                       VEHICLES MANAGER");

        jListVehicles.setAutoscrolls(false);
        jScrollPane2.setViewportView(jListVehicles);

        jButtonSearch.setText("SEARCH");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jLabelCount.setText("Vehicles 0");

        jButtonDelete.setText("DELETE");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonAdd.setText("ADD");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCount, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabelCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonOpen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenActionPerformed
        try {
            String list = jListVehicles.getSelectedValue();
            if(list != null){
                String[]plate = list.split(" / ");
                System.out.println(plate[0]);
                VehicleCard VC = new VehicleCard(plate[0]);
                VC.setVisible(true);
                VC.setLocationRelativeTo(this);
                this.dispose();
                return;
            }
            VehicleCard NC = new VehicleCard(""); 
            NC.setVisible(true);
            NC.setLocationRelativeTo(this);
            this.dispose();
        } catch (IOException ex) {
            System.getLogger(Concesionario.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_jButtonOpenActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        try {
            String input = JOptionPane.showInputDialog(this,"Vehicle to Seach?");
            if(input == null){return;}
            if(isStringLoad(input)){
                LoadVehicles();
                this.UpdateVehiclesList();
                return;
            }
            if(existIDInFile(FILE,input)){
                VehicleCard VC = new VehicleCard(input);
                VC.setVisible(true);
                VC.setLocationRelativeTo(this);
                this.dispose();
            }
            else if(LoadSort(input)){
                this.UpdateVehiclesList();
                JOptionPane.showMessageDialog(this,"Vehicle "+input+" does not exists in file");
            }
            else{
                JOptionPane.showMessageDialog(this,"Vehicle "+input+" does not exists in file");
            }
            
        } catch (IOException ex) {
            System.getLogger(Concesionario.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        String list = jListVehicles.getSelectedValue();
        if(list != null){
            String[]plate = list.split(" / ");
            System.out.println(plate[0]);
            try {
                String[]NV = getByIDFromFile(FILE,plate[0]);
                Vehicle V = new Vehicle(NV[0],NV[1],NV[2],Integer.parseInt(NV[3]),NV[4]);
                V.delete();
                this.UpdateVehiclesList();
            } catch (IOException ex) {
                System.getLogger(Concesionario.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        try {
           VehicleCard VC = new VehicleCard("");
           VC.setVisible(true);
           VC.setLocationRelativeTo(this);
           this.dispose();
        } catch (IOException ex) {
            System.getLogger(Concesionario.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }//GEN-LAST:event_jButtonAddActionPerformed
    
    public String FILE = System.getProperty("user.dir")+"\\data\\vehicles.txt";
    
    public void UpdateVehiclesList()throws IOException{
        DefaultListModel<String> D = new DefaultListModel();
        ArrayList<String[]> fileContent = getAllFileContent(FILE);
        for(String[] F : fileContent){
            Vehicle V = new Vehicle(F[0],F[1],F[2],Integer.parseInt(F[3]),F[4]);
            D.addElement(V.returnInList());
        }
        jListVehicles.setModel(D);
        jLabelCount.setText("Vehicles "+intToString(D.getSize()));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonOpen;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabelCount;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JList<String> jListVehicles;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
