package com.dto;

/**
 * @author shkstart
 * @create 2022-05-31 20:55
 */
public class UserDTO {
    private Integer uid;
    private String userName;
    private String password;
    private Integer uState;
    private String phone;
    private String email;

    public UserDTO(Integer uid, String userName, String password, Integer uState, String phone, String email) {
        this.uid = uid;
        this.userName = userName;
        this.password = password;
        this.uState = uState;
        this.phone = phone;
        this.email = email;
    }

    public UserDTO() {
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getuState() {
        return uState;
    }

    public void setuState(Integer uState) {
        this.uState = uState;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uid +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", uState=" + uState +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
