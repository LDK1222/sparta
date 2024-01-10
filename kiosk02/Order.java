package kiosk02;  // String을 double로 변경 팀원들이 연산할 때 추가로 형변환을 해야하니 double형으로 선언해보라고 함
                  //그래서 totalPrice메서드에서 menu.getPrice()로 변경해서 Foodmenu클래스에서 double값으로 반환하도록 수정

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Foodmenu> basket;
    private int orderNumber;

    public Order() {
        basket = new ArrayList<>();
        orderNumber = 1;
    }

    public List<Foodmenu> getBasket() {
        return basket;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void addBasket(Foodmenu menu) {
        basket.add(menu);
    }

    public void clearBasket() {
        basket.clear();
    }

    public double totalPrice() {
        double total = 0.0;
        for (Foodmenu menu : basket) {
            total += menu.getPrice();
        }
        return total;
    }
}
