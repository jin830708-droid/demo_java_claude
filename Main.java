public class Main {
    private static final String AES_KEY = "J89AEcMbCDvBQfDr";
    private static final String AES_IV = "eYeBmbpZ4ZRpAcsf";

    public static void main(String[] args) {
        try {
            // 1. 암호화할 데이터
            String dataToEncrypt = "username=example&password=1234";
            
            // 2. AES 암호화
            String encryptedData = AESUtils.encrypt(dataToEncrypt, AES_KEY, AES_IV);
            System.out.println("Encrypted Data: " + encryptedData);

            // 3. GET 요청 보내기
            String getResponse = HttpClientExample.sendGetRequest();
            System.out.println("GET Response: " + getResponse);

            // 4. POST 요청 보내기
            String postResponse = HttpClientExample.sendPostRequest(encryptedData);
            System.out.println("POST Response: " + postResponse);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
