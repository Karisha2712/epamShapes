package radyuk.edu.shape.validator;

import radyuk.edu.shape.entity.Ellipse;

public class EllipseParametersValidator {
    public static boolean areParametersValid(Ellipse ellipse) {
        if (ellipse.getFirstPoint() == null || ellipse.getSecondPoint() == null) {
            return false;
        }
        return ellipse.getFirstPoint().x() != ellipse.getSecondPoint().x()
                && ellipse.getFirstPoint().y() != ellipse.getSecondPoint().y();
    }
}
