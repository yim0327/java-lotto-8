package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final String INVALID_NUMBER_COUNT_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String INVALID_DUPLICATE_NUMBERS_ERROR = "로또 번호는 중복될 수 없습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT_ERROR);
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);

        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_NUMBERS_ERROR);
        }
    }
}
