package radyuk.edu.shape.service;

import radyuk.edu.shape.entity.Ellipse;
import radyuk.edu.shape.exception.EllipseException;

public interface EllipseService {
    boolean isEllipse(Ellipse ellipse) throws EllipseException;

    boolean isCircle(Ellipse ellipse) throws EllipseException;

    boolean isEllipseValid(Ellipse ellipse) throws EllipseException;

    double calculateArea(Ellipse ellipse) throws EllipseException;

    double calculatePerimeter(Ellipse ellipse) throws EllipseException;

}
