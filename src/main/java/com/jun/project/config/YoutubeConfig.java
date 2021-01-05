package com.jun.project.config;

import com.jun.project.process.TargetURL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YoutubeConfig {

    @Bean
    public TargetURL targetURL() {
        return new TargetURL();
    }

    // controller was automatically configured by spring boot
}
