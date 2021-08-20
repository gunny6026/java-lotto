package lotto.step4;

import lotto.step4.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RankTest {

    Winning winning;

    @BeforeEach
    void init() {
        Lottery lottery = LottoCreator.convertToLotto("1,2,3,4,5,6");
        winning = new Winning(lottery, LottoNumber.of(7));
    } // 당첨 번호 1,2,3,4,5,6 / 보너스 볼 7

    @Test
    @DisplayName("6개가 일치하면 1등")
    void isRankFirst() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6));
        Lottery lottery = new Lottery(lottoNumbers);
        Rank match = winning.match(lottery);
        assertThat(match).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("보너스 볼 1개와 당첨 번호 5개가 일치하면 2등")
    void isRankSecond() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(7));
        Lottery lottery = new Lottery(lottoNumbers);
        Rank match = winning.match(lottery);
        assertThat(match).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("당첨 번호 5개가 일치하면 3등")
    void isRankThird() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(17));
        Lottery lottery = new Lottery(lottoNumbers);
        Rank match = winning.match(lottery);
        Assertions.assertThat(match).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("당첨 번호 4개가 일치하면 4등")
    void isRankFourth() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(15),
                LottoNumber.of(17));
        Lottery lottery = new Lottery(lottoNumbers);
        Rank match = winning.match(lottery);
        Assertions.assertThat(match).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("당첨 번호 3개가 일치하면 5등")
    void isRankFifth() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(14),
                LottoNumber.of(15),
                LottoNumber.of(17));
        Lottery lottery = new Lottery(lottoNumbers);
        Rank match = winning.match(lottery);
        Assertions.assertThat(match).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("당첨 번호 2개가 일치하면 꽝")
    void isRankNone() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(21),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(14),
                LottoNumber.of(15),
                LottoNumber.of(17));
        Lottery lottery = new Lottery(lottoNumbers);
        Rank match = winning.match(lottery);
        Assertions.assertThat(match).isEqualTo(Rank.NONE);
    }
}
