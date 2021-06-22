package flyerwge.healthplat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import flyerwge.healthplat.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {
    public User getUserByMessage(@Param("userName") String userName, @Param("password") String password);
    public List<User> getAllUser(@Param("userName") String userName, @Param("pageStart") Integer pageStart, @Param("pageSize") Integer pageSize);
    public Integer getUserCounts(@Param("userName") String userName);
    public Integer updateState(@Param("id") Long id, @Param("state") Boolean state);
    public Integer deleteUser(@Param("id") Long id);
    public User getUpdateUser(@Param("id") Long id);
    public Integer editUser(User user);

    public Integer addUser(@Param("user") User user);

//    用户注册
    public Boolean userRegister(@Param("userName") String userName,@Param("password") String password,@Param("email") String email);

}
