package flyerwge.healthplat.entity;

import lombok.Data;

@Data
public class QueryInfo {
    private String query;    //查询信息
    private Integer pageNum = 1;    //当前页码
    private Integer pageSize = 1;    //每页最大数
}
