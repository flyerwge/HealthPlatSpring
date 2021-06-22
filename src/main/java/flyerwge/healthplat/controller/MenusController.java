package flyerwge.healthplat.controller;

import com.alibaba.fastjson.JSON;
import flyerwge.healthplat.entity.MainMenu;
import flyerwge.healthplat.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenusController {

    @Autowired
    private MenuMapper menuMapper;

    @RequestMapping("/menus")
    public String getAllMenus(){
        Boolean flag = false;
        HashMap<String,Object> menuHash = new HashMap<>();
        List<MainMenu> menusQuery = menuMapper.getMenus();

        if (menusQuery != null){
            menuHash.put("menus",menusQuery);
            flag = true;
            menuHash.put("flag",flag);
        }else{
            flag = false;
            menuHash.put("flag",flag);
        }

        String ans = JSON.toJSONString(menuHash);
//        System.out.println(ans);
        return ans;
    }
}
