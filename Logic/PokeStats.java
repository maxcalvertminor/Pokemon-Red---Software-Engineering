public class PokeStats
{
    private String name, type1, type2;
    private int [] basestats;

    public PokeStats( String n, String t1, String t2, int[] bs )
    {
        name = n;
        type1 = t1;
        type2 = t2;
        basestats = bs;
    }
    public String getType1() { return type1; }
    public String getType2() { return type2; }
    
}