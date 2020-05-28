package com.logical.misc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(JUnit4ClassRunner.class)
public class TestUtils {


    @Test
    public void testGroupByStream() {
        List<String> names = new ArrayList<>();
        names.add("vishnu1");
        names.add("vishnu2");
        names.add("vishnu1");
        names.add("vishnu2");
        names.add("vishnu1");
        names.add("vishnu2");
        Map<String, List<String>> map = Utils.groupByStream(names, name -> name);
        map.forEach((k, v) -> {
            if (k.equals("vishnu1"))
                Assert.assertEquals(3, v.size());
        });
    }

    @Test
    public void testGroupBy() {
        List<String> names = new ArrayList<>();
        names.add("vishnu1");
        names.add("vishnu2");
        names.add("vishnu1");
        names.add("vishnu2");
        names.add("vishnu1");
        names.add("vishnu2");
        Map<String, List<String>> map = Utils.groupBy(names, name -> name);
        map.forEach((k, v) -> {
            if (k.equals("vishnu1"))
                Assert.assertEquals(3, v.size());
        });
    }


    @Test
    public void testReverseStringRecursively() {
        String name = "vishnu";
        String reversedName = new StringBuilder(name).reverse().toString();
        Assert.assertEquals(reversedName, Utils.reverse("vishnu"));
    }
}
