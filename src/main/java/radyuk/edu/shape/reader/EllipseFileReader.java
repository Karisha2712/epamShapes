package radyuk.edu.shape.reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger();

    public List<String> getValidEllipseLines(String filepath) throws EllipseException {
        if (!EllipseFileValidator.isFileValid(filepath)) {
            throw new EllipseException("Invalid file path");
        }
        Path path = Paths.get(filepath);
        List<String> fileLines;
        try (Stream<String> fileLinesStream = Files.lines(path)) {
            fileLines = fileLinesStream
                    .filter(EllipseFileLineValidator::isEllipseFileLineValid)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new EllipseException("Error while reading file: " + filepath, e);
        }
        if (fileLines.size() == 0) {
            throw new EllipseException("File doesn't contain valid lines");
        }
        logger.log(Level.INFO, "Lines received successfully");
        return fileLines;
    }
}

