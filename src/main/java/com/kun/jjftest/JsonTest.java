package com.kun.jjftest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: JsonTest
 * Package: com.kun.jjftest
 * Description:
 *
 * @Author KunJiang
 * @Create 12/9/24 7:40 PM
 * @Version 1.0
 */

public class JsonTest {
    public static void main(String[] args) {
        //convert java object to json format or json format to java object
        ObjectMapper objectMapper = new ObjectMapper();
        //Java to Json
        ArrayList<Employee> empList = new ArrayList<>();
        Employee e1 = new Employee(100,"Test1");
        Employee e2 = new Employee(200,"Test2");
        empList.add(e1);
        empList.add(e2);
        try {
            //pass list of java object to jason file
            String jsonEmp = objectMapper.writeValueAsString(empList);
            System.out.println(jsonEmp);
            try {
                objectMapper.writeValue(new File("./jsonEmp.json"), empList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //Json to Java
        String jsonString = "[{\"empID\":100,\"empName\":\"Test1\"},{\"empID\":200,\"empName\":\"Test2\"}]";
        ObjectMapper objectMapper1 = new ObjectMapper();
        try {
            //尝试将一个 JSON 字符串反序列化为 ArrayList<Employee>，但 ObjectMapper 默认无法直接推断 Employee 的类型，因为泛型类型在运行时会被擦除。
            //这种情况下，Jackson 会将 ArrayList.class 解析为一个 ArrayList<Map>，从而导致类型转换错误或无法正确解析 Employee 对象。
            ArrayList<Employee> list2 = objectMapper1.readValue(jsonString, ArrayList.class);
            //为了正确反序列化为 ArrayList<Employee>，需要使用 TypeReference 来明确类型信息
            List<Employee> list3 = objectMapper1.readValue(jsonString, new TypeReference<ArrayList<Employee>>() {});
            System.out.println(list2);
            System.out.println(list3);
            try {
                List<Employee> list4 = objectMapper1.readValue(new File("./jsonEmp.json"), new TypeReference<List<Employee>>(){});
                for (Employee emp: list4){
                    System.out.println(emp.getEmpName() + "+" + emp.getEmpID());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //TypeReference 的使用:
            //Jackson 使用 TypeReference 显式指定目标类型（例如 ArrayList<Employee>），以解决 Java 泛型类型擦除的问题。
            //Employee 类的定义:
            //Employee 类需要有一个无参构造函数，否则 Jackson 无法实例化对象。
            //提供 toString 方法以便打印输出。
            //JSON 示例:
            //输入 JSON 是一个数组，每个数组元素表示一个 Employee 对象。
            for (Employee emp: list3){
                System.out.println(emp.toString());
                System.out.println(emp.getEmpID() + " " + emp.getEmpName());
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
