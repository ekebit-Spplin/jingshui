package orm.base;

/**
 * 实体类基类
 * User: 汪超.
 * Date：2016/7/7
 * Time：16:07
 */
public class BaseBean extends BaseModel{

	/**
	 * 通用标识
	 */
	private String id;
	/**
	 * 创建时间
	 */
	private String createTime;

	/**
	 * 创建人
	 */
	private String createUser;

	/**
	 * 是否删除
	 */
	private String isDelete;

	/**
	 * 更新时间
	 */
	private String updateTime;

	/**
	 * 更新人
	 */
	private String updateUser;

	/**
	 * 通用标识
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * 通用标识
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 创建时间
	 * @return
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间
	 * @param createTime
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * 创建人
	 * @return
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * 创建人
	 * @param createUser
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	/**
	 * 是否删除
	 * @return
	 */
	public String getIsDelete() {
		return isDelete;
	}

	/**
	 * 是否删除
	 * @param isDelete
	 */
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * 修改时间
	 * @return
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * 修改时间
	 * @param updateTime
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 修改人
	 * @return
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * 修改人
	 * @param updateUser
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
}
