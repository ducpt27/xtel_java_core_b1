package com.xtel.training.io.bai2.model;

public class Electric {

    protected Double electricNum;

    protected Double totalPrice;

    public Electric() {
    }

    public Electric(double electricNum) {
        this.electricNum = electricNum;
    }

    public Double getElectricNum() {
        return electricNum;
    }

    public void setElectricNum(Double electricNum) {
        this.electricNum = electricNum;
    }

    public Double getTotalPrice() {
        if (this.electricNum == null || this.electricNum < 0) {
            return null;
        }
        this.totalPrice = Double.valueOf(0);
        double electricNum = this.electricNum;
        if (electricNum >= 150) {
            this.totalPrice += 2000 * (electricNum - 150);
            electricNum = 150;
        }
        if (electricNum >= 100) {
            this.totalPrice += 1500 * (electricNum - 100);
            electricNum = 100;
        }
        if (electricNum >= 0) {
            this.totalPrice += 1000 * electricNum;
        }
        return this.totalPrice;
    }
}
