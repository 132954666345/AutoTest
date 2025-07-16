package util;

import org.testng.annotations.Factory;
import java.util.*;
import java.io.IOException;

public class TestEngine {
    
    @Factory
    public Object[] createTestInstances() {
        List<Object> testInstances = new ArrayList<>();
        
        try {
            // 1. 读取所有测试用例
            List<Map<String, String>> testCases = 
                TestCaseReader.loadTestCases("src/test/java/testdata");
            
            // 2. 按类型分组测试用例
            Map<String, List<Map<String, String>>> groupedCases = groupTestCases(testCases);
            
            // 3. 为每组测试用例创建执行器
            for (Map.Entry<String, List<Map<String, String>>> entry : groupedCases.entrySet()) {
                switch (entry.getKey().toLowerCase()) {
                    case "api":
                        testInstances.add(new APITestExecutor(entry.getValue()));
                        break;
                    case "ui":
                        testInstances.add(new UITestExecutor(entry.getValue()));
                        break;
                    // 添加其他测试类型
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("加载测试用例失败", e);
        }
        
        return testInstances.toArray();
    }
    
    private Map<String, List<Map<String, String>>> groupTestCases(
        List<Map<String, String>> testCases) {
        
        Map<String, List<Map<String, String>>> grouped = new HashMap<>();
        
        for (Map<String, String> testCase : testCases) {
            String testType = testCase.getOrDefault("testType", "default");
            grouped.computeIfAbsent(testType, k -> new ArrayList<>()).add(testCase);
        }
        
        return grouped;
    }
}