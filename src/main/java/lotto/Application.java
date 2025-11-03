package lotto;

import lotto.controller.GameManager;
import lotto.domain.LottoMachine;
import lotto.domain.generator.NumbersGenerator;
import lotto.domain.generator.RandomNumbersGenerator;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        NumbersGenerator generator = new RandomNumbersGenerator();
        LottoMachine lottoMachine = new LottoMachine(generator);
        GameManager gameManager = new GameManager(inputView, lottoMachine);

        gameManager.start();
    }
}
