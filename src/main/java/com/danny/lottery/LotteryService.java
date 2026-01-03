package com.danny.lottery;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 抽獎服務
 */
public class LotteryService {

    public void initializeLotteryActivity(LotteryActivity activity) throws IllegalArgumentException {
        // 驗證活動時間
        Date now = new Date();

        if (activity.getEndDate() != null && activity.getEndDate().before(now)) {
            throw new IllegalArgumentException("活動已結束");
        }

        // 驗證獎品機率總和為100%
        double totalProbability = 0.0;
        for (Prize prize : activity.getPrizes()) {
            totalProbability = totalProbability + prize.getProbability();
        }
        totalProbability = totalProbability + activity.getThankYou().getProbability();

        if (totalProbability != 1.0) {
            throw new IllegalArgumentException("機率總和必須為100%");
        }
    }

    public LotteryRecord drawLottery(Long userId, LotteryActivity activity)
            throws IllegalArgumentException {
        // 檢查活動是否過期
        if (activity.getEndDate() != null && activity.getEndDate().before(new Date())) {
            throw new IllegalArgumentException("活動已結束");
        }

        // 檢查用戶抽獎次數
        Integer userDrawCount = getUserDrawCount(activity, userId);
        if (userDrawCount >= activity.getMaxDrawsPerUser()) {
            throw new IllegalArgumentException("您已達到每日抽獎次數上限");
        }

        // 檢查總庫存
        List<Prize> prizes = activity.getPrizes();
        ThankYou thankYous = activity.getThankYou();

        // 獎品和錫謝惠顧的總庫存
        long totalStock = prizes.stream().mapToLong(p -> p.getStock()).sum() + thankYous.getStock();
        if (totalStock <= 0) {
            throw new IllegalArgumentException("抽獎庫存不足");
        }

        // 計算抽獎結果
        Random random = new Random();
        double randomValue = random.nextDouble();

        // 獎品機率累加
        List<Prize> sortedPrizes = prizes.stream()
                .sorted(Comparator.comparingDouble(p -> p.getProbability()))
                .collect(Collectors.toList());

        Prize prizeToWin = null;

        double cumulativeProbability = 0;

        for (Prize prize : sortedPrizes) {
            cumulativeProbability = cumulativeProbability + prize.getProbability();
            if (randomValue <= cumulativeProbability) {
                prizeToWin = prize;
                break;
            }
        }

        // 如果未中獎，則判定為錫謝惠顧
        if (prizeToWin == null) {
            prizeToWin = new Prize();
            prizeToWin.setName("銘謝惠顧");
        }

        // 更新庫存
        if (prizeToWin == null) {
            prizeToWin.setName("銘謝惠顧");
        } else {
            prizeToWin.setStock(prizeToWin.getStock() - 1);
        }

        // 記錄抽獎結果
        LotteryRecord record = new LotteryRecord(
                new Random().nextLong(),
                activity.getId(),
                userId,
                prizeToWin.getId(),
                prizeToWin.getName(),
                "SUCCESS",
                new Date());

        return record;
    }

    public Integer getUserDrawCount(LotteryActivity activity, Long userId) {
        int size = activity.getLotteryRecords().stream()
                .filter(e -> e.userId() == userId)
                .collect(Collectors.toList()).size();
        return size;
    }
}