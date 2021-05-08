package orm.config;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * 标签解析处理 
 * 
 * @author WangChao
 *
 */
public class TagClientPraser extends AbstractSimpleBeanDefinitionParser {
	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String path = element.getAttribute("path");
		builder.addPropertyValue("path", path);
	}
	
	@Override
	protected Class<?> getBeanClass(Element element) {
		return ClientPathBean.class;
	}
}
