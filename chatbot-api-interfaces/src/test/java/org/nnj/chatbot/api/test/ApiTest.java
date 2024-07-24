package org.nnj.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

/**
 * @author pptllj17
 * @description 单元测试
 */
public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/topics/4844211412121888/comments?sort=asc&count=30&with_sticky=true");

        get.addHeader("cookie", "zsxq_access_token=51CD3981-AB53-46F8-17B5-633C76CD1A41_E08193982977A3B2; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22812281421184582%22%2C%22first_id%22%3A%22190b471403e1b4-0cef90c028744e8-26001f51-3686400-190b471403f491%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTkwYjQ3MTQwM2UxYjQtMGNlZjkwYzAyODc0NGU4LTI2MDAxZjUxLTM2ODY0MDAtMTkwYjQ3MTQwM2Y0OTEiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI4MTIyODE0MjExODQ1ODIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22812281421184582%22%7D%2C%22%24device_id%22%3A%22190b471403e1b4-0cef90c028744e8-26001f51-3686400-190b471403f491%22%7D; zsxqsessionid=1a25b1bdc9ebd9e1cb7467715598cf66; abtest_env=beta\n");
        get.addHeader("Content-Type","application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/4844211412121888/comments");

        post.addHeader("cookie", "zsxq_access_token=51CD3981-AB53-46F8-17B5-633C76CD1A41_E08193982977A3B2; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22812281421184582%22%2C%22first_id%22%3A%22190b471403e1b4-0cef90c028744e8-26001f51-3686400-190b471403f491%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTkwYjQ3MTQwM2UxYjQtMGNlZjkwYzAyODc0NGU4LTI2MDAxZjUxLTM2ODY0MDAtMTkwYjQ3MTQwM2Y0OTEiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI4MTIyODE0MjExODQ1ODIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22812281421184582%22%7D%2C%22%24device_id%22%3A%22190b471403e1b4-0cef90c028744e8-26001f51-3686400-190b471403f491%22%7D; zsxqsessionid=1a25b1bdc9ebd9e1cb7467715598cf66; abtest_env=beta\n");
        post.addHeader("Content-Type","application/json;charset=utf8");

        String answerJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"我也不知道，你得自己看哦 \\n\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": true\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(answerJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
