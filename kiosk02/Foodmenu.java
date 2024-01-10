package kiosk02;

public class Foodmenu {

    private String name;
    private double price; // String을 double로 변경 팀원들이 연산할 때 추가로 형변환을 해야하니 double형으로 선언해보라고 함
    private String description;

    public Foodmenu(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
