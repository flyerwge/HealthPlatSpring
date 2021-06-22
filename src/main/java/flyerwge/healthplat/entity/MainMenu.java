package flyerwge.healthplat.entity;

import lombok.Data;

import java.util.List;

/**
 * 主导航
 */
@Data
public class MainMenu {
    private  Integer id;
    private  String title;
    private  String path;
    private  List<SubMenu> subMenuList;
}
