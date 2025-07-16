package util;

import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;

public class APITestExecutor {
    private final List<Map<String, String>> testCases;
    
    public APITestExecutor(List<Map<String, String>> testCases) {
        this.testCases = testCases;
    }
    
    @Test
    public void executeAPITests() {
        for (Map<String, String> testCase : testCases) {
            runAPITestCase(testCase);
        }
    }
    
    private void runAPITestCase(Map<String, String> testCase) {
        System.out.println("\n执行API测试用例: " + testCase.get("testCaseId"));
        System.out.println("描述: " + testCase.get("description"));
        System.out.println("端点: " + testCase.get("endpoint"));
        System.out.println("方法: " + testCase.get("method"));
        System.out.println("预期状态码: " + testCase.get("expectedStatusCode"));
        
        // 实际执行测试的逻辑
        // 使用RestAssured发送请求并验证响应
    }
}