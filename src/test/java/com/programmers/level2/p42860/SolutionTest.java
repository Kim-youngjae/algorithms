package com.programmers.level2.p42860;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SolutionTest {

    @BeforeAll
    void beforeAll() {
        Solution.isDebug = true;
    }

    @Test
    @DisplayName("BAA -> 1")
    void t001() {
        assertThat(
                new Solution().solution("BAA")
        ).isEqualTo(1);
    }

    @Test
    @DisplayName("CAA -> 2")
    void t002() {
        assertThat(
                new Solution().solution("CAA")).isEqualTo(2);
    }

    @Test
    @DisplayName("BBA -> 3")
    void t003() {
        assertThat(new Solution().solution("BBA")).isEqualTo(3);
    }

    @Test
    @DisplayName("ZBA -> 3")
    void t004() {
        assertThat(new Solution().solution("ZBA")
        ).isEqualTo(3);
    }

    @Test
    @DisplayName("ZBAAAA")
    void t005() {

        assertThat(
                new Solution().solution("ZBAAA")
        ).isEqualTo(3);
    }

    @Test
    @DisplayName("ZBAAAB")
    void t006() {

        assertThat(
                new Solution().solution("ZBAAA")
        ).isEqualTo(3);
    }
}