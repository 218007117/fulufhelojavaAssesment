package za.co.etalente.service.impl;

import org.springframework.stereotype.Service;
import za.co.etalente.data.model.Product;
import za.co.etalente.data.payload.request.InvestorRequest;
import za.co.etalente.data.payload.response.WithdrawalResponse;
import za.co.etalente.service.WithdrawalService;

import java.util.Calendar;

@Service
public class WithdrawalServiceImpl implements WithdrawalService {


    @Override
    public WithdrawalResponse getClosingBalance(InvestorRequest investorRequest, Product product) {

        double maxAmountAllowed = product.getCurrentBalance() * 0.9;
        Double closing = investorRequest.getWithdrawalAmount() <= maxAmountAllowed ? withdrawTransaction(product.getCurrentBalance(), investorRequest.getWithdrawalAmount()) : 0;
        WithdrawalResponse.WithdrawalResponseBuilder withdrawalResponseBuilder = WithdrawalResponse
                .builder()
                .balanceBeforeWithdrawal(product.getCurrentBalance())
                .closingBalance(closing)
                .date(Calendar.getInstance().getTime())
                .withdrawalAmount(investorRequest.getWithdrawalAmount());

        product.setCurrentBalance(closing);
        return withdrawalResponseBuilder
                .build();
    }

    @Override
    public Double withdrawTransaction(double currentBalance, Double withdrawalAmount) {
        //checks
        return currentBalance - withdrawalAmount;
    }



}
