package edu.radyuk.shape.reader;

import org.junit.Test;
import edu.radyuk.shape.exception.EllipseException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EllipseFileReaderTest {
    private static final String FILE_PATH = "src/main/resources/files/ellipses_coordinates.txt";

    @Test
    public void ifEllipseFileReaderReturnsValidResult() throws EllipseException {
        EllipseFileReader ellipseFileReader = new EllipseFileReader();
        List<String> fileLines = ellipseFileReader.receiveValidEllipseLines(FILE_PATH);
        List<String> expectedFileLines = new ArrayList<>();
        expectedFileLines.add("12.0 12.0 14.0 14.0");
        expectedFileLines.add("10.0 12.0 16.0 16.0");
        assertEquals(fileLines, expectedFileLines);
    }
}
