package turnstile;


import skipass.SeasonTicket;
import skipass.SkiPass;
import skipass.SkiPassSystem;

import java.util.Date;

public class Turnstile {
    private SkiPassSystem skiPassSystem;

    public Turnstile() {
        skiPassSystem = SkiPassSystem.getInstance();
    }


    public boolean checkSkiPass(SkiPass skiPass) {
        if (!skiPass.isDateValid(new Date())) {
            skiPassSystem.log(skiPass.toString() + ": Invalid date.");
            skiPassSystem.blockPass(skiPass);
            skiPassSystem.log(skiPass.toString() + ": Blocked for violating the rules.");
            return false;
        } else if (!skiPass.use()) {
            skiPassSystem.log(skiPass.toString() + ": No uses left.");
            return false;
        }

        if (!(skiPass instanceof SeasonTicket)){
            skiPassSystem.log(skiPass.toString() + String.format(": Passed all checks. %d uses left.", skiPass.getUses()));
        } else {
            skiPassSystem.log(skiPass.toString() + ": Passed all checks.");
        }
        return true;
    }
}
