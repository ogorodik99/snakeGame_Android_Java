package com.example.snakegame;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.snakegame.R;
import com.example.snakegame.Snake;


public class MainActivity extends Activity {

    private Snake snake;
    private GameView gameView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Находим элементы кнопок по их id
        Button btnUp = findViewById(R.id.btnUp);
        Button btnDown = findViewById(R.id.btnDown);
        Button btnLeft = findViewById(R.id.btnLeft);
        Button btnRight = findViewById(R.id.btnRight);

        // Создаем объект класса Snake и передаем размер ячейки поля (в пикселях)
        snake = new Snake(0, 0, getResources().getDimensionPixelSize(R.dimen.cell_size));

        // Находим игровое поле по его id
        gameView = findViewById(R.id.gameBoard);

        // Устанавливаем слушателей для кнопок управления
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snake.setDirection(Direction.UP);
            }
        });

        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snake.setDirection(Direction.DOWN);
            }
        });

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snake.setDirection(Direction.LEFT);
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snake.setDirection(Direction.RIGHT);
            }
        });

        // Устанавливаем объект Snake для отображения на игровом поле
        gameView.setSnake(snake);

        // Запускаем игровой цикл (обновление и отрисовка игры)
        gameView.startGameLoop();

        // Создаем объект GameLoop и запускаем его
        GameLoop gameLoop = new GameLoop(snake, gameView);
        gameLoop.setRunning(true);
        gameLoop.start();

    }
}