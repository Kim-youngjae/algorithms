package com.programmers.level2.p64065;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    @DisplayName("{{123}}")
    void t01() {
        assertThat(
                new Solution().solution("{{123}}")
        ).isEqualTo(
                new int[]{123}
        );
    }

    @Test
    @DisplayName("{{20,111},{111}}")
    void t02() {
        assertThat(
                new Solution().solution("{{20,111},{111}}")
        ).isEqualTo(
                new int[]{111, 20}
        );
    }

    @Test
    @DisplayName("{{2},{2,1},{2,1,3},{2,1,3,4}}")
    void t03() {
        assertThat(
                new Solution().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")
        ).isEqualTo(
                new int[]{2, 1, 3, 4}
        );
    }
}