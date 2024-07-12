package org.example.ch15.config.handle;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("登入成功");
        out.close();
    }
    /**
     * There are two ways to handle the success of authentication:
     * 1. Default method which doesn't need to be overridden.
     * 2. Custom method which needs to be overridden.
     */
}
