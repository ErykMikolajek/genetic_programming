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

        GProject.run(100, test);
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

        GProject.run(100, test);
    }
}