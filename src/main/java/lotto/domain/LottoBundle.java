package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoBundle {
    private final List<Lotto> lottos;

    public LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    /**
     * 결과 판별 : 각 로또들을 모두 매칭하여 결과 Map을 반환
     * - 로또 객체 리스트(상태)를 가지고 있는 LottoBundle에게 판별 책임(행동) 부여
     */
    public Map<Rank, Integer> judgeLotto(WinningNumber winningNumber) {
        Map<Rank, Integer> counts = makeEnumMap();

        for (Lotto lotto : lottos) {
            Rank rank = winningNumber.match(lotto);
            counts.merge(rank, 1, Integer::sum); // 없으면 새로 추가, 있으면 +1 갱신
        }

        return counts;
    }

    /**
     * EnumMap : Key를 Enum으로 하는 Map 컬렉션 생성 및 초기화
     */
    private Map<Rank, Integer> makeEnumMap() {
        // EnumMap : Enum타입만을 key로 사용하는 특수한 Map
        Map<Rank, Integer> map = new EnumMap<>(Rank.class);
        for (Rank r : Rank.values()) {  // EnumMap 초기화
            map.put(r, 0);
        }

        return map;
    }
}
