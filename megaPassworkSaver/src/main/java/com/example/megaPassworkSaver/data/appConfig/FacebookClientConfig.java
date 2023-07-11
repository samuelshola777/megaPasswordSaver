package com.example.megaPassworkSaver.data.appConfig;

import facebook4j.conf.ConfigurationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class FacebookClientConfig {



    private static final String FACEBOOK_APP_ID ;
    private static final String APP_SECRET = "YOUR_APP_SECRET";
    private static final String ACCESS_TOKEN = "YOUR_ACCESS_TOKEN";

    public static Configuration getConfiguration() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthAppId(APP_ID);
        configurationBuilder.setOAuthAppSecret(APP_SECRET);
        configurationBuilder.setOAuthAccessToken(ACCESS_TOKEN);
        configurationBuilder.setUseSSL(true);
        configurationBuilder.setJSONStoreEnabled(true);
        return configurationBuilder.build();
    }


}
