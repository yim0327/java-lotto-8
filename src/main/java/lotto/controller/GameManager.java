package lotto.controller;

import lotto.util.InputParser;
import lotto.view.InputView;

public class GameManager {
    private final InputView inputView;

    public GameManager(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        int lottoCount = new InputParser(inputView.inputPurchaseAmount()).parseInt();
    }
}
