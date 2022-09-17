package com.aop.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.aop","com.aop.aspect"})
@EnableAspectJAutoProxy
public class JavaConfig {

}
