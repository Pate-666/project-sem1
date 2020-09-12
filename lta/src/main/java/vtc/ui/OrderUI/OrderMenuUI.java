package vtc.ui.OrderUI;

import java.io.IOException;
import java.util.Scanner;

import vtc.bl.OrderBL;

public class OrderMenuUI {
    Scanner sc = new Scanner(System.in);

    public void financial_management_menu() {
        boolean back = true;
        while (back) {
            cls();
            System.out.println("[LTS] PF10 - Group6");
            System.out.println("+-------------------------------------------+");
            System.out.println("|            Financial management           |");
            System.out.println("+-------------------------------------------+");
            System.out.println("|      1. Order amount by year              |");
            System.out.println("|      2. Money earner by year              |");
            System.out.println("|      0. Come back                         |");
            System.out.println("+-------------------------------------------+");
            System.out.print("   --> Enter your choice:");
            String chose = sc.nextLine();
            switch (chose) {
                case "1":
                    cls();
                    OrderFunctionUI.orderByMonth();
                    System.out.printf("Press '%s' to go back:", "Enter");
                    String nh = sc.nextLine();
                    break;
                case "2":
                    cls();
                    OrderFunctionUI.monneyEarnerByMonth();
                    System.out.printf("Press '%s' to go back:", "Enter");
                    nh = sc.nextLine();
                    break;

                case "0":
                    back = false;
                    break;
                default:
                System.out.printf("Wrong, Press '%s' to go back:", "Enter");
                    nh = sc.nextLine();
            }
        }
    }

    public void manage_order_menu(int id) {
        boolean back = true;
        while (back) {
            cls();
            System.out.println("[LTS] PF10 - Group6");
            System.out.println("+-------------------------------------------+");
            System.out.println("|                Manage order               |");
            System.out.println("+-------------------------------------------+");
            System.out.println("|      1. Create order                      |");
            System.out.println("|      2. Update order                      |");
            System.out.println("|      3. Complete order                    |");
            System.out.println("|      4. View order                        |");
            System.out.println("|      0. Come back                         |");
            System.out.println("+-------------------------------------------+");
            System.out.print("   --> Enter your choice:");
            String chose = sc.nextLine();
            switch (chose) {
                case "1":
                    cls();
                    OrderBL.showTableClear();
                    OrderFunctionUI.createOrder(id);
                    break;
                case "2":
                    cls();
                    OrderBL.showTableExit();
                    OrderFunctionUI.updateOrder();
                    break;

                case "3":
                    cls();
                    OrderBL.showTableExit();
                    OrderFunctionUI.completeOrder();
                    System.out.printf(" Press '%s' to go back:", "Enter");
                    String nh = sc.nextLine();
                    break;
                case "4":
                    cls();
                    OrderFunctionUI.showOrderByDay();
                    OrderFunctionUI.showBill();
                    System.out.printf(" Press '%s' to go back:", "Enter");
                    nh = sc.nextLine();
                    break;
                case "0":
                    back = false;
                    break;
                default:
                System.out.printf("Wrong, Press '%s' to go back:", "Enter");
                    nh = sc.nextLine();
            }
        }
    }

    public static void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ignored) {
        }
    }
}