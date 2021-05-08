package orm.base.baseImp;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.formula.functions.T;
import orm.base.BasePageInfo;

import java.util.List;
import java.util.Map;

/**
 * User: 汪超.
 * Date：2016/8/19
 * Time：12:27
 */
public interface BaseServiceInterface {
	/**
	 * 通用分页查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public abstract JSONObject pagequery(Map map)throws Exception;

	/**
	 * 通用单个查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public abstract JSONObject selectp(String id)throws Exception;

	/**
	 * 通用删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public abstract JSONObject removep(String id)throws Exception;

	/**
	 * 通用更新
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public abstract JSONObject updatep(Map map)throws Exception;

	/**
	 * 通用新增
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public abstract JSONObject insertp(Map map)throws Exception;

	/**
	 * 通用新增列表
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public abstract JSONObject insertListTp(List<Map> list) throws Exception;
}
