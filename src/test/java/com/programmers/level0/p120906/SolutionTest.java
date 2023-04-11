package com.programmers.level0.p120906;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    @DisplayName("1234 -> 10")
    void t1() {
        assertThat(new Solution().solution(1234)).isEqualTo(10);
    }

    @Test
    @DisplayName("12345 -> 15")
    void t2() {
        assertThat(new Solution().solution(12345)).isEqualTo(15);
    }
}