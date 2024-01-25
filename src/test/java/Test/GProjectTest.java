package Test;

import EvolutionUtils.GProject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GProjectTest {
    @Test
    void Test1_1_A() {
        int[][] test = {
                {6, 5, 1},
                {9, 8, 7, 6, 5, 1},
                {3, 2, 3, 2, 3, 1},
                {9, 9, 9, 9, 9, 1},
                {1, 2, 3, 4, 5, 1},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1}};

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
                {0, 1, 1, 1, 1, 31415}};

        GProject.run(100, test, 40000);
    }
    @Test
    void Test1_1_D() {
        int[][] test = {
                {5, 5, 1},
                {9, 8, 7, 6, 5, 1},
                {3, 2, 3, 2, 3, 1},
                {9, 9, 9, 9, 9, 1},
                {1, 2, 3, 4, 5, 1},
                {1, 1, 1, 1, 1, 1}};

        GProject.run(100, test, 123);
    }

    @Test
    void Test1_1_E() {
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
    void Test1_1_F() {
        int[][] test = {
                {5, 5, 1},
                {9, 8, 7, 6, 5, 1},
                {3, 2, 3, 2, 3, 1},
                {9, 9, 9, 9, 9, 1},
                {1, 2, 3, 4, 5, 1},
                {1, 1, 1, 1, 1, 1}};

        GProject.run(100, test, 123);
    }
    @Test
    void Test1_2_A() {
        int[][] test = {
                {5, 2, 1},
                {9, 8, 17},
                {3, 2, 5},
                {9, 9, 18},
                {1, 2, 3},
                {1, 1, 2}};

        GProject.run(100, test, 123);
    }
    @Test
    void Test1_2_B() {
        int[][] test = {
                {5, 2, 1},
                {9, -8, 1},
                {-3, -2, -5},
                {9, 9, 18},
                {1, -2, -1},
                {1, -1, 0}};

        GProject.run(100, test, 123);
    }
    @Test
    void Test1_2_C() {
        int[][] test = {
                {5, 2, 1},
                {-2345, 5678, 3333},
                {789, -1234, -445},
                {9999, -8765, 1234},
                {-4321, 8765, 4444},
                {-1111, 2222, 1111}};

        GProject.run(100, test, 123);
    }
    @Test
    void Test1_2_D() {
        int[][] test = {
                {5, 2, 1},
                {-2345, 5678, -8023},
                {789, -1234, 2023},
                {9999, -8765, 18764},
                {-4321, 8765, -13086},
                {-1111, 2222, -3333}};

        GProject.run(100, test, 1000);
    }
    @Test
    void Test1_2_E() {
        int[][] test = {
                {5, 2, 1},
                {-234, 56, -13104},
                {789, -12, -9468},
                {99, -85, -8415},
                {-1, 5, -5},
                {-1111, 2, -2222}};

        GProject.run(100, test, 1000);
    }
    @Test
    void Test1_3_A() {
        int[][] test = {
                {10, 2, 1},
                {1, 2, 2},
                {3, 5, 5},
                {9, 1, 9},
                {0, 2, 2},
                {4, 1, 4},
                {0, 2, 2},
                {9, 8, 9},
                {7, 8, 8},
                {6, 4, 6},
                {5, 3, 5}};

        GProject.run(1000, test, 10);
    }
    @Test
    void Test1_3_B() {
        int[][] test = {
                {10, 2, 1},
                {-54, 20, 20},
                {-6574, -6573, -6573},
                {9999, -100, 9999},
                {0, 2000, 2000},
                {4131, -1111, 4131},
                {4567, 4566, 4567},
                {9999, 8888, 9999},
                {-7654, -8765, -7654},
                {6, 4, 6},
                {5444, 3000, 5444}};

        GProject.run(1000, test, 10);
    }
    @Test
    void Test1_4_A() {
        int[][] test = {
                {10, 10, 1},
                {-52, -64, -67, -24, 92, 72, 65, -27, -2, 13, 0},
                {20, 41, 23, -48, 2, 0, -33, -12, 32, 51, 7},
                {7, 42, 33, -61, 4, -29, 99, 57, -36, 57, 17},
                {-46, -44, -47, 91, -8, -76, 78, 15, -4, 40, 0},
                {85, -98, 18, 15, -60, -17, 65, -74, 16, 27, -2},
                {-87, 57, -7, 83, -17, 50, 92, 53, -50, -33, 14},
                {-5, -64, -70, -4, 95, 27, -52, -74, -42, 2, -18},
                {-55, 16, 69, -14, 3, -47, 31, 14, -47, 23, 0},
                {94, -7, -7, -56, -67, 92, 8, -46, 47, -72, -1},
                {53, 74, -56, 79, 21, 86, 8, 13, 42, -40, 28}};

        GProject.run(1000, test, 15);
    }
}