package edu.radyuk.shape.observer;

import edu.radyuk.shape.entity.Ellipse;

public interface EllipseObserver {
    void updateParameters(Ellipse ellipse);
}
