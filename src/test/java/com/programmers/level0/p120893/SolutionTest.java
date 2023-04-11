package com.programmers.level0.p120893;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    @Test
    @DisplayName("cccCCC의 결과는 CCCccc")
    void t1() {
        assertThat(new Solution().solution("cccCCC")).isEqualTo("CCCccc");
    }

    @Test
    @DisplayName("abCdEfghIJ 결과는 ABcDeFGHij")
    void t2() {
        assertThat(new Solution().solution("abCdEfghIJ")).isEqualTo("ABcDeFGHij");
    }

}