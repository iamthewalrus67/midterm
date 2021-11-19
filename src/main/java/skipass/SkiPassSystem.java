package skipass;

import lombok.Getter;
import skipass.enums.Days;
import skipass.enums.Lifts;
import skipass.enums.Season;
import skipass.enums.TicketType;

import java.util.ArrayList;
import java.util.List;

public class SkiPassSystem {
    private static SkiPassSystem skiPassSystem;
    @Getter
    private List<SkiPass> registeredTickets;
    @Getter
    private List<String> logs;

    private SkiPassSystem() {
        registeredTickets = new ArrayList<>();
        logs = new ArrayList<>();
    }

    public static SkiPassSystem getInstance() {
        if (skiPassSystem == null) {
            skiPassSystem = new SkiPassSystem();
        }

        return skiPassSystem;
    }

    public void blockPass(SkiPass skiPass) {
        skiPass.setUses(0);
    }

    public DaysTicket createSkiPass(TicketType ticketType, Days days) {
        if (ticketType == TicketType.WEEKEND && days.getDays()>2) {
            throw new IllegalArgumentException("DaysTicket can't have more than 2 uses on weekends.");
        }
        DaysTicket daysTicket = new DaysTicket();
        daysTicket.setTicketType(ticketType);
        daysTicket.setUses(days.getDays());
        registeredTickets.add(daysTicket);

        return daysTicket;
    }

    public LiftsTicket createSkiPass(TicketType ticketType, Lifts lifts) {
        LiftsTicket liftsTicket = new LiftsTicket();
        liftsTicket.setTicketType(ticketType);
        liftsTicket.setUses(lifts.getLifts());
        registeredTickets.add(liftsTicket);

        return liftsTicket;
    }

    public SeasonTicket createSkiPass(Season season) {
        SeasonTicket seasonTicket = new SeasonTicket();
        seasonTicket.setSeason(season);
        seasonTicket.setTicketType(TicketType.WEEKEND);
        seasonTicket.setUses(1);
        registeredTickets.add(seasonTicket);

        return seasonTicket;
    }

    public void log(String s) {
        logs.add(s);
    }
}
