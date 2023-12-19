package tebogo.khula.khambola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import tebogo.khula.khambola.dto.CreateAccount;
import tebogo.khula.khambola.entity.Account;
import tebogo.khula.khambola.services.AccountService;

@Controller
@RequestMapping("/users")
public class AccountController {
    
    @Autowired
    private AccountService service;

    @PostMapping("/signup")
    public ResponseEntity<Account> saveAccount(@RequestBody @Valid CreateAccount account){
        return new ResponseEntity<>(service.saveAccount(account), HttpStatus.CREATED);
    }

    @GetMapping("/all-account")
    public ResponseEntity<List<Account>> getAllAccount(@RequestBody CreateAccount account){
        return ResponseEntity.ok(service.getAllAccount());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Account>> getAllAccount(@PathVariable int id){
        return ResponseEntity.ok(service.getAccount(id));
    }
}
