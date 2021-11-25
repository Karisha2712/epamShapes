package edu.radyuk.shape.reader;

import edu.radyuk.shape.exception.EllipseException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class EllipseFileReaderTest {
    private static final String FILE_PATH = "src/main/resources/files/ellipses_coordinates.txt";
    private static final String INVALID_FILE_PATH = "files/ellipses_coordinates.txt";
    private static final EllipseFileReader ELLIPSE_FILE_READER = new EllipseFileReader();

    @Test
    public void ifEllipseFileReaderReturnsValidResult() throws EllipseException {
        List<String> fileLines = ELLIPSE_FILE_READER.receiveValidEllipseLines(FILE_PATH);
        List<String> expectedFileLines = new ArrayList<>();
        expectedFileLines.add("12.0 12.0 14.0 14.0");
        expectedFileLines.add("10.0 12.0 16.0 16.0");
        assertEquals(fileLines, expectedFileLines);
    }

    @Test
    public void ifEllipseFileReaderThrowsInvalidFilePathException() {
        var expectedException = assertThrows(EllipseException.class,
                () -> ELLIPSE_FILE_READER.receiveValidEllipseLines(INVALID_FILE_PATH));
        assertEquals("Invalid file path", expectedException.getMessage());
    }

}
