package lotto.domain;

public class Money {
    private static final int LOTTO_PURCHASE = 1000;
    private final int purchaseAmount;

    public Money(int purchaseAmount) {
        validateIsThousandUnit(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int lottoPurchaseCount() {
        return purchaseAmount/LOTTO_PURCHASE;
    }

    private void validateIsThousandUnit(int purchaseAmount) {}
}
