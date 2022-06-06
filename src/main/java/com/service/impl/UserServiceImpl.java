package com.service.impl;

import com.dto.UserDTO;
import com.dao.UserDAO;
import com.service.UserService;

/**
 * @author shkstart
 * @create 2022-06-02 1:21
 */
public class UserServiceImpl implements UserService {
    UserDAO userDao=new UserDAO();
    @Override
    public void saveUser(UserDTO user) throws Exception {
        userDao.addUser(user);
    }

    @Override
    public void editUser(UserDTO user) throws Exception {
        userDao.updateUser(user);
    }

    @Override
    public UserDTO getUser(Integer id) throws Exception {
        return userDao.getUserDTOById(id);
    }

}
