package com.example.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws IOException, ServletException {
        
        JsonObject loginResult = new JsonObject();
        PrintWriter pw = res.getWriter();
        String resultCd = ""
            , resultMsg = ""
        ;

        if ( e instanceof UsernameNotFoundException ) {
            resultCd = "99";
            resultMsg = "존재하지 않는 아이디입니다~";
        } else if (e instanceof BadCredentialsException) {
            resultCd = "98";
            resultMsg = "올바른 비밀번호가 아닙니다~";
        } else if (e instanceof DisabledException) {
            resultCd = "97";
            resultMsg = "비활성화 된 계정입니다. 관리자에게 문의주세요~";
        } else {
            resultCd = "99";
            resultMsg = "";
            log.error(e.getMessage());
        }

        res.setHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        loginResult.addProperty("resultCode", resultCd);
		loginResult.addProperty("resultMessage", resultMsg);
        pw.write(loginResult.toString());
        pw.close();
    }

}
