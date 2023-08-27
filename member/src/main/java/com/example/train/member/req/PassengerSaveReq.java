package com.example.train.member.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;
@Data
public class PassengerSaveReq {
    private Long id;
//    @NotNull(message="会员ID不能为空")

    private Long memberId;
    @NotBlank(message="旅客不能为空")
    private String name;
    @NotBlank(message="身份证号不能为空")
    private String idCard;
    @NotBlank(message="旅客类型不能为空")
    private String type;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

}