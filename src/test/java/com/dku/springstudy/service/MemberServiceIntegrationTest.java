package com.dku.springstudy.service;

import com.dku.springstudy.model.Member;
import com.dku.springstudy.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @DisplayName("회원가입 테스트")
    @Test
    void joinTest() {
        Member member = new Member();
        member.setEmail("testets123@google.com");
        member.setPassword("123123");
        member.setNickname("testestrqe");

        String memberEmail = memberService.join(member);

        Member foundMember = memberRepository.findByEmail(memberEmail).get();
        System.out.println(foundMember.getEmail());
        System.out.println(memberEmail);
        assertThat(foundMember.getEmail()).isEqualTo(memberEmail);
    }
}