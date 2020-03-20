package com.baba.Recursion;

public class RatInTheMaze {
    static int numberOfPath = 0;
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0, 0},
                {0, 0, 10, 0},
                {0, 0, 0, 10},
                {0, 10, 0, 0}
        };
        int[][] soln = new int[maze.length][maze.length];

        ratInMaze(maze,soln,0,0,maze.length-1,maze.length-1);

        System.out.println(numberOfPath);
    }

    static boolean ratInMaze(int[][] maze, int[][] soln, int i, int j, int m, int n) {
        if (i == m && j == n) {
            soln[m][n] = 1;
            printSoln(soln);
            countPath();
            return true;
        }

        if (i > m || j > n) {
            return false;
        }

        if (maze[i][j]==10){
            return false;
        }

        soln[i][j] = 1;

        boolean rightSuccess = ratInMaze(maze, soln, i, j + 1, m, n);
        boolean downSuccess = ratInMaze(maze, soln, i + 1, j, m, n);

        // Backtracking
        soln[i][j] = 0;

        if (rightSuccess || downSuccess){
            return true;
        }
        return false;
    }

    static void printSoln(int[][] soln){
        for (int i=0; i<soln.length; i++){
            for (int j=0; j<soln.length; j++){
                System.out.print(soln[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void countPath(){
        numberOfPath++;
    }
}
