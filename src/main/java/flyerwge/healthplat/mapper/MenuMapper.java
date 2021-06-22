package flyerwge.healthplat.mapper;

import flyerwge.healthplat.entity.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    public List<MainMenu> getMenus();
}
