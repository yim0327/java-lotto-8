package lotto.controller;

import lotto.domain.LottoBundle;
import lotto.domain.LottoMachine;
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
        int lottoCount = new InputParser(inputView.inputPurchaseAmount()).parseInt();
        LottoBundle lottoBundle = lottoMachine.issueLotto(lottoCount);
    }
}
