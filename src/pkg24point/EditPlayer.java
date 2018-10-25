
package pkg24point;

import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Wei-Yu Liao
 */
public class EditPlayer extends javax.swing.JDialog {

    private Player newPlayer ;
    private boolean error = false;
    private String errorMessage ="";
    private int played ;
    private double rate;
    private int score;
    
    /**
     * Creates new form EditParcel
     */
    public EditPlayer(){
        initComponents();
        this.getRootPane().setDefaultButton(SaveJButton);
        this.setIconImage(Toolkit.getDefaultToolkit().
                getImage("src/pkg24point/icon2.jpg"));
        setLocationRelativeTo(null);
        nameJTextField.requestFocus();
        newPlayer = null;
        this.setAlwaysOnTop(true);
        this.setModal(true);
    }
    /**
     * @param player clone player
     */
    public EditPlayer(Player player){
        this();
        nameJTextField.setText(player.getName());
        played = player.getNumberOfGamePlayed();
        rate = player.getCorrectRate();
        score = player.getScore()*100;
        nameJTextField.requestFocus();
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
        SaveJButton = new javax.swing.JButton();
        cancelJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Parcel");
        setResizable(false);

        titleJLabel.setFont(new java.awt.Font("Tempus Sans ITC", 2, 24)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(51, 0, 0));
        titleJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleJLabel.setText("Edit Player");

        logoJLabel.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        logoJLabel.setForeground(new java.awt.Color(51, 0, 0));
        logoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg24point/icon2.jpg"))); // NOI18N
        logoJLabel.setToolTipText("");

        javax.swing.GroupLayout titleJPanelLayout = new javax.swing.GroupLayout(titleJPanel);
        titleJPanel.setLayout(titleJPanelLayout);
        titleJPanelLayout.setHorizontalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleJPanelLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(logoJLabel)
                .addGap(52, 52, 52)
                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        titleJPanelLayout.setVerticalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoJLabel)
                    .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        displayJPanel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        displayJPanel.setLayout(new java.awt.GridLayout(2, 0));

        nameJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameJLabel.setText("Name : ");
        displayJPanel.add(nameJLabel);

        nameJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameJTextField.setToolTipText("non-digits");
        displayJPanel.add(nameJTextField);

        SaveJPanel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SaveJPanel.setLayout(new java.awt.GridLayout(1, 0));

        SaveJButton.setBackground(java.awt.Color.green);
        SaveJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SaveJButton.setToolTipText("save");
        SaveJButton.setLabel("Save");
        SaveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveJButtonActionPerformed(evt);
            }
        });
        SaveJPanel.add(SaveJButton);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleJPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(109, Short.MAX_VALUE)
                    .addComponent(SaveJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(105, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(370, Short.MAX_VALUE)
                    .addComponent(SaveJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(34, 34, 34)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveJButtonActionPerformed
        
        String name = nameJTextField.getText();
        
        errorMessage="";
        error = false;
        if ( ! Validation.isName(name)){
            errorMessage += "Invalid Name\n";
            nameJTextField.requestFocus();
            error = true;
        }
        if ( nameJTextField.getText().equals("")){
            errorMessage += "Name Can't be empty!\n";
            error = true;
        } 
        if(!errorMessage.isEmpty()){
        JOptionPane.showMessageDialog(null, errorMessage, "Error!", JOptionPane.WARNING_MESSAGE);
        this.setAlwaysOnTop(true); 
        }
        if(error == false){
            newPlayer = new Player(name, played,rate, score) ;
            this.dispose();
        }
    }//GEN-LAST:event_SaveJButtonActionPerformed

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
    private javax.swing.JButton SaveJButton;
    private javax.swing.JPanel SaveJPanel;
    private javax.swing.JButton cancelJButton;
    private javax.swing.JPanel displayJPanel;
    private javax.swing.JLabel logoJLabel;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JPanel titleJPanel;
    // End of variables declaration//GEN-END:variables
}
