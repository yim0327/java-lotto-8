package lotto.domain;

public class Money {
    private static final int LOTTO_PURCHASE = 1000;
    private static final String INVALID_AMOUNT_UNIT_ERROR = "구입 금액은 "+LOTTO_PURCHASE+"원 단위로만 입력 가능합니다.";
    private static final String INVALID_UNDER_ZERO_AMOUNT_ERROR = "구입 금액은 0보다 커야 합니다.";
    private final int purchaseAmount;

    public Money(int purchaseAmount) {
        validateUnderZeroAmount(purchaseAmount);
        validateIsThousandUnit(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int lottoPurchaseCount() {
        return purchaseAmount/LOTTO_PURCHASE;
    }

    private void validateIsThousandUnit(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PURCHASE != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT_ERROR);
        }
    }

    private void validateUnderZeroAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(INVALID_UNDER_ZERO_AMOUNT_ERROR);
        }
    }
}
