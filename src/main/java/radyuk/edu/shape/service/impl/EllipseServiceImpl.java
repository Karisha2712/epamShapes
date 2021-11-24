package radyuk.edu.shape.service.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import radyuk.edu.shape.entity.Ellipse;
import radyuk.edu.shape.entity.Point;
import radyuk.edu.shape.exception.EllipseException;
import radyuk.edu.shape.service.EllipseService;

public class EllipseServiceImpl implements EllipseService {
    private static final Logger logger = LogManager.getLogger();
    private static final String ERROR_MESSAGE = "Invalid ellipse";

    @Override
    public boolean isEllipse(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            throw new EllipseException(ERROR_MESSAGE);
        }
        double width = Math.abs(ellipse.getFirstPoint().x() - ellipse.getSecondPoint().x());
        double height = Math.abs(ellipse.getFirstPoint().y() - ellipse.getSecondPoint().y());
        boolean result = Double.compare(width, height) != 0;
        logger.log(Level.INFO, "Ellipse is not circle: {}", result);
        return result && isEllipseValid(ellipse);
    }

    @Override
    public boolean isCircle(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            throw new EllipseException(ERROR_MESSAGE);
        }
        double width = Math.abs(ellipse.getFirstPoint().x() - ellipse.getSecondPoint().x());
        double height = Math.abs(ellipse.getFirstPoint().y() - ellipse.getSecondPoint().y());
        boolean result = Double.compare(width, height) == 0;
        logger.log(Level.INFO, "Ellipse is circle: {}", result);
        return result && isEllipseValid(ellipse);
    }

    @Override
    public boolean isEllipseValid(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            throw new EllipseException(ERROR_MESSAGE);
        }
        Point firstPoint = ellipse.getFirstPoint();
        Point secondPoint = ellipse.getSecondPoint();
        boolean result = firstPoint.x() != secondPoint.x()
                && firstPoint.y() != secondPoint.y();
        logger.log(Level.INFO, "Ellipse is valid: {}", result);
        return result;
    }

    @Override
    public double calculateArea(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            throw new EllipseException(ERROR_MESSAGE);
        }
        double a = Math.abs(ellipse.getFirstPoint().x() - ellipse.getSecondPoint().x()) / 2;
        double b = Math.abs(ellipse.getFirstPoint().y() - ellipse.getSecondPoint().y()) / 2;
        double result = Math.PI * a * b;
        logger.log(Level.INFO, "Calculated area: {}", result);
        return result;
    }

    @Override
    public double calculatePerimeter(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            throw new EllipseException(ERROR_MESSAGE);
        }
        double a = Math.abs(ellipse.getFirstPoint().x() - ellipse.getSecondPoint().x()) / 2;
        double b = Math.abs(ellipse.getFirstPoint().y() - ellipse.getSecondPoint().y()) / 2;
        double result = 2 * Math.PI * Math.sqrt((a * a + b * b) / 2);
        logger.log(Level.INFO, "Calculated perimeter: {}", result);
        return result;
    }
}
