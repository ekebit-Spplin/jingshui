package orm.base.baseImp;

import org.apache.poi.ss.formula.functions.T;
import orm.base.BasePageInfo;

import java.util.List;
import java.util.Map;

/**
 * User: 汪超.
 * Date：2016/8/19
 * Time：12:28
 */
public interface BaseDaoInterface {
	/**
	 * 通用分页
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public abstract <T> BasePageInfo<T> pagequery(Map map) throws Exception;

	/**
	 * 通用列表查询
	 * @param map
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	public abstract <T> List<T> query(Map map) throws Exception;
	/**
	 * 通用新增
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public abstract int insertp(Map map) throws Exception;

	/**
	 * 通用新增列表操作
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public abstract int insertListTp(List<Map> list) throws Exception;

	/**
	 * 通用更新
	 */
	public abstract int updatep(Map map) throws Exception;

	/**
	 * 通用查询单个
	 * @param id
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	public abstract <T> T selectp(String id) throws Exception;

	/**
	 * 通用删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public abstract int removep(String id) throws Exception;
}
