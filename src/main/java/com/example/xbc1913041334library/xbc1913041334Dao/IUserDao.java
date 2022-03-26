package com.example.xbc1913041334library.xbc1913041334Dao;

import java.util.List;

import com.example.xbc1913041334library.xbc1913041334Pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserDao {
   public User getUserById(Integer id);
   public User getUser1(Integer id,String userName);
   public User selectUserByUserName(String userName);
   public User getUser2(String userName,String passWord);
   public List<User> showAllUser();
}
