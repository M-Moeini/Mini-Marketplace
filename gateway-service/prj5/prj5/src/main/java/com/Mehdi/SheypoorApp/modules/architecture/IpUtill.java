package com.Mehdi.SheypoorApp.modules.architecture;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

public class IpUtill {
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
