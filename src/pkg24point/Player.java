package pkg24point;

public class Player extends Person { 
    private int numberOfGamePlayed ;
    private double correctRate;
    private int score;
    /**
     * 
     */
    public Player(){
        super();
        numberOfGamePlayed = 0;
        correctRate = 0.0;
        score = 0;
    }
    /**
     * 
     * @param name String
     * @param played int
     * @param rate double
     * @param score int
     */
    public Player(String name, int played, double rate, int score){
        super(name);
        numberOfGamePlayed = played ;
        correctRate = rate ;
        this.score =score;
    }
    /**
     * 
     * @param anotherPlayer clone object
     */
    public Player(Player anotherPlayer){
     name = anotherPlayer.name;
     numberOfGamePlayed = anotherPlayer.numberOfGamePlayed;
     correctRate = anotherPlayer.correctRate;
     score = anotherPlayer.score;
}
    /**
     * 
     * @return int score
     */
    public int getScore() {
        return score;
    }
    /**
     * 
     * @return intplayed
     */
    public int getNumberOfGamePlayed() {
        return numberOfGamePlayed;
    }
    /**
     * 
     * @param numberOfGamePlayed played
     */
    public void setNumberOfGamePlayed(int numberOfGamePlayed) {
        this.numberOfGamePlayed = numberOfGamePlayed;
    }
    /**
     * 
     * @return double rate
     */
    public double getCorrectRate() {
        return correctRate;
    }
    /**
     * 
     * @param correctRate double
     */
    public void setCorrectRate(double correctRate) {
        this.correctRate = correctRate;
    }
    /**
     * 
     * @param score int
     */
    public void setScore(int score) {
        this.score = score;
    }
  /**
   * 
   * @return String
   */
    @Override
    public String toString() {
        return "Player{" + "numberOfGamePlayed=" + numberOfGamePlayed + ", correctRate=" + correctRate + ", score=" + score + '}';
    }
    /**
     * Not used
     * @param player object player
     * @return boolean
     */
    public boolean compareTo(Player player){
        if (this.name.equalsIgnoreCase(player.getName()))
           return false;
        else return true;
    }
}
