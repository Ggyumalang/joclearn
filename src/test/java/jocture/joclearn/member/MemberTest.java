package jocture.joclearn.member;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemberTest {

    @Test
    void member() {
        Member member = new Member("khg5087", "khg5087@naver.com", "abcd1234");
        assertThat(member.getStatus()).isEqualTo(MemberStatus.STANDBY);
    }
}