package com.zy.bk.entity;

public class Admin {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.id
     *
     * @mbggenerated Tue Mar 14 15:00:03 CST 2023
     */
    private Long id;


    private String account;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.username
     *
     * @mbggenerated Tue Mar 14 15:00:03 CST 2023
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin.password
     *
     * @mbggenerated Tue Mar 14 15:00:03 CST 2023
     */
    private String password;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.id
     *
     * @return the value of admin.id
     *
     * @mbggenerated Tue Mar 14 15:00:03 CST 2023
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.id
     *
     * @param id the value for admin.id
     *
     * @mbggenerated Tue Mar 14 15:00:03 CST 2023
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.username
     *
     * @return the value of admin.username
     *
     * @mbggenerated Tue Mar 14 15:00:03 CST 2023
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.username
     *
     * @param username the value for admin.username
     *
     * @mbggenerated Tue Mar 14 15:00:03 CST 2023
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin.password
     *
     * @return the value of admin.password
     *
     * @mbggenerated Tue Mar 14 15:00:03 CST 2023
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin.password
     *
     * @param password the value for admin.password
     *
     * @mbggenerated Tue Mar 14 15:00:03 CST 2023
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}