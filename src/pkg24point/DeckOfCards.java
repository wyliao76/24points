package pkg24point;

import java.util.Random;
import javax.swing.ImageIcon;
   /**
    */   
public class DeckOfCards {
    final private ImageIcon[] cards = new ImageIcon[53];
    static Random rand = new Random();
    static ImageIcon imageIcon = new ImageIcon();
    
   /**
    */   
   public void loadCards(){
       for (int i =1; i<cards.length; i++){
           cards[i] = new ImageIcon(("src/Cards/"+i+".png"));
       }
   }
   /**
     * @return ImageIcon
    */   
   public ImageIcon shuffle(){
       int  i = rand.nextInt(13) + 1;
       imageIcon = this.cards[i];
       return imageIcon;
   }
   /**
     * @return ImageIcon
    */   
   public ImageIcon shuffle2(){
       int  i = rand.nextInt(13) + 14;
       imageIcon = this.cards[i];
       return imageIcon;
   }
   /**
     * @return ImageIcon
    */   
   public ImageIcon shuffle3(){
       int  i = rand.nextInt(13) + 27;
       imageIcon = this.cards[i];
       return imageIcon;
   }
    /**
     * @return ImageIcon
    */  
   public ImageIcon shuffle4(){
       int  i = rand.nextInt(12) + 40;
       imageIcon = this.cards[i];
       return imageIcon;
   }
}
