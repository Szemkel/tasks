package pl.tpacuszka.rtask.xform;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class MineSweeperImplTest {

    @Rule public ExpectedException thrown = ExpectedException.none();

    private String validInput = "*...\n..*.\n....";
    private String[] notValidInputs = {"", "*...\n..*", "*...\n..*s"};
    private String validHint = "*211\n12*1\n0111";

    @Test
    public void canCreateObject() throws Exception {
        new MineSweeperImpl();
    }

    @Test
    public void throwsExceptionWhenArgumentsAreNotValid() throws Exception {
        for (String notValidInput : notValidInputs) {
            thrown.expect(IllegalArgumentException.class);
            MineSweeper mineSweeper = new MineSweeperImpl();
            mineSweeper.setMineField(notValidInput);
        }
    }

    @Test
    public void itIsExceptionlessWhenArgumentsAreValid() throws Exception {
        MineSweeper mineSweeper = new MineSweeperImpl();
        mineSweeper.setMineField(validInput);
    }

    @Test
    public void throwsExceptionWhenFieldIsNotPopulated() throws Exception {
        thrown.expect(IllegalStateException.class);
        MineSweeper mineSweeper = new MineSweeperImpl();
        mineSweeper.getHintField();
    }

    @Test
    public void hintHasTheSameDimensionsAsProvidedMineField() throws Exception {
        MineSweeper mineSweeper = new MineSweeperImpl();
        mineSweeper.setMineField(validInput);
        assertEquals(validInput.length(), mineSweeper.getHintField().length());
    }

    @Test
    public void returnedHintIsValid() throws Exception {
        MineSweeper mineSweeper = new MineSweeperImpl();
        mineSweeper.setMineField(validInput);
        assertEquals(validHint, mineSweeper.getHintField());
    }
}