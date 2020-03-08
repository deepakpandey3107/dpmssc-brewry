package com.dp.micro.brewry.dpmsscbrewry.service;

import com.dp.micro.brewry.dpmsscbrewry.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID id) {
        log.info("Get Beer for : {}", id);
        return BeerDto.builder().id(id).beerName("Corona")
                .beerStyle("Draught").upc(1l).build();
    }

    @Override
    public BeerDto saveNew(BeerDto beerDto) {
        log.info("Saving new Beer with name : {}", beerDto.getBeerName());
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .upc(beerDto.getUpc()).build();
    }

    @Override
    public BeerDto update(UUID id, BeerDto beerDto) {
        log.info("Update Beer for : {}", id);
        return BeerDto.builder()
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .upc(beerDto.getUpc()).build();
    }

    @Override
    public void delete(UUID id) {
        log.info("Deleting Beer for : {}", id);

    }
}
