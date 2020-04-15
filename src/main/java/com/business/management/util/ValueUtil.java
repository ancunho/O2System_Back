package com.business.management.util;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

/**
 * @author : Cunho
 * @date : 2020/4/15
 */
public class ValueUtil {

    /**
     * data가 빈 값인지 체크
     *
     * @param data
     * @return
     */
    public static boolean isEmpty(Object data) {
        if (data == null) {
            return true;

        } else if (data instanceof String || data instanceof StringBuffer) {
            String str = data.toString().trim();
            return str.isEmpty() || str.equalsIgnoreCase("null");

        } else if (data instanceof Object[]) {
            return ((Object[]) data).length == 0;

        } else if (data instanceof Collection<?>) {
            return ((Collection<?>) data).isEmpty();

        } else if (data instanceof Map<?, ?>) {
            return ((Map<?, ?>) data).isEmpty();
        }

        return false;
    }

    /**
     * data가 빈 값이 아닌지 체크
     *
     * @param data
     * @return
     */
    public static boolean isNotEmpty(Object data) {
        return !isEmpty(data);
    }

    /**
     * a와 b가 동일한 지 확인.
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isEqual(Object a, Object b) {
        if (a == null && b == null) {
            return true;

        } else if (a == null || b == null) {
            return false;

        } else if (a.equals(b)) {
            return true;

        } else if (a instanceof List && b instanceof List) {
            List<Object> aList = (List<Object>) a;
            List<Object> bList = (List<Object>) b;

            if (aList.isEmpty() && bList.isEmpty()) {
                return true;
            } else if (aList.size() != bList.size()) {
                return false;
            }

            int i = 0;
            for (Object aObj : aList) {
                if (isNotEqual(aObj, bList.get(i++))) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    /**
     * a와 b가 동일한 지 확인.
     * a, b가 문자열인 경우 ignoreCase 적용
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isEqualIgnoreCase(String a, String b) {
        if (a == null && b == null) {
            return true;

        } else if (a == null || b == null) {
            return false;

        } else if (a.equalsIgnoreCase(b)) {
            return true;

        } else {
            return false;
        }
    }

    /**
     * a와 b가 동일하지 않은지 확인.
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isNotEqual(Object a, Object b) {
        return !isEqual(a, b);
    }

    /**
     * value가 checkValues에 포함되어 있는지 체크
     *
     * @param value
     * @param checkValues
     * @return
     */
    public static boolean isInclude(Object value, Object... checkValues) {
        for (Object checkValue : checkValues) {
            if (ValueUtil.isEqual(value, checkValue)) {
                return true;
            }
        }

        return false;
    }

    /**
     * value가 checkValues에 포함되어 있는지 체크
     *
     * @param value
     * @param checkValues
     * @return
     */
    public static boolean isInclude(Object value, String... checkValues) {
        for (Object checkValue : checkValues) {
            if (ValueUtil.isEqual(value, checkValue)) {
                return true;
            }
        }

        return false;
    }

    /**
     * keys, values로 map을 생성
     *
     * @param keys separated value ex) id,name,description
     * @param values object value array
     * @return
     */
    public static Map<String, Object> newMap(String keys, Object... values) {
        Map<String, Object> map = new HashMap<String, Object>(values == null ? 3 : values.length);

        if (!isEmpty(keys) && !isEmpty(values)) {
            String[] keyArr = keys.split(",");

            if (keyArr.length != values.length) {
                throw new IllegalArgumentException("keys count and values count mismatch!");
            }

            for (int i = 0; i < keyArr.length; i++) {
                map.put(keyArr[i], values[i]);
            }
        }

        return map;
    }

    /**
     * keys, values로 map을 생성
     *
     * @param keys separated value ex) id,name,description
     * @param values string value array
     * @return
     */
    public static Map<String, String> newStringMap(String keys, String... values) {
        Map<String, String> map = new HashMap<String, String>(values == null ? 3 : values.length);

        if (!isEmpty(keys) && !isEmpty(values)) {
            String[] keyArr = keys.split(",");

            if (keyArr.length != values.length) {
                throw new IllegalArgumentException("keys count and values count mismatch!");
            }

            for (int i = 0; i < keyArr.length; i++) {
                map.put(keyArr[i], values[i]);
            }
        }

        return map;
    }

    /**
     * List 생성 후 values를 담아서 리턴
     *
     * @param values
     * @return
     */
    public static List<Object> newList(Object... values) {
        List<Object> list = new ArrayList<Object>(values == null ? 3 : values.length);
        for (Object value : values) {
            list.add(value);
        }

        return list;
    }

    /**
     * List 생성 후 values를 담아서 리턴
     *
     * @param values
     * @return
     */
    public static List<String> newStringList(String... values) {
        List<String> list = new ArrayList<String>(values == null ? 3 : values.length);
        for (String value : values) {
            list.add(value);
        }

        return list;
    }

    /**
     * a, b 두 개의 Map을 merge하여 하나의 Map으로 리턴
     *
     * @param a
     * @param b
     * @return
     */
    public static Map<String, Object> merge(Map<String, Object> a, Map<String, Object> b) {
        if (a == null && b == null) {
            return null;
        } else if (a == null && b != null) {
            return b;
        } else if (a != null && b == null) {
            return a;
        } else {
            a.putAll(b);
            return a;
        }
    }

    /**
     * value의 첫 글자를 대문자로 변경.
     *
     * @param value
     * @return
     */
    public static String toUpperCaseHead(String value) {
        char[] charArr = value.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(charArr[0]).toUpperCase());

        for (int i = 1; i < charArr.length; i++) {
            sb.append(String.valueOf(charArr[i]));
        }

        return sb.toString();
    }


    /**
     * size 만큼의 난수 생성.(정수)
     *
     * @param size
     * @return
     */
    public static String generateUid(int size) {
        StringBuilder value = new StringBuilder();

        int firstNo = (int) (Math.random() * 10);
        value.append(firstNo == 0 ? ++firstNo : firstNo);

        for (int i = 1; i < size; i++) {
            value.append((int) (Math.random() * 10));
        }

        return value.toString();
    }

    /**
     * List 객체를 String Type으로 변환 (구분자 ',')
     *
     * @param list
     * @return
     */
    public static String listToString(List<String> list) {
        return listToString(list, ",");
    }

    /**
     * list내의 엘리먼트를 delimiter를 붙여서 문자열로 리턴하되 중복을 제거하지는 않음
     *
     * @param list
     * @param delimiter
     * @return
     */
    public static String listToString(List<String> list, String delimiter) {
        return listToString(list, delimiter, false);
    }

    /**
     * list내의 엘리먼트를 delimiter를 붙여서 문자열로 리턴하되 중복을 제거할 지 여부는 removeDuplication값에 따라 변경됨
     *
     * @param list
     * @param delimiter
     * @param removeDuplication
     * @return
     */
    public static String listToString(List<String> list, String delimiter, boolean removeDuplication) {
        StringJoiner value = new StringJoiner(delimiter);

        if (removeDuplication) {
            Set<String> set = new HashSet<String>();
            for (String str : list)
                set.add(str);

            for (String str : set)
                value.add(str);
        } else {
            for (String str : list)
                value.add(str);
        }

        return value.toString();
    }


    /**
     * PC Host Name 가져오기
     *
     * @return
     */
    public static String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "Unknown";
        }
    }


}
