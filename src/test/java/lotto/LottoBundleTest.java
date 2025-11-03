package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {
    LottoBundle lottoBundle;
    WinningNumber winningNumber;

    @BeforeEach
    void SetUp() {
        lottoBundle = new LottoBundle(
                List.of(new Lotto(List.of(1,2,3,4,5,8)),
                        new Lotto(List.of(1,2,3,4,5,9)),
                        new Lotto(List.of(1,2,3,4,5,10))));

        winningNumber = new WinningNumber(
                new Lotto(List.of(1,2,3,4,5,6)), 7);
    }

    @Test
    void 로또_번호와_당첨_번호를_비교하여_결과를_반환한다() {
        Map<Rank, Integer> result = lottoBundle.judgeLotto(winningNumber);
        assertThat(result.get(Rank.THIRD)).isEqualTo(3);
    }
}
