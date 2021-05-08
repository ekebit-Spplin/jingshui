package orm.base.Ex;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import orm.base.BaseController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * User: 汪超.
 * Date：2016/8/18
 * Time：18:07
 */
@Controller
@Scope("prototype")
public class BaseControllerEx extends BaseController {

	BaseServiceEx baseServiceEx;

	@PostConstruct
	protected void init() {
	}

	protected void init(Object service) {
		this.baseServiceEx = (BaseServiceEx) service;
	}

	/**
	 * 通用分页查询
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doPageQuery", method = RequestMethod.POST)
	protected JSONObject doPageQuery(@RequestParam(required = false) Map map) throws Exception {
		return baseServiceEx.pagequery(map);
	}

	/**
	 * 通用列表查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "doQuery", method = RequestMethod.POST)
	protected JSONObject doQuery(@RequestParam Map map) throws Exception{
		return baseServiceEx.query(map);
	}

	/**
	 * 通用单条记录查询
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doSelect/{id}", method = RequestMethod.POST)
	protected JSONObject doSelect(@PathVariable String id) throws Exception {
		return baseServiceEx.selectp(id);
	}

	/**
	 * 通用删除
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doRemove/{id}", method = RequestMethod.POST)
	protected JSONObject doRemove(@PathVariable String id) throws Exception {
		return baseServiceEx.removep(id);
	}

	/**
	 * 通用新增
	 *
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doInsert", method = RequestMethod.POST)
	protected JSONObject doInsert(@RequestParam Map map) throws Exception {
		return baseServiceEx.insertp(map);
	}

	/**
	 * 新增list
	 * @param list
	 * @return
	 * @throws Exception
     */
	@RequestMapping(value = "/doInsertList" ,method = RequestMethod.POST)
	protected JSONObject doInsertList(@RequestBody List<Map> list) throws Exception{
		return baseServiceEx.insertListTp(list);
	}

	/**
	 * 通用更新
	 *
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doUpdate", method = RequestMethod.POST)
	protected JSONObject doUpdate(@RequestParam Map map) throws Exception {
		return baseServiceEx.updatep(map);
	}

}
