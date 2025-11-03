package lotto.domain;

public class WinningNumber {
    private static final String INVALID_DUPLICATE_BONUS_NUMBER_ERROR = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private static final String INVALID_BONUS_NUMBER_BOUNDARIES_ERROR = "보너스 번호는 "+LottoRules.MIN_NUMBER_BOUNDARIES+"부터 "+LottoRules.MAX_NUMBER_BOUNDARIES+" 사이의 숫자여야 합니다.";
    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningNumber(Lotto winningNumber,int bonusNumber) {
        this.winningNumber = winningNumber;
        validateDuplicateBonusNumber(bonusNumber);
        validateBonusNumberBoundary(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumber(int number) {
        if (winningNumber.containsNumber(number)) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_BONUS_NUMBER_ERROR);
        }
    }

    private void validateBonusNumberBoundary(int number) {
        if (number < LottoRules.MIN_NUMBER_BOUNDARIES || number > LottoRules.MAX_NUMBER_BOUNDARIES) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_BOUNDARIES_ERROR);
        }
    }

}
