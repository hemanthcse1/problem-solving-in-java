package examples.interviewquestions.strings.medium;

public class AlphabetBoardPath {
    public String alphabetBoardPath(String target) {
        StringBuilder path = new StringBuilder();
        int currentRow = 0, currentCol = 0;

        for (char ch : target.toCharArray()) {
            int targetRow = (ch - 'a') / 5;
            int targetCol = (ch - 'a') % 5;

            if (currentRow > targetRow) {
                path.append("U".repeat(currentRow - targetRow));
            }
            if (currentCol > targetCol) {
                path.append("L".repeat(currentCol - targetCol));
            }
            if (currentRow < targetRow) {
                path.append("D".repeat(targetRow - currentRow));
            }
            if (currentCol < targetCol) {
                path.append("R".repeat(targetCol - currentCol));
            }

            path.append("!");

            currentRow = targetRow;
            currentCol = targetCol;
        }

        return path.toString();
    }

    public static void main(String[] args) {
        AlphabetBoardPath alphabetBoard = new AlphabetBoardPath();
        System.out.println(alphabetBoard.alphabetBoardPath("leet"));
        System.out.println(alphabetBoard.alphabetBoardPath("code"));
    }
}
