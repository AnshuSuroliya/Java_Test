package com.gangawing.ucount.creditworthiness.controller;

import com.gangawing.ucount.creditworthiness.dto.UcsCreditRatingLookupDTO;
import com.gangawing.ucount.creditworthiness.dto.UcsCreditworthinessSaveDTO;
import com.gangawing.ucount.creditworthiness.service.CreditworthinessService;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Creditworthiness")
public class CreditworthinessController {

    @GetMapping(value = "/lookup", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody UcsCreditRatingLookupDTO getAllLookupForCreditworthiness() {
        return CreditworthinessService.lookupCreditworthiness();
    }

    @PostMapping(value = "/save/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody UcsCreditworthinessSaveDTO saveCreditworthinessByorgId(
        @RequestBody UcsCreditworthinessSaveDTO ucsCreditworthinessSaveDTO, Optional.of("false"));
        return CreditworthinessService.saveCreditworthiness(ucsCreditworthinessSaveDTO, Optional.of("false"));
    }
}
