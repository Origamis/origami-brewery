package origamis.springframework.brewery.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import origamis.springframework.brewery.domain.CustomerDto;
import origamis.springframework.brewery.service.CustomerService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable UUID customerId) {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }
}
