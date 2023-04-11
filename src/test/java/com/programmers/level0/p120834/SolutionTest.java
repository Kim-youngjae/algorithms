package com.programmers.level0.p120834;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    @DisplayName("23 -> cd")
    void t1() {
        assertThat(new Solution().solution(23)).isEqualTo("cd");
    }
    @Test
    @DisplayName("51 -> fb")
    void t2() {
        assertThat(new Solution().solution(51)).isEqualTo("fb");
    }
    @Test
    @DisplayName("100 -> baa")
    void t3() {
        assertThat(new Solution().solution(100)).isEqualTo("baa");
    }
}