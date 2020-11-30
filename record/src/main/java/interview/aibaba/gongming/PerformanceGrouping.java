//package interview.aibaba.gongming;
//import java.io.*;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class PerformanceGrouping {
//
//    static ArrayList<ArrayList<Person>> personsGroup = new ArrayList<>();
//
//    static LinkedList<Person>[] buckets = new LinkedList[12];
//
//    public static void main(String[] args) throws IOException {
//
//        String path = "/Users/gongming/Downloads/data.csv";
//        int max = 3;
//
//        PerformanceGrouping performanceGrouping = new PerformanceGrouping();
//        performanceGrouping.getData(path);
//        performanceGrouping.pollAccess(max);
//        performanceGrouping.outputCsv();
//
//    }
//
//    /**
//     * 获取分发数据
//     *
//     * @param path
//     * @throws IOException
//     */
//    public void getData(String path) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader(path));
//        String line = null;
//        while ((line = reader.readLine()) != null) {
//            String[] item = line.split(",");
//
//            // person 实体
//            Person person = new Person();
//            person.setId(item[0]);
//            person.setStar(item[1]);
//            person.setDepartment(item[2]);
//
//            // 分发数据
//            if (buckets[Integer.parseInt(item[1]) - 1] == null) {
//                buckets[Integer.parseInt(item[1]) - 1] = new LinkedList<>();
//            }
//
//            buckets[Integer.parseInt(item[1]) - 1].add(person);
//        }
//
//    }
//
//    /**
//     * 轮询查询
//     *
//     * @param max
//     */
//    public void pollAccess(int max) {
//        // 初始化轮询
//        int index = -1;
//        // 取数据次数
//        int num = 0;
//        // 初始化结果集
//        ArrayList<String> set = new ArrayList<>();
//        ArrayList<Person> persons = new ArrayList<>();
//        // 校验是否为同一个部门
//        // todo 终止条件
//        int nums = 0;
//        while (nums < 15) {
//            while (num < max) {
//                index = (index + 1) % 12;
//                Person people = buckets[index].peek();
//                // 部门重复向后查找
//                if (set.contains(people.getDepartment())) {
//                    buckets[index].remove();
//                    buckets[index].addLast(people);
//                    // 重新进入
//                    index = (index - 1) % 12;
//                    // todo bug
//                } else {
//                    // 去除与拿结果
//                    buckets[index].remove();
//                    set.add(people.getDepartment());
//                    persons.add(people);
//                    num++;
//                }
//
//            }
//            personsGroup.add(persons);
//            persons = new ArrayList<>();
//            num = 0;
//            nums++;
//        }
//
//    }
//
//    /**
//     * 输出文件
//     */
//    public void outputCsv() {
//        // 表格头
//        String[] headArr = new String[]{"PointId", "X", "Y"};
//        //CSV文件路径及名称
//        LocalDateTime localDateTime = LocalDateTime.now();
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
//        String filePath = "/Users/gongming/Desktop/result.csv"; //CSV文件路径
//        String fileName = "CSV_" + df.format(localDateTime) + ".csv";//CSV文件名称
//        File csvFile = null;
//        BufferedWriter csvWriter = null;
//        try {
//            csvFile = new File(filePath + File.separator + fileName);
//            File parent = csvFile.getParentFile();
//            if (parent != null && !parent.exists()) {
//                parent.mkdirs();
//            }
//            csvFile.createNewFile();
//
//            // GB2312使正确读取分隔符","
//            csvWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "GB2312"), 1024);
//
//            // 写入文件头部标题行
//            csvWriter.write(String.join(","));
//            csvWriter.newLine();
//
//            // 写入文件内容
//            for (ArrayList<Person> persons : personsGroup) {
//                List<String> str = persons.stream().map(Person::getId).collect(Collectors.toList());
//                String result = String.join(",", str);
//                System.out.println(result);
//                csvWriter.write(result);
//                csvWriter.newLine();
//            }
//            csvWriter.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                csvWriter.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}