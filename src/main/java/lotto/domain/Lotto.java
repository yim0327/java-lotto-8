package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final String INVALID_NUMBER_COUNT_ERROR = "[ERROR] 로또 번호는 "+LottoRules.LOTTO_NUMBER_COUNT+"개여야 합니다.";
    private static final String INVALID_DUPLICATE_NUMBERS_ERROR = "로또 번호는 중복될 수 없습니다.";
    private static final String INVALID_NUMBER_BOUNDARIES_ERROR = "로또 번호는 "+LottoRules.MIN_NUMBER_BOUNDARIES+"부터 "+LottoRules.MAX_NUMBER_BOUNDARIES+" 사이의 숫자여야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicateNumbers(numbers);
        validateNumberBoundary(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    /**
     * 숫자 포함 여부 : 해당 숫자가 리스트에 존재하는지 여부
     */
    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    /**
     * 매칭 성공 개수 : 당첨 번호와 로또 번호를 비교하여 매칭 개수 반환
     * - 각 당첨 번호(other)의 값을 containsNumber의 매개변수로 함
     * - 당첨 번호와 로또 번호 일치 시 카운트 증가
     */
    public int countMatch(Lotto other) {
        return (int) numbers.stream().filter(other::containsNumber).count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoRules.LOTTO_NUMBER_COUNT) {
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
        if (numbers.stream().anyMatch(num -> num < LottoRules.MIN_NUMBER_BOUNDARIES
                || num > LottoRules.MAX_NUMBER_BOUNDARIES)) {
            throw new IllegalArgumentException(INVALID_NUMBER_BOUNDARIES_ERROR);
        }
    }
}
