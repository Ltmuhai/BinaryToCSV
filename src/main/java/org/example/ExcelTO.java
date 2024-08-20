package org.example;

import com.alibaba.excel.annotation.ExcelProperty;



public class ExcelTO {

    @ExcelProperty(value = "名字")
    private String name;
    @ExcelProperty(value = "公司")
    private String com;
    @ExcelProperty(value = "介绍")
    private String indro;
    @ExcelProperty(value = "公司")
    private String comp;
    @ExcelProperty(value = "地址")
    private String address;
    @ExcelProperty(value = "身份证")
    private String identification;
    @ExcelProperty(value = "时间")
    private String data;
    @ExcelProperty(value = "法人")
    private String legal_person;
    @ExcelProperty(value = "注册金额")
    private String amount;
    @ExcelProperty(value = "编号")
    private String id;
    @ExcelProperty(value = "网址")
    private String web;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }
    public String getIndro() {
        return indro;
    }

    public void setIndro(String indro) {
        this.indro = indro;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLegal_person() {
        return legal_person;
    }

    public void setLegal_person(String legal_person) {
        this.legal_person = legal_person;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
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
        this.id = IO[9];
        this.web = IO[10];
    }
//    public String getname() {
//        return name;
//    }
//    public String getcom() {
//        return com;
//    }
//    public String getindro() {
//        return indro;
//    }
//    public String getcomp() {
//        return comp;
//    }
//    public String getaddress() {
//        return address;
//    }
//    public String getidentification() {
//        return identification;
//    }
//    public String getdata() {
//        return data;
//    }
//    public String getlegal_person() {
//        return legal_person;
//    }
//    public String getamount() {
//        return amount;
//    }
//    public String getid() {
//        return id;
//    }
//    public String getweb() {
//        return web;
//    }
}
