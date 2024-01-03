package Test;

import EvolutionUtils.GProject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GProjectTest {
    @Test
    void Test1_1_A() {
        int[][] test = {
                {5, 5, 1},
                {9, 8, 7, 6, 5, 1},
                {3, 2, 3, 2, 3, 1},
                {9, 9, 9, 9, 9, 1},
                {1, 2, 3, 4, 5, 1},
                {1, 1, 1, 1, 1, 1}};

        GProject.run(100, test, 10);
    }
    @Test
    void Test1_1_B() {
        int[][] test = {
                {5, 5, 1},
                {9, 8, 7, 6, 5, 789},
                {3, 2, 3, 2, 3, 789},
                {9, 9, 9, 9, 9, 789},
                {1, 2, 3, 4, 5, 789},
                {1, 1, 1, 1, 1, 789}};

        GProject.run(100, test, 1000);
    }
    @Test
    void Test1_1_C() {
        int[][] test = {
                {5, 5, 1},
                {9, 8, 7, 6, 5, 31415},
                {3, 2, 3, 2, 3, 31415},
                {9, 9, 9, 9, 9, 31415},
                {1, 2, 3, 4, 5, 31415},
                {1, 1, 1, 1, 1, 31415}};

        GProject.run(100, test, 10000);
    }
    @Test
    void Test1_1_D() {
        int[][] test = {
                {5, 5, 3},
                {9, 8, 7, 6, 5, 1, 3, 5},
                {3, 2, 3, 2, 3, 1, 2, 1},
                {9, 9, 9, 9, 9, 1, 1, 12},
                {1, 2, 3, 4, 5, 1, 31, 23},
                {1, 1, 1, 1, 1, 1, 99, 2}};

        GProject.run(100, test, 123);
    }

}