package spring.basics.bean.callback;

import org.springframework.context.annotation.Bean;

public class CallbackConfig {
    @Bean(initMethod = "beanInit", destroyMethod = "beanDestroy")
    public DemoBean demoBean() {
        return new DemoBean();
    }
}
