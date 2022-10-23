package com.elton.SpringAOP;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//spring pure java configuration
@Configuration
//spring AOP proxy support
@EnableAspectJAutoProxy
//component scan
@ComponentScan("com.elton.SpringAOP")
public class DemoConfig {
}
