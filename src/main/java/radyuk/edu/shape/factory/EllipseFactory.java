package radyuk.edu.shape.factory;

import radyuk.edu.shape.entity.Ellipse;
import radyuk.edu.shape.entity.Point;
import radyuk.edu.shape.exception.EllipseException;

import java.util.List;


public final class EllipseFactory {
    public static final EllipseFactory instance = new EllipseFactory();
    public static final int COORDINATES_NUMBER = 4;

    private EllipseFactory() {

    }

    public Ellipse getEllipse(List<Double> pointsCoordinates) throws EllipseException {
        if (pointsCoordinates.size() != COORDINATES_NUMBER) {
            throw new EllipseException("Invalid number of coordinates: " + pointsCoordinates);
        }
        Point firstPoint = new Point(pointsCoordinates.get(0), pointsCoordinates.get(1));
        Point secondPoint = new Point(pointsCoordinates.get(2), pointsCoordinates.get(3));
        return new Ellipse(firstPoint, secondPoint);
    }

    private EllipseFactory getInstance() {
        return instance;
    }
}
