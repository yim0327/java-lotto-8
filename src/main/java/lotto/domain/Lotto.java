package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final String INVALID_NUMBER_COUNT_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String INVALID_DUPLICATE_NUMBERS_ERROR = "로또 번호는 중복될 수 없습니다.";
    private static final String INVALID_NUMBER_BOUNDARIES_ERROR = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final int MIN_NUMBER_BOUNDARIES = 1;
    private static final int MAX_NUMBER_BOUNDARIES = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicateNumbers(numbers);
        validateNumberBoundary(numbers);
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

    private void validateNumberBoundary(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < MIN_NUMBER_BOUNDARIES
                || num > MAX_NUMBER_BOUNDARIES)) {
            throw new IllegalArgumentException(INVALID_NUMBER_BOUNDARIES_ERROR);
        }
    }
}
