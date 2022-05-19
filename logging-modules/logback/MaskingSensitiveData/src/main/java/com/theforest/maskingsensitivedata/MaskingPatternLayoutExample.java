package com.theforest.maskingsensitivedata;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class MaskingPatternLayoutExample {

    private static final Logger logger = LoggerFactory.getLogger(MaskingPatternLayoutExample.class);

    public static void main(String[] args) {
        Map<String, String> user = new HashMap<String, String>();
        user.put("user_id", "87656");
        user.put("SSN", "786445563");
        user.put("address", "22 Street");
        user.put("city", "Chicago");
        user.put("Country", "U.S.");
        user.put("ip_address", "192.168.1.1");
        user.put("email_id", "spring@baeldung.com");
        user.put("salary", "1234124");
        JSONObject userDetails = new JSONObject(user);

        logger.info("MaskingPatternExample log from {}" + userDetails, MaskingPatternLayoutExample.class.getSimpleName());

        Employee employee = new Employee("1234124");
        logger.info("MaskingPatternExample log from {}" + employee, MaskingPatternLayoutExample.class.getSimpleName());
    }

    static class Employee {
        String salary;

        Employee(String salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "salary:" + salary + ";" +
                    "}";
        }
    }
}
