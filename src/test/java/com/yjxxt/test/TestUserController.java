package com.yjxxt.test;


import com.yjxxt.Starter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Starter.class})
@AutoConfigureMockMvc
public class TestUserController {

    private Logger log = LoggerFactory.getLogger(TestUserController.class);
    @Autowired
    private MockMvc mockMvc;
    //用户列表查询
    @Test
    public void apiTest01() throws Exception{
// 构建请求
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.get("/list")
                        .contentType("text/html") // 指定请求的contentType头信息
                        .accept(MediaType.APPLICATION_JSON); // 指定请求的Accept头信息
// 发送请求，获取请求结果
        ResultActions perform = mockMvc.perform(request);
// 请求结果校验
        perform.andExpect(MockMvcResultMatchers.status().isOk());
// 表示执行完成后返回相应的结果
        MvcResult mvcResult = perform.andReturn();
// 得到执行后的响应
        MockHttpServletResponse response = mvcResult.getResponse();
        log.info("响应状态：{}", response.getStatus());
        log.info("响应内容：{}", response.getContentAsString());
    }
    // 用户名记录查询
    @Test
    public void apiTest02() throws Exception{
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/findUser/admin")).
                        andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        log.info("响应状态：{}",mvcResult.getResponse().getStatus());
        log.info("响应内容：{}",mvcResult.getResponse().getContentAsString());
    }
}
