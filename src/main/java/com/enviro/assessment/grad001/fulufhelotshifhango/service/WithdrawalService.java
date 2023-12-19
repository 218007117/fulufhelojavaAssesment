package com.enviro.assessment.grad001.fulufhelotshifhango.service;

import com.enviro.assessment.grad001.fulufhelotshifhango.data.model.Product;
import com.enviro.assessment.grad001.fulufhelotshifhango.data.payload.request.InvestorRequest;
import com.enviro.assessment.grad001.fulufhelotshifhango.data.payload.response.WithdrawalResponse;

public interface WithdrawalService {

    WithdrawalResponse getClosingBalance(InvestorRequest investorRequest, Product product);
    Double withdrawTransaction(double currentBalance, Double withdrawalAmount);
}
