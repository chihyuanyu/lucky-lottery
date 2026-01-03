package com.danny.lottery;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 抽獎活動
 */
public class LotteryActivity {
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Integer maxDrawsPerUser; // 同一使用者不可超出其允許的抽獎次數
    private Integer totalDrawsLimit; // 抽獎次數上限
    private List<Prize> prizes;
    private ThankYou thankYou;

    List<LotteryRecord> lotteryRecords = new ArrayList<>();

    public List<LotteryRecord> getLotteryRecords() {
        return lotteryRecords;
    }

    public void setLotteryRecords(List<LotteryRecord> lotteryRecords) {
        this.lotteryRecords = lotteryRecords;
    }

    public LotteryActivity(String name, String description) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getMaxDrawsPerUser() {
        return maxDrawsPerUser;
    }

    public void setMaxDrawsPerUser(Integer maxDrawsPerUser) {
        this.maxDrawsPerUser = maxDrawsPerUser;
    }

    public Integer getTotalDrawsLimit() {
        return totalDrawsLimit;
    }

    public void setTotalDrawsLimit(Integer totalDrawsLimit) {
        this.totalDrawsLimit = totalDrawsLimit;
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    public void setPrizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public ThankYou getThankYou() {
        return thankYou;
    }

    public void setThankYou(ThankYou thankYou) {
        this.thankYou = thankYou;
    }

}
