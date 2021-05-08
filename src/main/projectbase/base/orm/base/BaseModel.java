package orm.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 实体类基类
 * Created by 张宏 on 2016/5/3.
 */
public class BaseModel {
    private Integer pageNo = 1;//页码
    private Integer pageSize = 10;//每页显示个数

    /**
     * 需要剔除的字段
     */
    public List<String> removes = new ArrayList<String>();

    /**
     * 构造方法 去除一些不需要的字段
     */
    public BaseModel() {
        this.removes.add("pageNo");
        this.removes.add("pageSize");
        this.removes.add("removes");
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;

    }

    public List<String> getRemoves() {
        return removes;
    }

    public void setRemoves(List<String> removes) {
        this.removes = removes;
    }

}