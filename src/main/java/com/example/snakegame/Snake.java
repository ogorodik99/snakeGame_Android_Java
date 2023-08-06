package com.example.snakegame;
import android.graphics.Point;
import java.util.ArrayList;


public class Snake {
    // Переменные для хранения координат головы и тела змейки
    private ArrayList<Point> body;
    private int headX, headY;

    // Переменные для хранения направления движения
    private int direction;

    // Размер ячейки поля
    private int cellSize;

    // Конструктор класса Snake
    public Snake(int initialX, int initialY, int cellSize) {
        this.body = new ArrayList<>();
        this.headX = initialX;
        this.headY = initialY;
        this.cellSize = cellSize;
        this.direction = Direction.RIGHT; // Задай начальное направление движения
    }

    // Метод для движения змейки
    public void move() {
        // Обновляем координаты головы змейки в зависимости от текущего направления
        switch (direction) {
            case Direction.UP:
                headY -= cellSize;
                break;
            case Direction.DOWN:
                headY += cellSize;
                break;
            case Direction.LEFT:
                headX -= cellSize;
                break;
            case Direction.RIGHT:
                headX += cellSize;
                break;
        }

        // Создаем новую точку для головы и добавляем ее в начало списка тела змейки
        Point newHead = new Point(headX, headY);
        body.add(0, newHead);
    }

    // Метод для установки нового направления движения
    public void setDirection(int newDirection) {
        // Запрещаем изменение направления на противоположное текущему
        if (Math.abs(direction - newDirection) != 2) {
            direction = newDirection;
        }
    }

    // Метод для проверки столкновения с границами поля
    public boolean checkCollisionWithBounds(int fieldWidth, int fieldHeight) {
        return headX < 0 || headY < 0 || headX >= fieldWidth || headY >= fieldHeight;
    }

    // Метод для проверки столкновения с самой собой (телом змейки)
    public boolean checkCollisionWithSelf() {
        for (int i = 1; i < body.size(); i++) {
            if (headX == body.get(i).x && headY == body.get(i).y) {
                return true;
            }
        }
        return false;
    }

    // Метод для получения списка точек, представляющих тело змейки
    public ArrayList<Point> getBody() {
        return body;
    }
    // Метод для получения размера ячейки поля
    public int getCellSize() {
        return cellSize;
    }
}
