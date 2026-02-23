package jocture.joclearn.application.member.data.dto;

import jocture.joclearn.domain.member.Member;
import jocture.joclearn.domain.member.MemberStatus;

public record MemberResponse(
    int memberId,
    String nickname,
    String email,
    MemberStatus status
) {

    public static MemberResponse of(Member member) {
        return new MemberResponse(
            member.getId(),
            member.getNickname().value(),
            member.getEmail().value(),
            member.getStatus());
    }
}
