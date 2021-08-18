package lotto.step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoCreatorTest {
    @Test
    @DisplayName("생성된 로또가 올바른 로또 인지 검증.")
    void createLotto() {
        Lottery lotto = LottoCreator.createLotto();
        assertThat(lotto.getLottery().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("입력한 지난 주 당첨 번호가 올바른 로또 인지 검증 - 6개의 로또 번호")
    void convertToLotto() {
        String input = "1, 2, 3, 4, 5, 6";
        Lottery lotto = LottoCreator.convertToLotto(input);
        assertThat(lotto.getLottery().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("입력한 지난 주 당첨 번호가 올바른 로또 인지 검증 - 중복된 숫자는 올 수 없다")
    void convertToLotto2() {
        String input = "3, 2, 3, 4, 5, 6";
        assertThatThrownBy(() -> LottoCreator.convertToLotto(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 지난 주 당첨 번호가 올바른 로또 인지 검증 - 로또 번호는 1~45 숫자만 올수 있다.")
    void convertToLotto3() {
        String input = "46, 2, 3, 4, 5, 6";
        assertThatThrownBy(() -> LottoCreator.convertToLotto(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 지난 주 당첨 번호가 올바른 로또 인지 검증 - 로또 번호는 1~45 숫자만 올수 있다.")
    void convertToLotto4() {
        String input = "1, 2, 3, 4, 0, 6";
        assertThatThrownBy(() -> LottoCreator.convertToLotto(input)).isInstanceOf(IllegalArgumentException.class);
    }


}