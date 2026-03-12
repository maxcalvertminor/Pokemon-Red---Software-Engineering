public class pokemon
{


    private String name, type1, type2;
    private int level, currHP, maxHP, att, def, spA, spD, spe;

    private int ivs; // individual values
    private int evs; //effortvalues
    private int[] base; // base status

    //more to come by later
    public pokemon( String name, int level )

    {
        this.name = name;
        this.level = level;
        //INIT other attributes 
        System.out.println ("hello!");
        PokeStats ps = PokeDex.getStats( name );
        type1 = ps.getType1();
        type2 = ps.getType2();
        base = ps.getbasestats();
        ivs = (int)(Math.random() *31 + 1);
        evs = 1;
        int i = 2;
        i *= base[2];
        i += ivs;
        i = i + (evs / 4);
        i /= 100;
        i += level;
        i += 10;
        maxHP = i;
        currHP = i;
        
        
        


        System.out.println( name + " " + type1 + " " + type2 + " " + level );
    }
    public int sethealth( int t){
        currHP -= t;
        return currHP;

    }
    public int attacked(int i){
        currHP = currHP - i;
        return currHP;
    }
    public int destroy(int a){
        currHP = a;
        return currHP;
    }
    public int getHealth(){
        return currHP;
    }
    
}

//later
