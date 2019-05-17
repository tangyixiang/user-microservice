package com.cloud.usermodule.user.dao;

import com.cloud.usermodule.user.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    @Select("SELECT * FROM sys_user WHERE sysuserid = #{id}")
    @Results(id="id",value = {
            @Result(column="sysuserid",property="sysUserId"),
            @Result(column="username",property="userName"),
            @Result(column="password",property="password"),
            @Result(column="email",property="email"),
            @Result(column="company_id",property="companyId"),
            @Result(column="role_id",property="roleId"),
            @Result(column="permission_id",property="permissionId"),
            @Result(column="create_time",property="createTime"),
            @Result(column="user_state",property="status"),
            @Result(column="region",property="region")
    })
    User find(String id);

}
