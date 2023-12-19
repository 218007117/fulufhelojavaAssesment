package za.co.etalente.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.etalente.data.enums.InvestmentType;
import za.co.etalente.data.model.Investor;
import za.co.etalente.data.model.Product;
import za.co.etalente.repository.InvestorRepository;
import za.co.etalente.data.payload.request.InvestorRequest;
import za.co.etalente.data.payload.response.ValidationErrorResponse;
import za.co.etalente.data.payload.response.WithdrawalResponse;
import za.co.etalente.service.WithdrawalService;

import java.util.List;

import static java.lang.Double.compare;

@RestController
@RequestMapping("/investor")
public class InvestorController {

    private final InvestorRepository investorRepository;
    private final WithdrawalService withdrawalService;

    public InvestorController(final InvestorRepository investorRepository, final WithdrawalService withdrawalService) {
        this.investorRepository = investorRepository;
        this.withdrawalService = withdrawalService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Investor>> findAllInvestors() {
        return ResponseEntity.ok(investorRepository.findAll());
    }

    @PutMapping("/{investorId}/withdraw/{productId}")
    public ResponseEntity withdraw(@PathVariable Integer investorId, @PathVariable Integer productId,
                                   @RequestBody final InvestorRequest investorRequest) {
        WithdrawalResponse withdrawalResponse = new WithdrawalResponse();
        Investor investor = investorRepository.findById(investorId).orElse(null);
        if (investor != null) {
            for (Product product : investor.getProducts()) {
                if (product.getProductId().equals(productId)
                        && product.getProductType().equals(InvestmentType.SAVINGS.toString())) { //enum
                   if(compare(product.getCurrentBalance(), investorRequest.getWithdrawalAmount()) < 0){
                       return ResponseEntity.ok(
                               new ValidationErrorResponse("WITHDRAWAL AMOUNT cannot be greater than current BALANCE"));
                   }
                    withdrawalResponse = withdrawalService.getClosingBalance(investorRequest, product);
                    break;
                } else if (product.getProductId().equals(productId) && product.getProductType().equals(InvestmentType.RETIREMENT.toString())) {
                     if(investor.getAge() <= 65)
                     {
                         return ResponseEntity.ok(
                                 new ValidationErrorResponse("YOU MUST be older that 65 yrs for " + "this Withdrawal"));
                     }
                    if(compare(product.getCurrentBalance(), investorRequest.getWithdrawalAmount()) < 0){
                        return ResponseEntity.ok(
                                new ValidationErrorResponse("WITHDRAWAL AMOUNT cannot be greater than current BALANCE"));
                    }
                    withdrawalResponse = withdrawalService.getClosingBalance(investorRequest, product);
                    break;
                }
            }
            investorRepository.save(investor);
            return ResponseEntity.ok(withdrawalResponse);
        }
       return ResponseEntity.ok(new ValidationErrorResponse("INVESTOR NOT FOUND"));
    }

}
