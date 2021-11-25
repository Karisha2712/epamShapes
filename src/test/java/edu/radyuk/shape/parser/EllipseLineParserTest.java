package edu.radyuk.shape.parser;

import edu.radyuk.shape.exception.EllipseException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EllipseLineParserTest {
    private final EllipseLineParser ellipseLineParser = new EllipseLineParser();

    @Test
    public void ifParseEllipseLinesReturnsValidValues() throws EllipseException {
        String correctLine = "10.0 12.0 12.0 14.0";
        List<Double> expectedList = new ArrayList<>();
        expectedList.add(10.0);
        expectedList.add(12.0);
        expectedList.add(12.0);
        expectedList.add(14.0);
        List<Double> doubleList = ellipseLineParser.parseEllipseLine(correctLine);
        assertEquals(doubleList, expectedList);
    }

    @Test
    public void ifParseEllipseLinesThrowsEmptyLineException() {
        String emptyLine = " ";
        String expectedMessage = "Line is empty";
        var expectedException = assertThrows(EllipseException.class,
                () -> ellipseLineParser.parseEllipseLine(emptyLine));
        assertEquals(expectedMessage, expectedException.getMessage());

    }

    @Test
    public void ifParseEllipseLinesThrowsIncorrectLineException() {
        String incorrectLine = "10j 12.0 13.0 14.0";
        String expectedMessage = "Invalid line";
        var expectedException = assertThrows(EllipseException.class,
                () -> ellipseLineParser.parseEllipseLine(incorrectLine));
        assertEquals(expectedMessage, expectedException.getMessage());

    }

    @Test
    public void ifParseEllipseLinesThrowsInvalidCoordinatesNumberException() {
        String incorrectCoordinatesNumberLine = "12.0 13.0 14.0";
        String expectedMessage = "Invalid coordinates number";
        var expectedException = assertThrows(EllipseException.class,
                () -> ellipseLineParser.parseEllipseLine(incorrectCoordinatesNumberLine));
        assertEquals(expectedMessage, expectedException.getMessage());

    }

}
