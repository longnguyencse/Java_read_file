package kalog.com.vn;


import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    private final static LogManager LOGGER = LogManager.getLogManager();
    private static List<String> abc = new ArrayList<>();
    private final static List<String> abc1 = new ArrayList<>();
    public static void main(String[] args) {
//        https://funnelgarden.com/java_read_file/#Performance_Rankings
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//        String sFile = classLoader.getResource("file.config.yml").getFile();
//        String sFile = classLoader.getResource("D:\\longnq\\source_DRY\\python\\data\\week1\\2").getFile();
//        String sFile = classLoader.getResource("D:\\longnq\\source_DRY\\python\\data\\week1\\2").getFile();
        long start = System.currentTimeMillis();
        File file = new File("D:\\longnq\\source_DRY\\python\\data\\week1\\2");

//        abc.add("abc");
//        abc.add("bc");
//        abc.add("abac");

//        abc.stream().peek(s -> {
//            System.out.println(s);
//            abc1.add("asd");
//            return s;
//        });
//        List<Integer> list = new ArrayList<>();
//        List<Integer> result = Stream.of(1, 2, 3, 4)
//                .peek(x -> {
//                    x = x -1;
//                    list.add(x);
//                })
//                .map(x -> x * 2)
//                .filter(x -> x > 8) // you have inserted a filter here
//                .collect(Collectors.toList());

//        System.out.println(list);
//        System.out.println(result);

//        .collect(Collectors.toList());
//        System.out.println(abc);
        // file not found
//        System.out.println("File Found: " + file.exists());
        // Read File Content
        try {
            String content =Files.lines(file.toPath())
                    .collect(Collectors.joining("\n"));
            System.out.println("================ time Files.lines: " + (System.currentTimeMillis() - start) );

            start = System.currentTimeMillis();
            InputStream inputStream = new FileInputStream(file);
            new BufferedInputStream(inputStream).read();
            System.out.println("================ time BufferedInputStream.read(): " + (System.currentTimeMillis() - start) );

            start = System.currentTimeMillis();
            FileInputStream fileInputStream = new FileInputStream(file);
//specify UTF-8 encoding explicitly

            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                String line;
                while((line = bufferedReader.readLine()) != null) {
//                    System.out.println(line);
                }
                System.out.println("================ time BufferedInputStream.read(): " + (System.currentTimeMillis() - start) );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
