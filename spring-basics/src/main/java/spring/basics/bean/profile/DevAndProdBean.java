package spring.basics.bean.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@DevAndProdProfile
public class DevAndProdBean {
}
