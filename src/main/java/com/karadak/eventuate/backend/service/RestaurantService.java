package com.karadak.eventuate.backend.service;

import com.karadak.eventuate.backend.aggregate.RestaurantAggregate;
import com.karadak.eventuate.backend.command.CreateRestaurantCommand;
import com.karadak.eventuate.backend.command.RestaurantCommand;
import com.karadak.eventuate.backend.model.CreateRestaurantRequest;
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
