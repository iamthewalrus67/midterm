package skipass.enums;

import lombok.Getter;

public enum Days {
    DAY_1(1), DAY_2(2), DAY_5(5);

    @Getter
    private final int days;

    private Days(int days) {
        this.days = days;
    }
}
