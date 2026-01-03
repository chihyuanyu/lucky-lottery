package com.danny.lottery;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    final static long userId = 1L;
    final static long activityId = 1L;
    final static LotteryService lotteryService = new LotteryService();

    final static HashMap<Long, LotteryActivity> activityMapper = new HashMap<>();

    public static void main(String[] args) {

        // 抽獎活動
        LotteryActivity activity1 = new LotteryActivity("16899抽獎活動", "感謝您的支持，祝您好運！");
        activity1.setId(1L);
        activity1.setStartDate(new Date());
        activity1.setEndDate(new Date(System.currentTimeMillis() + Duration.ofDays(7).toMillis()));
        activity1.setMaxDrawsPerUser(1);
        activity1.setTotalDrawsLimit(10);

        LotteryActivity activity2 = new LotteryActivity("16899抽獎活動", "感謝您的支持，祝您好運！");
        activity2.setId(2L);
        activity2.setStartDate(new Date());
        activity2.setEndDate(new Date(System.currentTimeMillis() + Duration.ofDays(7).toMillis()));
        activity2.setMaxDrawsPerUser(1);
        activity2.setTotalDrawsLimit(10);

        // 獎品
        List<Prize> prizes = new ArrayList<>();
        Prize prize = new Prize();
        prize.setName("獎品1");
        prize.setProbability(0.2);
        prize.setStock(10);
        prize.setMaxWinCountPerUser(1);
        prizes.add(prize);
        Prize prize2 = new Prize();
        prize2.setName("獎品2");
        prize2.setProbability(0.3);
        prize2.setStock(20);
        prize2.setMaxWinCountPerUser(1);
        prizes.add(prize2);
        Prize prize3 = new Prize();
        prize3.setName("獎品3");
        prize3.setProbability(0.4);
        prize3.setStock(30);
        prize3.setMaxWinCountPerUser(1);
        prizes.add(prize3);
        // 銘謝惠顧
        ThankYou thankYou = new ThankYou();
        thankYou.setProbability(0.1);

        activity1.setPrizes(prizes);
        activity1.setThankYou(thankYou);
        lotteryService.initializeLotteryActivity(activity1);
        LotteryRecord result = lotteryService.drawLottery(userId, activity1);
        System.out.println("抽獎結果: " + result.prizeName());

        activity2.setPrizes(prizes);
        activity2.setThankYou(thankYou);
        lotteryService.initializeLotteryActivity(activity2);
        LotteryRecord result2 = lotteryService.drawLottery(userId, activity2);
        System.out.println("抽獎結果: " + result2.prizeName());

        System.out.println("總庫存: " + prize.getName() + " " + prize.getStock());
        System.out.println("總庫存: " + prize2.getName() + " " + prize2.getStock());
        System.out.println("總庫存: " + prize3.getName() + " " + prize3.getStock());

    }
}
