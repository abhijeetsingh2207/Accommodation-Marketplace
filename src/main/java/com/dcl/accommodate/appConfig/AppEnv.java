package com.dcl.accommodate.appConfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "app")
public class AppEnv {
    private Jwt jwt;

    @Getter
    @Setter
    public static  class Jwt{
        private String secret;
    }
}
