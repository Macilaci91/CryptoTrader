package com.example.CryptoSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CryptoCtrl {
    @Autowired
    private CryptoRepo cryptoRepo;

    @GetMapping("/getCryptoAll")
    @ResponseBody
    public Iterable<Crypto> getCryptoAll(){
        return cryptoRepo.findAll();
    }

    @GetMapping("/update")
    @ResponseBody
    public String update(){
        DataThroughApi apiData = new DataThroughApi();
        List<Crypto> cryptoList = apiData.getMarket_value();
        for (Crypto entry:cryptoList){
            Crypto entryInDb = cryptoRepo.findById(entry.getName()).get();
            entryInDb.setValue(entry.getValue());
            cryptoRepo.save(entryInDb);
        }
        return "Crypto table successfully updated!";

    }


}