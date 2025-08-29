package com.hackerrank.tradingplatform.service;

import com.hackerrank.tradingplatform.dto.AddMoneyTraderDTO;
import com.hackerrank.tradingplatform.dto.TraderDTO;
import com.hackerrank.tradingplatform.dto.UpdateTraderDTO;
import com.hackerrank.tradingplatform.model.Trader;
import com.hackerrank.tradingplatform.repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TraderService {
    @Autowired
    private TraderRepository traderRepository;

    public Trader registerTrader(Trader trader) {
        return traderRepository.save(trader);
    }

    public Trader getTraderById(Long id) {
        return traderRepository.findById(id).get();
    }

    public Optional<Trader> getTraderByEmail(String email) {
        //return traderRepository.findByEmail(email).orElse(new Trader());
        return traderRepository.findByEmail(email);
    }

    public List<Trader> getAllTraders() {
        return traderRepository.findAll();
    }

    public Trader updateTrader(UpdateTraderDTO trader) {
         Trader existingTrader = traderRepository.findByEmail(trader.getEmail()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
         
         existingTrader.setName(trader.getName());

        return traderRepository.save(existingTrader);
    }

    public Trader addMoney(AddMoneyTraderDTO trader) {
        Trader existingTrader = traderRepository.findByEmail(trader.getEmail()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        double balance = existingTrader.getBalance();
        existingTrader.setBalance(balance + trader.getAmount());

        return traderRepository.save(existingTrader);
    }
}
