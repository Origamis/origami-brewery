package origamis.springframework.brewery.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import origamis.springframework.brewery.domain.BeerDto;
import origamis.springframework.brewery.service.BeerService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
@AllArgsConstructor
public class BeerController {
    
    private final BeerService beerService;
    
    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {
        return ResponseEntity.ok(beerService.getBeerById(beerId));
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveBeer(@RequestBody BeerDto beerDto) {
        
        var savedBeer = beerService.saveBeer(beerDto);
        
        var httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());
        
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDto> updateBeer(@PathVariable UUID beerId, @RequestBody BeerDto beerDto) {

        beerService.updateBeer(beerId, beerDto);
        return ResponseEntity.noContent().build();
    }
}
