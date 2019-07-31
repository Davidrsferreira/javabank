package org.academiadecodigo.javabank.controller.rest;

import org.academiadecodigo.javabank.command.AccountDto;
import org.academiadecodigo.javabank.command.CustomerDto;
import org.academiadecodigo.javabank.converters.AccountToAccountDto;
import org.academiadecodigo.javabank.converters.CustomerDtoToCustomer;
import org.academiadecodigo.javabank.converters.CustomerToCustomerDto;
import org.academiadecodigo.javabank.exceptions.CustomerNotFoundException;
import org.academiadecodigo.javabank.exceptions.JavaBankException;
import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.persistence.model.account.Account;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerRestController {

    private CustomerService customerService;
    private CustomerToCustomerDto customerToCustomerDto;
    private AccountToAccountDto accountToAccountDto;
    private CustomerDtoToCustomer customerDtoToCustomer;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setCustomerToCustomerDto(CustomerToCustomerDto customerToCustomerDto) {
        this.customerToCustomerDto = customerToCustomerDto;
    }

    @Autowired
    public void setAccountToAccountDto(AccountToAccountDto accountToAccountDto) {
        this.accountToAccountDto = accountToAccountDto;
    }

    @Autowired
    public void setCustomerDtoToCustomer(CustomerDtoToCustomer customerDtoToCustomer) {
        this.customerDtoToCustomer = customerDtoToCustomer;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "api/customer/{id}"
    )
    public ResponseEntity<CustomerDto> findByIdRest(@PathVariable Integer id) throws CustomerNotFoundException {

        Customer customer = customerService.get(id);

        return new ResponseEntity<>(customerToCustomerDto.convert(customer), HttpStatus.OK);

    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = {"api/customer/list", "api/customer/", "api/customer"}
    )
    public ResponseEntity<List<CustomerDto>> findAllRest() throws JavaBankException {

        List<Customer> customers = customerService.list();

        return new ResponseEntity<>(customerToCustomerDto.convert(customers), HttpStatus.OK);

    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = {"api/customer/{id}/account", "api/customer/{id}/account/"}
    )
    public ResponseEntity<List<AccountDto>> findAllAccountRest(@PathVariable Integer id) throws JavaBankException {

        List<Account> accounts = customerService.get(id).getAccounts();

        return new ResponseEntity<>(accountToAccountDto.convert(accounts), HttpStatus.OK);

    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = {"api/customer/{cid}/account/{aid}"}
    )
    public ResponseEntity<AccountDto> findAllAccountRest(@PathVariable Integer cid, @PathVariable Integer aid) throws JavaBankException {

        List<Account> accounts = customerService.get(cid).getAccounts();
        Account account = null;

        for (Account a : accounts) {
            if (a.getId() == aid) {
                account = a;
            }
        }

        return new ResponseEntity<>(accountToAccountDto.convert(account), HttpStatus.OK);

    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = {"api/customer/", "api/customer"},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity saveCustomerRest(
            @Valid @RequestBody CustomerDto customerDto,
            BindingResult bindingResult) throws CustomerNotFoundException {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        customerService.save(customerDtoToCustomer.convert(customerDto));

        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = {"api/customer/{id}"},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity editCustomerRest(
            @Valid @RequestBody CustomerDto customerDto,
            BindingResult bindingResult) throws CustomerNotFoundException {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Customer customer = customerService.get(customerDto.getId());

        if (customer == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());

        customerService.save(customerDtoToCustomer.convert(customerDto));

        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = {"api/customer/{id}"}
    )
    public ResponseEntity deleteRest(@PathVariable Integer id) throws JavaBankException {

        if (customerService.get(id) == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        customerService.delete(id);

        return new ResponseEntity(HttpStatus.OK);

    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value =  {"api/customer/{cid}/account/{aid}"}
    )
    public ResponseEntity deleteAccountByIdRest(@PathVariable Integer cid, @PathVariable Integer aid) throws JavaBankException {

        Customer customer = customerService.get(cid);

        if (customer == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }



        for (Account a : customer.getAccounts()) {
            if (a.getId() == aid) {
                customer.getAccounts().remove(a);
            }
        }

        customerService.save(customer);

        return new ResponseEntity(HttpStatus.OK);

    }
}
