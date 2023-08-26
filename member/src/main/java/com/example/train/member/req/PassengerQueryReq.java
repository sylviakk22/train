package com.example.train.member.req;

import com.example.train.common.req.PageReq;
import lombok.Data;

@Data
public class PassengerQueryReq extends PageReq {
    private Long memberId;

}