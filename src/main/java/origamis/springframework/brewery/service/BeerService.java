package origamis.springframework.brewery.service;

import origamis.springframework.brewery.domain.BeerDto;

import java.util.UUID;

public interface BeerService {
    
    BeerDto getBeerById(UUID beerId);

    BeerDto saveBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}