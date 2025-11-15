package jocture.joclearn.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    Member member;
    PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        passwordEncoder = new PasswordEncoder() {
            @Override public String encode(String rawPassword) {
                return rawPassword.toUpperCase();
            }

            @Override public boolean matches(String rawPassword, String encodedPassword) {
                return encode(rawPassword).equals(encodedPassword);
            }
        };
        member = Member.create("hgkim", "hgkim@abc.com", "abcd1234", passwordEncoder);
    }

    @Test
    void create() {
        assertThat(member.getStatus()).isEqualTo(MemberStatus.STANDBY);
    }

    @Test
    void activate() {
        member.activate();
        assertThat(member.getStatus()).isEqualTo(MemberStatus.ACTIVE);
    }

    @Test
    void deactivate() {
        member.deactivate();
        assertThat(member.getStatus()).isEqualTo(MemberStatus.INACTIVE);
    }

    @Test
    void changePassword() {
        String password = "jocture7890";
        member.changePassword(password, passwordEncoder);

        assertThat(member.getPasswordHash()).isEqualTo(password.toUpperCase());
    }

    @Test
    void verifyPassword() {
        String password = "abcd1234";
        boolean result = member.verifyPassword(password, passwordEncoder);

        assertThat(result).isTrue();
    }
}
