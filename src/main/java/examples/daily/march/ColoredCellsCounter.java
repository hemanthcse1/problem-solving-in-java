package examples.daily.march;

public class ColoredCellsCounter {

    public long countColoredCells(int n) {
        return (long) n * n + (long) (n - 1) * (n - 1);
    }

    public static void main(String[] args) {
        ColoredCellsCounter counter = new ColoredCellsCounter();
        System.out.println(counter.countColoredCells(1));     //  1
        System.out.println(counter.countColoredCells(2));     //  5
        System.out.println(counter.countColoredCells(3));     //  13
        System.out.println(counter.countColoredCells(4));     //  25
    }
}
