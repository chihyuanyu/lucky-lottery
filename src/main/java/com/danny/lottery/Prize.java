package com.danny.lottery;

import java.math.BigDecimal;

/**
 * 獎品
 */
public class Prize {

    private Long id;
    private String name;
    private double probability; // 中獎機率
    private Integer stock; // 獎品庫存
    private Integer maxWinCountPerUser; // 每位用戶最多獲獎次數

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

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getMaxWinCountPerUser() {
        return maxWinCountPerUser;
    }

    public void setMaxWinCountPerUser(Integer maxWinCountPerUser) {
        this.maxWinCountPerUser = maxWinCountPerUser;
    }

}
