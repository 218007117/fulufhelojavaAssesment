package com.enviro.assessment.grad001.fulufhelotshifhango.data.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WithdrawalResponse {
    private Double closingBalance;
    private Double withdrawalAmount;
    private Double balanceBeforeWithdrawal;
    private Date date = new Date();
}
