package com.xtel.training.ptd.exercise.config_xml.b2_electric.model;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "EletricPriceMilestion")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElectricPriceMilestone {

    @XmlAttribute(name = "id")
    private Integer id;

    @XmlElement(name = "Price")
    private Double price;

    @XmlElement(name = "FormElictricNum")
    private Integer formElictricNum;

    public ElectricPriceMilestone() {
    }

    public ElectricPriceMilestone(Integer id, Double price, Integer formElictricNum) {
        this.id = id;
        this.price = price;
        this.formElictricNum = formElictricNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getFormElictricNum() {
        return formElictricNum;
    }

    public void setFormElictricNum(Integer formElictricNum) {
        this.formElictricNum = formElictricNum;
    }
}