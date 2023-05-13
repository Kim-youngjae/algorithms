package com.programmers.level3.p43163;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    @DisplayName("hit, cog, [hot, dot, dog, lot, log, cog]")
    void t01() {
        assertThat(
                new Solution().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"})
        ).isEqualTo(4);
    }

}