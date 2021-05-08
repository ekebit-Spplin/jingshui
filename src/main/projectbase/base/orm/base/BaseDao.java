package orm.base;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库操作
 *
 * @author WangChao
 */

public class BaseDao extends SqlSessionDaoSupport {

    // 默认每页显示10条
    private int pageSize = 10;

    // 默认页数1
    private int pageNo = 1;

    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        // TODO Auto-generated method stub
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }


    /**
     * 分页
     *
     * @param sqlId
     * @param param
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> BasePageInfo<T> pageQuery(String sqlId, Object param) throws Exception {
        if (param instanceof BaseModel) {
            PageHelper.startPage(((BaseModel) param).getPageNo(), ((BaseModel) param).getPageSize());
        }
        List<T> list = (List<T>) (param == null ? list = this.query(sqlId) : this.query(sqlId, param));
        BasePageInfo<T> pageInfo = new BasePageInfo(list);
        if (param instanceof BaseModel) {//存入剔除的字段
            pageInfo.getRemoves().addAll(((BaseModel) param).getRemoves());
        }
        return pageInfo;
    }

    /**
     * 新增
     *
     * @param sqlId
     * @param t
     * @return
     */
    public <T> int save(String sqlId, T t) throws Exception {
        return getSqlSession().insert(sqlId, t);
    }

	/**
	 * 批量新增
	 * @param sqlId
	 * @param t
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	public <T> int save_list(String sqlId,T t)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", t);
		return getSqlSession().insert(sqlId, map);
	}

    /**
     * 更新
     *
     * @param sqlId
     * @param t
     * @return
     */
    public <T> int update(String sqlId, T t) throws Exception {
        return getSqlSession().update(sqlId, t);
    }

    /**
     * 删除
     *
     * @param sqlId
     * @param t
     * @return
     */
    public <T> int delete(String sqlId, T t) throws Exception {
        return getSqlSession().delete(sqlId, t);
    }

    /**
     * 返回第一条
     *
     * @param sqlId
     * @return
     */
    public <T> T get(String sqlId, Object param) throws Exception {
        return getSqlSession().selectOne(sqlId, param);
    }

    /**
     * 查询
     *
     * @param sqlId
     * @return
     */
    public <T> List<T> query(String sqlId) throws Exception {
        return getSqlSession().selectList(sqlId);
    }

    public <T> List<T> query(String sqlId, Object param) throws Exception {
        return getSqlSession().selectList(sqlId, param);
    }

    // 获得当前序列
    public String currval(String seq_name) throws Exception {
        return getSqlSession().selectOne("base.currval", seq_name);
    }

    // 获得下一个序列
    public String nextval(String seq_name) throws Exception {
        return getSqlSession().selectOne("base.nextval", seq_name);
    }

    // 设置序列的值
    public String setval(Map<String, Integer> map) throws Exception {
        return getSqlSession().selectOne("base.setval", map);
    }

    /**
     * 字典表数据查询
     *
     * @return
     */
    public Map<String, String> getValue(Map<String, String> map) throws Exception {
        return getSqlSession().selectOne("base.getValue", map);
    }
}
