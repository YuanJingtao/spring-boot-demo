package com.example.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Seckill
 *
 * @author YuanJingtao
 * @version 1.0
 * @date 2017-01-23 15:34
 */
public class Seckill{

    private Date startDate;
    private Date endDate;
    private Date createDate;
    private Integer number;
    private String name;
    private Long seckillId;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

}
