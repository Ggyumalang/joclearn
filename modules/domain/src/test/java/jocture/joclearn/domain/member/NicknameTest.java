package jocture.joclearn.domain.member;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NicknameTest {

    @Test
    void create() {
        Nickname nickname = new Nickname("jocture");
        assertThat(nickname.value()).isEqualTo("jocture");
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "JJ", "Lim", "123456789012345678901",
        ".jocture", "_jocture", "-jocture",
        "jocture*", "joc ture"
    })
    void create_fail(String value) {
        assertThatThrownBy(() -> new Nickname(value))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
