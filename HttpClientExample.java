import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientExample {
    
    private static final String API_URL = "https://jpdc.hunet.co.kr/Login/__sigUpLOGIN";
    
    public static String sendGetRequest() throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(API_URL);
            request.addHeader("Content-Type", "application/json");

            try (CloseableHttpResponse response = client.execute(request)) {
                return EntityUtils.toString(response.getEntity());
            }
        }
    }

    public static String sendPostRequest(String encryptedData) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost request = new HttpPost(API_URL);
            request.addHeader("Content-Type", "application/json");

            StringEntity entity = new StringEntity("{\"data\":\"" + encryptedData + "\"}");
            request.setEntity(entity);

            try (CloseableHttpResponse response = client.execute(request)) {
                return EntityUtils.toString(response.getEntity());
            }
        }
    }
}
