package radyuk.edu.shape.service.impl;

import radyuk.edu.shape.entity.Ellipse;
import radyuk.edu.shape.entity.Point;
import radyuk.edu.shape.exception.EllipseException;
import radyuk.edu.shape.service.EllipseService;

public class EllipseServiceImpl implements EllipseService {
    public static final String ERROR_MESSAGE = "Invalid ellipse";

    @Override
    public boolean isEllipse(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            throw new EllipseException(ERROR_MESSAGE);
        }
        double width = Math.abs(ellipse.getFirstPoint().x() - ellipse.getSecondPoint().x());
        double height = Math.abs(ellipse.getFirstPoint().y() - ellipse.getSecondPoint().y());
        boolean result = Double.compare(width, height) != 0;
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
        return result && isEllipseValid(ellipse);
    }

    @Override
    public boolean isEllipseValid(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            throw new EllipseException(ERROR_MESSAGE);
        }
        Point firstPoint = ellipse.getFirstPoint();
        Point secondPoint = ellipse.getSecondPoint();
        return firstPoint.x() != secondPoint.x()
                && firstPoint.y() != secondPoint.y();
    }

    @Override
    public boolean doesIntersectOneAxis(Ellipse ellipse, float distance) throws EllipseException {
        if (ellipse == null) {
            throw new EllipseException(ERROR_MESSAGE);
        }
        Point firstPoint = ellipse.getFirstPoint();
        Point secondPoint = ellipse.getSecondPoint();
        boolean doesIntersectXAxis = (Double.compare(firstPoint.x(), distance) == 0)
                || (Double.compare(secondPoint.x(), distance) == 0);
        boolean doesIntersectYAxis = (Double.compare(firstPoint.y(), distance) == 0)
                || (Double.compare(secondPoint.y(), distance) == 0);
        return (doesIntersectXAxis && !doesIntersectYAxis)
                || (!doesIntersectXAxis && doesIntersectYAxis);
    }

    @Override
    public double calculateArea(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            throw new EllipseException(ERROR_MESSAGE);
        }
        double a = Math.abs(ellipse.getFirstPoint().x() - ellipse.getSecondPoint().x()) / 2;
        double b = Math.abs(ellipse.getFirstPoint().y() - ellipse.getSecondPoint().y()) / 2;
        return Math.PI * a * b;
    }

    @Override
    public double calculatePerimeter(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            throw new EllipseException(ERROR_MESSAGE);
        }
        double a = Math.abs(ellipse.getFirstPoint().x() - ellipse.getSecondPoint().x()) / 2;
        double b = Math.abs(ellipse.getFirstPoint().y() - ellipse.getSecondPoint().y()) / 2;
        return 2 * Math.PI * Math.sqrt((a * a + b * b) / 2);
    }
}
