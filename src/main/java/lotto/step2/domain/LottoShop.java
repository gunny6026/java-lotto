package lotto.step2.domain;

import java.util.List;

public class LottoShop {
    private Lotto lotto;

    public LottoShop(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException("돈이 부족합니다. 로또 1장의 가격은 1000원입니다.");
        }
        int lottoCount = price / 1000;
        this.lotto = new Lotto(lottoCount);
    }
    public List<LottoTicket> sellLotto() {
        return lotto.getLotto();
    }
}
