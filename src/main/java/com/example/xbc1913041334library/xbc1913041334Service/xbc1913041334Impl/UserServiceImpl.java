package com.example.xbc1913041334library.xbc1913041334Service.xbc1913041334Impl;

import java.util.List;

import com.example.xbc1913041334library.xbc1913041334Dao.IUserDao;
import com.example.xbc1913041334library.xbc1913041334Pojo.User;
import com.example.xbc1913041334library.xbc1913041334Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {
    @Autowired
	private IUserDao userDao;

	@Override
	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}

	@Override
	public User getUser1(Integer id, String userName) {
		return userDao.getUser1(id,userName);
	}

	@Override
	public User selectUserByUserName(String userName) {
		return userDao.selectUserByUserName(userName);
	}

	@Override
	public User getUser2(String userName, String passWord) {
		return userDao.getUser2(userName,passWord);
	}

	@Override
	public List<User> showAllUser() {
		return userDao.showAllUser();
	}



}
