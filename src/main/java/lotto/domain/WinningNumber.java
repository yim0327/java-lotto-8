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

    /**
     * 당첨 번호 매칭 : 로또 번호와 당첨 번호 비교 매칭 후 결과 반환
     * - 당첨 번호 + 보너스 번호(상태)를 가지고 있는 WinningNumbers에게 매칭 책임(행동) 부여
     * - 매칭 시 필요한 정보를 Lotto에 요청
     */
    public Rank match(Lotto lotto) {
        int matchCount = lotto.countMatch(winningNumber);
        boolean bonusMatch = lotto.containsNumber(bonusNumber);
        return Rank.result(matchCount, bonusMatch);
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
