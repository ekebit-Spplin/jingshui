package orm.utils;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

/**
 * Junit测试基类
 * User: 汪超.
 * Date：2016/7/12
 * Time：16:34
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath*:/service-context.xml", "classpath*:/servlet-context.xml"})
public abstract class JunitBeanTest {

	protected Map<String, String> params = new HashMap<String, String>();

	private MockMvc mockMvc;

	/**
	 * 装载测试Controller，可为数组
	 */
	@Before
	public abstract void setUp();

	public void beforeSetUp(Object... controllers) {
		mockMvc = MockMvcBuilders.standaloneSetup(controllers).build();
	}

	/**
	 * 测试Controller类
	 *
	 * @return
	 */
	protected String postPathController(String path,MediaType... mediaTypes) {
		try {
			MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post(path).accept(mediaTypes);
			if(params.size() > 0){
				for (Map.Entry<String, String> entry : params.entrySet()) {
					mockHttpServletRequestBuilder.param(entry.getKey(), entry.getValue());
				}
			}
			ResultActions ras = mockMvc.perform(mockHttpServletRequestBuilder);
			MvcResult mr = ras.andReturn();
			return mr.getResponse().getContentAsString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
