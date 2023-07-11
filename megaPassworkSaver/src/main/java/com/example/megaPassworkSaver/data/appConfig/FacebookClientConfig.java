package com.example.megaPassworkSaver.data.appConfig;

import facebook4j.conf.ConfigurationBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class FacebookClientConfig {


@Value("${facebook_app_id}")
    private static   String FACEBOOK_APP_ID ;

    @Value("${facebook_app_secret}")
    private static  String FACEBOOK_APP_SECRET ;
    private static final String ACCESS_TOKEN = "YOUR_ACCESS_TOKEN";

    public static Configuration getConfiguration() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthAppId(FACEBOOK_APP_ID);
        configurationBuilder.setOAuthAppSecret(FACEBOOK_APP_SECRET);
        configurationBuilder.setOAuthAccessToken(ACCESS_TOKEN);
        configurationBuilder.setUseSSL(true);
        configurationBuilder.setJSONStoreEnabled(true);
        return configurationBuilder.build();
    }


}
