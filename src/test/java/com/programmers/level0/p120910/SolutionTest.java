package com.programmers.level0.p120910;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    @DisplayName("2, 10 -> 2048")
    void t1() {
        assertThat(new Solution().solution(2, 10)).isEqualTo(2048);
    }

    @Test
    @DisplayName("7, 15 -> 229376")
    void t2() {
        assertThat(new Solution().solution(7, 15)).isEqualTo(229376);
    }
}