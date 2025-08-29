package com.hackerrank.tradingplatform.controller;

import com.hackerrank.tradingplatform.dto.AddMoneyTraderDTO;
import com.hackerrank.tradingplatform.dto.TraderDTO;
import com.hackerrank.tradingplatform.dto.UpdateTraderDTO;
import com.hackerrank.tradingplatform.model.Trader;
import com.hackerrank.tradingplatform.service.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(value = "/trading/traders")
public class TraderController {
    @Autowired
    private TraderService traderService;

    //register
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Trader> registerTrader(@RequestBody @Valid Trader trader) {
        
        Optional<Trader> existingTrader = traderService.getTraderByEmail(trader.getEmail());

        if(existingTrader.isPresent()){ //we found same email in db
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            //    .body(null);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }else{
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(traderService.registerTrader(trader));
        }
    }

    //get by email
    @RequestMapping(method = RequestMethod.GET)
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TraderDTO> getTraderByEmail(@RequestParam("email") String email) {
        Optional<Trader> existingTrader = traderService.getTraderByEmail(email);

        Trader existingEntity = traderService.getTraderByEmail(email).orElse(null);


        if(existingTrader.isPresent()){
           // return ResponseEntity.status(HttpStatus.OK)
           // .body(new TraderDTO(traderService.getTraderByEmail//(email)));
           return ResponseEntity.ok(new TraderDTO(existingEntity));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(null);
        }
    }

    //get all
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    //@ResponseStatus(HttpStatus.OK)
    public List<TraderDTO> getAllTraders() {
        return traderService.getAllTraders()
                .stream()
                .map(TraderDTO::new)
                .collect(toList());
    }

    //update by email
    @RequestMapping(method = RequestMethod.PUT)
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Trader> updateTrader(@RequestBody @Valid UpdateTraderDTO trader) {

        return ResponseEntity.ok(traderService.updateTrader(trader));
    }

    //add money
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Trader> addMoney(@RequestBody @Valid AddMoneyTraderDTO trader) {
        Trader existingTrader = traderService.
            addMoney(trader);

           return ResponseEntity.ok(existingTrader);

    }   
}
