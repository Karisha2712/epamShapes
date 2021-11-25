package edu.radyuk.shape.parser;

import edu.radyuk.shape.exception.EllipseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EllipseLineParserTest {
    private static final EllipseLineParser ELLIPSE_LINE_PARSER = new EllipseLineParser();
    private static final String CORRECT_LINE = "10.0 12.0 12.0 14.0";
    private static final String EMPTY_LINE = " ";
    private static final String INCORRECT_LINE = "10j 12.0 13.0 14.0";
    private static final String INCORRECT_COORDINATES_NUMBER_LINE = "12.0 13.0 14.0";

    private static final List<Double> DOUBLE_LIST = new ArrayList<>();

    @BeforeAll
    static void setUp() {
        DOUBLE_LIST.add(10.0);
        DOUBLE_LIST.add(12.0);
        DOUBLE_LIST.add(12.0);
        DOUBLE_LIST.add(14.0);
    }

    @Test
    public void ifParseEllipseLinesReturnsValidValues() throws EllipseException {
        List<Double> doubleList = ELLIPSE_LINE_PARSER.parseEllipseLine(CORRECT_LINE);
        assertEquals(doubleList, DOUBLE_LIST);
    }

    @Test
    public void ifParseEllipseLinesThrowsEmptyLineException() {
        var expectedException = assertThrows(EllipseException.class,
                () -> ELLIPSE_LINE_PARSER.parseEllipseLine(EMPTY_LINE));
        assertEquals("Line is empty", expectedException.getMessage());

    }

    @Test
    public void ifParseEllipseLinesThrowsIncorrectLineException() {
        var expectedException = assertThrows(EllipseException.class,
                () -> ELLIPSE_LINE_PARSER.parseEllipseLine(INCORRECT_LINE));
        assertEquals("Invalid line", expectedException.getMessage());

    }

    @Test
    public void ifParseEllipseLinesThrowsInvalidCoordinatesNumberException() {
        var expectedException = assertThrows(EllipseException.class,
                () -> ELLIPSE_LINE_PARSER.parseEllipseLine(INCORRECT_COORDINATES_NUMBER_LINE));
        assertEquals("Invalid coordinates number", expectedException.getMessage());

    }

}
