

public class Pokemon
{


    private String name, type1, type2;
    public int typeID1, typeID2;
    private int level, hp, maxHP, att, def, spA, spD, spe;

    private int[] ivs; // individual values
    private int [] evs; //effortvalues
    private int[] base; // base status

    public Move[] moves;
    public Move move;

    //more to come by later
    public Pokemon( String name, int level )

    {
        this.name = name;
        this.level = level;
        //INIT other attributes 
        System.out.println ("hello!");
        PokeStats ps = PokeDex.getStats( name );
        type1 = ps.getType1();
        type2 = ps.getType2();

        System.out.println( name + " " + type1 + " " + type2 + " " + level );
    }

    public String getName() {
        return name;
    }
    public int getHealth() {
        return hp;
    }
}

//later
