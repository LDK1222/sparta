package kiosk;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Foodmenu> basket; //FoodMenu 리스트 형식으로 사용할 basket 생성

    private int orderNumber; //주문대기번호


    public Order() {
        basket = new ArrayList<>();
        orderNumber = 1;
    }


    public List<Foodmenu> getbasket() {return basket;}

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void addbasket(Foodmenu menu) {basket.add(menu);}

    public void Clearbasket() {basket.clear();}

    public double totalPrice() {
        double total = 0.0;
        for (Foodmenu menu : basket){
            total += Double.parseDouble(menu.getPrice().substring(2));
        }
        return total;
    }
}
