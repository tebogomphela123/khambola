package tebogo.khula.khambola.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tebogo.khula.khambola.dto.CreateAccount;
import tebogo.khula.khambola.entity.Account;
import tebogo.khula.khambola.repository.AccountRepository;


@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public Account saveAccount(CreateAccount userAccount){
        Account account = Account.build(
                                        0,
                                        userAccount.getFirstName(),
                                        userAccount.getLastName(),
                                        userAccount.getAge());
        return repository.save(account);
    }

    public List<Account> getAllAccount(){
        return repository.findAll();
    }

    public Optional<Account> getAccount(int id){
        return repository.findById(id);
    }


}
