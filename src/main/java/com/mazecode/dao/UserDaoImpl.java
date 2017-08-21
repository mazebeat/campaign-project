package com.mazecode.dao;

import com.mazecode.model.Users;
import org.springframework.stereotype.Repository;

//@Repository("userDao")
@Repository
public class UserDaoImpl extends AbstractDao<Users> implements UserDao {
}
