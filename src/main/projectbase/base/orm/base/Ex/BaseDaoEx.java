package orm.base.Ex;

import org.apache.poi.ss.formula.functions.T;
import orm.base.BaseDao;
import orm.base.BasePageInfo;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据对接层统一实现
 * User: 汪超.
 * Date：2016/8/18
 * Time：15:17
 */
public class BaseDaoEx extends BaseDao {
	BaseDaoEx baseDaoEx;

	@PostConstruct
	protected void init() {
	}

	protected void init(Object dao) {
		this.baseDaoEx = (BaseDaoEx) dao;
	}
	/**
	 * 通用分页查询
	 *
	 * @param param
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	public <T> BasePageInfo<T> pagequery(Map param) throws Exception {
		return baseDaoEx.pageQuery(baseDaoEx.getClass().getName()+ ".pagequery", param);
	}

	/**
	 * 通用列表查询
	 * @param param
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	public <T> List<T> query(Map param) throws Exception{
		return baseDaoEx.query(baseDaoEx.getClass().getName() + ".pagequery", param);
	}

	/**
	 * 通用单条记录查询
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public <T> T selectp(String id) throws Exception {
		return baseDaoEx.get(baseDaoEx.getClass().getName()+ ".select", id);
	}

	/**
	 * 通用新增操作
	 *
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public int insertp(Map param) throws Exception {
		return baseDaoEx.save(baseDaoEx.getClass().getName()+ ".insert", param);
	}

	/**
	 * 通用新增列表操作
	 * @param list
	 * @return
	 * @throws Exception
     */
	public int insertListTp(List<Map> list) throws Exception{
		Map map = new HashMap();
		map.put("list",list);
		return baseDaoEx.save(baseDaoEx.getClass().getName()+ ".insertList",list);
	}

	/**
	 * 通用更新操作
	 *
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public int updatep(Map param) throws Exception {
		return baseDaoEx.update(baseDaoEx.getClass().getName()+ ".update", param);
	}

	/**
	 * 通用删除操作
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int removep(String id) throws Exception{
		return baseDaoEx.delete(baseDaoEx.getClass().getName()+ ".remove",id);
	}
}
