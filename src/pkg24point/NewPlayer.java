/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg24point;

import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 * @author user
 */
public class NewPlayer extends javax.swing.JDialog {

    private Player newPlayer ;
    private boolean error = false;
    private String errorMessage ="";
    
    /**
     * Creates new form ScanNew
     * @param parent frame
     * @param modal boolean
     */
    public NewPlayer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getRootPane().setDefaultButton(SubmitJButton);
        this.setIconImage(Toolkit.getDefaultToolkit().
                getImage("src/pkg24point/icon2.jpg"));
        setLocationRelativeTo(null);
        nameJTextField.requestFocus();
        newPlayer = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleJPanel = new javax.swing.JPanel();
        titleJLabel = new javax.swing.JLabel();
        logoJLabel = new javax.swing.JLabel();
        displayJPanel = new javax.swing.JPanel();
        nameJLabel = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        SaveJPanel = new javax.swing.JPanel();
        SubmitJButton = new javax.swing.JButton();
        cancelJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Parcel");
        setResizable(false);

        titleJLabel.setFont(new java.awt.Font("Tempus Sans ITC", 2, 24)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(51, 0, 0));
        titleJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleJLabel.setText("New Player Infomation");

        logoJLabel.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        logoJLabel.setForeground(new java.awt.Color(51, 0, 0));
        logoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg24point/icon2.jpg"))); // NOI18N
        logoJLabel.setToolTipText("");

        javax.swing.GroupLayout titleJPanelLayout = new javax.swing.GroupLayout(titleJPanel);
        titleJPanel.setLayout(titleJPanelLayout);
        titleJPanelLayout.setHorizontalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleJPanelLayout.createSequentialGroup()
                .addGap(0, 327, Short.MAX_VALUE)
                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(titleJPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(logoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(306, Short.MAX_VALUE)))
        );
        titleJPanelLayout.setVerticalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleJPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(titleJPanelLayout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(logoJLabel)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );

        displayJPanel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        nameJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameJLabel.setText("Name : ");

        nameJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameJTextField.setToolTipText("non-digits");

        javax.swing.GroupLayout displayJPanelLayout = new javax.swing.GroupLayout(displayJPanel);
        displayJPanel.setLayout(displayJPanelLayout);
        displayJPanelLayout.setHorizontalGroup(
            displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayJPanelLayout.createSequentialGroup()
                .addComponent(nameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        displayJPanelLayout.setVerticalGroup(
            displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(displayJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(nameJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        SaveJPanel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SaveJPanel.setLayout(new java.awt.GridLayout(1, 0));

        SubmitJButton.setBackground(java.awt.Color.green);
        SubmitJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SubmitJButton.setText("Submit");
        SubmitJButton.setToolTipText("Save");
        SubmitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitJButtonActionPerformed(evt);
            }
        });
        SaveJPanel.add(SubmitJButton);

        cancelJButton.setBackground(new java.awt.Color(51, 255, 0));
        cancelJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cancelJButton.setText("Cancel");
        cancelJButton.setToolTipText("cancel");
        cancelJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelJButtonActionPerformed(evt);
            }
        });
        SaveJPanel.add(cancelJButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displayJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(131, Short.MAX_VALUE)
                    .addComponent(SaveJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(116, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(displayJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(406, Short.MAX_VALUE)
                    .addComponent(SaveJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitJButtonActionPerformed

        String Name = nameJTextField.getText();
        errorMessage="";
        error = false;
        if ( ! Validation.isName(Name)){
            errorMessage += "Invalid Name\n";
            nameJTextField.requestFocus();
            error = true;
        }
        if ( nameJTextField.getText().equals("")){
            errorMessage += "Name Can't be empty!\n";
            error = true;
        } 
        if(errorMessage !=""){
        JOptionPane.showMessageDialog(null, errorMessage, "Error!", JOptionPane.WARNING_MESSAGE);
        this.setAlwaysOnTop(true); 
        }
        if(error == false){
            newPlayer= new Player(Name,0,0.0,0) ;
            this.dispose();
        }
    }//GEN-LAST:event_SubmitJButtonActionPerformed

    private void cancelJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelJButtonActionPerformed
         this.dispose();
    }//GEN-LAST:event_cancelJButtonActionPerformed
/**
 * @return Player
 */
    public Player getPlayer(){
    return newPlayer;
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SaveJPanel;
    private javax.swing.JButton SubmitJButton;
    private javax.swing.JButton cancelJButton;
    private javax.swing.JPanel displayJPanel;
    private javax.swing.JLabel logoJLabel;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JPanel titleJPanel;
    // End of variables declaration//GEN-END:variables
}
