package com.lec.plion22Polynomial;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PolynomialTest {

// new Polynomial("3 + 3").calc() == 6;
//new Polynomial("13 + 2").calc() == 15;
//new Polynomial("3 * 3 + 3").calc() == 12;
//new Polynomial("(3 + 3) * 3").calc() == 18;

    @Test
    @DisplayName("3 + 3 = 6")
    void t1() {
        assertThat(new Polynomial("3 + 3").calc()).isEqualTo(6);
    }



    @Test
    @DisplayName("13 + 2 = 15")
    void t2() {
        assertThat(new Polynomial("13 + 2").calc()).isEqualTo(15);
    }

    @Test
    @DisplayName("3 * 3 + 3 = 12")
    void t3() {
        assertThat(new Polynomial("3 * 3 + 3").calc()).isEqualTo(12);
    }

    // cal2 test
    @Test
    @DisplayName("3 * (3 + 3) = 18")
    void t4() {
        assertThat(new Polynomial("3 * (3 + 3)").calc2()).isEqualTo(18);
    }

    @Test
    @DisplayName("((1+(2*3)+((4+2)/2))) = 10")
    void t5() {
        assertThat(new Polynomial("((1+(2*3)+((4+2)/2)))").calc2()).isEqualTo(10);
    }
}