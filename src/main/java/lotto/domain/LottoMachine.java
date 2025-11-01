package lotto.domain;

import lotto.domain.generator.NumbersGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final NumbersGenerator generator;

    public LottoMachine(NumbersGenerator generator) {
        this.generator = generator;
    }

    public LottoBundle issueLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(generator.generate()));
        }

        return new LottoBundle(lottos);
    }

}
