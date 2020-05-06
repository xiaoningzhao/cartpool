package edu.sjsu.cmpe275.cartpool.cartpool.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.sjsu.cmpe275.cartpool.cartpool.exceptions.ResponseBody;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        ResponseBody exceptionBody = new ResponseBody(LocalDateTime.now().toString(),HttpServletResponse.SC_FORBIDDEN,"Access Denied", e.getMessage());
        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(exceptionBody));
    }
}
