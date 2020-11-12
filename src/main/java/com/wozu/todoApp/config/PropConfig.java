package com.wozu.todoApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@PropertySource("/secret/properties")
@Configuration
public class PropConfig {

    @Autowired
    Environment env;


}
