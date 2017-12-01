package com.karadak.emitter.backend.controller;

import com.karadak.common.model.CreateRestaurantRequest;
import com.karadak.common.model.CreateRestaurantResponse;
import com.karadak.emitter.backend.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
public class RestaurantController {

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping(value = "/name")
    public String get() {
        return "The name";
    }

    @PostMapping(value = "/restaurants")
    public CompletableFuture<CreateRestaurantResponse> createRestaurant(@RequestBody @Valid CreateRestaurantRequest request) {
        return restaurantService.createRestaurant(request)
                .thenApply(entityAndEventInfo -> new CreateRestaurantResponse(entityAndEventInfo.getEntityId()));
    }
}
