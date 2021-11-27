package edu.radyuk.shape.repository;

import edu.radyuk.shape.comparator.EllipseComparator;
import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.exception.EllipseException;
import edu.radyuk.shape.factory.EllipseFactory;
import edu.radyuk.shape.filler.RepositoryFiller;
import edu.radyuk.shape.observer.impl.EllipseObserverImpl;
import edu.radyuk.shape.repository.impl.EllipseAreaSpecification;
import edu.radyuk.shape.repository.impl.EllipseFirstQuarterSpecification;
import edu.radyuk.shape.repository.impl.EllipseIdRangeSpecification;
import edu.radyuk.shape.repository.impl.EllipseSecondQuarterSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EllipseRepositoryTest {
    private static final EllipseRepository repository = EllipseRepository.getInstance();
    private static Ellipse ellipse1;
    private static Ellipse ellipse2;

    @BeforeAll
    static void setUp() throws EllipseException {
        EllipseFactory ellipseFactory = EllipseFactory.getInstance();
        EllipseObserverImpl observer = new EllipseObserverImpl();
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
        pointsCoordinates2.add(-5.0);
        pointsCoordinates2.add(8.0);
        pointsCoordinates2.add(-6.0);
        pointsCoordinates2.add(9.0);
        ellipse2 = ellipseFactory.getEllipse(pointsCoordinates2);
        ellipse2.attach(observer);
    }

    @Test
    public void ifSizeMethodWorks() {
        assertEquals(repository.size(), 1);
    }

    @Test
    public void ifAddMethodWorks() {
        repository.add(ellipse2);
        assertEquals(repository.size(), 2);
    }

    @Test
    public void ifRemoveMethodWorks() {
        repository.remove(ellipse1);
        assertEquals(repository.size(), 0);
    }

    @Test
    public void ifSetAndGetMethodsWork() throws EllipseException {
        repository.set(0, ellipse2);
        assertEquals(ellipse2, repository.get(0));
    }

    @Test
    public void ifClearMethodsWorks() {
        repository.set(0, ellipse2);
        repository.clear();
        assertEquals(repository.size(), 0);
    }

    @Test
    public void ifSortByYCoordinateIsCorrect() {
        EllipseComparator comparator = EllipseComparator.Y_COORDINATE;
        repository.add(ellipse2);
        List<Ellipse> actualEllipses = repository.sort(comparator);
        List<Ellipse> expectedEllipses = new ArrayList<>();
        expectedEllipses.add(ellipse2);
        expectedEllipses.add(ellipse1);
        assertEquals(expectedEllipses, actualEllipses);
    }

    @Test
    public void ifSortByXCoordinateIsCorrect() {
        EllipseComparator comparator = EllipseComparator.X_COORDINATE;
        repository.add(ellipse2);
        List<Ellipse> actualEllipses = repository.sort(comparator);
        List<Ellipse> expectedEllipses = new ArrayList<>();
        expectedEllipses.add(ellipse2);
        expectedEllipses.add(ellipse1);
        assertEquals(expectedEllipses, actualEllipses);
    }

    @Test
    public void ifQueryByIdSpecificationReturnsValidValues() {
        repository.add(ellipse2);
        EllipseSpecification specification = new EllipseIdRangeSpecification(1, 3);
        List<Ellipse> actualEllipses = repository.query(specification);
        List<Ellipse> expectedEllipses = new ArrayList<>();
        expectedEllipses.add(ellipse2);
        assertEquals(expectedEllipses, actualEllipses);
    }

    @Test
    public void ifQueryByAreaSpecificationReturnsValidValues() {
        repository.add(ellipse2);
        EllipseSpecification specification = new EllipseAreaSpecification(60, 80);
        List<Ellipse> actualEllipses = repository.query(specification);
        List<Ellipse> expectedEllipses = new ArrayList<>();
        expectedEllipses.add(ellipse1);
        assertEquals(expectedEllipses, actualEllipses);
    }

    @Test
    public void ifQueryByFirstQuarterSpecificationReturnsValidValues() {
        repository.add(ellipse2);
        EllipseSpecification specification = new EllipseFirstQuarterSpecification();
        List<Ellipse> actualEllipses = repository.query(specification);
        List<Ellipse> expectedEllipses = new ArrayList<>();
        expectedEllipses.add(ellipse1);
        assertEquals(expectedEllipses, actualEllipses);
    }

    @Test
    public void ifQueryBySecondQuarterSpecificationReturnsValidValues() {
        repository.add(ellipse2);
        EllipseSpecification specification = new EllipseSecondQuarterSpecification();
        List<Ellipse> actualEllipses = repository.query(specification);
        List<Ellipse> expectedEllipses = new ArrayList<>();
        expectedEllipses.add(ellipse2);
        assertEquals(expectedEllipses, actualEllipses);
    }

    @Test
    public void ifGetEllipseStorageReturnsCorrectValue() {
        repository.add(ellipse2);
        List<Ellipse> actualEllipses = repository.getEllipseStorage();
        List<Ellipse> expectedEllipses = new ArrayList<>();
        expectedEllipses.add(ellipse1);
        expectedEllipses.add(ellipse2);
        assertEquals(expectedEllipses, actualEllipses);
    }

    @Test
    public void ifSortByIdIsCorrect() {
        EllipseComparator comparator = EllipseComparator.ID;
        repository.remove(ellipse1);
        repository.add(ellipse2);
        repository.add(ellipse1);
        List<Ellipse> actualEllipses = repository.sort(comparator);
        List<Ellipse> expectedEllipses = new ArrayList<>();
        expectedEllipses.add(ellipse1);
        expectedEllipses.add(ellipse2);
        assertEquals(expectedEllipses, actualEllipses);
    }

    @Test
    public void ifSortByAreaIsCorrect() {
        EllipseComparator comparator = EllipseComparator.AREA;
        repository.add(ellipse2);
        List<Ellipse> actualEllipses = repository.sort(comparator);
        List<Ellipse> expectedEllipses = new ArrayList<>();
        expectedEllipses.add(ellipse2);
        expectedEllipses.add(ellipse1);
        assertEquals(expectedEllipses, actualEllipses);
    }

    @Test
    public void ifIsEmptyMethodReturnsTrue() {
        repository.set(0, ellipse2);
        repository.clear();
        assertTrue(repository.isEmpty());
    }

    @Test
    public void ifIsEmptyMethodReturnsFalse() {
        assertFalse(repository.isEmpty());
    }
}
