package com.tianmao.dao;


import com.tianmao.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tianmao.entity.User;

public class UserDao {
    public User findUserByMark(String mark, String pass) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DatabaseUtil.getConnection();
            ps = con.prepareStatement("select * from Student where Sname=? or Srollno=?");
            ps.setString(1, mark);
            ps.setString(2, mark);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.close(rs, ps, con);
        }
        return null;
    }

}
