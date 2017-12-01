package com.karadak.emitter.backend.service;

import com.karadak.common.model.CreateRestaurantRequest;
import com.karadak.emitter.backend.aggregate.RestaurantAggregate;
import com.karadak.emitter.backend.command.CreateRestaurantCommand;
import com.karadak.emitter.backend.command.RestaurantCommand;
import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;

import java.util.concurrent.CompletableFuture;

public class RestaurantService {
    private final AggregateRepository<RestaurantAggregate, RestaurantCommand> repository;

    public RestaurantService(AggregateRepository<RestaurantAggregate, RestaurantCommand> repository) {
        this.repository = repository;
    }

    public CompletableFuture<EntityWithIdAndVersion<RestaurantAggregate>> createRestaurant(CreateRestaurantRequest createRestaurantRequest) {
        return repository.save(new CreateRestaurantCommand(createRestaurantRequest));
    }
}
