package edu.radyuk.shape.validator.impl;

import edu.radyuk.shape.entity.Point;
import edu.radyuk.shape.validator.EllipseParametersValidator;

public class EllipseParametersValidatorImpl implements EllipseParametersValidator {
    public EllipseParametersValidatorImpl() {

    }

    public boolean areParametersValid(Point firstPoint, Point secondPoint) {
        if (firstPoint == null || secondPoint == null) {
            return false;
        }
        return firstPoint.x() != secondPoint.x()
                && firstPoint.y() != secondPoint.y();
    }
}
