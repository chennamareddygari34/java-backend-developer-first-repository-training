package com.weektwo.casestudy.service;
import com.weektwo.casestudy.domain.BankAccount;
import com.weektwo.casestudy.exception.InvalidAmountException;
import com.weektwo.casestudy.repository.BankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Transactional(
        isolation = Isolation.READ_UNCOMMITTED,
        rollbackFor = SQLException.class,
        noRollbackFor = InvalidAmountException.class
)
@Service
public class BankServiceImpl implements BankService {
    private final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);
    @Autowired
    private BankRepository repository;
    @Override
    public void createNewAccount(BankAccount ba) {
        repository.save(ba);
    }

    @Override
    public int updateAccountDetails(BankAccount ba) {
        return  0;
    }

    @Override
    public boolean activateAccount(Long acNum) {
        Optional<BankAccount> op = repository.findById(acNum);
        BankAccount baOld = op.orElseThrow();
        boolean existingstatus = baOld.getStatus();
        boolean newstatus = Boolean.parseBoolean("true");
        BankAccount baNew = new BankAccount();
        baNew.setBalance(baOld.getBalance());
        baNew.setAcCrDt(baOld.getAcCrDt());
        baNew.setStatus(newstatus);
        baNew.setAcHldNm(baOld.getAcHldNm());
        baNew.setAcNum(baOld.getAcNum());
        repository.save(baNew);
        return baNew.getStatus();
    }

    @Override
    public boolean deActivateAccount(Long acNum) {
        Optional<BankAccount> op = repository.findById(acNum);
        BankAccount baOld = op.orElseThrow();
        boolean existingstatus = baOld.getStatus();
        boolean newstatus = Boolean.parseBoolean("false");
        BankAccount baNew = new BankAccount();
        baNew.setBalance(baOld.getBalance());
        baNew.setAcCrDt(baOld.getAcCrDt());
        baNew.setStatus(newstatus);
        baNew.setAcHldNm(baOld.getAcHldNm());
        baNew.setAcNum(baOld.getAcNum());
        repository.save(baNew);
        return baNew.getStatus();
    }

    @Override
    public double withdraw(Long acNum, double amt) {
        if (amt <= 0) throw new InvalidAmountException("Amount Should be Non Zero Positive " + amt);
        Optional<BankAccount> op = repository.findById(acNum);
        BankAccount baOld = op.orElseThrow();
        double existingBalance = baOld.getBalance();
        double newBalance = existingBalance - amt;
        BankAccount baNew = new BankAccount();
        baNew.setBalance(newBalance);
        baNew.setAcCrDt(baOld.getAcCrDt());
        baNew.setStatus(baOld.getStatus());
        baNew.setAcHldNm(baOld.getAcHldNm());
        baNew.setAcNum(baOld.getAcNum());
        repository.save(baNew);
        return baNew.getBalance();
    }


    @Override
    public double deposit(Long acNum, double amt) throws InvalidAmountException {
        // just explanation I am using this strategy
        // it can be done in more efficient way
        if(amt <= 0) throw new InvalidAmountException("Amount Should be Non Zero Positive "+amt);
        Optional<BankAccount> op = repository.findById(acNum);
        BankAccount baOld = op.orElseThrow();
        double existingBalance = baOld.getBalance();
        double newBalance = existingBalance + amt;
        BankAccount baNew = new BankAccount();
        baNew.setBalance(newBalance);
        baNew.setAcCrDt(baOld.getAcCrDt());
        baNew.setStatus(baOld.getStatus());
        baNew.setAcHldNm(baOld.getAcHldNm());
        baNew.setAcNum(baOld.getAcNum());
        repository.save(baNew);
//        withdraw(acNum, 10);
        return baNew.getBalance();
    }

    @Override
    public int transferMoney(Long srcAc, Long dstAc, double amt) throws InvalidAmountException {
        return 0;
    }


    @Override
    public BankAccount findAccountByAcNum(Long acNum) throws InvalidAmountException {
        Optional<BankAccount> op = repository.findById(acNum);
        BankAccount baOld = op.orElseThrow();
//        Long existingacc = baOld.getAcNum();
//        double newacc = ;
//        BankAccount baNew = new BankAccount();
//        baNew.setBalance(baOld.getBalance());
//        baNew.setAcCrDt(baOld.getAcCrDt());
//        baNew.setStatus(baOld.getStatus());
//        baNew.setAcHldNm(baOld.getAcHldNm());
//        baNew.setAcNum(existingacc);
        return repository.save(baOld);
//        return baNew.getAcNum();
    }

    @Override
    public List<BankAccount> findAllBankAccounts() {
        List<BankAccount> op = repository.findAll();
        return op ;
    }



    @Override
    public List<BankAccount> namesStartsWith(String prefix) {
        return repository.findByAcHldNmStartingWith(prefix);
    }
}


