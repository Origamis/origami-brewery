package origamis.springframework.brewery.service.impl;

import org.springframework.stereotype.Service;
import origamis.springframework.brewery.domain.CustomerDto;
import origamis.springframework.brewery.service.CustomerService;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Customer")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public CustomerDto updateCustomer(UUID customerId, CustomerDto customerDto) {
        return null;
    }

    @Override
    public void deleteCustomerById(UUID customerId) {

    }
}
