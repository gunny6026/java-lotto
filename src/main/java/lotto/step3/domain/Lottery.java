package lotto.step3.domain;

import java.util.Set;

public class Lottery {
    public static final int LOTTO_COUNT = 6;
    private final Set<LottoNumber> lottery;

    public Lottery(Set<LottoNumber> lottery) {
        if (lottery.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호는" + LOTTO_COUNT + "개 이어야 합니다.");
        }
        this.lottery = lottery;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottery.contains(lottoNumber);
    }

    public Set<LottoNumber> getLottery() {
        return lottery;
    }

    @Override
    public String toString() {
        return lottery.toString();
    }
}
