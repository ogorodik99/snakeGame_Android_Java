package com.example.snakegame;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;

import java.util.ArrayList;

public class GameView extends View {

    private Snake snake;
    private Paint snakePaint;
    private int cellSize;

    public GameView(Context context, Snake snake) {
        super(context);
        this.snake = snake;

        // Создаем объект Paint для рисования змейки
        snakePaint = new Paint();
        snakePaint.setColor(Color.GREEN);

        // Получаем размер ячейки поля из змейки
        cellSize = snake.getCellSize();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Отрисовываем змейку
        ArrayList<Point> body = snake.getBody();
        for (Point p : body) {
            canvas.drawRect(p.x, p.y, p.x + cellSize, p.y + cellSize, snakePaint);
        }
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
        // Перерисовываем View после изменения змейки
        invalidate();
    }

    public void startGameLoop() {
        // Здесь ты можешь добавить код для запуска игрового цикла
        // например, обновление змейки и отрисовка в цикле с определенной задержкой
    }
}
