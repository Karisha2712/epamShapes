package edu.radyuk.shape.factory;

import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.entity.Point;
import edu.radyuk.shape.exception.EllipseException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public final class EllipseFactory {
    private static final Logger logger = LogManager.getLogger();
    private static final EllipseFactory instance = new EllipseFactory();
    public static final int COORDINATES_NUMBER = 4;

    private EllipseFactory() {

    }

    public Ellipse getEllipse(List<Double> pointsCoordinates) throws EllipseException {
        if (pointsCoordinates.size() != COORDINATES_NUMBER) {
            throw new EllipseException("Invalid number of coordinates: " + pointsCoordinates);
        }
        Point firstPoint = new Point(pointsCoordinates.get(0), pointsCoordinates.get(1));
        Point secondPoint = new Point(pointsCoordinates.get(2), pointsCoordinates.get(3));
        Ellipse ellipse = new Ellipse(firstPoint, secondPoint);
        logger.log(Level.INFO, "Ellipse was created successfully");
        return ellipse;
    }

    public static EllipseFactory getInstance() {
        return instance;
    }
}
