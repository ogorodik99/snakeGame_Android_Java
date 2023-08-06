package com.example.snakegame;
public class GameLoop extends Thread {

    private static final long FPS = 10; // Частота обновления в кадрах в секунду
    private static final long MILLIS_PER_FRAME = 1000 / FPS; // Время между кадрами в миллисекундах

    private boolean running = false;
    private Snake snake;
    private GameView gameView;

    public GameLoop(Snake snake, GameView gameView) {
        this.snake = snake;
        this.gameView = gameView;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        long startTime;
        long sleepTime;

        while (running) {
            startTime = System.currentTimeMillis();

            // Обновляем состояние змейки
            snake.move();

            // Перерисовываем игровое поле
            gameView.postInvalidate();

            // Рассчитываем время ожидания до следующего кадра
            sleepTime = MILLIS_PER_FRAME - (System.currentTimeMillis() - startTime);
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
