package skipass.enums;

import lombok.Getter;

public enum Lifts {
    LIFTS_10(10), LIFTS_20(20), LIFTS_50(50), LIFTS_100(100);

    @Getter
    private final int lifts;

    private Lifts(int lifts) {
        this.lifts = lifts;
    }
}
