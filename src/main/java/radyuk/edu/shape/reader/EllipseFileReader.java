package radyuk.edu.shape.reader;

import radyuk.edu.shape.exception.EllipseException;
import radyuk.edu.shape.validator.EllipseFileLineValidator;
import radyuk.edu.shape.validator.EllipseFileValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EllipseFileReader {
    private static final String FILE_ERROR = "Invalid file path";

    public List<String> getValidEllipseLines(String filepath) throws EllipseException {
        if (!EllipseFileValidator.isFileValid(filepath)) {
            throw new EllipseException(FILE_ERROR);
        }
        Path path = Paths.get(filepath);
        try (Stream<String> fileLines = Files.lines(path)) {
            return fileLines
                    .filter(EllipseFileLineValidator::isEllipseFileLineValid)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new EllipseException("");
        }
    }
}

