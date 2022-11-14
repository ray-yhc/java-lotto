package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    private static List<Lotto> userLottos = new ArrayList<>();
    private static List<Integer> winningCount = new ArrayList<>(Arrays.asList(0,0,0,0,0));

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int cost = inputCost();

        // TODO: lottoCount 계산
        int lottoCount = PriceConfig.getLottoCountWithoutChange(cost);
        System.out.println(lottoCount + "개를 구매했습니다.");
        // TODO: lotto 발행
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            userLottos.add(lotto);
            System.out.println(lotto);
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winningLotto = new Lotto(inputWinningLottoNums());
        System.out.println("보너스 번호를 입력해 주세요.");
        // TODO: 정답 lotto 생성
        int winningBonus = inputWinningBonusNum();

        // TODO: 통계 계산
        Statistics statistics = new Statistics(winningLotto, winningBonus);


        for (int i = 0; i < userLottos.size(); i++) {
            int prize = statistics.getPrize(userLottos.get(i));
            if(prize != -1)
                winningCount.set(prize, winningCount.get(prize)+1);
            // TODO: 어떻게 할건지?? 리스트? 맵?
        }


        StringBuilder sb = new StringBuilder();

        sb.append("당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - ");
        sb.append(winningCount.get(5));
        sb.append("개\n" +
                "4개 일치 (50,000원) - ");
        sb.append(winningCount.get(4));
        sb.append("개\n" +
                "5개 일치 (1,500,000원) - ");
        sb.append(winningCount.get(3));
        sb.append("개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        sb.append(winningCount.get(2));
        sb.append("개\n" +
                "6개 일치 (2,000,000,000원) - ");
        sb.append(winningCount.get(1));
        sb.append("개\n" +
                "총 수익률은 ");
        sb.append(0);
        sb.append("%입니다.");

        System.out.println(sb);
    }

    private static int inputCost() {
        String userInput = Console.readLine().strip();
        //TODO : 기능구현, 예외처리
        return 0;
    }

    private static List<Integer> inputWinningLottoNums() {
        String userInput = Console.readLine().strip();
        //TODO : 기능구현, 예외처리
        return Arrays.asList(9, 8, 7, 6, 5, 4);
    }

    private static int inputWinningBonusNum() {
        String userInput = Console.readLine().strip();
        //TODO : 기능구현, 예외처리
        return 0;
    }


}
