package flyerwge.healthplat.controller;

import com.alibaba.fastjson.JSON;
import flyerwge.healthplat.entity.User;
import flyerwge.healthplat.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

//跨域问题：注解@CrossOrigin
//@CrossOrigin("http://localhost:8080")
@RestController
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    //@RequestBody:传递数据时找到User
    @RequestMapping("/login")
    public String login(@RequestBody User user){
        Boolean flag = false;
        HashMap<String,Object> userHash = new HashMap<>();
        User userQuery = userMapper.getUserByMessage(user.getUserName(),user.getPassword());    //数据库中获取数据作为对象
//        System.out.println("user:"+userQuery);

        if (userQuery != null){
            flag = true;
        }

        userHash.put("flag",flag);
        userHash.put("userQuery",userQuery);

        String userJson = JSON.toJSONString(userHash);
        return userJson;
    }
}
