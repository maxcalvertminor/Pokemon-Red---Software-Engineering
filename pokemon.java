public class pokemon {

    private String name, type1, type2;
    private int level, currHP, maxHP, att, def, spA, spD, spe;

    private int ivs; // individual values
    private int evs; // effort values
    private int[] base; // base stats

    // ✅ Main constructor (advanced system)
    public pokemon(String name, int level) {
        this.name = name;
        this.level = level;

        System.out.println("hello!");

        //PokeStats ps = PokeDex.getStats(name);
        //type1 = ps.getType1();
        //type2 = ps.getType2();
        //base = ps.getbasestats();
        type1 = "Normal";
        type2 = "";
        base = new int[]{50, 50, 50, 50, 50, 50};

        ivs = (int)(Math.random() * 31 + 1);
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

        System.out.println(name + " " + type1 + " " + type2 + " " + level);
    }

    // ✅ Factory method (replaces old constructor safely)
    public static pokemon basic(String n, int h) {
        pokemon p = new pokemon(n, 1); // default level
        p.currHP = h;
        p.maxHP = h;
        return p;
    }

    // ✅ Old required methods (compatibility)
    public String getName() {
        return name;
    }

    public int getHealth() {
        return currHP;
    }

    public void setHealth(int h) {
        currHP = h;
    }

    // ---- Your new methods ----

    // damage method (renamed would be better, but kept for compatibility)
    public int sethealth(int t) {
        currHP -= t;
        return currHP;
    }

    public int attacked(int i) {
        currHP -= i;
        return currHP;
    }

    public int destroy(int a) {
        currHP = a;
        return currHP;
    }
}