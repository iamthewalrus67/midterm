package skipass;

import lombok.ToString;

@ToString
public class LiftsTicket extends SkiPass{
    LiftsTicket() {}

    @Override
    public boolean use() {
        if (!isValid()) {
            return false;
        }

        setUses(getUses()-1);
        return true;
    }
}
