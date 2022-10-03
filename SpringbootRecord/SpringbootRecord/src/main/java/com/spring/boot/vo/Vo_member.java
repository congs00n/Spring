package com.spring.boot.vo;

import lombok.Builder;
import lombok.Data;

@Data
public class Vo_member {
    private String memberId;
    private String loginId;
    private String password;
    private String name;
    private String role;
    private String regDay;

    @Builder
    public Vo_member( String loginId, String password, String name, String role, String regDay) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.role = role;
        this.regDay = regDay;
    }
/*
    public Vo_member(String MEM_NUM, String MEM_ID, String MEM_NAME, String MEM_EMAIL, String REG_DAY) {
        this.MEM_NUM = MEM_NUM;
        this.MEM_ID = MEM_ID;
        this.MEM_NAME = MEM_NAME;
        this.MEM_EMAIL = MEM_EMAIL;
        this.REG_DAY = REG_DAY;
    }

    public String getMEM_NUM() {
        return MEM_NUM;
    }

    public void setMEM_NUM(String MEM_NUM) {
        this.MEM_NUM = MEM_NUM;
    }

    public String getMEM_ID() {
        return MEM_ID;
    }

    public void setMEM_ID(String MEM_ID) {
        this.MEM_ID = MEM_ID;
    }

    public String getMEM_NAME() {
        return MEM_NAME;
    }

    public void setMEM_NAME(String MEM_NAME) {
        this.MEM_NAME = MEM_NAME;
    }

    public String getMEM_EMAIL() {
        return MEM_EMAIL;
    }

    public void setMEM_EMAIL(String MEM_EMAIL) {
        this.MEM_EMAIL = MEM_EMAIL;
    }

    public String getREG_DAY() {
        return REG_DAY;
    }

    public void setREG_DAY(String REG_DAY) {
        this.REG_DAY = REG_DAY;
    }

     */
}