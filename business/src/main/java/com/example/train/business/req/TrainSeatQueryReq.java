package com.example.train.business.req;

import com.example.train.common.req.PageReq;
import lombok.Data;

@Data
public class TrainSeatQueryReq extends PageReq {
    private String trainCode;
}