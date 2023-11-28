package com.example.securingweb.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import java.io.IOException;

public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    public CustomLoginSuccessHandler(String defaultTargetUrl) {
        // SavedRequestAwareAuthenticationSuccessHandler#setDefaultTargetUrl()
        // 로그인후 특별히 redirect 할 url 이 없는경우 기본적으로 redirect 할 url
        setDefaultTargetUrl(defaultTargetUrl);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
//        스프링시큐리티가 세션에 담아준 정보들을 가져오는 방법
//        MemberDetails memberDetails = (MemberDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Cookie cookie = new Cookie("test","hello");
        cookie.setMaxAge(60);
        response.addCookie(cookie);

        super.onAuthenticationSuccess(request, response, authentication);
    }


}
