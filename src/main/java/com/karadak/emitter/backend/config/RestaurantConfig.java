package com.karadak.emitter.backend.config;

import com.karadak.emitter.backend.aggregate.RestaurantAggregate;
import com.karadak.emitter.backend.command.RestaurantCommand;
import com.karadak.emitter.backend.service.RestaurantService;
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
