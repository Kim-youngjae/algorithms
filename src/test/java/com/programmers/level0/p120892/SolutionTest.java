package com.programmers.level0.p120892;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    @DisplayName("\"dfjardstddetckdaccccdegk\", 4 -> attack")
    void t1() {
        assertThat(new Solution().solution("dfjardstddetckdaccccdegk", 4)).isEqualTo("attack");
    }

    @Test
    @DisplayName("\"pfqallllabwaoclk\", 2 -> fallback")
    void t2() {
        assertThat(new Solution().solution("pfqallllabwaoclk", 2)).isEqualTo("fallback");
    }
}