package vtc.ui.ProductsUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vtc.bl.ProductBL;
import vtc.dal.ProductDAL;
import vtc.persistance.Product;

public class ProductFunctionUI {
    public static ProductDAL dal_product = new ProductDAL();
    static Scanner sc = new Scanner(System.in);
    static List<Product> productsList = new ArrayList<>();
    static ProductBL productBL = new ProductBL();

    public static void showProduct() {
        ProductBL productBL = new ProductBL();
        List<Product> lst = productBL.getAll();

        System.out.println("\nItem List: ");
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-10s | %-30s | %-15s | %-10s | %-20s | %-20s | %-15s | %-19s |\n", "ID", "Product name",
                "Cost", "Discount", "Price", "Promotion", "Category", "Products In Stock");
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        for (Product product : lst) {
            System.out.printf("| %-10s | %-30s | %-15s | %-10s | %-20s | %-20s | %-15s | %-19s |\n",
                    product.getProductId(), product.getProductName(), product.getCost(), product.getDiscount(),
                    product.getPrice(), product.getPromotion(), product.getCategory(), product.getProductsInStock());
        }
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------------------------------------------------------+");

    }

    public static void insertProduct() {
        while (true) {

            ProductBL productBL = new ProductBL();

            if (productBL.addProduct(inputProduct())) {
                System.out.println("Insert product complete!");
            } else {
                System.err.println("Insert product failed!");
            }

            System.out.print("Continued(y/n): ");
            String choice1 = yesno();
            if (choice1.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public static String yesno() {
        String yn = null;
        while (true) {
            yn = sc.nextLine();
            if (yn.equals("N") || yn.equals("Y") || yn.equals("n")
                    || yn.equals("y")) {
                break;
            }
        }

        return yn;
    }

    public static Product inputProduct() {
        Product product = new Product();

        System.out.print("Product name: ");
        product.setProductName(inputString());
        System.out.print("Unit cost: ");
        Double cost = input_double();
        product.setCost(cost);
        System.out.print("Unit discount: ");
        int discount = input_int();
        product.setDiscount(discount);
        System.out.print("Unit price: ");
        Double price = input_double();
        product.setPrice(price);
        System.out.print("Product promotion: ");
        product.setPromotion(inputString());
        System.out.print("Product category: ");
        product.setCategory(inputString());
        System.out.print("Products in stock: ");
        int productsInStock = input_int();
        product.setProductsInStock(productsInStock);

        return product;
    }

    public static void inputInfoUpdate() {

        while (true) {
            Product product = new Product();

            Scanner sc = new Scanner(System.in);
            System.out.print("Product_id : ");
            int id = input_int();
            product.setProductId(id);
            System.out.print("Product name: ");
            product.setProductName(inputString());
            System.out.print("Unit cost: ");
            Double cost = input_double();
            product.setCost(cost);
            System.out.print("Unit discount: ");
            int discount = sc.nextInt();
            product.setDiscount(discount);
            System.out.print("Unit price: ");
            Double price = input_double();
            product.setPrice(price);
            System.out.print("Product promotion: ");
            product.setPromotion(inputString());
            System.out.print("Product category: ");
            product.setCategory(inputString());
            System.out.print("Products in stock: ");
            int productsInStock = input_int();
            product.setProductsInStock(productsInStock);
            System.out.printf("Do you want to update(y/n):");
            String choice = yesno();
            if (choice.equalsIgnoreCase("y")) {
                productsList.add(product);
                try {
                    productBL.Update(product);
                } catch (Exception e) {

                    e.printStackTrace();
                }
            } else {
                System.out.println("Error. can't Update!");
            }
            System.out.print("Continued(y/n): ");
            String x = yesno();
            if (x.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public static void inputProductsInStock() {

        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.print("ProductId : ");
            int id = input_int();
            System.out.print("Products in stock: ");
            int productsInStock = input_int();
            try {
                productBL.UpdateProductsInStock(id, productsInStock);
            } catch (Exception e) {
            }
            System.out.print("Do you want to update(y/n):");
            String choice = yesno();
            if (choice.equalsIgnoreCase("y")) {
                try {
                    productBL.UpdateProductsInStock(id, productsInStock);

                } catch (Exception e) {
                    System.out.println("Error. can't Update!");
                }
            }
            System.out.print("Continued(y/n): ");
            String x = yesno();
            if (x.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public static int input_int() {
        final Scanner input = new Scanner(System.in);
        int x = 0;
        String a;
        while (true) {
            a = input.nextLine();
            try {
                x = Integer.parseInt(a);
                if (x >= 0) {
                    return x;
                } else {
                    System.out.print("  Wrong type, enter again: ");
                }
            } catch (Exception e) {
                System.out.print("  Wrong type, enter again: ");
            }
        }

    }

    private static String inputString() {
        final Scanner input = new Scanner(System.in);
        String a;
        while (true) {
            a = input.nextLine();
            if (a.trim().compareTo("") == 0) {
                System.out.print("  Wrong type, enter again: ");

            } else {
                return a.trim();
            }
        }

    }

    public static double input_double() {
        final Scanner input = new Scanner(System.in);
        double x = 0;
        String a;
        while (true) {
            a = input.nextLine();
            try {
                x = Double.parseDouble(a);
                if (x >= 0) {
                    return x;
                } else {
                    System.out.print("  Wrong type, enter again: ");
                }
            } catch (Exception e) {
                System.out.print("  Wrong type, enter again: ");
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