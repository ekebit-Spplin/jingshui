package orm.spring;

/**
 * 业务异常抛出
 * Created by 汪超 on 2016/5/6.
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 3152616724785436891L;

	public BusinessException(String frdMessage) {
		super(createFriendlyErrMsg(frdMessage));
	}

	public BusinessException(Throwable throwable) {
		super(throwable);
	}

	public BusinessException(Throwable throwable, String frdMessage) {
		super(throwable);
	}

	public BusinessException(String frdMessage,String targetClsName) {
		super(createFriendlyErrMsg(frdMessage,targetClsName));
	}

	/**
	 * 异常友好抛出
	 * @param msgBody 提示主体
	 * @return
	 */
	private static String createFriendlyErrMsg(String msgBody) {
		String prefixStr = "抱歉，";
		String suffixStr = " 请稍后再试或与管理员联系！";

		StringBuffer friendlyErrMsg = new StringBuffer("");

		friendlyErrMsg.append(prefixStr);

		friendlyErrMsg.append(msgBody);

		friendlyErrMsg.append(suffixStr);

		return friendlyErrMsg.toString();
	}

	/**
	 * 异常友好抛出
	 * @param msgBody 提示主体
	 * @return
	 */
	private static String createFriendlyErrMsg(String msgBody,String targetClsName) {
		return createFriendlyErrMsg(msgBody)  + targetClsName;
	}
}
