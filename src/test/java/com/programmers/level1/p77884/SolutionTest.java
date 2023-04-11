package com.programmers.level1.p77884;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    @DisplayName("13 17 -> 43")
    void t1() {
        assertThat(new Solution().solution(13, 17)).isEqualTo(43);
    }


    @Test
    @DisplayName("24\t27 -> 52")
    void t2() {
        assertThat(new Solution().solution(24, 27)).isEqualTo(52);
    }
}