package origamis.springframework.brewery.mappers;

import org.mapstruct.Mapper;
import origamis.springframework.brewery.domain.Beer;
import origamis.springframework.brewery.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto toDto(Beer beer);

    Beer toEntity(BeerDto beerDto);
}
