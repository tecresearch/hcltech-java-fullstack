package com.hcl.orders;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class OrderApp {

    // Product class
    static class Product {
        private int productId;
        private String productName;
        private int productCost;
        private LocalDate manufacturingDate;
        private LocalDate expiryDate;

        public Product(int productId, String productName, int productCost, LocalDate manufacturingDate, LocalDate expiryDate) {
            this.productId = productId;
            this.productName = productName;
            this.productCost = productCost;
            this.manufacturingDate = manufacturingDate;
            this.expiryDate = expiryDate;
        }

        public int getProductCost() {
            return productCost;
        }

        public LocalDate getExpiryDate() {
            return expiryDate;
        }

        @Override
        public String toString() {
            return productName + " (₹" + productCost + ", Exp: " + expiryDate + ")";
        }
    }

    // Order class
    static class Order {
        private int orderNumber;
        private LocalDate orderDate;
        private List<Product> allProducts;

        public Order(int orderNumber, LocalDate orderDate, List<Product> allProducts) {
            this.orderNumber = orderNumber;
            this.orderDate = orderDate;
            this.allProducts = allProducts;
        }

        public int getOrderNumber() {
            return orderNumber;
        }

        public List<Product> getAllProducts() {
            return allProducts;
        }

        public int getTotalCost() {
            return allProducts.stream().mapToInt(Product::getProductCost).sum();
        }

        public List<Product> getProductsExpiringThisMonth() {
            LocalDate now = LocalDate.now();
            Month currentMonth = now.getMonth();
            int currentYear = now.getYear();
            return allProducts.stream()
                    .filter(p -> p.getExpiryDate().getMonth() == currentMonth && p.getExpiryDate().getYear() == currentYear)
                    .collect(Collectors.toList());
        }

        @Override
        public String toString() {
            return "Order #" + orderNumber + " | Date: " + orderDate + " | Total: ₹" + getTotalCost();
        }
    }

    // Sample data
    static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        // Sample products
        Product p1 = new Product(1, "Milk", 50, LocalDate.of(2025, 6, 1), LocalDate.of(2025, 7, 20));
        Product p2 = new Product(2, "Bread", 30, LocalDate.of(2025, 6, 5), LocalDate.of(2025, 7, 18));
        Product p3 = new Product(3, "Butter", 100, LocalDate.of(2025, 5, 10), LocalDate.of(2025, 8, 10));
        Product p4 = new Product(4, "Cheese", 150, LocalDate.of(2025, 6, 15), LocalDate.of(2025, 7, 25));

        // Sample orders
        orders.add(new Order(101, LocalDate.of(2025, 7, 10), Arrays.asList(p1, p2)));
        orders.add(new Order(102, LocalDate.of(2025, 7, 12), Arrays.asList(p3, p4)));

        // 1. Get All Orders
        System.out.println("All Orders:");
        orders.forEach(System.out::println);

        // 2. Get a Specific Order
        int searchOrderNumber = 101;
        Order foundOrder = getOrderById(searchOrderNumber);
        if (foundOrder != null) {
            System.out.println("\nOrder Found: " + foundOrder);

            // 2a. Products expiring this month
            System.out.println("Products expiring this month:");
            foundOrder.getProductsExpiringThisMonth().forEach(System.out::println);

            // 3. Total cost of the order
            System.out.println("Total Cost: ₹" + foundOrder.getTotalCost());
        } else {
            System.out.println("Order #" + searchOrderNumber + " not found.");
        }
    }

    public static Order getOrderById(int orderNumber) {
        return orders.stream()
                .filter(o -> o.getOrderNumber() == orderNumber)
                .findFirst()
                .orElse(null);
    }
}
