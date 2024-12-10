package com.kun.jjftest;

/**
 * ClassName: MockWebService
 * Package: com.kun.jjftest
 * Description:
 *
 * @Author KunJiang
 * @Create 12/9/24 7:15 PM
 * @Version 1.0
 */

import com.fasterxml.jackson.databind.ObjectMapper;

public class MockWebService {
    public static String getUserJson() {
        // 模拟用户数据
        String json = "{ \"id\": 1, \"name\": \"John Doe\", \"email\": \"johndoe@example.com\" }";
        return json;
    }
}
