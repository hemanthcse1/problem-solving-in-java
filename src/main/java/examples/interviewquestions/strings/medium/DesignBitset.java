package examples.interviewquestions.strings.medium;

public class DesignBitset {

    private boolean[] bits;
    private int size;
    private int count;
    private boolean flipped;

    public DesignBitset(int size) {
        this.size = size;
        this.bits = new boolean[size];
        this.count = 0;
        this.flipped = false;
    }

    public void fix(int idx) {
        if (bits[idx] == flipped) {
            bits[idx] = !flipped;
            count++;
        }
    }

    public void unfix(int idx) {
        if (bits[idx] != flipped) {
            bits[idx] = flipped;
            count--;
        }
    }

    public void flip() {
        flipped = !flipped;
        count = size - count;
    }

    public boolean all() {
        return count == size;
    }

    public boolean one() {
        return count > 0;
    }

    public int count() {
        return count;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            if (bits[i] == flipped) {
                sb.append('0');
            } else {
                sb.append('1');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DesignBitset bs = new DesignBitset(5);

        System.out.println(bs.toString());

        bs.fix(3);
        System.out.println(bs.toString());

        bs.fix(1);
        System.out.println(bs.toString());

        bs.flip();
        System.out.println(bs.toString());

        System.out.println("All bits set to 1? " + bs.all());

        bs.unfix(0);
        System.out.println(bs.toString());

        bs.flip();
        System.out.println(bs.toString());

        System.out.println("At least one bit set to 1? " + bs.one());

        bs.unfix(0);
        System.out.println(bs.toString());

        System.out.println("Count of bits set to 1: " + bs.count());
        System.out.println("Bitset representation: " + bs.toString());
    }
}
