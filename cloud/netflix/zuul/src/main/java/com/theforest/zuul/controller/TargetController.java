package com.theforest.zuul.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.Enumeration;

@Slf4j
@RestController
@RequestMapping("/**")
public class TargetController {

    private final static String NEXT_LINE = "\n";

    @RequestMapping(path = "")
    public String test(HttpServletRequest request) {
        StringBuffer strLog = new StringBuffer();

        strLog.append("................ Interceptor cap/** ......  " + NEXT_LINE);
        strLog.append("Method: " + request.getMethod() + NEXT_LINE);
        strLog.append("URL: " + request.getRequestURL() + NEXT_LINE);
        strLog.append("URI: " + request.getRequestURI() + NEXT_LINE);
        strLog.append("Host Remote: " + request.getRemoteHost() + NEXT_LINE);
        strLog.append("----- PARAMS ----" + NEXT_LINE);

        request.getParameterMap().forEach((key, value) -> {
            for (int n = 0; n < value.length; n++) {
                strLog.append("name:" + key + " value: " + value[n] + NEXT_LINE);
            }
        });

        strLog.append(NEXT_LINE + "----- Headers ----" + NEXT_LINE);
        Enumeration<String> nameHeaders = request.getHeaderNames();
        while (nameHeaders.hasMoreElements()) {
            String name = nameHeaders.nextElement();
            Enumeration<String> valueHeaders = request.getHeaders(name);
            while (valueHeaders.hasMoreElements()) {
                String value = valueHeaders.nextElement();
                strLog.append("name:" + name + " value: " + value + NEXT_LINE);
            }
        }
        try {
            strLog.append(NEXT_LINE + "----- BODY ----" + NEXT_LINE);
            BufferedReader reader = request.getReader();
            if (reader != null) {
                int symbol;
                while ((symbol = reader.read()) != -1) {
                    strLog.append((char) symbol);
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        log.info(strLog.toString().strip());

        return NEXT_LINE + strLog;
    }
}
