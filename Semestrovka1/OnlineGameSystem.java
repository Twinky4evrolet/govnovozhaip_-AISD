//Задача: Представьте, что вы разрабатываете backend для высоконагруженного
//сервиса (например, онлайн-игры). Вам нужно хранить userID пользователей,
//которые сейчас находятся в сети.
//Когда пользователь заходит, система делает insert(userID).
//Когда выходит — delete(userID).
//Когда нужно проверить, активен ли друг пользователя, вызывается contains(userID).

import java.util.Scanner;

public class OnlineGameSystem {
    private Treap activeUsers;

    public OnlineGameSystem() {
        this.activeUsers = new Treap();
    }

    public void userLogin(int userId) {
        if (!activeUsers.contains(userId)) {
            activeUsers.insert(userId);
            System.out.println("Игрок " + userId + " вошел в сеть.");
        } else {
            System.out.println("Игрок " + userId + " уже в сети.");
        }
    }

    public void userLogout(int userId) {
        if (activeUsers.contains(userId)) {
            activeUsers.delete(userId);
            System.out.println("Игрок " + userId + " вышел из сети.");
        } else {
            System.out.println("Игрок " + userId + " не найден в системе.");
        }
    }

    public void checkFriendStatus(int userId) {
        if (activeUsers.contains(userId)) {
            System.out.println("Статус игрока " + userId + ": В СЕТИ");
        } else {
            System.out.println("Статус игрока " + userId + ": ОФФЛАЙН");
        }
    }

    public void showAllOnline() {
        System.out.print("Список ID игроков в сети (отсортирован): ");
        activeUsers.display();
    }

    public static void main(String[] args) {
        OnlineGameSystem gameServer = new OnlineGameSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Система управления сессиями (на базе Treap) ---");

        // Пример работы:
        gameServer.userLogin(105);
        gameServer.userLogin(200);
        gameServer.userLogin(50);

        gameServer.showAllOnline();

        gameServer.checkFriendStatus(200);
        gameServer.checkFriendStatus(999);

        gameServer.userLogout(105);
        gameServer.showAllOnline();

    }
}