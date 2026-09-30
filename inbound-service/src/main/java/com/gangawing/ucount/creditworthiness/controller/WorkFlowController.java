package com.gangawing.ucount.creditworthiness.controller;

import com.gangawing.ucount.creditworthiness.dto.WorkFlowStatusDTO;
import com.gangawing.ucount.creditworthiness.dto.WorkFlowSubmitDTO;
import com.gangawing.ucount.creditworthiness.service.WorkFlowService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "WorkFlow")
public class WorkFlowController {

    @GetMapping(value = "/status/{orgId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody WorkFlowStatusDTO getWorkFlowStatus(@PathVariable String orgId) {
        return WorkFlowService.getStatusByOrgId(orgId);
    }

    @PostMapping(value = "/submit", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody WorkFlowStatusDTO submitWorkFlow(@RequestBody WorkFlowSubmitDTO workFlowSubmitDTO) {
        return WorkFlowService.submit(workFlowSubmitDTO);
    }
}
