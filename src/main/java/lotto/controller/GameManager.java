package lotto.controller;

import lotto.domain.LottoBundle;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.util.InputParser;
import lotto.view.InputView;

public class GameManager {
    private final InputView inputView;
    private final LottoMachine lottoMachine;

    public GameManager(InputView inputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.lottoMachine = lottoMachine;
    }

    public void start() {
        int purchaseAmount = new InputParser(inputView.inputPurchaseAmount()).parseInt();
        Money money = new Money(purchaseAmount);
        LottoBundle lottoBundle = lottoMachine.issueLotto(money.lottoPurchaseCount());
    }
}
