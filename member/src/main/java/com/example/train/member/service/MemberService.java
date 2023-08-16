package com.example.train.member.service;

import cn.hutool.core.collection.CollUtil;
import com.example.train.common.exception.BusinessException;
import com.example.train.common.exception.BusinessExceptionEnum;
import com.example.train.member.domain.Member;
import com.example.train.member.domain.MemberExample;
import com.example.train.member.mapper.MemberMapper;
import com.example.train.member.req.MemberRegisterReq;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;

    public int count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }
    public long register(MemberRegisterReq req){
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);//createCriteria()用于创造条件
        List<Member> list = memberMapper.selectByExample(memberExample);
        if(CollUtil.isNotEmpty(list)){    //Hutool库的工具类
            //return list.get(0).getId();
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }
        Member member = new Member();
        member.setId(System.currentTimeMillis());//系统时间戳
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }
}
