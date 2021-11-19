package skipass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import skipass.enums.Season;

import java.util.Calendar;
import java.util.Date;

@ToString
public class SeasonTicket extends SkiPass{
    @Getter @Setter
    private Season season;

    SeasonTicket() {

    }

    @Override
    public boolean use() {
        if (!isValid()) {
            return false;
        }

        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        int currentMonth = calendar.get(Calendar.MONTH);
        if (((currentMonth <= 2 || currentMonth == 12) && (season != Season.WINTER)) ||
                ((currentMonth >= 3 && currentMonth <= 5) && (season != Season.SPRING)) ||
                ((currentMonth >= 6 && currentMonth <= 8) && (season != Season.SUMMER)) ||
                ((currentMonth >= 9 && currentMonth <= 11) && (season != Season.FALL))) {
            setUses(0);
            return false;
        }

        return true;
    }
}
