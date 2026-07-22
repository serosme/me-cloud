package me.shared.mybatisplus;

import com.github.yulichang.autoconfigure.consumer.MybatisPlusJoinPropertiesConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusJoinConfig {
    @Bean
    public MybatisPlusJoinPropertiesConsumer mybatisPlusJoinPropertiesConsumer() {
        return prop -> prop
                .setBanner(false);
    }
}
