import java.util.ArrayList;

public class Trainer {
    public ArrayList<pokemon> team = new ArrayList();
    public String name;
    public String[] dialogue;
    public int currpokemon;
    public int allpokemon;
    public ArrayList<Integer> teamhealth = new ArrayList();

    public Trainer(String n, pokemon t) {
        this.name = n;
        team.add(t);
        currpokemon = 0;
        allpokemon = 0;
        

    } 
    public int currpoke(){
    return currpokemon;
    }  
    public int health(){
        int e = team.get(currpokemon).getHealth();
        return e;
    }
    public void attack(int e){
        team.get(currpokemon).attacked(e);
    }
    public void addPokemon(pokemon t){
        
        allpokemon += 1;
        if(allpokemon > 6){
            System.out.println("you can only have 6 pokemon!");
            allpokemon = 6;
        }
        else{
            team.add(t);
        }
    }
    public pokemon getPokemon(int e){
        if( e > 6 && e < 0){
            System.out.println("you only have 6 pokemon!");
            return team.get(currpokemon);
        }
        else{
        currpokemon = e;
        team.get(e);
        return team.get(e);

        }
        
        
    }
    public ArrayList<Integer> allpokemonhealth(){
        
       
        for(int i = 0; i == allpokemon; i++ ){
            teamhealth.add(team.get(i).getHealth());
            
        }
        return teamhealth;
    }
    public int pokehelth(int e){
        int i = team.get(e).getHealth();
        return i;
    }
}