package com.kun.jjftest;

/**
 * ClassName: NestedJsonExample
 * Package: com.kun.jjftest
 * Description:
 *
 * @Author KunJiang
 * @Create 12/9/24 7:26 PM
 * @Version 1.0
 */

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NestedJsonExample {
    public static void main(String[] args) {
        String json = "{\n" +
                "  \"order_id\": 12345,\n" +
                "  \"order_date\": \"2024-12-09\",\n" +
                "  \"customer\": {\n" +
                "    \"customer_id\": 987,\n" +
                "    \"name\": \"Alice Smith\",\n" +
                "    \"email\": \"alice.smith@example.com\",\n" +
                "    \"address\": {\n" +
                "      \"street\": \"123 Main St\",\n" +
                "      \"city\": \"Springfield\",\n" +
                "      \"state\": \"IL\",\n" +
                "      \"zipcode\": \"62704\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"items\": [\n" +
                "    {\n" +
                "      \"item_id\": 1,\n" +
                "      \"product_name\": \"Wireless Mouse\",\n" +
                "      \"quantity\": 2,\n" +
                "      \"price\": 20.99,\n" +
                "      \"details\": {\n" +
                "        \"manufacturer\": \"TechBrand\",\n" +
                "        \"warranty\": \"1 year\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"item_id\": 2,\n" +
                "      \"product_name\": \"Keyboard\",\n" +
                "      \"quantity\": 1,\n" +
                "      \"price\": 45.50,\n" +
                "      \"details\": {\n" +
                "        \"manufacturer\": \"KeyTech\",\n" +
                "        \"warranty\": \"2 years\"\n" +
                "      }\n" +
                "    }\n" +
                "  ],\n" +
                "  \"total_amount\": 87.48,\n" +
                "  \"status\": \"Shipped\"\n" +
                "}";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(json);

            // 获取订单信息
            int orderId = root.get("order_id").asInt();
            String orderDate = root.get("order_date").asText();
            System.out.println("Order ID: " + orderId);
            System.out.println("Order Date: " + orderDate);

            // 获取客户信息
            JsonNode customer = root.get("customer");
            String customerName = customer.get("name").asText();
            String email = customer.get("email").asText();
            System.out.println("Customer Name: " + customerName);
            System.out.println("Customer Email: " + email);

            // 获取订单项信息
            JsonNode items = root.get("items");
            for (JsonNode item : items) {
                String productName = item.get("product_name").asText();
                int quantity = item.get("quantity").asInt();
                double price = item.get("price").asDouble();
                System.out.println("Product: " + productName + ", Quantity: " + quantity + ", Price: $" + price);

                // 获取嵌套的 details 信息
                JsonNode details = item.get("details");
                String manufacturer = details.get("manufacturer").asText();
                System.out.println("  Manufacturer: " + manufacturer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

