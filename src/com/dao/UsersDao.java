package com.dao;

import com.entity.Users;

import java.util.List;

public interface UsersDao {
    void insertUsers(Users users);
    void deleteUsersById(Integer id);
    void updateUsers(Users users);
    Users selectUsersById(Integer id);
    Users selectUsersByUsername(String username);
    List<Users> selectUsers();

}
