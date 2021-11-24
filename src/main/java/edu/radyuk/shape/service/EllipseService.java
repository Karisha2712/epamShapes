package edu.radyuk.shape.service;

import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.exception.EllipseException;

public interface EllipseService {
    boolean isEllipse(Ellipse ellipse) throws EllipseException;

    boolean isCircle(Ellipse ellipse) throws EllipseException;

    boolean isEllipseValid(Ellipse ellipse) throws EllipseException;

    double calculateArea(Ellipse ellipse) throws EllipseException;

    double calculatePerimeter(Ellipse ellipse) throws EllipseException;

}
