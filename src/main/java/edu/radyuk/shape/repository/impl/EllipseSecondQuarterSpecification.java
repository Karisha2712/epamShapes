package edu.radyuk.shape.repository.impl;

import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.repository.EllipseSpecification;

public class EllipseSecondQuarterSpecification implements EllipseSpecification {
    public EllipseSecondQuarterSpecification() {

    }

    @Override
    public boolean specify(Ellipse ellipse) {
        boolean isBelongedToUpperHalfPlane = (ellipse.getFirstPoint().y() >= 0)
                && (ellipse.getSecondPoint().y() >= 0);
        boolean isBelongedToLeftHalfPlane = (ellipse.getFirstPoint().x() <= 0)
                && (ellipse.getSecondPoint().x() <= 0);
        return isBelongedToLeftHalfPlane && isBelongedToUpperHalfPlane;
    }
}
