package com.programmers.level0.p120829;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    @DisplayName("70도 입력됬을 때 결과는 1")
    void t1() {
        assertThat(new Solution().solution(70)).isEqualTo(1);
    }

    @Test
    @DisplayName("91도 입력됬을 때 결과는 3")
    void t2() {
        assertThat(new Solution().solution(91)).isEqualTo(3);
    }

    @Test
    @DisplayName("180도 입력됬을 때 결과는 4")
    void t3() {
        assertThat(new Solution().solution(180)).isEqualTo(4);
    }

    @Test
    @DisplayName("92도 입력됬을 때 결과는 3")
    void t4() {
        assertThat(new Solution().solution(93)).isEqualTo(3);
    }

    @Test
    @DisplayName("93도 입력됬을 때 결과는 3")
    void t5() {
        assertThat(new Solution().solution(92)).isEqualTo(3);
    }

}