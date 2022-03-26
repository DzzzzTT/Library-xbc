//package com.example.xbc1913041334library.xbc1913041334Dao.impl;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import com.example.xbc1913041334library.xbc1913041334Dao.IUserDao;
//import com.example.xbc1913041334library.xbc1913041334Pojo.User;
//import org.springframework.stereotype.Repository;
//
//
//@Repository
//public class UserDaoImpl implements IUserDao {
//    private List<User> users =new ArrayList<User>();
//
//    public UserDaoImpl() {
//		super();
//		users.add(new User(1,"user_name_1","123456","note_1"));
//		users.add(new User(2,"user_name_2","123456","note_2"));
//		users.add(new User(3,"user_name_3","123456","note_3"));
//	}
//
//	@Override
//	public User getUser(Integer id) {
//		// TODO Auto-generated method stub
//		for(User user:users) {
//		  if(user.getId()==id)
//			  return user;
//		}
//		return null;
//	}
//
//	@Override
//	public User getUser(Integer id, String userName) {
//		// TODO Auto-generated method stub
//		System.out.println("dao层"+id+"   "+userName);
//		for(User user:users) {
//			  if(user.getId()==id&&user.getUserName().equals(userName))
//				  return user;
//			}
//		return null;
//	}
//
//	@Override
//	public User getUser(String userName, String passWord) {
//    	 Boolean flag=false;
//		for(User user:users) {
//			if(user.getPassWord()==passWord&&user.getUserName().equals(userName))
//				return user;
//		}
//		return null;
//	}
//
//	@Override
//	public List<User> showAllUser() {
//		// TODO Auto-generated method stub
//		return users;
//	}
//
//}
