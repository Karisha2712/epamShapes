package edu.radyuk.shape.repository;

import edu.radyuk.shape.comparator.EllipseAreaComparator;
import edu.radyuk.shape.comparator.EllipseComparator;
import edu.radyuk.shape.entity.Ellipse;
import edu.radyuk.shape.exception.EllipseException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EllipseRepository {
    private static final EllipseRepository instance = new EllipseRepository();
    private final List<Ellipse> ellipseStorage;

    private EllipseRepository() {
        ellipseStorage = new ArrayList<>();
    }

    public static EllipseRepository getInstance() {
        return instance;
    }

    public int size() {
        return ellipseStorage.size();
    }

    public void add(Ellipse ellipse) {
        ellipseStorage.add(ellipse);
    }

    public void set(int index, Ellipse ellipse) {
        ellipseStorage.set(index, ellipse);
    }

    public Ellipse get(int index) throws EllipseException {
        if (index >= ellipseStorage.size()) {
            throw new EllipseException("Invalid index");
        }
        return ellipseStorage.get(index);
    }

    public void remove(Ellipse ellipse) {
        ellipseStorage.remove(ellipse);
    }

    public void clear() {
        ellipseStorage.clear();
    }

    public boolean isEmpty() {
        return ellipseStorage.isEmpty();
    }

    public List<Ellipse> getEllipseStorage() {
        return List.copyOf(ellipseStorage);
    }

    public List<Ellipse> sort(EllipseComparator comparator) {
        return ellipseStorage.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public List<Ellipse> sortByArea() {
        return ellipseStorage.stream()
                .sorted(new EllipseAreaComparator())
                .collect(Collectors.toList());
    }

    public List<Ellipse> query(EllipseSpecification specification) {
        return ellipseStorage.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
    }
}
