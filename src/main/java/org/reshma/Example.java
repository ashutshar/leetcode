package org.reshma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Example {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list = Arrays.asList(new String[]{"a", "b", "c", "e"});

       Stream s = list.stream().filter(l -> l.equalsIgnoreCase("d"));
        list.add("d");
        String s1 = (String)s.findFirst().get();

    }



}
