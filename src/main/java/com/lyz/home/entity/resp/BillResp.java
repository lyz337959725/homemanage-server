package com.lyz.home.entity.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillResp {
    private int id;
    private String typeName;
    private String personName;
    private BigDecimal spend;
    private String spendDate;
    private String content;
    private boolean income;
}
