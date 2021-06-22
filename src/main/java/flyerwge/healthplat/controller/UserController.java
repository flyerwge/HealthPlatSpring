package flyerwge.healthplat.controller;

import com.alibaba.fastjson.JSON;
import flyerwge.healthplat.entity.QueryInfo;
import flyerwge.healthplat.entity.User;
import flyerwge.healthplat.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("alluser")
    public String getUserList(QueryInfo queryInfo){
        int userCounts =  userMapper.getUserCounts("%"+queryInfo.getQuery()+"%"); //最大列表数
        int pageStart =  (queryInfo.getPageNum()-1)*queryInfo.getPageSize(); //当前编号

        List<User> userList =  userMapper.getAllUser("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String,Object> userHash = new HashMap<>();

        userHash.put("userCounts",userCounts);
        userHash.put("userList",userList);

        String userJson = JSON.toJSONString(userHash);
        return userJson;
    }

    @RequestMapping("/userstate")
    public String updateUserState(@RequestParam("id") Long id,@RequestParam("state") Boolean state){
        int isUpdate = userMapper.updateState(id, state);
        return  isUpdate > 0 ? "success" : "error";
    }

    /**
     * 通过mp实现向MySQL数据库插入数据
     * @param user：前端访问传入用户参数
     * @return
     */
    @RequestMapping("/adduser")
    public String addUser(@RequestBody User user){
        user.setState(0);
        int isInsert = userMapper.insert(user);
        return  isInsert > 0 ? "success" : "error";
    }

    /**
     * 根据主键删除用户信息
     * @param id
     * @return
     */
    @RequestMapping("/deleteuser")
    public String deleteUser(Long id){
        int isDelete = userMapper.deleteUser(id);
        return  isDelete > 0?"success":"error";
    }

    @RequestMapping("/getupdateuser")
    public String getUpdateUser(Long id){
        System.out.println(id);
        User user = userMapper.getUpdateUser(id);
        String str = JSON.toJSONString(user);
        return str;
    }

    @RequestMapping("/edituser")
    public String editUser(@RequestBody User user){
        int isEdit = userMapper.editUser(user);
        return  isEdit > 0 ? "success" :"error";
    }

//    用户注册
    public Boolean insertUserList(){
        Boolean isInsertUserList = false;

        return  isInsertUserList;
    }
}