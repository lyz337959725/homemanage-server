package com.lyz.home.entity.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class BillDto {

    private String word;
    private int person;
    private int type;
    private int book;
    private int size;
    private int page;
}
