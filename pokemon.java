public class pokemon {

    private String name;
    private int health;

    public pokemon(String n, int h) {
        name = n;
        health = h;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int h) {
        health = h;
    }
}
