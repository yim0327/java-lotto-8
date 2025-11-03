package lotto.domain;

public enum Rank {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    MISS(0, false, 0L);

    private final int match;
    private final boolean bonus;
    private final long prize;

    Rank(int match, boolean bonus, Long prize) {
        this.match = match;
        this.bonus = bonus;
        this.prize = prize;
    }

    public long getPrize() {
        return prize;
    }

    public static Rank result(int match, boolean bonus) {
        if (match == 6) return FIRST;
        if (match == 5 && bonus) return SECOND;
        if (match == 5) return THIRD;
        if (match == 4) return FOURTH;
        if (match == 3) return FIFTH;
        return MISS;
    }
}