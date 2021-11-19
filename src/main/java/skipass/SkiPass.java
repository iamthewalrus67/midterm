package skipass;

import skipass.enums.TicketType;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

public abstract class SkiPass {
    private static int idCounter = 1;
    @Getter
    private int id;
    @Getter @Setter
    private int uses;
    @Getter @Setter
    private TicketType ticketType;

    protected SkiPass() {
        this.id = idCounter++;
    }

    public boolean isValid() {
        return uses > 0;
    }

    public boolean isDateValid(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if ((ticketType == TicketType.WEEKEND) && ((dayOfWeek == Calendar.SATURDAY) || (dayOfWeek == Calendar.SUNDAY))) {
            return true;
        } else if (!(ticketType == TicketType.WEEKEND) && !((dayOfWeek == Calendar.SATURDAY) || (dayOfWeek == Calendar.SUNDAY))) {
            return true;
        }

        return false;
    }

    public abstract boolean use();
}
