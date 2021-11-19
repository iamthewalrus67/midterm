package skipass;

import lombok.ToString;

import java.util.Calendar;
import java.util.Date;

@ToString
public class DaysTicket extends SkiPass{
    private Date lastVisit;

    DaysTicket() {

    }

    @Override
    public boolean use() {
        Date currentDate = new Date();

        if ((lastVisit == null) || ((currentDate.getTime() - lastVisit.getTime())/(1000*60*60*24) >= 1 )) {
            setUses(getUses() - 1);
        }

        lastVisit = currentDate;

        return true;
    }
}
