package com.danny.lottery;

/**
 * 銘謝惠顧
 */
public class ThankYou {
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

    private double probability; // 中獎機率
    private Integer stock = 0; // 獎品庫存
}