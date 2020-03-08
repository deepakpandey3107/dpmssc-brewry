package com.dp.micro.brewry.dpmsscbrewry.web.controller;

import com.dp.micro.brewry.dpmsscbrewry.service.BeerService;
import com.dp.micro.brewry.dpmsscbrewry.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RequestMapping("/api/v1/beers")
@RestController
public class BeerController {

    private BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId) {
        BeerDto beerDto = beerService.getBeerById(beerId);
        return new ResponseEntity<>(beerDto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Void> createBeer(@RequestBody BeerDto beerDto) {
        BeerDto newBeer = beerService.saveNew(beerDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{beerId}").buildAndExpand(newBeer.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<Void> updateBeer(@PathVariable UUID beerId, @RequestBody BeerDto beerDto) {
        BeerDto updatedBeer = beerService.update(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId){
        beerService.delete(beerId);
    }
}