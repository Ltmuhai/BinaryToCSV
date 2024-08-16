package org.example;

public class ExcelTO {
    //名字
    private String name;
    //公司
    private String com;
    //介绍
    private String indro;
    //公司
    private String comp;
    //地址
    private String address;
    //身份证
    private String identification;
    //时间"
    private String data;
    //法人
    private String legal_person;
    //注册金额
    private String amount;
    //编号
    private String ID;
    //网址
    private String web;
    public ExcelTO(String[] IO) {
        this.name = IO[0];
        this.com = IO[1];
        this.indro = IO[2];
        this.comp = IO[3];
        this.address = IO[4];
        this.identification = IO[5];
        this.data = IO[6];
        this.legal_person = IO[7];
        this.amount = IO[8];
        this.ID = IO[9];
        this.web = IO[10];
    }
}
