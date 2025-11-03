package lotto.controller;

import lotto.domain.*;
import lotto.util.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public GameManager(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void start() {
        Money money = readMoney();

        LottoBundle lottoBundle = createLottoBundle(money);
        outputView.printBundle(lottoBundle);

        WinningNumber winningNumber = createWinningNumber();

        Map<Rank, Integer> result = lottoBundle.judgeLotto(winningNumber);
        Profit profit = Profit.of(result, money.getPurchaseAmount());

        printResult(result, profit);
    }

    private Money readMoney() {
        while(true) {
            try{
                int purchaseAmount = new InputParser(inputView.inputPurchaseAmount()).parseInt();
                return new Money(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

    }

    private LottoBundle createLottoBundle(Money money) {
        return lottoMachine.issueLotto(money.lottoPurchaseCount());
    }

    private WinningNumber createWinningNumber() {
        while (true) {
            try {
                List<Integer> splittedNumbers = new InputParser(inputView.inputWinningNumber()).splitString();
                Lotto answerLotto = new Lotto(splittedNumbers);

                int bonus = new InputParser(inputView.inputBonusNumber()).parseInt();

                return new WinningNumber(answerLotto, bonus);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private void printResult(Map<Rank, Integer> result, Profit profit) {
        outputView.printResult(result);
        outputView.printProfit(profit.rate());
    }

}
