package examples;

public class NumberComplement {

    public int findComplement(int num) {
        int mask = 0;
        int temp = num;

        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }

        return ~num & mask;
    }

    public static void main(String[] args) {
        NumberComplement solver = new NumberComplement();

        System.out.println(solver.findComplement(5));
        System.out.println(solver.findComplement(1));
    }
}
