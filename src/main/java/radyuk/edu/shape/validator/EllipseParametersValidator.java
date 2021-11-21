package radyuk.edu.shape.validator;

import radyuk.edu.shape.entity.Point;

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
