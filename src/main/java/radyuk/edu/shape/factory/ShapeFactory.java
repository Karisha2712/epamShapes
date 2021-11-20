package radyuk.edu.shape.factory;

import radyuk.edu.shape.entity.Ellipse;
import radyuk.edu.shape.entity.Point;
import radyuk.edu.shape.exception.EllipseException;


public final class ShapeFactory {
    public static final ShapeFactory instance = new ShapeFactory();

    private ShapeFactory() {

    }

    public Ellipse getEllipse(Point firstPoint, Point secondPoint) throws EllipseException {
        return new Ellipse(firstPoint, secondPoint);
    }

    private ShapeFactory getInstance() {
        return instance;
    }
}
