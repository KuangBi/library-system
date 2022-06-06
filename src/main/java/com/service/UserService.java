package com.service;

import com.dto.UserDTO;

/**
 * @author shkstart
 * @create 2022-06-02 1:12
 */
public interface UserService {
    /**
     * 注册用户
     */
    void saveUser(UserDTO user) throws Exception;
    /**
     * 修改用户
     */
    void editUser(UserDTO user) throws Exception;
    /**
     * 查询个人信息
     */
    UserDTO getUser(Integer id) throws Exception;

}
