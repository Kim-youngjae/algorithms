package com.programmers.level0.p120891;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    @DisplayName("3 -> 1")
    void t1() {
        assertThat(new Solution().solution(3)).isEqualTo(1);
    }

    @Test
    @DisplayName("29423 -> 2")
    void t2() {
        assertThat(new Solution().solution(29423)).isEqualTo(2);
    }
}