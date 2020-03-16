package com.lyz.home.entity.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Component
@ConfigurationProperties("wx")
public class WxAuthDto {

    private String appid;

    private String secret;

    private String grant_type = "authorization_code";

    private String js_code;
}
