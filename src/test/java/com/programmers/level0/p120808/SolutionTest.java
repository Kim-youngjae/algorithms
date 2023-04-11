package com.programmers.level0.p120808;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    @DisplayName("1,2,3,4 -> [5,4]")
    void t1() {
        assertThat(new Solution().solution(1, 2, 3, 4)).isEqualTo(new int[]{5, 4});
    }

    @Test
    @DisplayName("9,2,1,3 -> [29, 6]")
    void t2() {
        assertThat(new Solution().solution(9, 2, 1, 3)).isEqualTo(new int[]{29, 6});
    }

    @Test
    @DisplayName("2,3,9,3 -> [11, 3]")
    void t3() {
        assertThat(new Solution().solution(2, 3, 9, 3)).isEqualTo(new int[]{11, 3});
    }
}