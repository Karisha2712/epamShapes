package edu.radyuk.shape.parser;

import edu.radyuk.shape.exception.EllipseException;
import edu.radyuk.shape.factory.EllipseFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EllipseLineParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String REGEXP_DELIMITER = "\\s+";

    public List<Double> parseEllipseLine(String ellipseLine) throws EllipseException {
        if (ellipseLine == null || ellipseLine.isBlank()) {
            throw new EllipseException("Line is empty");
        }
        List<Double> pointsCoordinates;
        try {
            pointsCoordinates = Arrays.stream(ellipseLine.split(REGEXP_DELIMITER))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new EllipseException("Invalid line", e);
        }
        if (pointsCoordinates.size() != EllipseFactory.COORDINATES_NUMBER) {
            throw new EllipseException("Invalid coordinates number");
        }
        logger.log(Level.INFO, "Lines parsed successfully");
        return pointsCoordinates;
    }
}
