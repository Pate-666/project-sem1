package vtc;

import vtc.accounts.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        while (true) {

            final DAL_Account dal_Account = new DAL_Account();
            final GUI_Account gui_account = new GUI_Account();
            String username;
            String password;

            System.out.println("+-------------------------------------------+");
            System.out.println("|               [WELL COME]                 |");
            System.out.println("+-------------------------------------------+");
            System.out.print("      [Username]*");
            username = nhap();         
            password = readPassword("      [Password]*");
            final String check = dal_Account.check_account(username, password);
            if (check == null) {
                System.out.println("Tai khoan hoac mat khau khong chinh xac!");
                System.out.printf("Nhan %s de tiep tuc:", "Enter");
                final String nh = sc.nextLine();
            } else {
                if (check.equals("Admin")) {
                    gui_account.admin_main_menu();
                } else if (check.equals("Staff")) {
                    gui_account.staff_main_menu();
                }
                if (check.equals("Admin")) {
                    gui_account.admin_main_menu();
                } else if (check.equals("Staff")) {
                    gui_account.staff_main_menu();
                }

            }
        }
    }

    private static String nhap() {
        final Scanner input = new Scanner(System.in);
        String a;
        while (true) {
            a = input.nextLine();
            if (a.trim().compareTo("") == 0) {
                System.out.println("Nhap sai,moi nhap lai! ");
                System.out.print("#Chon: ");
            } else {
                break;
            }
        }
        return a.trim();
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

    public static String readPassword(final String prompt) {
        final EraserThread et = new EraserThread(prompt);
        final Thread mask = new Thread(et);
        mask.start();

        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String password = "";

        try {
            password = in.readLine();
        } catch (final IOException ioe) {
          ioe.printStackTrace();
        }
        // stop masking
        et.stopMasking();
        // return the password entered by the user
        return password;
     }
}