package com.example.dao;
import com.example.model.User;
import java.util.ArrayList;
import java.util.List;

public class Userdao {
    private static List<User> users = new ArrayList<>();
    private static int idCounter = 1;

    public List<User> getAllUsers() { return users; }

    public void addUser(User user) {
        user.setId(idCounter++);
        users.add(user);
    }

    public User getUser(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    public void updateUser(User user) {
        User existing = getUser(user.getId());
        if (existing != null) {
            existing.setName(user.getName());
            existing.setEmail(user.getEmail());
        }
    }

    public void deleteUser(int id) {
        users.removeIf(u -> u.getId() == id);
    }
}
