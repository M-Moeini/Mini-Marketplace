package com.mehdi.otp.Model;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class IP {

    @Id
    @GeneratedValue
    private Long id;

    private String ip;
    private int ReqNum;
    private String  otpCode;
    private Long createdAt;

    private Long startedBlockTime ;

    public IP(String ip, int reqNum) {
        this.ip = ip;
        ReqNum = reqNum;
    }

    public IP() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getReqNum() {
        return ReqNum;
    }

    public void setReqNum(int reqNum) {
        ReqNum = reqNum;
    }

    public String  getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String  otpCode) {
        this.otpCode = otpCode;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getStartedBlockTime() {
        return startedBlockTime;
    }

    public void setStartedBlockTime(Long startedBlockTime) {
        this.startedBlockTime = startedBlockTime;
    }
}
