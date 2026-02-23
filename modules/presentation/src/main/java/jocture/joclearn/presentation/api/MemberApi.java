package jocture.joclearn.presentation.api;

import org.springframework.web.bind.annotation.*;
import jocture.joclearn.application.member.data.dto.MemberJoinRequest;
import jocture.joclearn.application.member.service.MemberReader;
import jocture.joclearn.application.member.service.MemberWriter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberApi {

    private final MemberReader memberReader;
    private final MemberWriter memberWriter;

    /** 회원 목록 조회 */
    @GetMapping
    public void getMembers() {
        //TODO
    }

    /** 특정 회원 조회 */
    @GetMapping("/{memberId}")
    //@GetMapping("/me")
    public void getMember() {
        //TODO
    }

    /** 회원 가입 */
    @PostMapping
    public void joinMember(MemberJoinRequest request) {
        memberWriter.joinMember2(request);
    }

    /** 회원정보 수정 */
    @PutMapping("/{memberId}")
    //@PutMapping("/me")
    public void updateMember() {
        //TODO
    }

    /** 회원 탈퇴 */
    @DeleteMapping("/{memberId}")
    //@DeleteMapping("/me")
    public void leaveMember() {
        //TODO
    }
}
