package com.programmers.level2.p87377;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    @DisplayName("[1, -1, 0], [2, -1, 0]의 교점")
    void t_1() {
        assertThat(
                new Solution().intersection(
                        new int[]{1, -1, 0}, new int[]{2, -1, 0}))
                .isEqualTo(Point.of(0,0));
    }

    @Test
    @DisplayName("[1, -1, 0], [4, -1, 0]의 교점")
    void t_2() {
        assertThat(
                new Solution().intersection(
                        new int[]{1, -1, 0}, new int[]{4, -1, 0}))
                .isEqualTo(Point.of(0,0));
    }

    @Test
    @DisplayName("[1, -1, 0], [4, -1, 0]의 교점")
    void t_3() {
        assertThat(
                new Solution().intersection(
                        new int[]{1, -1, 0}, new int[]{4, -1, 0}))
                .isEqualTo(Point.of(0,0));
    }

    @Test
    @DisplayName("[0, 1, -1], [1, 0, -1], [1, 0, 1]의 교점")
    void t_4() {
        assertThat(
                new Solution().intersections(
                        new int[][]{new int[]{0, 1, -1}, new int[]{1, 0, -1}, new int[]{1, 0, 1}}))
                .isEqualTo(Set.of(Point.of(-1, 1), Point.of(1, 1)));
    }

    @Test
    @DisplayName("[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]의 교점")
    void t_5() {
        assertThat(
                new Solution().intersections(
                        new int[][]{new int[]{2, -1, 4}, new int[]{-2, -1, 4}, new int[]{0, -1, 1}, new int[]{5, -8, -12}, new int[]{5, 8, 12}}))
                .isEqualTo(Set.of(Point.of(4, 1), Point.of(4, -4), Point.of(-4, -4), Point.of(-4, 1), Point.of(0, 4)));
    }

    @Test
    @DisplayName("매트릭스를 그리기 위한 최소점")
    void t_6() {
        assertThat(
                new Solution().getMinPoint(Set.of(Point.of(1, 1), Point.of(1, -1))))
                .isEqualTo(Point.of(1, -1));
    }

    @Test
    @DisplayName("매트릭스를 그리기 위한 최대점")
    void t_7() {
        assertThat(
                new Solution().getMaxPoint(Set.of(Point.of(1, 1), Point.of(1, -1))))
                .isEqualTo(Point.of(1, 1));
    }

    @Test
    @DisplayName("emptyMatrix, [Point.of(4, -7), Point.of(-1, 6)]")
    void t_8() {
        assertThat(
                new Solution().emptyMatrix(Set.of(Point.of(4, -7), Point.of(-1, 6)))
        ).isEqualTo(
                new char[][]{
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'}
                }
        );
    }

    @Test
    @DisplayName("emptyMatrix, [Point.of(1, 1), Point.of(-1, 1)]")
    void t9() {
        assertThat(
                new Solution().emptyMatrix(Set.of(Point.of(1, 1), Point.of(-1, 1)))
        ).isEqualTo(
                new char[][]{
                        {'.', '.', '.'}
                }
        );
    }

    @Test
    @DisplayName("transformToMatrix, [Point.of(1, 1), Point.of(-1, 1)]")
    void t10() {
        assertThat(
                new Solution().pointToMatrix(Set.of(Point.of(1, 1), Point.of(-1, 1)))
        ).isEqualTo(
                new char[][]{
                        {'*', '.', '*'}
                }
        );
    }

    @Test
    @DisplayName("transformToMatrix, [Point.of(4, -7), Point.of(-1, 6)]")
    void t7_2() {
        assertThat(
                new Solution().pointToMatrix(Set.of(Point.of(4, -7), Point.of(-1, 6)))
        ).isEqualTo(
                new char[][]{
                        {'.', '.', '.', '.', '.', '*'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                        {'*', '.', '.', '.', '.', '.'}
                }
        );
    }
}
