package com.gangawing.ucount.creditworthiness.service;

import com.gangawing.ucount.creditworthiness.dto.UcsCreditRatingLookupDTO;
import com.gangawing.ucount.creditworthiness.dto.UcsCreditworthinessSaveDTO;
import java.util.Optional;

public class CreditworthinessService {

    public static UcsCreditRatingLookupDTO lookupCreditworthiness() {
        return new UcsCreditRatingLookupDTO();
    }

    public static UcsCreditworthinessSaveDTO saveCreditworthiness(
            UcsCreditworthinessSaveDTO ucsCreditworthinessSaveDTO, Optional<String> dryRunFlag) {
        return ucsCreditworthinessSaveDTO;
    }
}
