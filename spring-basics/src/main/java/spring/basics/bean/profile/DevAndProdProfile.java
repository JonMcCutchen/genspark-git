package spring.basics.bean.profile;

import org.springframework.context.annotation.Profile;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Profile("dev & prod")
@Retention(RetentionPolicy.RUNTIME)
public @interface DevAndProdProfile {
}
