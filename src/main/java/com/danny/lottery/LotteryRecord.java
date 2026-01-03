package com.danny.lottery;

import java.util.Date;

public record LotteryRecord(
                Long id,
                Long userId,
                Long activityId,
                Long prizeId,
                String prizeName,
                String status, // DRAFF, PENDING, SUCCESS, FAIL
                Date drawDate) {
}
