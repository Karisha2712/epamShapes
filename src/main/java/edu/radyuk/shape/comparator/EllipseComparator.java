package edu.radyuk.shape.comparator;

import edu.radyuk.shape.entity.Ellipse;

import java.util.Comparator;

public enum EllipseComparator implements Comparator<Ellipse> {
    ID {
        @Override
        public int compare(Ellipse o1, Ellipse o2) {
            return o1.getEllipseId() - o2.getEllipseId();
        }
    },

    X_COORDINATE {
        @Override
        public int compare(Ellipse o1, Ellipse o2) {
            return Double.compare(o1.getFirstPoint().x(), o2.getFirstPoint().x());
        }
    },

    Y_COORDINATE {
        @Override
        public int compare(Ellipse o1, Ellipse o2) {
            return Double.compare(o1.getFirstPoint().y(), o2.getFirstPoint().y());
        }
    }
}
