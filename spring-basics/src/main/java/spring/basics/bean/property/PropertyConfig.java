package spring.basics.bean.property;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@PropertySource("bean/app.properties")
public class PropertyConfig {
}
