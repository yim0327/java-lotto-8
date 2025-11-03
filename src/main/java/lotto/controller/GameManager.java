package lotto.controller;

import lotto.domain.*;
import lotto.util.InputParser;
import lotto.view.InputView;

import java.util.List;
import java.util.Map;

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

        LottoBundle lottoBundle = createLottoBundle(money);
        WinningNumber winningNumber = createWinningNumber();

        Map<Rank, Integer> result = lottoBundle.judgeLotto(winningNumber);
        Profit profit = Profit.of(result, money.getPurchaseAmount());
    }

    private LottoBundle createLottoBundle(Money money) {
        return lottoMachine.issueLotto(money.lottoPurchaseCount());
    }

    private WinningNumber createWinningNumber() {
        List<Integer> splittedNumbers = new InputParser(inputView.inputWinningNumber()).splitString();
        Lotto answerLotto = new Lotto(splittedNumbers);

        int bonus = new InputParser(inputView.inputBonusNumber()).parseInt();

        return new WinningNumber(answerLotto, bonus);
    }

}
