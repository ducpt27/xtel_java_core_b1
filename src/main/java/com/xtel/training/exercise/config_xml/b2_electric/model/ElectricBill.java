package com.xtel.training.exercise.config_xml.b2_electric.model;

import javax.xml.bind.annotation.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@XmlRootElement(name = "EletricPriceMilestions")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElectricBill {

    private Integer eletricNum;

    private Double totalPrice;

    @XmlElement(name = "EletricPriceMilestion")
    private List<ElectricPriceMilestone> electricPriceMilestones = null;

    public ElectricBill() {
    }

    public List<ElectricPriceMilestone> getElectricMilestones() {
        return electricPriceMilestones;
    }

    public void setElectricMilestones(List<ElectricPriceMilestone> electricPriceMilestones) {
        this.electricPriceMilestones = electricPriceMilestones;
    }

    public void setEletricNum(Integer eletricNum) {
        this.eletricNum = eletricNum;
    }

    public Integer getEletricNum() {
        return eletricNum;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getTotalPrice() {
        countTotalPrice();
        return this.totalPrice;
    }

    public void countTotalPrice() {
        // Sắp xếp các mốc giá điện từ cao đến thấp
        Comparator<ElectricPriceMilestone> compareByFormElectricNum = (ElectricPriceMilestone o1, ElectricPriceMilestone o2) -> {
            return o1.getFormElictricNum().compareTo(o2.getFormElictricNum());
        };
        Collections.sort(electricPriceMilestones, compareByFormElectricNum.reversed());

        //Tính tổng tiền điện
        Integer eletricNum = this.eletricNum;
        this.totalPrice = 0.0;
        for (ElectricPriceMilestone electricPriceMilestone : electricPriceMilestones) {
            Integer formElectricNum = electricPriceMilestone.getFormElictricNum();
            Double price = electricPriceMilestone.getPrice();
            if (price == null || formElectricNum == null) continue;
            if (eletricNum > formElectricNum) {
                this.totalPrice += (eletricNum - formElectricNum) * price;
                eletricNum = formElectricNum;
            }
        }
    }
}
