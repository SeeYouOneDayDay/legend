package ref;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Refunsafe {

    public static Class findClass(String className) {
        try {
            return Class.forName(className);
        } catch (Throwable e) {
            e(e);
        }
        try {
            return ClassLoader.getSystemClassLoader().loadClass(className);
        } catch (Throwable e) {
            e(e);
        }
//        try {
//            return new String().getClass().getClassLoader().loadClass(className);
//        } catch (Throwable e) {
//            e(e);
//        }

        return null;
    }

    public static Constructor getConstructor(String className, Class<?>... types) {
        return getConstructor(findClass(className), types);
    }

    public static Constructor getConstructor(Class<?> clazz, Class<?>... types) {
        if (clazz == null) {
            return null;
        }
        Constructor constructor = null;
        try {
            constructor = clazz.getDeclaredConstructor(types);
        } catch (Throwable e) {
//            e(e);
        }
        try {
            if (constructor == null) {
                constructor = clazz.getConstructor(types);
            }
        } catch (Throwable e) {
//            e(e);
        }
        if (constructor != null) {
            //版本23以后
            //我们不能使用 constructor.setAccessible(true);谷歌会限制
            // AccessibleObject.setAccessible(new AccessibleObject[]{constructor}, true);
            // 或者修改标签： Field override = AccessibleObject.class.getDeclaredField(
            //                        Build.VERSION.SDK_INT == Build.VERSION_CODES.M ? "flag" : "override");
            constructor.setAccessible(true);
        }
        return constructor;
    }

    public static Method getMethod(String className, String methodName, Class<?>... types) {
        return getMethod(findClass(className), methodName, types);

    }

    public static Method getMethod(Class<?> clazz, String methodName, Class<?>... types) {
        if (clazz == null || TextUtils.isEmpty(methodName)) {
            return null;
        }
        Method method = null;
        while (clazz != Object.class) {
            try {
                method = clazz.getDeclaredMethod(methodName, types);

                if (method != null) {
//                    forceAccessible(method);
                    if (!method.isAccessible()){
                        method.setAccessible(true);
                    }
                    return method;
                }
            } catch (Throwable e) {
            }
            clazz = clazz.getSuperclass();
        }
        return method;
    }

    public static Object newInstance(Constructor constructor, Object... args) {
        if (constructor == null) {
            return null;
        }
        try {
            return constructor.newInstance(args);
        } catch (Throwable e) {
            e(e);
        }
        return null;
    }


    public static Object invoke(Object obj, Method method, Object... args) {
        if (method == null) {
            return null;
        }
        try {
            if (args == null || args.length < 1) {
                return method.invoke(obj);
            } else {
                return method.invoke(obj, args);
            }
        } catch (Throwable e) {
            e(e);
        }
        return null;
    }

    public static Field getField(String className, String fieldName) {
        return getField(findClass(className), fieldName);
    }


    public static Field getField(Class clazz, String fieldName) {
        if (clazz == null || TextUtils.isEmpty(fieldName)) {
            return null;
        }
        Field field = null;
        while (clazz != Object.class) {
            try {
                field = clazz.getDeclaredField(fieldName);

                if (field != null) {
//                    setFinalFieldReadable(field);
//                    forceAccessible(field);
                    if (!field.isAccessible()){
                        field.setAccessible(true);
                    }
                    return field;
                }
            } catch (Throwable e) {
            }
            clazz = clazz.getSuperclass();
        }
        return field;
    }

    private static void setFinalFieldReadable(Field field) throws NoSuchFieldException, IllegalAccessException {
        int modify = field.getModifiers();
        if (Modifier.isFinal(modify)) {
            Field modifiersField = Field.class.getDeclaredField("accessFlags");
            if (modifiersField == null) {
                modifiersField = Field.class.getDeclaredField("modifiers");
            }
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, modify & ~Modifier.FINAL);
        }
    }


    public static Object getFieldValue(String className, String fieldName) {
        return getFieldValue(className, fieldName, null);
    }

    public static Object getFieldValue(String className, String fieldName, Object instance) {
        return getFieldValue(findClass(className), fieldName, instance);
    }

    public static Object getFieldValue(Class<?> clazz, String fieldName) {
        return getFieldValue(clazz, fieldName, null);
    }

    public static Object getFieldValue(Object instance, String fieldName) {
        return getFieldValue(instance.getClass(), fieldName, instance);
    }

    public static Object getFieldValue(Class<?> clazz, String fieldName, Object instance) {
        try {
            Field addr = getField(clazz, fieldName);
            if (addr != null) {
                return addr.get(instance);
            }
        } catch (Throwable e) {
//            e(e);
        }
        return null;
    }

    private static Field override;

    public static void forceAccessible(AccessibleObject member) {
        try {
            member.setAccessible(true);
            if (member.isAccessible()) return;
        } catch (SecurityException ignored) {
        }
        if (override == null) {
            override = getField(AccessibleObject.class, Build.VERSION.SDK_INT >= Build.VERSION_CODES.N ? "override" : "flag");
        }
        try {
            override.setBoolean(member, true);
        } catch (IllegalAccessException e) {
            throw new SecurityException("Cannot set AccessibleObject.override", e);
        }
    }

    public static boolean setFieldObject(String className, String fieldName, Object instance, Object newValues) {
        if (TextUtils.isEmpty(className) || TextUtils.isEmpty(fieldName)) {
            e(new Exception("setFieldObject 参数异常，设置失败！"));
            return false;
        }
        return setFieldObject(findClass(className), fieldName, instance, newValues);
    }

    public static boolean setFieldObject(Class<?> clazz, String fieldName, Object instance, Object newValues) {
        try {
            Field addr = getField(clazz, fieldName);
            if (addr != null) {
                addr.set(instance, newValues);
                return true;
            } else {
                return false;
            }
        } catch (Throwable e) {
        }
        return false;
    }

    public static Object call(String className, String methodName, Object receiver) {
        return call(findClass(className), methodName, receiver);
    }

    public static Object call(String className, String methodName, Object receiver,
                              Class[] types, Object[] params) {
        return call(findClass(className), methodName, receiver, types, params);
    }

    public static Object call(Class<?> clazz, String methodName, Object receiver) {
        return call(clazz, methodName, receiver, null, null);
    }

    public static Object call(Class<?> clazz, String methodName, Object instance,
                              Class[] types, Object[] params) {
        try {

            if (types == null || params == null) {
                Method method = getMethod(clazz, methodName);
                return invoke(instance, method);
            } else {
                Method method = getMethod(clazz, methodName, types);
                return invoke(instance, method, params);
            }

        } catch (Throwable throwable) {
            e(throwable);
        }
        return null;
    }

//    //double
//    public static Object dCall(Class<?> clazz, String[] mns, Object receiver,
//                               Class[] types, Object[] params) {
//        try {
//            Method method = null;
//
//            if (mns != null || mns.length > 0) {
//                for (String mn : mns) {
//                    if (types == null || params == null) {
//                        method = getMethod(clazz, mn);
//                        if (method != null) {
//                            return invoke(receiver, method);
//                        }
//                    } else {
//                        method = getMethod(clazz, mn, types);
//                        if (method != null) {
//                            return invoke(receiver, method);
//                        }
//                    }
//                }
//            }
//        } catch (Throwable throwable) {
//            e(throwable);
//        }
//        return null;
//    }
//
//    public static Object get(Class<?> clazz, String className, String fieldName, Object receiver) {
//        try {
//            if (clazz == null) clazz = findClass(className);
//            return getFieldValue(clazz, fieldName, receiver);
//        } catch (Throwable throwable) {
//            e(throwable);
//        }
//        return null;
//    }


    public static boolean isSame(Class<?>[] params, Class<?>[] types) {
        //无参
        if (
                (params == null && types == null)
                        || (params.length == 0 && types.length == 0)
                        || (params == null && types.length == 0)
                        || (params == null && types.length == 0)
                        || (params.length == 0 && types == null)
        ) {
            return true;
        }
        // 有参
        if (params.length == types.length) {
            for (int i = 0; i < params.length; i++) {
                if (params[i] != types[i]) {
                    return false;
                }
            }
            // all same is same
            return true;
        }
        return false;
    }


    /**************************************工具方法***********************************/
    public static void e(Throwable e) {
        Log.e("sanbo.Refunsafe", Log.getStackTraceString(e));
    }


}
