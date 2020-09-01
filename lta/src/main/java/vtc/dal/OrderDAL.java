package vtc.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vtc.persistance.*;
// import vtc.persistance.OrderDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.time.LocalDate;
import java.sql.ResultSet;

public class OrderDAL {

    public static void showTableClear() {
        final String sql = "SELECT * FROM lemon_tee_shop.table where status = 'Clear';";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            System.out.println("+-------------------------+");
            System.out.printf("| %-10s | %-10s |\n", "Id", "Status");
            System.out.println("+-------------------------+");
            while (rs.next()) {
                System.out.printf("| %-10s | %-10s |\n", rs.getInt("table_id"), rs.getString("status"));
            }
            System.out.println("+-------------------------+");
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }
    }

    public static void showTableExsit() {
        final String sql = "SELECT * FROM lemon_tee_shop.table where status = 'Exsit';";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            System.out.println("+----------------------------------+");
            System.out.printf("| %-10s | %-10s |\n", "Id", "Status");
            System.out.println("+-----------------------------------+");
            while (rs.next()) {
                System.out.printf("| %-10s | %-10s |\n", rs.getInt("table_id"), rs.getString("status"));
            }
            System.out.println("+----------------------------------+");
        } catch (final SQLException ex) {

            System.out.println(ex.toString());
        }

    }

    // public static void showOrderByDay(final String day) {
    // final String sql = "SELECT * FROM lemon_tee_shop.order where date(time) = '"
    // + day + "';";
    // try (Connection con = UtilDB.getConnection();
    // Statement stm = con.createStatement();
    // ResultSet rs = stm.executeQuery(sql)) {
    // System.out.println(
    // "+-------------------------------------------------------------------------------------------+");
    // System.out.printf("| %-10s | %-20s | %-12s | %-25s | %-10s |\n", "Id",
    // "Time", "Account Id", "note",
    // "Table id");
    // System.out.println(
    // "+-------------------------------------------------------------------------------------------+");
    // while (rs.next()) {
    // System.out.printf("| %-10s | %-20s | %-12s | %-25s | %-10s |\n",
    // rs.getInt("order_id"),
    // rs.getString("time"), rs.getInt("account_id"), rs.getString("note"),
    // rs.getInt("table_id"));
    // }
    // System.out.println(
    // "+-------------------------------------------------------------------------------------------+");
    // } catch (final SQLException ex) {

    // System.out.println(ex.toString());
    // }
    // }

    // public static void showBill(final int id) {
    // double totalmonney = 0;
    // double billmonney = 0;
    // String sql = "SELECT order_id, time, table_id, note, first_name, last_name
    // FROM lemon_tee_shop.order inner join accounts on order.account_id =
    // accounts.account_id where order_id = '"
    // + id + "';";
    // try (Connection con = UtilDB.getConnection();
    // Statement stm = con.createStatement();
    // ResultSet rs = stm.executeQuery(sql)) {
    // System.out.println("+-------------------------------------------------------------------------+");
    // System.out.println("| Lemon tee shop |");
    // System.out.println("| |");
    // while (rs.next()) {
    // System.out.printf("| Staff name: %-15sTime: %-15s Table: %-8s|\n",
    // rs.getString("first_name").concat(" " + rs.getString("last_name")),
    // rs.getString("time"),
    // rs.getInt("table_id"));
    // // System.out.println(
    // // "| |");
    // }

    // } catch (final SQLException ex) {

    // System.out.println(ex.toString());
    // }
    // sql = "SELECT name, price, amount ,order_id FROM lemon_tee_shop.order_details
    // inner join lemon_tee_shop.products on order_details.product_id =
    // products.product_id where order_id = '"
    // + id + "' ;";
    // try (Connection con = UtilDB.getConnection();
    // Statement stm = con.createStatement();
    // ResultSet rs = stm.executeQuery(sql)) {
    // System.out.println("+-------------------------------------------------------------------------+");
    // System.out.println("| |");
    // System.out.printf("| %-30s | %-13s| %-7s | %-13s|\n", "Product name", "Price
    // one unit", "Amount",
    // "Total money");

    // while (rs.next()) {
    // // System.out.println(
    // // "| | | | |");
    // System.out.println("| |");
    // System.out.printf("| %-30s | %-13s | %-7s | %-13s|\n", rs.getString("name"),
    // rs.getDouble("price"),
    // rs.getInt("amount"), (totalmonney = rs.getDouble("price") *
    // rs.getInt("amount")));

    // billmonney = billmonney + totalmonney;
    // }
    // System.out.println("| |");
    // System.out.println("+-------------------------------------------------------------------------+");
    // System.out.println("| |");
    // System.out.printf("| Total bill: %-60s|\n", billmonney);
    // System.out.println("| |");
    // System.out.println("+-------------------------------------------------------------------------+");

    // } catch (final SQLException ex) {

    // System.out.println(ex.toString());
    // }
    // }

    // public static void orderAmountByMonth(final int year) {
    // int count = 0;
    // System.out.println("+-----------------------------------+");
    // System.out.println("| " + year + " |");
    // System.out.println("+-----------------------------------+");
    // System.out.printf("| %-10s | %-20s |\n", "Month", "Amount");
    // System.out.println("+-----------------------------------+");
    // for (int i = 1; i <= 12; i++) {
    // String sql = "SELECT * from lemon_tee_shop.order where year(order.time) = " +
    // year
    // + " and month(order.time) = "+i+"";
    // try (Connection con = UtilDB.getConnection();
    // Statement stm = con.createStatement();
    // ResultSet rs = stm.executeQuery(sql)) {
    // while (rs.next()) {
    // count++;
    // }
    // System.out.printf("| %-10s | %-15s |\n", i, count);
    // System.out.println("+-----------------------------------+");
    // count = 0;
    // } catch (final SQLException ex) {

    // System.out.println(ex.toString());
    // }
    // }
    // }

    // public static void monneyEarnByMonth(final int year) {
    // double monneyEarner = 0;
    // System.out.println("+-----------------------------------+");
    // System.out.println("| " + year + " |");
    // System.out.println("+-----------------------------------+");
    // System.out.printf("| %-10s | %-20s |\n", "Month", "Monney Earner");
    // System.out.println("+-----------------------------------+");
    // for (int i = 1; i <= 12; i++) {
    // String sql = "SELECT amount, price from lemon_tee_shop.order_details inner
    // join lemon_tee_shop.products on order_details.product_id =
    // products.product_id join lemon_tee_shop.order on order_details.order_id =
    // order.order_id where year(order.time) = "
    // + year + " and month(order.time) = "+i+";";
    // try (Connection con = UtilDB.getConnection();
    // Statement stm = con.createStatement();
    // ResultSet rs = stm.executeQuery(sql)) {
    // while (rs.next()) {
    // monneyEarner = monneyEarner + (rs.getInt("amount") * rs.getDouble("price"));
    // }
    // System.out.printf("| %-10s | %-20s |\n", i, monneyEarner);
    // System.out.println("+-----------------------------------+");
    // monneyEarner = 0;
    // } catch (final SQLException ex) {

    // System.out.println(ex.toString());
    // }
    // }

    // }

    public static int completeOrder(final int table) {
        int count = 0;
        final String sql = "SELECT status FROM lemon_tee_shop.table where table_id = '" + table + "';";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                if (!rs.getString("status").equals("Clear")) {
                    count = 1;
                }
            }
        } catch (final SQLException ex) {
            return count;
        }
        if (count == 1) {
            try (Connection con = UtilDB.getConnection();
                    PreparedStatement pstm = con.prepareStatement(
                            "UPDATE `lemon_tee_shop`.`table` SET `status` = 'Clear' WHERE (`table_id` = '" + table
                                    + "');");) {
                final int rs = pstm.executeUpdate();
                if (rs == 1) {
                    System.out.println("Successful!");
                    count = 2;
                } else {
                    System.out.println("Fail!");
                }
            } catch (final SQLException ex) {
                ex.printStackTrace();
                System.out.println("Update error!");

            }
        }
        if (count == 0) {
            System.out.println("Wrong table!");
        }
        return count;
    }

    public static int createOrder(Order order) {
        int count = 0;
        final String sql = "SELECT status FROM lemon_tee_shop.table where table_id = '" + order.getTable() + "';";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                if (rs.getString("status").equals("Clear")) {
                    count = 1;

                } else {
                    count = 2;
                }
            }
        } catch (final SQLException ex) {

            return count;
        }

        if (count == 1) {
            try (Connection con = UtilDB.getConnection();
                    PreparedStatement pstm = con
                            .prepareStatement("UPDATE lemon_tee_shop.table SET status = 'Exsit' WHERE (table_id = '"
                                    + order.getTable() + "');");) {
                final int rs = pstm.executeUpdate();
                if (rs == 1) {

                }
            } catch (final SQLException ex) {

                return count;
            }
            while (true) {
                try (Connection con = UtilDB.getConnection();
                        PreparedStatement pstm = con.prepareStatement(
                                "INSERT INTO lemon_tee_shop.order (time, account_id, note, table_id) VALUES (?, ?, ?, ?);");) {
                    pstm.setString(1, order.getTime());
                    pstm.setInt(2, order.getAccountId());
                    pstm.setString(3, order.getNote());
                    pstm.setInt(4, order.getTable());
                    return count = 3;
                } catch (SQLException ex) {
                    System.out.println("Error!");
                    System.out.println(ex.toString());
                    return 0;

                }
            }

        }
        return count;
    }

    public static int productsInOrder(OrderDetails orderDetails) {

        int count = 0;
        int order_id = 0;
        int productInStock = 0;
        String sql = "SELECT products_in_stock FROM lemon_tee_shop.products where product_id  = '"
                + orderDetails.getproductId() + "';";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                if (rs.getInt("products_in_stock") == 0) {
                    // System.out.println("The product is out of stock!");
                    return count = -1;
                } else if (rs.getInt("products_in_stock") < orderDetails.getamount()) {
                    // System.out.println("Insufficient quantity of products!");
                    return count = -2;
                } else {
                    count = 1;
                }

            }
        } catch (final SQLException ex) {
            return count;
        }

        if (count == 1) {
            sql = "SELECT max(order_id) FROM lemon_tee_shop.order;";
            try (Connection con = UtilDB.getConnection();
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery(sql)) {
                while (rs.next()) {
                    order_id = rs.getInt("max(order_id)");
                   return count = 2;
                }
            } catch (final SQLException ex) {
                return count = 0;
            }
        }
        if (count == 2) {

            try (Connection con = UtilDB.getConnection();
                    PreparedStatement pstm = con.prepareStatement(
                            "INSERT INTO order_details (product_id, amount, order_id) VALUES (?, ?, ?);");) {
                pstm.setInt(1, orderDetails.getproductId());
                pstm.setInt(2, orderDetails.getamount());
                pstm.setInt(3, orderDetails.getOrderId());

            } catch (SQLException ex) {
                // System.out.println("Error!");
                // System.out.println(ex.toString());
                return count = 0;

            }

            sql = "SELECT products_in_stock FROM lemon_tee_shop.products where product_id = '"
                    + orderDetails.getproductId() + "';";
            try (Connection con = UtilDB.getConnection();
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery(sql)) {
                while (rs.next()) {
                    productInStock = rs.getInt("products_in_stock") - orderDetails.getamount();
                    System.out.println(productInStock);
                }
            } catch (final SQLException ex) {
                // System.out.println(ex.toString());
                return count =  0;
            }
            System.out.println(productInStock);
            try (Connection con = UtilDB.getConnection();
                    PreparedStatement pstm = con.prepareStatement(
                            "UPDATE lemon_tee_shop.products SET products_in_stock = '" + productInStock
                                    + "' WHERE (product_id = '" + orderDetails.getproductId() + "');");) {
                final int rs = pstm.executeUpdate();
                if (rs == 1) {
                    // System.out.println("Successful!");
                    return count = 3;
                } else {
                    return count = 0;
                }
            } catch (final SQLException ex) {
                System.out.println(ex);
                return count;

            }
        }
        // if (count == 0)
        // {
        // System.out.println("Product not exsit!");
        // }
        return count;

    }

    public static int updateOrder(final int table) {
        int order_id = 0;
        int count = 0;
        String sql = "SELECT status FROM lemon_tee_shop.table where table_id = '" + table + "';";
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                if (!rs.getString("status").equals("Clear")) {
                    return count = 1;

                } else {
                    System.out.println("Table clear!");
                }
            }
        } catch (final SQLException ex) {
            System.out.println(ex);
        }

        System.out.println(count);
        if (count == 1) {
            sql = "SELECT max(order_id) FROM lemon_tee_shop.order where table_id = '" + table + "';";
            try (Connection con = UtilDB.getConnection();
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery(sql)) {
                while (rs.next()) {
                    order_id = rs.getInt("max(order_id)");

                }
            } catch (final SQLException ex) {
                System.out.println(ex);
            }
        }

        System.out.println(order_id);
        return order_id;
    }


    public static Order getOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setOrderId(rs.getInt("order_id"));
        order.setTime(rs.getString("time"));
        order.setAccountId(rs.getInt("account_id"));
        order.setNote(rs.getString("note"));
        order.setTable(rs.getInt("table_id"));
        return order;
    }


    public static OrderDetails getOrderDetails(ResultSet rs) throws SQLException {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setorderDetailsId(rs.getInt("order_details_id"));
        orderDetails.setproductId(rs.getInt("product_id"));
        orderDetails.setamount(rs.getInt("amount"));
        orderDetails.setOrderId(rs.getInt("order_id"));
        return orderDetails;
    }

    public static List<Order> getOrderByDay(String day) {
        String sql = "SELECT * FROM lemon_tee_shop.order where date(time) = '" + day + "';";
        List<Order> lst = new ArrayList<>();
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lst.add(getOrder(rs));
            }
        } catch (SQLException ex) {
            lst = null;
            System.out.println(ex.toString());
        }
        return lst;
    }

    public static List<OrderDetails> getOrderDetails(int id) {
        String sql = "SELECT * FROM lemon_tee_shop.order_details inner join lemon_tee_shop.products on order_details.product_id = products.product_id where order_id = '"
                + id + "' ;";
        List<OrderDetails> lst = new ArrayList<>();
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lst.add(getOrderDetails(rs));
            }
        } catch (SQLException ex) {
            lst = null;
            System.out.println(ex.toString());
        }
        return lst;
    }

    public static List<OrderDetails> getBillDetails(int id) {
        String sql = "SELECT * FROM lemon_tee_shop.order_details  where order_id = '" + id + "' ;";
        List<OrderDetails> lst = new ArrayList<>();
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lst.add(getOrderDetails(rs));
            }
        } catch (SQLException ex) {
            lst = null;
            System.out.println(ex.toString());
        }
        return lst;
    }

    public static List<Order> getBill(int id) {
        String sql = "SELECT * FROM lemon_tee_shop.order order_id = '" + id + "';";
        List<Order> lst = new ArrayList<>();
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lst.add(getOrder(rs));
            }
        } catch (SQLException ex) {
            lst = null;
            System.out.println(ex.toString());
        }
        return lst;
    }

    public static List<Order> getOrderByMonth(int year, int month) {
        String sql = "SELECT * from lemon_tee_shop.order  where year(order.time) = " + year
                + " and month(order.time) = " + month + "";
        List<Order> lst = new ArrayList<>();
        try (Connection con = UtilDB.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lst.add(getOrder(rs));
            }
        } catch (SQLException ex) {
            lst = null;
            System.out.println(ex.toString());
        }
        return lst;
    }

}