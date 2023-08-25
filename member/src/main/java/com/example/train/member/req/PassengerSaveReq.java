package com.example.train.member.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
@Data
public class PassengerSaveReq {
    private Long id;
    @NotNull(message="会员ID不能为空")

    private Long memberId;
    @NotBlank(message="旅客不能为空")

    private String name;
    @NotBlank(message="身份证号不能为空")

    private String idCard;
    @NotBlank(message="旅客类型不能为空")

    private String type;

    private Date createTime;

    private Date updateTime;

}