package radyuk.edu.shape.parser;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import radyuk.edu.shape.exception.EllipseException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EllipseLineParser {
    private static final String REGEXP_DELIMITER = "\\s+";
    private static final int COORDINATES_NUMBER = 4;
    private static final Logger logger = LogManager.getLogger();

    public List<Double> parseEllipseLine(String ellipseLine) throws EllipseException {
        if (ellipseLine == null || ellipseLine.isEmpty()) {
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
        if (pointsCoordinates.size() != COORDINATES_NUMBER) {
            throw new EllipseException("Invalid coordinates number");
        }
        logger.log(Level.INFO, "Lines parsed successfully");
        return pointsCoordinates;
    }
}
