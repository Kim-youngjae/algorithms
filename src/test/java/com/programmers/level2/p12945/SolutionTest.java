package com.programmers.level2.p12945;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    @DisplayName("3 -> 2")
    void t1() {
        assertThat(new Solution().solution(3)).isEqualTo(2);
    }

    @Test
    @DisplayName("5 -> 5")
    void t2() {
        assertThat(new Solution().solution(5)).isEqualTo(5);
    }

    @Test
    @DisplayName("5 -> 5")
    void t3() {
        assertThat(new Solution().solution(10)).isEqualTo(0);
    }
}