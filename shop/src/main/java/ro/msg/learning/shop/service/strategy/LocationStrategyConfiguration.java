package ro.msg.learning.shop.service.strategy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocationStrategyConfiguration {
    
    @Bean
    public static LocationStrategy chooseLocationStrategy(@Value("${strategy}") String strategy)
    {
        if(strategy.equals("single"))
        {
            return new SingleLocation();
        }else
        if(strategy.equals("abundant"))
        {
            return new MostAbundantStrategy();
        }
        throw new RuntimeException("strategy selection error!");
    }
}