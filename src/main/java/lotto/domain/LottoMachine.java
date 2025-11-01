package lotto.domain;

import lotto.domain.generator.NumbersGenerator;

public class LottoMachine {
    private final NumbersGenerator generator;

    public LottoMachine(NumbersGenerator generator) {
        this.generator = generator;
    }

}
