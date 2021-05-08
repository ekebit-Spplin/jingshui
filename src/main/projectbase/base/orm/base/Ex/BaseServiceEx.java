package orm.base.Ex;

import com.alibaba.fastjson.JSONObject;
import orm.base.BaseService;
import orm.base.baseImp.BaseDaoInterface;
import wangchao.tools.CreateKey;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * User: 汪超.
 * Date：2016/8/19
 * Time：12:25
 */
public class BaseServiceEx extends BaseService{


	BaseDaoInterface baseDaoInterface;

	@PostConstruct
	public void init(){

	}

	public void init(Object dao){
		this.baseDaoInterface = (BaseDaoInterface) dao;
	}

	/**
	 * 通用分页查询
	 *
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JSONObject pagequery(Map param) throws Exception {
		return this.codeData(baseDaoInterface.pagequery(param));
	}

	/**
	 * 通用列表查询
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JSONObject query(Map param) throws Exception{
		return this.codeData(baseDaoInterface.query(param));
	}

	/**
	 * 通用单条数据查询
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public JSONObject selectp(String id) throws Exception {
		return this.codeData(baseDaoInterface.selectp(id));
	}

	/**
	 * 通用删除数据操作
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public JSONObject removep(String id) throws Exception {
		int ret = baseDaoInterface.removep(id);
		if (ret == -1)
			return this.codeMess(eCode, "删除失败");
		return this.codeMess(sCode, "删除成功");
	}

	/**
	 * 通用新增数据操作
	 *
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JSONObject insertp(Map param) throws Exception {
		param.put("id", CreateKey.get());
		int ret = baseDaoInterface.insertp(param);
		if (ret == -1)
			return this.codeMess(eCode, "新增失败");
		return this.codeData(param);
	}

	/**
	 * 通用批量新增数据操作
	 * @param list
	 * @return
	 * @throws Exception
     */
	public JSONObject insertListTp(List<Map> list) throws Exception{
		for(Map map:list){
			map.put("id",CreateKey.get());
		}
		int ret = baseDaoInterface.insertListTp(list);
		if (ret == -1)
			return this.codeMess(eCode,"新增失败");
		return this.codeMess(sCode,"新增成功");
	}

	/**
	 * 通用修改数据操作
	 *
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public JSONObject updatep(Map param) throws Exception {
		int ret = baseDaoInterface.updatep(param);
		if (ret == -1)
			return this.codeMess(eCode, "修改失败");
		return this.codeMess(sCode, "修改成功");
	}
}
