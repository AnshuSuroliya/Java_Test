package com.gangawing.ucount.creditworthiness.service;

import com.gangawing.ucount.creditworthiness.dto.WorkFlowStatusDTO;
import com.gangawing.ucount.creditworthiness.dto.WorkFlowSubmitDTO;

public class WorkFlowService {

    public static WorkFlowStatusDTO getStatusByOrgId(String orgId) {
        WorkFlowStatusDTO workFlowStatusDTO = new WorkFlowStatusDTO();
        workFlowStatusDTO.setOrgId(orgId);
        return workFlowStatusDTO;
    }

    public static WorkFlowStatusDTO submit(WorkFlowSubmitDTO workFlowSubmitDTO) {
        WorkFlowStatusDTO workFlowStatusDTO = new WorkFlowStatusDTO();
        workFlowStatusDTO.setOrgId(workFlowSubmitDTO.getOrgId());
        return workFlowStatusDTO;
    }
}
