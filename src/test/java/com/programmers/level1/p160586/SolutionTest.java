package com.programmers.level1.p160586;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    @DisplayName("[\"AA\"], [\"B\"] -> [-1]")
    void t01() {
        assertThat(
                new Solution().solution(new String[]{"AA"}, new String[]{"B"})
        ).isEqualTo(new int[]{-1});
    }

    @Test
    @DisplayName("[ABACD, BCEFD]\t[ABCD, AABB] -> [9, 4]")
    void t02() {
        assertThat(
                new Solution().solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"})
        ).isEqualTo(new int[]{9, 4});

    }
}