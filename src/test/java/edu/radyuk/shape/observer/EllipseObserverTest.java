package edu.radyuk.shape.observer;

import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.entity.Point;
import edu.radyuk.shape.exception.EllipseException;
import edu.radyuk.shape.factory.EllipseFactory;
import edu.radyuk.shape.filler.WarehouseFiller;
import edu.radyuk.shape.observer.impl.EllipseObserverImpl;
import edu.radyuk.shape.warehouse.EllipseParameters;
import edu.radyuk.shape.warehouse.Warehouse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EllipseObserverTest {
    private final Warehouse warehouse = Warehouse.getInstance();
    private static final EllipseObserverImpl observer = new EllipseObserverImpl();
    private static final EllipseFactory ellipseFactory = EllipseFactory.getInstance();
    private static Ellipse ellipse;

    @BeforeAll
    static void setUp() throws EllipseException {
        WarehouseFiller warehouseFiller = new WarehouseFiller();
        List<Double> pointsCoordinates = new ArrayList<>();
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(20.0);
        pointsCoordinates.add(20.0);
        ellipse = ellipseFactory.getEllipse(pointsCoordinates);
        ellipse.attach(observer);
        List<Ellipse> ellipses = new ArrayList<>();
        ellipses.add(ellipse);
        warehouseFiller.fillWarehouse(ellipses);
    }

    @Test
    public void ifDataIsChanged() throws EllipseException {
        EllipseParameters oldParameters = warehouse.receiveParameters(ellipse.getEllipseId());
        double oldArea = oldParameters.getArea();
        double oldPerimeter = oldParameters.getPerimeter();
        ellipse.setSecondPoint(new Point(3.0, 4.0));
        EllipseParameters newParameters = warehouse.receiveParameters(ellipse.getEllipseId());
        double newArea = newParameters.getArea();
        double newPerimeter = newParameters.getPerimeter();
        assertTrue((Double.compare(oldArea, newArea) != 0)
                && (Double.compare(oldPerimeter, newPerimeter) != 0));

    }
}
