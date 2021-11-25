package edu.radyuk.shape.repository.impl;

import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.repository.EllipseSpecification;

public class EllipseIdRangeSpecification implements EllipseSpecification {
    private final int idFrom;
    private final int idTo;

    public EllipseIdRangeSpecification(int idFrom, int idTo) {
        this.idFrom = idFrom;
        this.idTo = idTo;
    }

    @Override
    public boolean specify(Ellipse ellipse) {
        return ((ellipse.getEllipseId() > idFrom) && (ellipse.getEllipseId() < idTo));
    }
}
