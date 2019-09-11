package com.example.codeengine.expensetracker.auth.controllers;

import com.example.codeengine.expensetracker.auth.entities.FxRate;
import com.example.codeengine.expensetracker.auth.repos.FxRateRepository;
import com.example.codeengine.expensetracker.auth.requests.FxRateRequest;
import com.example.codeengine.expensetracker.auth.requests.FxRateUpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class FxRateController {
    private static final Logger LOGGER= LoggerFactory.getLogger(FxRateController.class);
    @Autowired
    FxRateRepository fxRateRepository;
    @PostMapping("/fxRate/save")
    public FxRate addFxRate(@RequestBody FxRateRequest fxRateRequest){
  try{
      LOGGER.info("FXRate controller-> ".concat(fxRateRequest.toString()));
      FxRate fxRate= new FxRate(fxRateRequest.getCurrencyCode(),fxRateRequest.getRate(),fxRateRequest.getTransactionType(),fxRateRequest.getStatus());
      FxRate fxRate1= fxRateRepository.save(fxRate);
      LOGGER.info("FXRate controller-> ".concat(fxRateRequest.toString()).concat("Successs"));
      return fxRate1;
  }
  catch (Exception ex){
      LOGGER.error("FXRate Controller-> ".concat("Error").concat(ex.toString()));
      return null;

  }

    }

    @PostMapping("/fxRate/update")
    public FxRate updateFxRate(@RequestBody FxRateUpdateRequest fxRateUpdateRequest){
        try{
        LOGGER.info("updateFxRate -> ".concat(fxRateUpdateRequest.toString()));
        Optional<FxRate> fxRateOptional = fxRateRepository.findById(fxRateUpdateRequest.getId());
        FxRate fxRate= fxRateOptional.get();
        fxRate.setRate(fxRateUpdateRequest.getRate());
        fxRate.setStatus(fxRateUpdateRequest.getStatus());
        FxRate fxRate1= fxRateRepository.save(fxRate);
        return fxRate1;

        }catch (Exception ex){
            LOGGER.error("updateFxRate ->".concat("Error").concat(ex.toString()));
            return null;
        }
    }
}
