package lotto;

import lotto.domain.LottoBundle;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.domain.generator.RandomNumbersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    LottoMachine lottoMachine = new LottoMachine(new RandomNumbersGenerator());
    LottoBundle lottoBundle;

    @BeforeEach
    void SetUp() {
        Money money = new Money(5000);
        lottoBundle = lottoMachine.issueLotto(money.lottoPurchaseCount());
    }

    @Test
    void 구입_금액에_해당하는_수량만큼_로또를_발행한다() {
        assertThat(lottoBundle.getLottoCount()).isEqualTo(5);
    }
}
