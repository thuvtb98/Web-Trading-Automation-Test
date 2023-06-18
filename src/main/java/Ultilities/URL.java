package Ultilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class URL {
  public static final String JSON_FILE =
      System.getProperty("user.dir").concat("/src/main/resources/testing-urls.json");

  public static String currentTestUrl(String testPage) {
    ObjectMapper objectMapper = new ObjectMapper(); // class is used to read/write json
    String finalTestingUrl;

    try {
      FileInputStream fileInputStream = new FileInputStream(JSON_FILE); // read json file
      InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8"); //chuyển đổi dữ liệu dạng byte thành dữ liệu dạng ký tự trong input stream khi đọc dữ liệu từ nơi lưu trữ (data source)
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader); //để đọc văn bản từ luồng đầu vào (như tệp) bằng cách đệm và đọc liền mạch các ký tự, mảng hoặc dòng.

      Map<String, HashMap> testingUrlData = objectMapper.readValue(bufferedReader, HashMap.class);
      String sitePath = testingUrlData.get(testPage).get("url").toString();
      finalTestingUrl = System.getenv("testingURL").concat(sitePath);

      // close after interacting with the file
      fileInputStream.close();
      inputStreamReader.close();
      bufferedReader.close();

    } catch (Exception e) {
      e.printStackTrace(); // show error
      throw new RuntimeException("ERROR | issue when reading testing url data json file");
    }

    return finalTestingUrl;
  }
}
