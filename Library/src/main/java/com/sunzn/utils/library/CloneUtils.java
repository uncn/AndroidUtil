package com.sunzn.utils.library;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CloneUtils {

    private CloneUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：无需进行复制的特殊类型数组
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    private static Class[] exception = new Class[]{String.class, Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Void.class, Object.class, Class.class};

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：判断该类型对象是否无需复制
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：c 指定类型
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：如果不需要复制则返回真，否则返回假
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    private static boolean isNeedLessClone(Class c) {
        if (c.isPrimitive()) {          // 基本类型
            return true;
        }
        for (Class tmp : exception) {   // 是否在无需复制类型数组里
            if (c.equals(tmp)) {
                return true;
            }
        }
        return false;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：尝试创建新对象
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：value 原始对象
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 异常：IllegalAccessException
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：新的对象
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    private static Object createObject(Object value) throws IllegalAccessException {
        try {
            return value.getClass().newInstance();
        } catch (InstantiationException e) {
            return null;
        } catch (IllegalAccessException e) {
            throw e;
        }
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：复制对象数据
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：value 原始对象
     * ║ 参数：level 复制深度 小于 0 为无限深度，即将深入到最基本类型和 Object 类级别的数据复制；
     * ║            大于 0 则按照其值复制到指定深度的数据，等于 0 则直接返回对象本身而不进行任何复制行为。
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 异常：IllegalAccessException
     * ║ 异常：InstantiationException
     * ║ 异常：InvocationTargetException
     * ║ 异常：NoSuchMethodException
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：返回复制后的对象
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Object clone(Object value, int level) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        if (value == null) {
            return null;
        }
        if (level == 0) {
            return value;
        }
        Class c = value.getClass();
        if (isNeedLessClone(c)) {
            return value;
        }
        level--;
        if (value instanceof Collection) { // 复制新的集合
            Collection tmp = (Collection) c.newInstance();
            for (Object v : (Collection) value) {
                tmp.add(clone(v, level));  // 深度复制
            }
            value = tmp;
        } else if (c.isArray()) {          // 复制新的Array
            // 首先判断是否为基本数据类型
            if (c.equals(int[].class)) {
                int[] old = (int[]) value;
                value = Arrays.copyOf(old, old.length);
            } else if (c.equals(short[].class)) {
                short[] old = (short[]) value;
                value = Arrays.copyOf(old, old.length);
            } else if (c.equals(char[].class)) {
                char[] old = (char[]) value;
                value = Arrays.copyOf(old, old.length);
            } else if (c.equals(float[].class)) {
                float[] old = (float[]) value;
                value = Arrays.copyOf(old, old.length);
            } else if (c.equals(double[].class)) {
                double[] old = (double[]) value;
                value = Arrays.copyOf(old, old.length);
            } else if (c.equals(long[].class)) {
                long[] old = (long[]) value;
                value = Arrays.copyOf(old, old.length);
            } else if (c.equals(boolean[].class)) {
                boolean[] old = (boolean[]) value;
                value = Arrays.copyOf(old, old.length);
            } else if (c.equals(byte[].class)) {
                byte[] old = (byte[]) value;
                value = Arrays.copyOf(old, old.length);
            } else {
                Object[] old = (Object[]) value;
                Object[] tmp = Arrays.copyOf(old, old.length, old.getClass());
                for (int i = 0; i < old.length; i++) {
                    tmp[i] = clone(old[i], level);
                }
                value = tmp;
            }
        } else if (value instanceof Map) {             // 复制新的MAP
            Map tmp = (Map) c.newInstance();
            Map org = (Map) value;
            for (Object key : org.keySet()) {
                tmp.put(key, clone(org.get(key), level)); // 深度复制
            }
            value = tmp;
        } else {
            Object tmp = createObject(value);
            if (tmp == null) {  // 无法创建新实例则返回对象本身，没有克隆
                return value;
            }
            Set<Field> fields = new HashSet<Field>();
            while (c != null && !c.equals(Object.class)) {
                fields.addAll(Arrays.asList(c.getDeclaredFields()));
                c = c.getSuperclass();
            }
            for (Field field : fields) {
                if (!Modifier.isFinal(field.getModifiers())) {      // 仅复制非final字段
                    field.setAccessible(true);
                    field.set(tmp, clone(field.get(value), level)); // 深度复制
                }
            }
            value = tmp;
        }
        return value;
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：浅表复制对象
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：value 原始对象
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 异常：IllegalAccessException
     * ║ 异常：InstantiationException
     * ║ 异常：InvocationTargetException
     * ║ 异常：NoSuchMethodException
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：克隆后的对象，只克隆一层
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Object clone(Object value) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        return clone(value, 1);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：深度复制对象
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：value 原始对象
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 异常：IllegalAccessException
     * ║ 异常：InstantiationException
     * ║ 异常：InvocationTargetException
     * ║ 异常：NoSuchMethodException
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：克隆后的对象
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static Object deepClone(Object value) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        return clone(value, -1);
    }
}