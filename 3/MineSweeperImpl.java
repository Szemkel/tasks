package pl.tpacuszka.rtask.xform;

import java.util.ArrayList;
import java.util.List;

public class MineSweeperImpl implements MineSweeper {

    private MineField populatedMineField;

    /**
     * Initialises the field
     *
     * A mine-field of N x M squares is represented by N lines of exactly M characters each.
     * The character '*' represents a mine * and the character '.' represents no-mine.
     * Lines are separated by '\n'
     * <p/>
     * * Example mine-field string (as input to setMineField()): "*...\n..*.\n...."
     * (a 3 x 4 mine-field of 12 squares, 2 of which are mines)
     *
     * @param mineField string containing the mines
     * @throws IllegalArgumentException if mineField is not properly formatted
     */
    @Override
    public void setMineField(String mineField) throws IllegalArgumentException {
        if (!isArgumentValid(mineField)) {
            throw new IllegalArgumentException();
        }
        populatedMineField = new MineField(mineField);
    }

    /**
     * Checks if given minefield string is valid
     * @param mineField
     * @return
     */
    private boolean isArgumentValid(String mineField) {
        if (null == mineField || mineField.isEmpty()) {
            return false;
        } else if (!linesHaveSameLength(mineField)) {
            return false;
        } else if (linesContainUnallowedChars(mineField)) {
            return false;
        }
        return true;
    }

    /**
     * Checks if lines contain unallowed strings
     * @param mineField
     * @return
     */
    private Boolean linesContainUnallowedChars(String mineField) {
        for (String line : mineField.split("\n")) {
            String allowedCharsRemoved = line.replace(".", "").replace("*", "");
            if (allowedCharsRemoved.length() > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if lines in given mine field String are the same size
     * @param mineField
     * @return
     */
    private Boolean linesHaveSameLength(String mineField) {
        String[] lines = mineField.split("\n");
        for (String line : lines) {
            if (line.length() != lines[0].length()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Produces a hint-field of identical dimensions as the mineFiled() where each
     * square is a * for a mine or the number of adjacent mine-squares if the square does
     not contain a mine.
     * <p/>
     * Example hint-field (for the above input): "*211\n12*1\n0111"
     *
     * @return a string representation of the hint-field
     * @throws IllegalStateException if the mine-field has not been initialised (i.e.
    setMineField() has not been called)
     */
    @Override
    public String getHintField() throws IllegalStateException {
        if (populatedMineField == null) {
            throw new IllegalStateException("Mine field is not populated");
        }
        return populatedMineField.getHint();
    }

    /**
     * Stores mine fields
     */
    final private class MineField {

        ArrayList<Mine> mines = new ArrayList<>();
        private int height;
        private int width;

        MineField(String mineField) {
            populate(mineField);
            setDimensions(mineField);
        }

        /**
         * Populate mines array
         * @param mineField
         */
        private void populate(String mineField) {
            String[] lines = mineField.split("\n");
            for (int y = 0; y < lines.length; y++) {
                String line = lines[y];
                for (int x = 0; x < line.length(); x++) {
                    if (line.charAt(x) == '*') {
                        mines.add(new Mine(x, y));
                    }
                }
            }
        }

        /**
         * Get hint string
         * @return
         */
        String getHint() {
            String hint = "";
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    hint += getHintForCoordinates(x, y);
                }
                hint += y + 1 < height ? "\n" : "";
            }
            return hint;
        }

        /**
         * Gets hint for given coordinates
         * @param x
         * @param y
         * @return
         */
        private String getHintForCoordinates(int x, int y) {
            Integer adjacentMines = 0;
            for (Mine mine : mines) {
                if (mine.isPlacedOn(x, y)) {
                    return "*";
                } else if (mine.isAdjacentTo(x, y)) {
                    adjacentMines++;
                }
            }
            return adjacentMines.toString();
        }

        /**
         * Set dimensions of the mine field
         * @param mineField
         */
        private void setDimensions(String mineField) {
            String[] lines = mineField.split("\n");
            height = lines.length;
            width = lines[0].length();
        }
    }

    /**
     * Represents mine on field
     */
    final private class Mine {
        /**
         * X coordinate of mine
         */
        private int x;

        /**
         * Y coordinate of mine
         */
        private int y;

        Mine(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Check if mine is placed on given coordinates
         * @param x
         * @param y
         * @return
         */
        Boolean isPlacedOn(int x, int y) {
            return this.x == x && this.y == y;
        }

        /**
         * Checks if mine is adjacent to given coordinates
         * @param x
         * @param y
         * @return
         */
        Boolean isAdjacentTo(int x, int y) {
            int diffX = Math.abs(this.x - x);
            int diffY = Math.abs(this.y - y);

            if (diffX > 1 || diffY > 1) {
                return false;
            }

            return diffX + diffY <= 2;
        }
    }
}
