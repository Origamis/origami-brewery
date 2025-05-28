package origamis.springframework.brewery.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import origamis.springframework.brewery.domain.BeerDto;
import origamis.springframework.brewery.service.BeerService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer/")
@AllArgsConstructor
@Slf4j
public class BeerController {
    
    private final BeerService beerService;
    
    @GetMapping("{beerId}")
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

    @PutMapping("{beerId}")
    public ResponseEntity<Void> updateBeer(@PathVariable UUID beerId, @RequestBody BeerDto beerDto) {

        beerService.updateBeer(beerId, beerDto);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeerById(@PathVariable UUID beerId) {
        log.info("Deleting beer with id {}", beerId);
        beerService.deleteBeerById(beerId);
    }
}
