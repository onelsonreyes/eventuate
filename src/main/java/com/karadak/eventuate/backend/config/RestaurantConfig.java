package com.karadak.eventuate.backend.config;

import com.karadak.eventuate.backend.aggregate.RestaurantAggregate;
import com.karadak.eventuate.backend.command.RestaurantCommand;
import com.karadak.eventuate.backend.service.RestaurantService;
import io.eventuate.AggregateRepository;
import io.eventuate.EventuateAggregateStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class RestaurantConfig {

    @Bean
    public AggregateRepository<RestaurantAggregate, RestaurantCommand> restaurantAggregateRestaurantCommandAggregateRepository(EventuateAggregateStore eventStore) {
        return new AggregateRepository<>(RestaurantAggregate.class, eventStore);
    }

    @Bean
    public RestaurantService restaurantService(AggregateRepository<RestaurantAggregate, RestaurantCommand> aggregateRepository) {
        return new RestaurantService(aggregateRepository);
    }
}
