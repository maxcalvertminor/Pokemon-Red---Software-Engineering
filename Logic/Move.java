import javax.swing.*;
import java.util.function.*;

public class Move extends Action {
    int damage;
    String type;
    int typeID;
    Ability ability;

    public Move(int d, String s, Ability a) {
        damage = d;
        type = s;
        ability = a;

        typeID = HelperMethods.ConvertStringTypeToTypeID(type);
    }
}
