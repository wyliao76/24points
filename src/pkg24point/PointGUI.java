
package pkg24point;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author user
 */
public class PointGUI extends javax.swing.JFrame {
     DeckOfCards d = new DeckOfCards();
     private ArrayList <Player> players = new ArrayList ();
     String path = "src/pkg24point/players"+".xml";
/**
 * construct PointGUI
 */
    public PointGUI() {
        initComponents();
        setLocationRelativeTo(null); //centers the form at start.
        this.setIconImage(Toolkit.getDefaultToolkit().
                getImage("src/pkg24point/icon2.jpg"));
        readFromFile(path);
        d.loadCards();
        displayCards();
        shuffleJButton.setEnabled(false);
        checkJButton.setEnabled(false);
        answerJTextField.setEditable(false);
        editJMenuItem.setEnabled(false);
        SaveJMenuItem.setEnabled(false);
        this.getRootPane().setDefaultButton(loginJButton); //set buttonAdd as default
    }
    /**
     * Method: readFromFile
 Reads Player from a text file that is comma delimited.
 Uses an object from the ReadFile class to read record.
     * @param file String
 pre-condition: a valid file name, Citystats.txt is expected
 for input with comma separated text fields (but no spaces) for
 city name, population, median, local, and degree
 post-condition: a new City is created with the read fields
 and added to the ArrayList City
     */
    public void readFromFile(String file)            
    { 
      players.clear();
      try{
         FileReader inputFile = new FileReader(file);
         BufferedReader input = new BufferedReader(inputFile);
         String Line = input.readLine();
         while (Line != null){
             Player player = new Player();
             StringTokenizer token = new StringTokenizer(Line, ",");
             while (token.hasMoreElements())
             {
                 player.setName(token.nextToken());
                 player.setNumberOfGamePlayed(Integer.parseInt(token.nextToken()));
                 player.setCorrectRate(Double.parseDouble(token.nextToken()));
                 player.setScore(Integer.parseInt(token.nextToken())); 
             }
             players.add(player);
             Line = input.readLine();
         }
      }
      catch (FileNotFoundException exp){
          exp.printStackTrace();
      }
      catch (IOException exp){
          exp.printStackTrace();
      }
    }
    /**
     * Method: savePlayer
 Save an arrayList of player to a file.
     * @parem void
     * @return void
 pre-condition: 
 post-condition: save to a new file or a exist file 
 and added to the ArrayList Players
     * @see savePlayer
     */
    private void savePlayer() 
    {    
                try{
               writeToFile(path);
             }
            catch(IOException exp)
                    {
                    exp.printStackTrace();
                    }
                 displayPlayer(0,players);
            }
      /**
     * Method: writeToFile
     * Write cities to a text file that is comma delimited.
     * @param file String
     * @see writeToFile
     * @throws IOException throws
     * @see Player
     */
    public void writeToFile(String file) throws IOException {
        PrintWriter output = new PrintWriter(file);
        for ( int i =0; i<players.size(); i++){
           Player temp = players.get(i);
           String Line = temp.getName()+ "," + temp.getNumberOfGamePlayed() 
                   + ","+ temp.getCorrectRate()+ ","+temp.getScore();
           output.println(Line);
        }
        output.close();
    }
    /**
     * 
     */     
  public void displayCards(){
      cardJLabel1.setIcon(d.shuffle());
      cardJLabel2.setIcon(d.shuffle2());
      cardJLabel3.setIcon(d.shuffle3());
      cardJLabel4.setIcon(d.shuffle4());
  }
  /**
   */
  public void enable(){
      shuffleJButton.setEnabled(true);
      checkJButton.setEnabled(true);
      answerJTextField.setEditable(true);
      editJMenuItem.setEnabled(true);
      SaveJMenuItem.setEnabled(true);
      this.getRootPane().setDefaultButton(checkJButton); //set buttonAdd as default
  }
  /**
   * @param void
   */
  private void clearAll(){
      resultJTextField.setText("");
      cardJLabel1.setIcon(null);
      cardJLabel2.setIcon(null);
      cardJLabel3.setIcon(null);
      cardJLabel4.setIcon(null);
      answerJTextField.setText("");
      answerJTextField.setEditable(false);
      shuffleJButton.setEnabled(false);
      checkJButton.setEnabled(false);
      editJMenuItem.setEnabled(false);
      SaveJMenuItem.setEnabled(false);
  }
  /** displayerPlayer
     * This method is called from within the constructor to
     * display the data for the selected parcel.
     * @parem index : int
     * @parem parcels : ArrayList
     * @return void
     */
  private void displayPlayer(int index, ArrayList < Player > players){
      playerJTextField.setText(players.get(index).getName());
      gamePlayedJTextField.setText(String.valueOf(players.get(index).getNumberOfGamePlayed()));
      correctRateJTextField.setText(String.valueOf(players.get(index).getCorrectRate()));
      scoreJTextField.setText(String.valueOf(players.get(index).getScore()*100));
  }
  /**
   * 
   * @param playerName
   * @return int
   */
  private int findIndex (String playerName){
      for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(playerName)) 
                return i;
        }
        return -1;
  }
  /**
   * 
   * @param Name 
   */
   private void searchPlayer(String Name){
      if (Name != null && (Name.length()>0)){
   //       nameJRadioButtonMenuItem.setSelected(true);
          String [] NmaeArray = new String [players.size()];
          for ( int i = 0; i < NmaeArray.length; i++){
              NmaeArray[i] = players.get(i).getName();
          }
          int index = linearSearch(NmaeArray, Name);
          displayPlayer(index,players);
          if ( index<0){
              JOptionPane.showMessageDialog(null, Name + " not found ", " Search result", JOptionPane.INFORMATION_MESSAGE);
          }
      }
  }
   /**
    * 
    * @param array String[]Array
    * @param key   String
    * @return int
    */
    public int linearSearch(String [] array, String key) {
    for ( int i = 0; i < array.length; i++){
        if (array[i].toLowerCase().contains(key.toLowerCase()))
            return i;
    }
    return -1;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleJPanel = new javax.swing.JPanel();
        resultJTextField = new javax.swing.JTextField();
        shuffleJButton = new javax.swing.JButton();
        logoJLabel = new javax.swing.JLabel();
        loginJButton = new javax.swing.JButton();
        playerJTextField = new javax.swing.JTextField();
        welcomeJLabel = new javax.swing.JLabel();
        controlJPanel = new javax.swing.JPanel();
        answerJLabel = new javax.swing.JLabel();
        answerJTextField = new javax.swing.JTextField();
        checkJButton = new javax.swing.JButton();
        displayJPanel = new javax.swing.JPanel();
        cardJLabel1 = new javax.swing.JLabel();
        cardJLabel2 = new javax.swing.JLabel();
        cardJLabel3 = new javax.swing.JLabel();
        cardJLabel4 = new javax.swing.JLabel();
        playerDataJPanel = new javax.swing.JPanel();
        gamePlayedJLabel = new javax.swing.JLabel();
        gamePlayedJTextField = new javax.swing.JTextField();
        correctRateJLabel = new javax.swing.JLabel();
        correctRateJTextField = new javax.swing.JTextField();
        scoreJLabel = new javax.swing.JLabel();
        scoreJTextField = new javax.swing.JTextField();
        parcelJMenuBar = new javax.swing.JMenuBar();
        FileJMenu = new javax.swing.JMenu();
        SaveJMenuItem = new javax.swing.JMenuItem();
        ClearJMenuItem = new javax.swing.JMenuItem();
        PrintJMenuItem = new javax.swing.JMenuItem();
        JSeparator = new javax.swing.JPopupMenu.Separator();
        ExitJMenuItem = new javax.swing.JMenuItem();
        ManageJMenu = new javax.swing.JMenu();
        addJMenuItem = new javax.swing.JMenuItem();
        editJMenuItem = new javax.swing.JMenuItem();
        searchJMenuItem = new javax.swing.JMenuItem();
        HelpJMenu = new javax.swing.JMenu();
        AboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("24-Point Card Game");
        setResizable(false);

        resultJTextField.setEditable(false);

        shuffleJButton.setText("Shuffle");
        shuffleJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shuffleJButtonActionPerformed(evt);
            }
        });

        logoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg24point/icon2.jpg"))); // NOI18N

        loginJButton.setText("Login");
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });

        playerJTextField.setEditable(false);

        welcomeJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeJLabel.setText("Welcome!");

        javax.swing.GroupLayout titleJPanelLayout = new javax.swing.GroupLayout(titleJPanel);
        titleJPanel.setLayout(titleJPanelLayout);
        titleJPanelLayout.setHorizontalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(welcomeJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(playerJTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                .addGroup(titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(titleJPanelLayout.createSequentialGroup()
                        .addComponent(loginJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(shuffleJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(resultJTextField))
                .addGap(2, 2, 2))
            .addGroup(titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleJPanelLayout.createSequentialGroup()
                    .addContainerGap(130, Short.MAX_VALUE)
                    .addComponent(logoJLabel)
                    .addContainerGap(317, Short.MAX_VALUE)))
        );
        titleJPanelLayout.setVerticalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleJPanelLayout.createSequentialGroup()
                .addGroup(titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(titleJPanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(resultJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(titleJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(welcomeJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shuffleJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(titleJPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(logoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        answerJLabel.setText("Enter An Anwser");

        checkJButton.setText("Check");
        checkJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlJPanelLayout = new javax.swing.GroupLayout(controlJPanel);
        controlJPanel.setLayout(controlJPanelLayout);
        controlJPanelLayout.setHorizontalGroup(
            controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlJPanelLayout.createSequentialGroup()
                .addComponent(answerJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(answerJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(checkJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        controlJPanelLayout.setVerticalGroup(
            controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlJPanelLayout.createSequentialGroup()
                .addGroup(controlJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(answerJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answerJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkJButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        displayJPanel.setLayout(new java.awt.GridLayout(1, 0));
        displayJPanel.add(cardJLabel1);
        displayJPanel.add(cardJLabel2);
        displayJPanel.add(cardJLabel3);
        displayJPanel.add(cardJLabel4);

        playerDataJPanel.setLayout(new java.awt.GridLayout(6, 0));

        gamePlayedJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gamePlayedJLabel.setText("Game Played");
        playerDataJPanel.add(gamePlayedJLabel);

        gamePlayedJTextField.setEditable(false);
        playerDataJPanel.add(gamePlayedJTextField);

        correctRateJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        correctRateJLabel.setText("Correct Rate");
        playerDataJPanel.add(correctRateJLabel);

        correctRateJTextField.setEditable(false);
        playerDataJPanel.add(correctRateJTextField);

        scoreJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreJLabel.setText("Score !");
        playerDataJPanel.add(scoreJLabel);

        scoreJTextField.setEditable(false);
        playerDataJPanel.add(scoreJTextField);

        FileJMenu.setText("File");
        FileJMenu.setToolTipText("file");

        SaveJMenuItem.setText("Save");
        SaveJMenuItem.setToolTipText("Open new file");
        SaveJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveJMenuItemActionPerformed(evt);
            }
        });
        FileJMenu.add(SaveJMenuItem);

        ClearJMenuItem.setText("Clear");
        ClearJMenuItem.setToolTipText("clear all fields");
        ClearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearJMenuItemActionPerformed(evt);
            }
        });
        FileJMenu.add(ClearJMenuItem);

        PrintJMenuItem.setText("Print");
        PrintJMenuItem.setToolTipText("Print");
        PrintJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintJMenuItemActionPerformed(evt);
            }
        });
        FileJMenu.add(PrintJMenuItem);
        FileJMenu.add(JSeparator);

        ExitJMenuItem.setText("Exit");
        ExitJMenuItem.setToolTipText("Exit program");
        ExitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitJMenuItemActionPerformed(evt);
            }
        });
        FileJMenu.add(ExitJMenuItem);

        parcelJMenuBar.add(FileJMenu);

        ManageJMenu.setText("Manage");

        addJMenuItem.setMnemonic('A');
        addJMenuItem.setText("Login");
        addJMenuItem.setToolTipText("Add new city");
        addJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJMenuItemActionPerformed(evt);
            }
        });
        ManageJMenu.add(addJMenuItem);

        editJMenuItem.setMnemonic('E');
        editJMenuItem.setText("Edit Player");
        editJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJMenuItemActionPerformed(evt);
            }
        });
        ManageJMenu.add(editJMenuItem);

        searchJMenuItem.setMnemonic('r');
        searchJMenuItem.setText("Search Player");
        searchJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJMenuItemActionPerformed(evt);
            }
        });
        ManageJMenu.add(searchJMenuItem);

        parcelJMenuBar.add(ManageJMenu);

        HelpJMenu.setText("Help");

        AboutJMenuItem.setText("About");
        AboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutJMenuItemActionPerformed(evt);
            }
        });
        HelpJMenu.add(AboutJMenuItem);

        parcelJMenuBar.add(HelpJMenu);

        setJMenuBar(parcelJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(controlJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(228, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(634, Short.MAX_VALUE)
                    .addComponent(playerDataJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(displayJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(controlJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(playerDataJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(41, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveJMenuItemActionPerformed
        savePlayer();
    }//GEN-LAST:event_SaveJMenuItemActionPerformed

    private void ClearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearJMenuItemActionPerformed
        clearAll();// Empty all fields and reset form by calling the method clearAll
    }//GEN-LAST:event_ClearJMenuItemActionPerformed

    private void PrintJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintJMenuItemActionPerformed
        PrintUtilities.printComponent(this);// Print entire form
    }//GEN-LAST:event_PrintJMenuItemActionPerformed

    private void ExitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitJMenuItemActionPerformed
        savePlayer();
        System.exit(0);
    }//GEN-LAST:event_ExitJMenuItemActionPerformed

    private void AboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutJMenuItemActionPerformed
        About pointAbout = new About();
        pointAbout.setVisible(true);
        //Display About form
    }//GEN-LAST:event_AboutJMenuItemActionPerformed

    private void shuffleJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shuffleJButtonActionPerformed
        displayCards();
    }//GEN-LAST:event_shuffleJButtonActionPerformed

    private void checkJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkJButtonActionPerformed
    //    evaluateExpression eva = new evaluateExpression(); 
       int index = findIndex(playerJTextField.getText());
    //   System.out.println("index "+index);
          Player p = players.get(index);
          int i =  p.getNumberOfGamePlayed();
          int score = p.getScore();
          i++;
          p.setNumberOfGamePlayed(i);
          evaluateString eva = new evaluateString();
            String expression = answerJTextField.getText();
            try {
                if (expression.equals("") || expression.length() <1)
                    throw new NumberFormatException();
                System.out.println(expression + " = " + eva.evaluate(expression));
                 if(eva.evaluate(expression) == 24){
                   resultJTextField.setText("You got "+(int)eva.evaluate(expression) +", That's Correct!");
                   score++;          
                 }
                 else {
                   resultJTextField.setText("You got "+ (int)eva.evaluate(expression) +", That's Incorrect!");
                 }
                p.setCorrectRate((score/(double)i)*100.0);
                p.setScore(score);
   //             System.out.println("Score = " +score);
   //             System.out.println("played = " +i);
   //             System.out.println("rate = " +(score/(double)i)*100.0);
                savePlayer();  
            }
            catch (NumberFormatException e){
                System.out.println("Wrong or empty expression");
            }
            displayPlayer(index,players);
    }//GEN-LAST:event_checkJButtonActionPerformed

    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJButtonActionPerformed
        // Add new player
         try
        {            
            // Create and display a new NewPlayerDialog
            NewPlayer player = new NewPlayer(this, true);
            player.setVisible(true);
            
            // The modal dialog takes focus, upon regaining focus:
            Player newPlayer = player.getPlayer();
            
            if (newPlayer != null) 
            {
                // Add the new player to the database
                players.add(newPlayer);   
                savePlayer();
                displayPlayer(findIndex(newPlayer.getName()),players);                  //refresh GUI     
                 if (!playerJTextField.getText().isEmpty()){
                   enable();
                 }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Player not Added", 
                    "Player is null or laready exists", JOptionPane.WARNING_MESSAGE);                              
            }
        }
        catch (NullPointerException nullex)
        {
            JOptionPane.showMessageDialog(null, "Player not Added", "Input Error",
                  JOptionPane.WARNING_MESSAGE);            
       }
    }//GEN-LAST:event_loginJButtonActionPerformed

    private void searchJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJMenuItemActionPerformed
        // Find specified city
        String Name = JOptionPane.showInputDialog("Enter the name of the Player");
        searchPlayer(Name);
        displayPlayer(findIndex(Name),players);
    }//GEN-LAST:event_searchJMenuItemActionPerformed

    private void editJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJMenuItemActionPerformed
        int index =  findIndex(playerJTextField.getText());
        try
        {
            Player playerToEdit = new Player(players.get(index));
            EditPlayer editedPlayer = new EditPlayer(playerToEdit); 
            editedPlayer.setVisible(true);
            
             if(editedPlayer.getPlayer() != null){
                players.remove(index);
                players.add(editedPlayer.getPlayer());
                savePlayer();
                displayPlayer(players.size()-1,players); 
            }
             else
            {
                JOptionPane.showMessageDialog(null, "Player not edited", 
                    "Player is null or laready exists", JOptionPane.WARNING_MESSAGE);                            
            }
        }
       catch (NullPointerException nullex){
                    JOptionPane.showMessageDialog(null, "Player was not edited"
                           , " Edit Error", JOptionPane.WARNING_MESSAGE);
                    }                            
    }//GEN-LAST:event_editJMenuItemActionPerformed

    private void addJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJMenuItemActionPerformed
        // call buttonAddActionPerformed
        loginJButtonActionPerformed(evt);
    }//GEN-LAST:event_addJMenuItemActionPerformed

    public static void main(String args[]) {
      SplashScreen splashScreen = new SplashScreen();
      splashScreen.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutJMenuItem;
    private javax.swing.JMenuItem ClearJMenuItem;
    private javax.swing.JMenuItem ExitJMenuItem;
    private javax.swing.JMenu FileJMenu;
    private javax.swing.JMenu HelpJMenu;
    private javax.swing.JPopupMenu.Separator JSeparator;
    private javax.swing.JMenu ManageJMenu;
    private javax.swing.JMenuItem PrintJMenuItem;
    private javax.swing.JMenuItem SaveJMenuItem;
    private javax.swing.JMenuItem addJMenuItem;
    private javax.swing.JLabel answerJLabel;
    private javax.swing.JTextField answerJTextField;
    private javax.swing.JLabel cardJLabel1;
    private javax.swing.JLabel cardJLabel2;
    private javax.swing.JLabel cardJLabel3;
    private javax.swing.JLabel cardJLabel4;
    private javax.swing.JButton checkJButton;
    private javax.swing.JPanel controlJPanel;
    private javax.swing.JLabel correctRateJLabel;
    private javax.swing.JTextField correctRateJTextField;
    private javax.swing.JPanel displayJPanel;
    private javax.swing.JMenuItem editJMenuItem;
    private javax.swing.JLabel gamePlayedJLabel;
    private javax.swing.JTextField gamePlayedJTextField;
    private javax.swing.JButton loginJButton;
    private javax.swing.JLabel logoJLabel;
    private javax.swing.JMenuBar parcelJMenuBar;
    private javax.swing.JPanel playerDataJPanel;
    private javax.swing.JTextField playerJTextField;
    private javax.swing.JTextField resultJTextField;
    private javax.swing.JLabel scoreJLabel;
    private javax.swing.JTextField scoreJTextField;
    private javax.swing.JMenuItem searchJMenuItem;
    private javax.swing.JButton shuffleJButton;
    private javax.swing.JPanel titleJPanel;
    private javax.swing.JLabel welcomeJLabel;
    // End of variables declaration//GEN-END:variables
}
