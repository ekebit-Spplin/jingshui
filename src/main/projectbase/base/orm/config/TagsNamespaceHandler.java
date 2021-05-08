package orm.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 注册定自义标签对应的解析
 * 
 * @author WangChao
 *
 */
public class TagsNamespaceHandler extends NamespaceHandlerSupport {

	public void init() {
		registerBeanDefinitionParser("client-file-path", new TagClientPraser());
	}
}
