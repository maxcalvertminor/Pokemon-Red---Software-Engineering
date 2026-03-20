import javax.swing.*;
import java.util.function.*;

interface Ability {
  void useAbility(pokemon pokemon);
}

public class Move {
    int damage;
    String type;
    int typeID;

    public Move(int d, String s, Ability a) {
        damage = d;
        type = s;
        Ability ability = (pokemon p) -> a.useAbility(p);

        typeID = HelperMethods.ConvertStringTypeToTypeID(type);
    }

    
}
