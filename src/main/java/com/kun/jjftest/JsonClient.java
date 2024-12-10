package com.kun.jjftest;

/**
 * ClassName: JsonClient
 * Package: com.kun.jjftest
 * Description:
 *
 * @Author KunJiang
 * @Create 12/9/24 7:16 PM
 * @Version 1.0
 */

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonClient {
    public static void main(String[] args) {
        try {
            // 模拟调用 Web 服务并获取 JSON 数据
            String jsonResponse = MockWebService.getUserJson();

            // 使用 Jackson 解析 JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);

            // 提取数据
            int id = jsonNode.get("id").asInt();
            String name = jsonNode.get("name").asText();
            String email = jsonNode.get("email").asText();

            // 打印解析结果
            System.out.println("User ID: " + id);
            System.out.println("User Name: " + name);
            System.out.println("User Email: " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

