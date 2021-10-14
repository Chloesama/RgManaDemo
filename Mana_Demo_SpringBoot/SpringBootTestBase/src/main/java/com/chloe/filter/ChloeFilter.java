package com.chloe.filter;

import com.chloe.util.quest.RequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ChloeFilter
 * @Description TODO
 * @Author RgMana
 * @Date 2021/9/24 9:28
 * @Version 1.0
 **/
@Slf4j
@WebFilter(urlPatterns = "/test", filterName = "anissFilter")
@Component
public class ChloeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("Chloe111---ChloeFilter");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        RequestWrapper requestWrapper = new RequestWrapper(httpServletRequest);
        String bodyString = requestWrapper.getBodyString();

        log.info("Chloe2---bodyString:" + bodyString);
        filterChain.doFilter(requestWrapper,httpServletResponse);
    }
}
