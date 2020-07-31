package com.xusanjin.mytest.demo;

import com.xusanjin.mytest.dao.PersonDao;
import com.xusanjin.mytest.dao.ProductDao;
import com.xusanjin.mytest.entity.Person;
import com.xusanjin.mytest.entity.Product;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Log4j2
public class Demo {


    @Autowired
    private PersonDao personDao;

    @Autowired
    private ProductDao productDao;

    @Test
    public void demo() {
        log.info("===============测试==================");
    }

    @Test
    public void personList() {
        List<Person> all = personDao.getAll();
        for (Person one : all) {
            log.info(one);
        }
    }

    @Test
    public void productList() {
        List<Product> products = productDao.getAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    public void str() throws ParseException {
        String str = "30%";

        NumberFormat nf = NumberFormat.getPercentInstance();

        Number m = nf.parse(str);


        BigDecimal decimal = new BigDecimal(String.valueOf(m));

//        BigDecimal b = new BigDecimal(100.20);

        double v = (100.20 * decimal.doubleValue());

        System.out.println("百分比1==========" + m);
        System.out.println("百分比2==========" + decimal);
        System.out.println("=================" + v);
    }

    @Test
    public void str1() {
        String percent = "66.60%";
        percent = percent.replace("%", "");
        Float f = Float.valueOf(percent) / 100;
        BigDecimal decimal = new BigDecimal(f);
        System.out.println(decimal);
    }


}
