package origamis.springframework.brewery.service.impl;

import org.springframework.stereotype.Service;
import origamis.springframework.brewery.model.BeerDto;
import origamis.springframework.brewery.service.BeerService;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Corona")
                .beerStyle("Lager")
                .build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        return null;
    }

    @Override
    public void deleteBeerById(UUID beerId) {

    }
}