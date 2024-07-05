package ru.topacademy.javaqa.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class GameTest {
    Game game = new Game();

    @Test
    public void testWinFirstPlayer() {
        Player player1 = new Player(1, "Роман", 10);
        Player player2 = new Player(2, "Вова", 5);
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("Роман", "Вова");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWinSecondPlayer() {
        Player player1 = new Player(1, "Роман", 10);
        Player player2 = new Player(2, "Вова", 15);
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("Роман", "Вова");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWinDraw() {
        Player player1 = new Player(1, "Роман", 5);
        Player player2 = new Player(2, "Вова", 5);
        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round("Роман", "Вова");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIfFirstPlayerException() {
        Player player1 = new Player(1, "Роман", 10);
        Player player2 = new Player(2, "Вова", 5);
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, ()-> {
            game.round("Эдик", "Вова");
        });
    }

    @Test
    public void testIfSecondPlayerException() {
        Player player1 = new Player(1, "Роман", 10);
        Player player2 = new Player(2, "Вова", 5);
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, ()-> {
            game.round("Роман", "Эдик");
        });
    }
}
