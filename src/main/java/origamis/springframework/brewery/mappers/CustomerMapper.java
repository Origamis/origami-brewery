package origamis.springframework.brewery.mappers;

import org.mapstruct.Mapper;
import origamis.springframework.brewery.domain.Customer;
import origamis.springframework.brewery.model.CustomerDto;

@Mapper
public interface CustomerMapper {
    
    Customer toEntity(CustomerDto customerDto);
    
    CustomerDto toDto(Customer customer);
}