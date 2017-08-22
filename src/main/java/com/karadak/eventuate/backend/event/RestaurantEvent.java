package com.karadak.eventuate.backend.event;

import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "com.karadak.eventuate.backend.aggregate.RestaurantAggregate")
public abstract class RestaurantEvent implements Event {
}
