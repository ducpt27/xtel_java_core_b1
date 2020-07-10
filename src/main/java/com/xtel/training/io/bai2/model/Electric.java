package com.xtel.training.io.bai2.model;

public class Electric {

    protected Double electricNum;

    protected Double totalPrice;

    public Electric() {
    }

    public Electric(double electricNum) {
        this.electricNum = electricNum;
    }

    private Double countTotalPrice() {
        this.totalPrice = Double.valueOf(0);
        Double electricNum = this.electricNum;
        if (electricNum >= 150) {
            this.totalPrice += 2000 * (electricNum - 150);
            electricNum = Double.valueOf(150);
        }
        if (electricNum >= 100) {
            this.totalPrice += 1500 * (electricNum - 100);
            electricNum = Double.valueOf(100);
        }
        if (electricNum > 0) {
            this.totalPrice += 1000 * electricNum;
        } else {
            return null;
        }
        return this.totalPrice;
    }

    public Double getElectricNum() {
        return electricNum;
    }

    public void setElectricNum(Double electricNum) {
        this.electricNum = electricNum;
    }

    public Double getTotalPrice() {
        if (electricNum < 0) {
            return null;
        }
        return countTotalPrice();
    }
}
