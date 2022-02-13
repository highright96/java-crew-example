package dev.highright96.springstudy.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("CustomFilter Init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        log.info("CustomFilter DoFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("CustomFilter Destroy");
    }
}
