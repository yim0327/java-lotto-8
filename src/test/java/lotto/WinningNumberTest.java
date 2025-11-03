package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    @Test
    void 보너스_번호에_당첨_번호와_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumber(new Lotto(List.of(1,2,3,4,5,6)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_1부터_45_사이의_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumber(new Lotto(List.of(1,2,3,4,5,6)), 48))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호와_당첨_번호를_비교하여_결과를_반환한다() {
        assertThat(new WinningNumber(new Lotto(List.of(1,2,3,4,5,6)), 7)
                .match(new Lotto(List.of(1,2,3,4,5,7))))
                .isEqualTo(Rank.SECOND);
    }
}
