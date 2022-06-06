package com.dao;

import com.dto.UserDTO;
import com.dao.BaseDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-06-01 8:03
 */
public class UserDAO extends BaseDAO<UserDTO>  {

    public void addUser(UserDTO user) throws SQLException {
            String sql="insert into t_user(u_id ,u_name,u_password,u_state,u_phone,u_email) values(?,?,?,?,?,?)";
            update(sql,user.getUserName(),user.getPassword(),user.getuState(),user.getPhone(),user.getEmail());
    }


    public void updateUser(UserDTO user) throws SQLException {
        String sql="update t_user set u_name=?,u_password=?,u_state=?,u_phone=?,u_email=? where u_id=?";
        update(sql,user.getUserName(),user.getPassword(),user.getuState(),user.getPhone(),user.getEmail(),user.getUid());

    }


    public void deleteUser(Integer Id) throws SQLException {
        String sql="delete from t_user where u_id=?";
        update(sql,Id);
    }


    public List<UserDTO> getUserDTOList() throws SQLException {
        String sql="select u_id uId,u_name userName,u_password password,u_state uState,u_phone phone,u_email email from t_user";
        return getBeanList(UserDTO.class,sql);
    }


    public UserDTO getUserDTOById(Integer Id) throws SQLException {
        String sql="select u_id uId,u_name userName,u_password password,u_state uState,u_phone phone,u_email email from t_user where u_id=?";
        return getBean(UserDTO.class,sql,Id);
    }
}
