package lesson4;

import javafx.application.Application;

public interface AuthService {
    void addUser(String name, String pass);

    boolean auth(String name, String pass);
}
