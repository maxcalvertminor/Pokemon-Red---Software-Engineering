public class Trainer {
    public Pokemon[] team;
    public String name;
    public String[] dialogue;
    public Pokemon activePokemon;
    public boolean inBattle;
    public int activeIndex;

    public Trainer(String n, Pokemon[] t, String[] d) {
        name = n;
        team = t;
        dialogue = d;
        if(team != null) {
            activePokemon = team[0];
        }
        activeIndex = 0;
    } 

    public void SendOut(int index) {
        // activate anim or whatever else

        // logic
        if(team != null && team[index] != null) {
            activePokemon = team[index];
        }
        activeIndex = index;
    }

    public void DeathSwitch() {
        // activate anim or whatever else

        // logic
        if(team[activeIndex + 1] != null) {
            activeIndex++;
            activePokemon = team[activeIndex];
            return;
        } else {
            Pokemon remainingPokemon = null;
            int helper = -1;
            for(int i = 0; i < team.length; i++) {
                if(team[i] != null) {
                    remainingPokemon = team[i];
                    helper = i;
                    break;
                }
            }
            activePokemon = remainingPokemon;
            activeIndex = helper;
        }
    }

    public void HasAnAlivePokemon() {
        boolean yuh;
    }
} 