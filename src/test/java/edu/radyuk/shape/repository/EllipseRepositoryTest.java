package edu.radyuk.shape.repository;

import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.exception.EllipseException;
import edu.radyuk.shape.factory.EllipseFactory;
import edu.radyuk.shape.filler.RepositoryFiller;
import edu.radyuk.shape.observer.impl.EllipseObserverImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EllipseRepositoryTest {
    private static final EllipseRepository repository = EllipseRepository.getInstance();
    private static final EllipseObserverImpl observer = new EllipseObserverImpl();
    private static final EllipseFactory ellipseFactory = EllipseFactory.getInstance();
    private static Ellipse ellipse1;
    private static Ellipse ellipse2;

    @BeforeAll
    static void setUp() throws EllipseException {
        RepositoryFiller repositoryFiller = new RepositoryFiller();
        List<Double> pointsCoordinates = new ArrayList<>();
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(10.0);
        pointsCoordinates.add(20.0);
        pointsCoordinates.add(20.0);
        ellipse1 = ellipseFactory.getEllipse(pointsCoordinates);
        ellipse1.attach(observer);
        List<Ellipse> ellipses = new ArrayList<>();
        ellipses.add(ellipse1);
        repositoryFiller.fillRepository(ellipses);
        List<Double> pointsCoordinates2 = new ArrayList<>();
        pointsCoordinates2.add(5.0);
        pointsCoordinates2.add(10.0);
        pointsCoordinates2.add(24.0);
        pointsCoordinates2.add(20.0);
        ellipse2 = ellipseFactory.getEllipse(pointsCoordinates2);
        ellipse2.attach(observer);
    }

    @Test
    public void ifSizeMethodWorks() {
        Assertions.assertEquals(repository.size(), 1);
    }

    @Test
    public void ifAddMethodWorks() {
        repository.add(ellipse2);
        Assertions.assertEquals(repository.size(), 2);
        repository.remove(ellipse2);
    }

    @Test
    public void ifRemoveMethodWorks() {
        repository.remove(ellipse1);
        Assertions.assertEquals(repository.size(), 0);
        repository.add(ellipse1);
    }

    @Test
    public void ifSetAndGetMethodsWork() throws EllipseException {
        repository.set(0, ellipse2);
        Assertions.assertEquals(ellipse2, repository.get(0));
        repository.remove(ellipse2);
    }

    @Test
    public void ifClearMethodsWorks() {
        repository.set(0, ellipse2);
        repository.clear();
        Assertions.assertEquals(repository.size(), 0);
        repository.add(ellipse1);
    }

    @Test
    public void ifIsEmptyMethodReturnsTrue() {
        repository.set(0, ellipse2);
        repository.clear();
        Assertions.assertTrue(repository.isEmpty());
        repository.add(ellipse1);
    }

    @Test
    public void ifIsEmptyMethodReturnsFalse() {
        Assertions.assertFalse(repository.isEmpty());
    }
}
