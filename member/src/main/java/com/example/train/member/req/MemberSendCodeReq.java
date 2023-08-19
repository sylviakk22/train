package com.example.train.member.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class MemberSendCodeReq {
    @NotBlank(message="手机号不能为空")
    @Pattern(regexp = "^1\\d{10}$", message = "手机号码格式错误") //正则表达式
    private String mobile;
}
