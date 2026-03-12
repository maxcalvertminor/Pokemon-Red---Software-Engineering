import java.util.HashMap;
public class PokeDex {
    private static HashMap<String, PokeStats> pokedex = new HashMap<>();
    public static void addEntry ( String name, PokeStats ps )
    {
        
        pokedex.put(name, ps);
    }

    public static PokeStats getStats( String name)
    {
        return pokedex.get( name );
    }
}
