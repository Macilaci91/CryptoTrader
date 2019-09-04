package com.example.CryptoSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WallettCtrl {
    @Autowired
    private WallettRepo wallettRepo;
    @Autowired
    private CryptoRepo cryptoRepo;

    @GetMapping("/getWallettAll")
    @ResponseBody
    public Iterable<Wallett> getCsoportAll(){
        return wallettRepo.findAll();
    }

    @GetMapping("/buy")
    @ResponseBody
    public String buy(@RequestParam String name,@RequestParam float amount){
        float value = cryptoRepo.selectValue(name).getValue();
        float dollar = wallettRepo.selectAmount("USD").getQuantity();
        float price = amount*value;
        Wallett setDollar = wallettRepo.findById("USD").get();
        if(price < dollar) {
            if (wallettRepo.countName(name) == 0) {
                Wallett newBuy = new Wallett(name, amount, value);
                wallettRepo.save(newBuy);
                setDollar.setQuantity(dollar - price);
                wallettRepo.save(setDollar);
                return "Succesfully buy " + amount + " " + name + " for " + amount * value + " dollar";
            } else {
                Wallett wallettDb = wallettRepo.findById(name).get();
                float quantity = wallettRepo.selectAmount(name).getQuantity();
                wallettDb.setQuantity(quantity + amount);
                setDollar.setQuantity(dollar - price);
                wallettRepo.save(wallettDb);
                wallettRepo.save(setDollar);
                return "Succesfully buy " + amount + " " + name + " for " + amount * value + " dollar! " + "You have " + (amount + quantity) + " " + name + "!";
            }
        } else {
            return "You don't have enough money";
        }
    }
    @GetMapping("/sell")
    @ResponseBody
    public String sell(@RequestParam String name,@RequestParam float amount){
        float quantity = wallettRepo.selectAmount(name).getQuantity();
        float dollar = wallettRepo.selectAmount("USD").getQuantity();
        float value = cryptoRepo.selectValue(name).getValue();
        float price = amount*value;
        Wallett setDollar = wallettRepo.findById("USD").get();
        if(quantity - amount == 0){
            wallettRepo.deleteById(name);
            setDollar.setQuantity(dollar + price);
            wallettRepo.save(setDollar);
            return ("Succesfully sell " + amount + " " + name + " for " + amount * value + " dollar");
        } else if(quantity - amount > 0) {
            Wallett cryptoDb = wallettRepo.findById(name).get();
            cryptoDb.setQuantity(quantity - amount);
            setDollar.setQuantity(dollar + price);
            wallettRepo.save(cryptoDb);
            wallettRepo.save(setDollar);
            return  ("Succesfully sell " + amount + " " + name + " for " + amount * value + " dollar! " + "You have " + (quantity-amount) + " " + name + " left");
        } else {
            return "You don't have enough crypto!";
        }
    }
}
