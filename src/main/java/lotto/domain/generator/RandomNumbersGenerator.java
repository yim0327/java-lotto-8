package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;
    private static final int NUMBER_COUNT = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE, NUMBER_COUNT);
    }

}
