package edu.radyuk.shape.reader;

import edu.radyuk.shape.exception.EllipseException;
import edu.radyuk.shape.validator.impl.EllipseFileValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EllipseFileReader {
    private static final Logger logger = LogManager.getLogger();

    public List<String> receiveValidEllipseLines(String filepath) throws EllipseException {
        EllipseFileValidatorImpl ellipseFileValidator = new EllipseFileValidatorImpl();
        if (!ellipseFileValidator.isFileValid(filepath)) {
            throw new EllipseException("Invalid file path");
        }
        Path path = Paths.get(filepath);
        List<String> fileLines;
        try (Stream<String> fileLinesStream = Files.lines(path)) {
            fileLines = fileLinesStream
                    .filter(ellipseFileValidator::isEllipseFileLineValid)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new EllipseException("Error while reading file: " + filepath, e);
        }
        logger.log(Level.INFO, "Lines received successfully");
        return fileLines;
    }
}

