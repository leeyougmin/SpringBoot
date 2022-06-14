package com.example.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.common.Url;
import com.example.entity.UserInfo;
import com.example.service.CommonSerivce;
import com.google.gson.JsonObject;

@Component
public class LoginSuccesHandler implements AuthenticationSuccessHandler {

    @Autowired
    CommonSerivce commonSerivce;

    @Override
    public void onAuthenticationSuccess( HttpServletRequest req , HttpServletResponse res , Authentication auth ) throws IOException, ServletException {

        UserInfo userInfo = (UserInfo) auth.getPrincipal();
        JsonObject loginResult = new JsonObject();
        PrintWriter pw = res.getWriter();
        String resultCd = "00";

        try {
            commonSerivce.setLogInAccesLog(userInfo);   // Logging Login Access Log
            loginResult.addProperty("targetUrl", Url.MAIN.MAIN);
            loginResult.addProperty("resultCd", resultCd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Response JSON type
        res.setHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        pw.write(loginResult.toString());
        pw.close();
        // new PrintWriter( res.getWriter() )
        //     .write( loginResult.toString() )
        // ;
    }
    
}
