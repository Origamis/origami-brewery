package origamis.springframework.brewery.service;

import origamis.springframework.brewery.domain.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID customerId);
}
