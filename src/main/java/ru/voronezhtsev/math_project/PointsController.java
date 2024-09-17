package ru.voronezhtsev.math_project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PointsController {
    private final CoordinateService coordinateService;

    public PointsController(CoordinateService coordinateService) {
        this.coordinateService = coordinateService;
    }

    @GetMapping("/points")
    public List<Point> getPoints() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(coordinateService.getX(), coordinateService.getY()));
        return points;
    }

    public static class Point {
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Double getX() {
            return x;
        }

        public Double getY() {
            return y;
        }
    }
}
