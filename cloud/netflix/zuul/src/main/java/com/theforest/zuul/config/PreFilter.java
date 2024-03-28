package com.theforest.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Enumeration;

@Slf4j
//@Component
public class PreFilter extends ZuulFilter {
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        StringBuffer strLog = new StringBuffer();
        strLog.append("\n------ NUEVA PETICION ------\n");
        strLog.append(MessageFormat.format("Server: {0} Method: {1} Path: {2} \n",
                ctx.getRequest().getServerName(),
                ctx.getRequest().getMethod(),
                ctx.getRequest().getRequestURI()));
        Enumeration< String > enume = ctx.getRequest().getHeaderNames();
        String header;
        while (enume.hasMoreElements()) {
            header = enume.nextElement();
            strLog.append(String.format("Headers: %s = %s \n", header, ctx.getRequest().getHeader(header)));
        };
        log.info(strLog.toString());
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER;
    }

    @Override
    public String filterType() {
        return "pre";
    }

}
