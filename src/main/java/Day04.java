import java.awt.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Day04 extends Day {

    public static void main(String[] args) {
        new Day04().run("day04.txt");
    }

    @Override
    public String part1() {
//
//        String word = "XMAS";
//
//        int maxX = this.input.get(0).length();
//        int maxY = this.input.size();
//        char[][] grid = new char[maxX][maxY];
//
//        IntStream.range(0,maxY).forEach(i -> {
//            IntStream.range(0,maxX).forEach(j -> {
//                grid[i][j] = this.input.get(i).charAt(j);
//            });
//        });
//
//        System.out.println(Arrays.deepToString(grid));
//
//        Point forward = new Point(1,0);
//        Point backward = new Point(-1,0);
//        Point up = new Point(0,1);
//        Point down = new Point(0,-1);
//        Point diagFU = new Point(1,1);
//        Point diagFD = new Point(1,-1);
//        Point diagBU = new Point(-1,1);
//        Point diagBD = new Point(-1,-1);
//
//        var res = IntStream.range(0,maxY).map(i -> {
//            return IntStream.range(0,maxX).map(j -> {
//                var firstLetter = grid[i][j];
//                if (firstLetter == word.charAt(0)) {
//                    var cpt = 0;
//                    if (checkWord(grid, new Point(i, j), forward, word)) cpt++;
//                    if (checkWord(grid, new Point(i, j), backward, word)) cpt++;
//                    if (checkWord(grid, new Point(i, j), up, word)) cpt++;
//                    if (checkWord(grid, new Point(i, j), down, word)) cpt++;
//                    if (checkWord(grid, new Point(i, j), diagFU, word)) cpt++;
//                    if (checkWord(grid, new Point(i, j), diagFD, word)) cpt++;
//                    if (checkWord(grid, new Point(i, j), diagBU, word)) cpt++;
//                    if (checkWord(grid, new Point(i, j), diagBD, word)) cpt++;
//                    return cpt;
//                }
//                return 0;
//            }).sum();
//        }).sum();
//
//        return "" + res;
        return "";
    }

    public boolean checkWord(char[][] grid, Point start, Point direction, String word) {
        for (int i = 0; i < word.length(); i++) {
            var x = start.x + i * direction.x;
            var y = start.y + i * direction.y;
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                return false;
            }
            if (grid[x][y] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String part2() {

        char middle = 'A';

        int maxX = this.input.get(0).length();
        int maxY = this.input.size();
        char[][] grid = new char[maxX][maxY];

        IntStream.range(0,maxY).forEach(i -> {
            IntStream.range(0,maxX).forEach(j -> {
                grid[i][j] = this.input.get(i).charAt(j);
            });
        });

        Point diagFU = new Point(1,-1);
        Point diagFD = new Point(1,1);
        Point diagBU = new Point(-1,-1);
        Point diagBD = new Point(-1,1);

        var res = IntStream.range(0,maxY).map(i -> {
            return IntStream.range(0,maxX).map(j -> {
                var letter = grid[i][j];
                if (letter == middle) {
                    var cpt = 0;
                    if (checkCrossWord(grid, new Point(i, j), diagBD, diagBU, diagFU, diagFD)) cpt++;
                    if (checkCrossWord(grid, new Point(i, j), diagFD, diagBD, diagBU, diagFU)) cpt++;
                    if (checkCrossWord(grid, new Point(i, j), diagFU, diagFD, diagBD, diagBU)) cpt++;
                    if (checkCrossWord(grid, new Point(i, j), diagBU, diagFU, diagFD, diagBD)) cpt++;
                    return cpt;
                }
                return 0;
            }).sum();
        }).sum();

        return "" + res;
    }

    public boolean checkCrossWord(char[][] grid, Point start, Point A, Point B, Point C, Point D) {

        char before = 'M';
        char after = 'S';

        // A et B == M
        // C et D == S

        var xA = start.x + A.x;
        var yA = start.y + A.y;
        var xB = start.x + B.x;
        var yB = start.y + B.y;
        var xC = start.x + C.x;
        var yC = start.y + C.y;
        var xD = start.x + D.x;
        var yD = start.y + D.y;
        if (xA < 0 || xA >= grid.length || yA < 0 || yA >= grid[0].length) {
            return false;
        }
        if (xB < 0 || xB >= grid.length || yB < 0 || yB >= grid[0].length) {
            return false;
        }
        if (xC < 0 || xC >= grid.length || yC < 0 || yC >= grid[0].length) {
            return false;
        }
        if (xD < 0 || xD >= grid.length || yD < 0 || yD >= grid[0].length) {
            return false;
        }
        if (grid[xA][yA] != before || grid[xB][yB] != before || grid[xC][yC] != after || grid[xD][yD] != after) {
            return false;
        }
        return true;
    }

}