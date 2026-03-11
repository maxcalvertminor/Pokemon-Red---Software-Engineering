import java.io.File;
import java.util.Scanner;

public class battle1 {
    
    private Trainer player;
    private Trainer enemy;
    private int[] checker = {0,0};

    public battle1(Trainer p, Trainer e)throws Exception{
        
        player = p;
        enemy = e;
        
        
        int a = p.health();
        int b = e.health();
        int inbattle = 0;
        Scanner reader = new Scanner(System.in);

        int [] x = {0,0};
        int [] q = {0,0};
        int currpoke = 0;
        int currpokeplayer = 0;

        
        System.out.println("Would you like to start a battle? [Y/N]");
        String battlestart = reader.nextLine();

        if(battlestart.equals("Y"))
        {
            inbattle += 1;
            
            
        }
        if(battlestart == "N"){
            
        }
        while(inbattle != 0){
            
            for(int l = 0; l <= 3; l++ ){
                    if( l < 2){
                    
                    x[l] = p.pokehelth(l);
                    q[l] = e.pokehelth(l);
                    System.out.println("REAL" + x[0] + x[1] + " " + q[0] + q[1]);
                        
                        
                    }
                    if( l == 2){
                          if(x[0] <= checker[0] && q[1] <= checker[1]){
                            inbattle = 0;
                            System.out.println("you lose!");
                            l = 3;
                
                            }  
                            if(q[0] <= checker[0] && q[1] <= checker[1]){
                            inbattle = 0;
                            System.out.println("you Win!");
                            l = 3;
                
                            }
                            System.out.println("another check");
                            
                        } 
                    

                } 
            System.out.println("do you want to attack, defend, or switch pokemon?");
            String action = reader.nextLine();
            if(action.equals("attack")){
                System.out.println("what attack would you like to use? [tackle bite]");
                String move = reader.nextLine();
                if(move.equals("tackle")){
                    int enmo = (int)(Math.random()*3 + 1);
                    if( enmo == 1){
                        e.attack(6);
                    int enak = (int)(Math.random()*2 + 1);
                    if(enak == 1){
                        p.attack(6);
                        System.out.println(" the enemy used tackle!");
                    }
                    if(enak == 2){
                        p.attack(4);
                        System.out.println("the enemy used bite!");
                    }
                    System.out.println(e.health());
                    System.out.println(p.health());
                    }
                    if (enmo == 2){
                        System.out.println("the enemy defended!");
                        e.attack(3);
                        System.out.println(e.health());
                    }
                    if (enmo == 3 || e.health() <= 0){
                        e.attack(6);
                    
                     if(e.currpoke() == 0){
                        e.getPokemon(1).getHealth();

                    }
                    if(e.currpoke() == 1){
                        e.getPokemon(0).getHealth();
                    }
                    System.out.println("enemy has switched" + e.health());
                    

                    }
                    
                    


                }
                if(move.equals("bite")){
                    int enmo = (int)(Math.random()*3 + 1);

                    if( enmo == 1){
                        e.attack(4);
                     int enak = (int)(Math.random()*2 + 1);
                    if(enak == 1){
                        p.attack(6);
                        System.out.println(" the enemy used tackle!");
                    }
                    if(enak == 2){
                        p.attack(4);
                        System.out.println("the enemy used bite!");
                    }
                    System.out.println(e.health());
                    System.out.println(p.health());
                    }
                    if (enmo == 2){
                        System.out.println("the enemy defended!");
                        e.attack(2);
                        System.out.println(e.health());
                    }
                    if (enmo == 3 || e.health() <= 0){
                        e.attack(4);
                        if(e.currpoke() == 0){
                        e.getPokemon(1).getHealth();

                        }
                        if(e.currpoke() == 1){
                        e.getPokemon(0).getHealth();
                        }
                        
                        System.out.println("enemy has switched" + e.health());
                    

                    }
                    

                }
                if(move.equals("AOPAL")){
                    p.attack(15);
                }
                
            
                
                
                

                System.out.println(e.health());
                System.out.println(p.health());
            }
            

            if( action.equals("defend")){
                int endmg = (int)(Math.random()*2 + 1);
                if(endmg == 1){
                    p.attack(3);
                }
                if(endmg == 2){
                    p.attack(2);
                }
                System.out.println(p.health());
                int m = (int)(Math.random()*20 + 1);
                if(m <= 5){
                    e.getPokemon(1);
                    System.out.println("enemy has switched" + e.health());
                }
            }
            if( action.equals("AREYOUSRS")){
                b = 0;
                if(b <= 0){
                inbattle = 0;
                System.out.println("you win!");
                
                }
            }
            if(action.equals("switch") || p.health() == 0){
                Scanner switcher = new Scanner(System.in);
                int i = switcher.nextInt();
                if( i > 1){
                    p.getPokemon(0);
                    a = p.health();
                    System.out.println("switched! " + a);
                }
                else{
                    p.getPokemon(i);
                    a = p.health();
                    System.out.println("switched! " + a);
                }
                    
               
            }

            if(action.equals("teamshealth")){
                System.out.println(p.allpokemonhealth());
                System.out.println(e.allpokemonhealth());
            }
            

            }
    }
     
}
