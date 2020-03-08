package com.dp.micro.brewry.dpmsscbrewry.service;

import com.dp.micro.brewry.dpmsscbrewry.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID id);
    BeerDto saveNew(BeerDto beerDto);

    BeerDto update(UUID id, BeerDto beerDto);

    void delete(UUID id);
}
