package orm.base.Ex;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import orm.base.BaseModel;
import orm.base.BasePageInfo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 张宏 on 2016/5/3.
 */
public class BaseEx {
	/**
	 * 日志打印
	 */
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	protected int sCode = 1;   //成功码
	protected int eCode = 0;   //失败码
	protected String codeKey = "code";
	protected String messKey = "mess";
	protected String dataKey = "data";
	protected String sMess = "SUCCESS";
	/**
	 * 时间格式化
	 */
	protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 获得当前时间字符串（yyyy-MM-dd HH:mm:ss）
	 *
	 * @return
	 */
	public String now() {
		return sdf.format(new Date());
	}

	/**
	 * 可以剔除某些字段的方法
	 *
	 * @param pl
	 * @return
	 */
	/**
	 * 可以剔除某些字段的方法
	 *
	 * @param pl
	 * @return
	 */
	public JSONObject codeData(final Object pl) {
		JSONObject jsonObject = new JSONObject();
		if (pl instanceof BasePageInfo) {
			if (((BasePageInfo) pl).getSelectMenu() != null) {
				SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
				String[] params = ((BasePageInfo) pl).getSelectMenu().split(",");
				for (String param : params) {
					filter.getIncludes().add(param);
				}
				jsonObject = JSONObject.parseObject(JSON.toJSONString(pl, filter));// ;
			} else {
				if (((BasePageInfo) pl).getRemoves().size() != 0) {
					SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
					filter.getExcludes().addAll(((BasePageInfo) pl).getRemoves());
					jsonObject = JSONObject.parseObject(JSON.toJSONString(pl, filter));// ;
				} else {
					jsonObject = (JSONObject) JSON.toJSON(pl);// ;
				}
			}
		} else if (pl instanceof BaseModel) {
			jsonObject = parseObject(jsonObject, (BaseModel) pl);
		} else if (pl instanceof List) {
			List<Object> objects = new ArrayList<Object>();
			for (Object obj : (List<Object>) pl) {
				if (obj instanceof BaseModel) {
					jsonObject = parseObject(jsonObject, (BaseModel) obj);
					BaseModel baseModel = (BaseModel) JSON.toJavaObject(jsonObject, obj.getClass());
					objects.add(baseModel);
				}
			}
			JSONArray array = (JSONArray) JSON.toJSON(objects);
			JSONObject _jsonObject = new JSONObject();
			_jsonObject.put("list", array);
			return this.codeData(sCode, _jsonObject);
		}
		return codeData(sCode, jsonObject);
	}

	/**
	 * 封裝json導出
	 *
	 * @param jsonObject
	 * @param obj
	 * @return
	 */
	private JSONObject parseObject(JSONObject jsonObject, BaseModel obj) {
		if (obj.getRemoves().size() != 0) {
			SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
			filter.getExcludes().addAll(obj.getRemoves());
			jsonObject = JSONObject.parseObject(JSON.toJSONString(obj, filter));// ;
		} else {
			jsonObject = (JSONObject) JSON.toJSON(obj);// ;
		}
		return jsonObject;
	}

	public JSONObject codeMess(int code, Object o) {
		JSONObject jo = new JSONObject();
		jo.put(codeKey, code);
		jo.put(messKey, o);
		return jo;
	}

	public JSONObject codeData(int code, Object o) {
		JSONObject jo = new JSONObject();
		jo.put(codeKey, code);
		jo.put(dataKey, o);
		return jo;
	}


	/**
	 * 字符串转int
	 *
	 * @param str
	 */
	public static int toInt(String str) {
		if (str == null || str.equals(""))
			return 0;
		else
			return Integer.parseInt(str);
	}

	/**
	 * 字符串转double(金额)
	 *
	 * @param str
	 */
	public static double toDouble(String str) {
		if (str == null || str.equals(""))
			return 0d;
		else
			return Double.parseDouble(str);
	}
}
