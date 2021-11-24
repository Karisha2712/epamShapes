package edu.radyuk.shape.validator;

import edu.radyuk.shape.entity.Point;

public interface EllipseParametersValidator {
    boolean areParametersValid(Point firstPoint, Point secondPoint);
}
