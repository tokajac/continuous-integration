package continuous.integration.exposerest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.testng.annotations.BeforeClass;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
class ExposeRestApplicationTests extends AbstractTestNGSpringContextTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@BeforeClass
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testHandling() throws Exception {
		String postBodyString = "{\"email\":\"test@test.com\",\"customCode\":\"custom\"}";

		mockMvc.perform( post( "/basicConsume" ).content( postBodyString ).contentType(MediaType.APPLICATION_JSON) ).andExpect( status().isOk() );
	}

	@Test
	public void testBasicFailure() throws Exception {
		String postBodyString = "{\"email\":\"test@test.com\",\"customCode\":\"custom\"}";

		mockMvc.perform( post( "/basicConsume" ).content( postBodyString ).contentType(MediaType.APPLICATION_JSON) )
				.andExpect( status().isOk() )
				.andExpect( jsonPath("$.message").value("wrong") );
	}
}
