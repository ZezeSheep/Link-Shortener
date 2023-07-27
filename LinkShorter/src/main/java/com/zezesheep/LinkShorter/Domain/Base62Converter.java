package com.zezesheep.LinkShorter.Domain;

import java.util.ArrayList;
import java.util.List;

public class Base62Converter {

    private static final Base62Converter instance;

    private static List<String> mapSymbol10To62 = new ArrayList<>();

    static {
        instance = new Base62Converter();

        for(int i = 0; i < 10; i++){
            String valueIn62 = String.valueOf(i);
            mapSymbol10To62.add(valueIn62);
        }

        for(int i = 0; i < 26; i++){
            char lowerCaseLetter = (char)('a' + i);
            String valueIn62 = String.valueOf(lowerCaseLetter);
            mapSymbol10To62.add(valueIn62);
        }

        for(int i = 0; i < 26; i++){
            char upperCaseLetter = (char)('A' + i);
            String valueIn62 = String.valueOf(upperCaseLetter);
            mapSymbol10To62.add(valueIn62);
        }

    }

    public static Base62Converter getInstance() {
        return instance;
    }

    public String toBase62(Long numberBase10) {
        String numberBase62 = "";
        while(numberBase10 != 0){
            int rest = (int)(numberBase10 % 62);
            numberBase62 = mapSymbol10To62.get(rest) + numberBase62;
            numberBase10 = numberBase10 / 62;
        }
        return numberBase62;
    }


    
}
