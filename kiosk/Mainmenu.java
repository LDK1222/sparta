package kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mainmenu {

    List<Foodmenu> pastaMenu = new ArrayList<>(); //파스타 리스트 생성

    List<Foodmenu> sideMenu = new ArrayList<>(); //사이드메뉴 리스트 생성

    List<Foodmenu> drinkMenu = new ArrayList<>(); //음료 리스트 생성

    Order order = new Order(); //Order클래스의 메서드를 사용하기위한 변수 order 생성

    Scanner sc = new Scanner(System.in); // Scanner인 객체 sc를 생성

    public Mainmenu() { //각각의 리스트에 이름, 가격, 음식설명 추가
        pastaMenu.add(new Foodmenu("알리오 올리오", "6.9", "풍부한 마늘향을 끌어올린 가장 기본적인 오일파스타"));
        pastaMenu.add(new Foodmenu("토마토 파스타", "8.9", "그라냐 파다노 치즈를 듬뿍 갈아올린 토마토 파스타"));
        pastaMenu.add(new Foodmenu("봉골레 파스타", "9.9", "조개의 시원한 맛과 함께 마늘의 알싸함이 감도는 파스타"));

        sideMenu.add(new Foodmenu("고르곤 졸라피자", "8.9", "고르곤졸라 치즈로 만든 피자를 달콤한 꿀과 함께 즐기는 피자"));
        sideMenu.add(new Foodmenu("스파이시 윙&봉", "7.9", "특제 바베큐 양념을 덧발라 구운 매운 윙&봉"));
        sideMenu.add(new Foodmenu("갈릭 바게트", "4.9", "진한 마늘향과 버터를 발라 바삭하게 구운 마늘바게트"));

        drinkMenu.add(new Foodmenu("탄산음료", "2.0", "콜라,사;이다,환타"));
        drinkMenu.add(new Foodmenu("레몬에이드", "4.0", "상큼한 레몬이 가득 들어간 레몬에이드"));
        drinkMenu.add(new Foodmenu("자몽에이드", "4.0", "상큼한 자몽슬라이스가 통으로 들어간 자몽에이드"));


    }

    public void showMainmenu() {
        System.out.println("\"Rolling Pasta에 와주셔서 감사합니다.\"");
        System.out.println("메뉴판을 보시고 주문해주시길 바랍니다");
        System.out.println();
        System.out.println("[ Rolling Pasta Menu ]");
        System.out.println("1. Pasta Menu ");
        System.out.println("2. Side Menu ");
        System.out.println("3. Drinks ");
        System.out.println();
        System.out.println("[ORDER MENU]");
        System.out.println("4.주문내역");
        System.out.println("5.취소하기");

        System.out.println("메뉴선택 ");
        int choice = sc.nextInt();
        sc.nextLine(); // 개행문자 제거

        switch (choice) {
            case 1:  //파스타 메뉴출력
                ShowpastaMenu();
                break;
            case 2: //사이드 메뉴출력
                ShowsideMenu();
                break;
            case 3: // 음료메뉴출력
                ShowdrinkMenu();
                break;
            case 4: //주문내역 메서드출력
                ShowOrderMenu();
                break;
            case 5: //주문취소 메서드출력
                OrderCancel();
                break;
            default:
                System.out.println("1~5번까지의 숫자만 입력가능합니다.");
                break;
        }
    }
public void ShowpastaMenu() {

      System.out.println();
      System.out.println("[ Pasta Menu ]");
        for (int i = 0; i < pastaMenu.size(); i++) { //pastaMenu리스트에 있는 size만큼 반복 (size는 3이므로 i= 0,1,2)
            Foodmenu menu = pastaMenu.get(i);  // pastaMenu리스트에서 get()을 사용하여 menu안에 버거정보를 대입
            System.out.println((i + 1) + ". " + menu.getName() + "  | " + menu.getPrice() + "  | " + menu.getDescription());
        } // (i + 1)을 사용한 이유는 i는 배열의 첫번째 값부터 출력하기 위해 0을 사용하였는데, 번호는 1번부터 출력해야하니 i+1 을 해줘서 1,2,3이 출력되게 만들어 줬음.

        System.out.print("상품선택 : ");
        int choisepasta = sc.nextInt(); //3개의 파스타중 추가할 메뉴 선택
        sc.nextLine(); //개행문자 제거

        int pastaInfo = choisepasta - 1; //사용자가 선택한 숫자와 리스트의 번호를 맞춰주기 위하여 -1을 해준다

        Foodmenu selectedpasta = pastaMenu.get(pastaInfo);  //Foodmenu 객체를 만들어서 pastainfo 정보대입
        System.out.println("\n" + "\"" + selectedpasta.getName() + "   |  " + selectedpasta.getPrice() + "  | " + selectedpasta.getDescription() + "\""); // 정보를 사용자에게 출력
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1.확인       2.취소");

        int check = sc.nextInt();
        sc.nextLine();

        if (check == 1) {
            order.addbasket(selectedpasta);
            System.out.println(selectedpasta.getName() + " 가 장바구니에 추가되었습니다.");
            System.out.println();
        } else if (check == 2) {
            System.out.println("장바구니 추가가 취소되었습니다.");
        } else System.out.println("숫자를 잘못 입력하였습니다.");


        showMainmenu(); //모든기능이 종료되면 MainMenu를 호출해줌
    }
        public void ShowsideMenu() {
            System.out.println();
            System.out.println("[ Side Menu ]");
            for (int i = 0; i < sideMenu.size(); i++) { //sideMenu리스트에 있는 size만큼 반복 (size는 3이므로 i= 0,1,2)
                Foodmenu menu = sideMenu.get(i);  // sideMenu리스트에서 get()을 사용하여 menu안에 버거정보를 대입
                System.out.println((i + 1) + ". " + menu.getName() + "  | " + menu.getPrice() + "  | " + menu.getDescription());
            } // (i + 1)을 사용한 이유는 i는 배열의 첫번째 값부터 출력하기 위해 0을 사용하였는데, 번호는 1번부터 출력해야하니 i+1 을 해줘서 1,2,3이 출력되게 만들어 줬음.

            System.out.print("상품선택 : ");
            int choiseside = sc.nextInt(); //3개의 사이드중 추가할 메뉴 선택
            sc.nextLine(); //개행문자 제거

            int sideInfo = choiseside - 1; //사용자가 선택한 숫자와 리스트의 번호를 맞춰주기 위하여 -1을 해준다

            Foodmenu selectedside = sideMenu.get(sideInfo);  //Foodmenu 객체를 만들어서 sideinfo 정보대입
            System.out.println("\n" + "\"" + selectedside.getName() + "   |  " + selectedside.getPrice() + "  | " + selectedside.getDescription() + "\""); // 정보를 사용자에게 출력
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1.확인       2.취소");

            int check = sc.nextInt();
            sc.nextLine();

            if (check == 1) {
                order.addbasket(selectedside);
                System.out.println(selectedside.getName() + " 가 장바구니에 추가되었습니다.");
                System.out.println();
            } else if (check == 2) {
                System.out.println("장바구니 추가가 취소되었습니다.");
            } else System.out.println("숫자를 잘못 입력하였습니다.");

            showMainmenu(); //모든기능이 종료되면 MainMenu를 호출해줌
        }
        public void ShowdrinkMenu() {
            System.out.println();
            System.out.println("[ Drinks Menu ]");
            for (int i = 0; i < drinkMenu.size(); i++) { //drinkMenu리스트에 있는 size만큼 반복 (size는 3이므로 i= 0,1,2)
                Foodmenu menu = drinkMenu.get(i);  // drinkMenu리스트에서 get()을 사용하여 menu안에 버거정보를 대입
                System.out.println((i + 1) + ". " + menu.getName() + "  | " + menu.getPrice() + "  | " + menu.getDescription());
            } // (i + 1)을 사용한 이유는 i는 배열의 첫번째 값부터 출력하기 위해 0을 사용하였는데, 번호는 1번부터 출력해야하니 i+1 을 해줘서 1,2,3이 출력되게 만들어 줬음.

            System.out.print("상품선택 : ");
            int choisedrink = sc.nextInt(); //3개의 사이드중 추가할 메뉴 선택
            sc.nextLine(); //개행문자 제거

            int drinkInfo = choisedrink - 1; //사용자가 선택한 숫자와 리스트의 번호를 맞춰주기 위하여 -1을 해준다

            Foodmenu selecteddrink = drinkMenu.get(drinkInfo); //Foodmenu 객체를 만들어서 sideinfo 정보대입
            System.out.println("\n" + "\"" + selecteddrink.getName() + "   |  " + selecteddrink.getPrice() + "  | " + selecteddrink.getDescription() + "\""); // 정보를 사용자에게 출력
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1.확인       2.취소");

            int check = sc.nextInt();
            sc.nextLine();

            if (check == 1) {
                order.addbasket(selecteddrink);
                System.out.println(selecteddrink.getName() + " 가 장바구니에 추가되었습니다.");
                System.out.println();
            } else if (check == 2) {
                System.out.println("장바구니 추가가 취소되었습니다.");
            } else System.out.println("숫자를 잘못 입력하였습니다.");

            showMainmenu(); //모든기능이 종료되면 MainMenu를 호출해줌
        }
        public void ShowOrderMenu() {
            System.out.println("아래와 같이 주문 하시겠습니까?");
            System.out.println();
            System.out.println("[ Orders ]");

            List<Foodmenu> basket = order.getbasket();
            // FoodMenu 리스트형식 basket을 생성 order안에있는 getbasket()을 통해 basket안의 값을리턴받아서 대입.

            for (int i = 0; i < basket.size(); i++) { //넘겨받은 basket의 길이만큼 반복해서 장바구니안의 메뉴 출력
                Foodmenu menu = basket.get(i);  //FoodMenu형식의 Menu를 만들어서 basket안에 들어있는 0번째 값부터 가져옴
                System.out.println(menu.getName() + "  | " + menu.getPrice() + "  |  " + menu.getDescription());
            }
            System.out.println();
            System.out.println("[ Total ]");
            System.out.println(order.totalPrice() + " $"); //order클래스안의 totalPrice()를 실행시켜 총값 출력하기

            System.out.println("\n1. 주문     2.메뉴로 돌아가기");
            int checkNumber = sc.nextInt(); //주문할지 메뉴로 돌아갈지 선택
            sc.nextLine();

            if (checkNumber == 1) {

                OrderComplete();

            } else if (checkNumber == 2) {
                System.out.println("메뉴로 돌아갑니다.");
                showMainmenu();
            }
        }
        public void OrderComplete() {
            int orderNumber = order.getOrderNumber();
            //order클래스의 getOrderNumber()을 호출하여 order()안에 있는 orderNumber의 숫자를 받아서 orderNumber변수에 초기화

            System.out.println("주문이 완료되었습니다.");
            System.out.println();
            System.out.println("대기번호는 [ " + orderNumber + " ] 번 입니다.");
            System.out.println("3초 후 메뉴판으로 돌아갑니다.");
            System.out.println();

            order.Clearbasket(); //주문완료가 되었으니 카트 초기화 해주기
            order.setOrderNumber(orderNumber + 1);
            //대기번호를 사용하였으니 setOrderNumber 메서드안에 orderNumber + 1 을 넘겨주어서 order클래스안의 orderNumber을 1 증가 시켜줌

            try { //3초간 지연시키려고 Thread의 .sleep 사용 또 예외처리를 하지않으면 사용불가능하여 try-catch문을 사용
                Thread.sleep(3000);
            } catch (InterruptedException e) { // InterruptedException 예외상황 발생시
                System.out.println(e);
            }
            showMainmenu();

        }
        public void OrderCancel() {
            System.out.println();
            System.out.println("진행하던 주문을 취소하시겠습니까?");
            System.out.println("1.확인      2.취소     ");

            int cancelNum = sc.nextInt(); //확인할지 취소할지 번호를 받아옴.
            sc.nextLine();


            if (cancelNum == 1) {
                order.Clearbasket(); //사용자가 1.확인 선택시 order클래스안의 Clearbasket() 메서드를 호출해서 카트를 비워줌
                System.out.println("진행하면 주문이 취소되었습니다.");
                System.out.println();
                return;
            } else if (cancelNum == 2) {
                System.out.println("주문을 유지하고 메뉴판으로 돌아갑니다."); //유지시 메뉴판으로 돌아감
            }
            showMainmenu();
        }

    }







