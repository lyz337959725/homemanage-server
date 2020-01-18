package com.lyz.home.entity.resp.statistics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FinanceByMonthResp {

    private String months;

    private BigDecimal spendAmount;

    private BigDecimal incomeAmount;
}
