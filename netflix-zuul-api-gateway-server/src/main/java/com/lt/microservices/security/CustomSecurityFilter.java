package com.lt.microservices.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class CustomSecurityFilter extends GenericFilterBean {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        // Do something
        logger.info("Michael - Test doFilter");

        filterChain.doFilter(request, response);
    }
}
