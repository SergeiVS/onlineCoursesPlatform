package repository;

import java.util.HashMap;
import java.util.Map;

public class Passwords implements PasswordsRepositoryInterface{
    Map<Integer, Integer> passwords = new HashMap<>();

    //где оба поля ключ- е-майл и значение- пароль будут зашифрованы через Хэшкод.

    public Passwords(Map<Integer, Integer> passwords) {
        this.passwords = passwords;
    }

    public Map<Integer, Integer> getPasswords() {
        return passwords;
    }

    public void addPass(Integer emailHash, Integer passwordHash){
        // Добавление пароля и e-mail в коллекцию
        passwords.put(emailHash, passwordHash);

    }

    public boolean verifyPass(Integer eMailHash, Integer passwordHash){
        return passwords.entrySet().stream()
                // Фильтруем записи с указанным хэшем e-mail
                .filter(entry -> entry.getKey().equals(eMailHash))
                // Проверяем, совпадает ли хэш пароля
                .anyMatch(entry -> entry.getValue().equals(passwordHash)); // Проверяем, совпадает ли хэш пароля
    }



}
