package com.Mehdi.SheypoorApp.modules.architecture;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmsRequest implements Serializable {
    private String    username;
    private String	  password;
    private String    to;
    private String    from;
    private String    text;
    private Boolean   isFlash;
}
