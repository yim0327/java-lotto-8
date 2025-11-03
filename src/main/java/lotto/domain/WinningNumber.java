package lotto.domain;

public class WinningNumber {
    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningNumber(Lotto winningNumber,int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

}
