package com.karadak.emitter.backend.aggregate;

import com.karadak.common.event.RestaurantCreatedEvent;
import com.karadak.common.model.CreateRestaurantRequest;
import com.karadak.emitter.backend.command.CreateRestaurantCommand;
import com.karadak.emitter.backend.command.RestaurantCommand;
import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

import java.util.List;

public class RestaurantAggregate extends ReflectiveMutableCommandProcessingAggregate<RestaurantAggregate, RestaurantCommand> {
    private CreateRestaurantRequest restaurantRequest;
    private boolean deleted = false;

    public List<Event> process(CreateRestaurantCommand createRestaurantCommand) {
        return EventUtil.events(new RestaurantCreatedEvent(createRestaurantCommand.getCreateRestaurantRequest()));
    }

    public void apply(RestaurantCreatedEvent event) {
        this.restaurantRequest = event.getCreateRestaurantRequest();
    }

    public CreateRestaurantRequest getRestaurantRequest() {
        return restaurantRequest;
    }
}
