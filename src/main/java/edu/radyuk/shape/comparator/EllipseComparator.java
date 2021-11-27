package edu.radyuk.shape.comparator;

import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.exception.EllipseException;
import edu.radyuk.shape.service.impl.EllipseServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    },
    AREA {
        @Override
        public int compare(Ellipse o1, Ellipse o2) {
            double area1 = 0;
            double area2 = 0;
            try {
                EllipseServiceImpl ellipseService = new EllipseServiceImpl();
                area1 = ellipseService.calculateArea(o1);
                area2 = ellipseService.calculateArea(o2);
            } catch (EllipseException e) {
                logger.log(Level.ERROR, e);
            }
            return Double.compare(area1, area2);
        }
    };

    private static final Logger logger = LogManager.getLogger();
}
