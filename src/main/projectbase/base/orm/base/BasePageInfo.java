package orm.base;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义分页
 * Created by 张宏 on 2016/5/3.
 */
public class BasePageInfo<T> extends PageInfo {

    /**
     * 需要剔除的字段
     */
    public List<String> removes = new ArrayList<String>();
    /**
     * 只显示的字段
     */
    public String selectMenu;

	public void addRemove(String... strs) {
        for (String str : strs) {
            this.removes.add(str);
        }
    }

	public <T> BasePageInfo(List<T> list) {
        super(list);
    }

    public List<String> getRemoves() {
        return removes;
    }

    public void setRemoves(List<String> removes) {
        this.removes = removes;
    }


    public String getSelectMenu() {
        return selectMenu;
    }

    public void setSelectMenu(String selectMenu) {
        this.selectMenu = selectMenu;
    }
}
