package edu.radyuk.shape.repository.impl;

import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.repository.EllipseSpecification;

public class EllipseFirstQuarterSpecification implements EllipseSpecification {
    public EllipseFirstQuarterSpecification() {

    }

    @Override
    public boolean specify(Ellipse ellipse) {
        boolean isBelongedToUpperHalfPlane = (ellipse.getFirstPoint().y() >= 0)
                && (ellipse.getSecondPoint().y() >= 0);
        boolean isBelongedToRightHalfPlane = (ellipse.getFirstPoint().x() >= 0)
                && (ellipse.getSecondPoint().x() >= 0);
        return isBelongedToRightHalfPlane && isBelongedToUpperHalfPlane;
    }
}
