package com.example.customers_module.controller;

import com.example.customers_module.dto.CustomerDTO;
import com.example.customers_module.entity.CustomerEntity;
import com.example.customers_module.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping({"/customer","/customer/"})
    public CustomerDTO addCustomer(@RequestBody @Valid CustomerDTO customerDTO){
        return customerService.create(customerDTO);
    }

    @PostMapping({"/auth", "/auth/"})
    public CustomerDTO login(@RequestBody @Valid CustomerDTO customerDTO, HttpServletRequest req) throws ServletException {
        req.login(customerDTO.getEmail(), customerDTO.getPassword());

        CustomerEntity user = (CustomerEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomerDTO model = new CustomerDTO();
        model.setEmail(user.getEmail());
        model.setUserId(user.getCustomerId());
        model.setAdmin(user.isAdmin());
        return model;
    }

    @DeleteMapping({"/auth", "/auth/"})
    public String logout(HttpServletRequest req) throws ServletException {
        req.logout();
        return "Uživatel odhlášen";
    }

    @GetMapping({"/auth", "/auth/"})
    public CustomerDTO getCurrentCustomer() throws ServletException {
        try {
            CustomerEntity user = (CustomerEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            CustomerDTO model = new CustomerDTO();
            model.setEmail(user.getEmail());
            model.setUserId(user.getCustomerId());
            model.setAdmin(user.isAdmin());
            return model;
        } catch (ClassCastException e) {
            throw new ServletException();
        }
    }
    @ExceptionHandler(ServletException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void handleServletException() {
    }
}
