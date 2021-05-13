package com.example.demo1;

public class Proxy implements Rent{
    private Host host;

    public Proxy(){

    }

    public Proxy(Host host){
        this.host=host;
    }

    public void rent(){
        seeHouse();
        host.rent();
        sign();
        fare();
    }

    //看房
    public void seeHouse(){
        System.out.println("中介带你看房");
    }

    //收中介费
    public void fare(){
        System.out.println("收中介费");
    }

    //签订合同
    public void sign(){
        System.out.println("签订租赁合同");
    }
}
