package com.mehdi.otp.Utill;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class IPUtill {
    public String getIp() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();
        String ip = request.getRemoteAddr();
        System.out.println("ip1 "+request.getRemoteUser());
        System.out.println("ip2 "+ ip);

        return ip;
    }
}
