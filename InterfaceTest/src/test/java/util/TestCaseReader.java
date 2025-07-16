package util;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class TestCaseReader {
    
    // 自动发现并读取测试用例文件
    public static List<Map<String, String>> loadTestCases(String directory) throws IOException {
        List<Map<String, String>> allTestCases = new ArrayList<>();
        
        try (Stream<Path> paths = Files.walk(Paths.get(directory))) {
            paths.filter(Files::isRegularFile)
                 .filter(new TestCaseReader()::isSupportedFile)
                 .forEach(path -> {
                     try {
                         if (path.toString().endsWith(".csv")) {
                             allTestCases.addAll(readCSVTestCases(path.toString()));
                         } else if (path.toString().endsWith(".json")) {
                             allTestCases.addAll(readJSONTestCases(path.toString()));
                         }
                     } catch (IOException e) {
                         System.err.println("读取测试用例文件失败: " + path);
                         e.printStackTrace();
                     }
                 });
        }
        return allTestCases;
    }
    
    private boolean isSupportedFile(Path path) {
        String fileName = path.getFileName().toString();
        return fileName.endsWith(".csv") || fileName.endsWith(".json");
    }
    
    private static List<Map<String, String>> readCSVTestCases(String filePath) throws IOException {
        List<Map<String, String>> testCases = new ArrayList<>();
        
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                 .withFirstRecordAsHeader()
                 .withIgnoreHeaderCase()
                 .withTrim())) {

            for (CSVRecord record : csvParser) {
                Map<String, String> testCase = new HashMap<>();
                for (String header : csvParser.getHeaderNames()) {
                    testCase.put(header, record.get(header));
                }
                testCases.add(testCase);
            }
        }
        return testCases;
    }
    
    private static List<Map<String, String>> readJSONTestCases(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(
            new File(filePath),
            mapper.getTypeFactory().constructCollectionType(List.class, Map.class)
        );
    }
}