package dev.highright96.springstudy.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order(2)
@Component
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("LoggingFilter Init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        log.info("request URI : {}", httpServletRequest.getRequestURI());
        log.info("request method : {}", httpServletRequest.getMethod());
        log.info("request host : {}", httpServletRequest.getRemoteAddr());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("LoggingFilter Destroy");
    }
}
