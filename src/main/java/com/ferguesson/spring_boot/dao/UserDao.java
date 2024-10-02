package com.ferguesson.spring_boot.dao;


import com.ferguesson.spring_boot.model.User;

import java.util.List;

public interface UserDao {

   void saveUser(User user);

   void updateUser(User user);

   void removeUserById(long id);

   List<User> getAllUsers();

   void cleanUsersTable();
}
