package za.co.etalente.service;

import za.co.etalente.data.model.Product;
import za.co.etalente.data.payload.request.InvestorRequest;
import za.co.etalente.data.payload.response.WithdrawalResponse;

public interface WithdrawalService {

    WithdrawalResponse getClosingBalance(InvestorRequest investorRequest, Product product);
    Double withdrawTransaction(double currentBalance, Double withdrawalAmount);
}
