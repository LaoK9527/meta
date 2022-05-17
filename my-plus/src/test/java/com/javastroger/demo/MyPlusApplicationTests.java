package com.javastroger.demo;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.FutureTask;
import java.util.function.Function;
import java.util.stream.Collectors;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.read.listener.PageReadListener;
import com.javastroger.demo.entity.Payment;
import com.javastroger.demo.entity.User;
import com.javastroger.demo.service.OrderService;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@MapperScan
class MyPlusApplicationTests {

    @Autowired
    private OrderService orderService;

    /**
     * 所有中间件都是基于TCP/IP协议
     *
     */
    @Test
    void contextLoads() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) continue;
            System.out.println(i);
        }
    }

    @Test
    void rabbitMq() {
        System.out.println("这些都是简单的东西");
        Payment payment = new Payment();
    }

    /**
     * 生产者
     */
    @Test
    void fanout_test() {
        orderService.makeOrder("9", "213444");
    }

    @Test
    void fanout_consumer_test() {

    }

    @Test
    void future_task() {
        new Thread(new FutureTask<String>(()->{
            System.out.println("sadasd");
            return "1024";
        }), "AA").start();
    }

    @Test
    void main_test() {
        List<User> list = new ArrayList<>();
        Map<String, User> collect = list.stream().collect(Collectors.toMap(User::getPassword, Function.identity(), (a, b) -> b));
        System.out.println(collect);
    }

    @Test
    void map_test() {
        User user1 = new User(new BigDecimal(39), "userName", "士大夫");
        User user2 = new User(new BigDecimal(40), "userNames", "想");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        BigDecimal reduce = list
                .stream()
                .map(x -> x.getId())
                .reduce(BigDecimal.ZERO, BigDecimal::add).divide(new BigDecimal(10));
        System.out.println(reduce);

        Map<BigDecimal, Map<String, List<User>>> decimalUserMap = list
                .stream()
                .collect(Collectors.groupingBy(User::getId,
                        Collectors.groupingBy(User::getUserName, Collectors.toList())));
        System.out.println(decimalUserMap);

        List<User> userList = new ArrayList<>();
    }

    @Test
    @Transactional
    void easyExcelExport() {
        List<Payment> paymentList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Payment payment = new Payment();
            payment.setPayId(Long.valueOf(i));
            payment.setPayStr("数据" + i);
            payment.setPaySerial("serial" + i);
            paymentList.add(payment);
        }
        System.out.println("开始导出");
        EasyExcel.write("D://USER.xlsx", Payment.class).sheet().doWrite(paymentList);
        System.out.println("导出完成");
    }

    @Test
    void easyExcelImport() {
        EasyExcel.read("D://USER.xlsx", Payment.class, new PageReadListener<Payment>(dataList -> {
            for (Payment payment : dataList) {
                System.out.println(payment);
            }
        })).sheet().doRead();
    }

    @Test
    void 最长回文串_test() {
        String str = "jijoad";
        int length = str.length();
        int start = 0;
        int max = 1;
        Boolean[][] dp = new Boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        char[] chars = str.toCharArray();
        // 字串遍历
        for (int L = 2; L <= length; L++) {
            for (int i = 0; i < length; i++) {
                int j = L + i - 1;

                if (j >= length) {
                    break;
                }

                if (chars[i] == chars[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }

        System.out.println(str.substring(start, max + start));

    }

    @Test
    void sub_test() {
        String str = "";
//        System.out.println(str.lastIndexOf(str));
//        System.out.println("000000000000"+strUtils(str));
        System.out.println(charAtUtil(str));
    }

    private String strUtils(String str) {
        if (StrUtil.isNotBlank(str)) {
            char[] chars = str.toCharArray();
            int len = chars.length;
            char aChar = chars[len - 1];
            if (len == 1) {
                return str;
            }
            if (chars.length > 1 && aChar == '=') {
                return strUtils(str.substring(0, chars.length - 1));
            }
            return str;
        }
        return str;
    }

    private String charAtUtil(String string) {
        if (StrUtil.isNotBlank(string)) {
            int len = string.length();
            if (len == 1) {
                return string;
            }
            if (string.charAt(len -1) == '=') {
                return charAtUtil(string.substring(0, len - 1));
            }
            return string;
        }
        return string;
    }

    @Test
    void getToken() {
        String s = HttpUtil.get("http://localhost:8080/apps/app/1");
        System.out.println(s);
    }

    @Test
    void file_test() throws IOException {
        File file = new File("D://USER.xlsx");
        System.out.println(file.getName());

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line =bufferedReader.readLine();

        while (line!=null){
            System.out.println(line);
            line = bufferedReader.readLine();
        }

        bufferedReader.close();
        fileReader.close();
    }


    @Test
    void system_test() {
        System.out.println(System.nanoTime());
    }


}

