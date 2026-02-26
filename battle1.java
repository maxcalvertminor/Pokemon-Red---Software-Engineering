import java.io.File;
import java.util.Scanner;

public class battle {
    
    private String player;
    private String enemy;

    public battle(String p, String e) throws Exception{
        player = p;
        enemy = e;
        int inbattle = 0;
        inbattle += 1;
        if(inbattle > 0){
            pokemon playerpoke = new pokemon("Charmander",5);
            pokemon enemeypoke = new pokemon("Squirtle", 5);
            int pi = (int)(Math.random() + 1 * 20 +1);
            int ei  = (int)(Math.random() + 1 * 20 +1);
            if( pi > ei){
                enemeypoke.sethealth(5);
                System.out.println(enemeypoke.getHealth());
            }
            else{
                playerpoke.sethealth(5);
                System.out.println(playerpoke.getHealth());
            }

            if(playerpoke.getHealth() == 0){
                inbattle = 0;
                System.out.println("you lose!");
            }
            
            if(enemeypoke.getHealth() == 0){
                inbattle = 0;
                System.out.println("you win!");
                
            }

        }
    }
     
}
