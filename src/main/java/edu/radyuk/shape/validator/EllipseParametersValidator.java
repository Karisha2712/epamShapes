package edu.radyuk.shape.validator;

import edu.radyuk.shape.entity.Point;

public class EllipseParametersValidator {
    private EllipseParametersValidator() {

    }

    public static boolean areParametersValid(Point firstPoint, Point secondPoint) {
        if (firstPoint == null || secondPoint == null) {
            return false;
        }
        return firstPoint.x() != secondPoint.x()
                && firstPoint.y() != secondPoint.y();
    }
}
