package com.lyz.home.entity.resp;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class RespEntity {

    private boolean success;

    private String message;

    private Object data;
}
