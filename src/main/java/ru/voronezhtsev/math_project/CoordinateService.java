package ru.voronezhtsev.math_project;

import org.springframework.stereotype.Service;

@Service
public class CoordinateService {
    private int x;
    private int y;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
