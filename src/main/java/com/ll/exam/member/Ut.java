package com.ll.exam.member;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.exam.article.dto.ArticleDto;

public class Ut {
    public static class json {
        private static ObjectMapper om;
        static{
             om = new ObjectMapper();
        }
        public static String toStr(Object obj, String defaultValue) {

            try {
                return om.writeValueAsString(obj);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }


        public static <T> T toObj(String jsonStr, Class<T> cls, Object o) {
            try {
                return om.readValue(jsonStr, cls);
            } catch (JsonProcessingException e) {
                return null;
            }
        }
    }
}
