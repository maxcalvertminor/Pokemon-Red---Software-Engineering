import java.util.HashMap;
import java.io.File;
import java.util.Scanner;
import java.util.*;
import java.io.*;
public class pokemoves {
    private static HashMap<String, Move> Moves = new HashMap<>();
    public static void move(String name, Move e){
        Moves.put(name,e);
    }
    public static Move getMove(String name){
        return Moves.get(name);
    }
    public String checkmove(String name) throws Exception{
        File path = new File("POKEMON.2\\Pokemon\\pokemonlearning.txt");
        Scanner reader = new Scanner(path);
        while(reader.hasNext()){
            String line = reader.nextLine();
            String[] pokeSplit = line.split(",");
            name = pokeSplit[1];
            if(line.equals(name)){
                return "this pokemon has " + name;
            }
            else{
                return "this pokemon does not have this move!";
                
            }
        }
        return name;


    }
    
   
}
