package edu.radyuk.shape.reader;

import edu.radyuk.shape.exception.EllipseException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class EllipseFileReaderTest {
    private final EllipseFileReader ellipseFileReader = new EllipseFileReader();

    @Test
    public void ifEllipseFileReaderReturnsValidResult() throws EllipseException {
        URL fileUrl = EllipseFileReaderTest.class.getClassLoader()
                .getResource("files/ellipses_coordinates.txt");
        File file = new File(fileUrl.getFile());
        String filePath = file.getAbsolutePath();
        List<String> fileLines = ellipseFileReader.receiveValidEllipseLines(filePath);
        List<String> expectedFileLines = new ArrayList<>();
        expectedFileLines.add("12.0 12.0 14.0 14.0");
        expectedFileLines.add("10.0 12.0 16.0 16.0");
        assertEquals(expectedFileLines, fileLines);
    }

    @Test
    public void ifEllipseFileReaderThrowsInvalidFilePathException() {
        String invalidFilePath = "jj";
        var expectedException = assertThrows(EllipseException.class,
                () -> ellipseFileReader.receiveValidEllipseLines(invalidFilePath));
        assertEquals("Invalid file path", expectedException.getMessage());
    }

}
