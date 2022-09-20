package com.lody.legend.utility;//package com.lody.legend.utility;
//
//import android.text.TextUtils;
//import android.util.Log;
//
//import java.io.FileDescriptor;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//
//import libcore.io.Libcore;
//import libcore.io.Memory;
//import sun.misc.Unsafe;
//
///**
// *
// * Legend native helper functions.
// *
// * NOTICE: Don't edit class name of this class.
// *
// * @author Lody
// * @version 1.0
// */
//public final class LegendNativebk {
//    // has no
//    public static native void munprotect(long address, int size);
//
//
//
//    public static void memcpy(long dest, long src, long length) {
//        for (long i = 0; i < length; i++) {
//            Memory.pokeByte(dest, Memory.peekByte(src));
//            dest++;
//            src++;
//        }
//    }
//
//
//    public static void memput(long deskAddress, byte[] bytes) {
//        for (int i = 0; i < bytes.length; i++) {
//            Memory.pokeByte(deskAddress, bytes[i]);
//            deskAddress++;
//        }
//    }
//
//
//    public static byte[] memget(long srcAddress, int length) {
//        long dstBuf = Unsafe.getUnsafe().allocateMemory(length);
//        Unsafe.getUnsafe().copyMemory(srcAddress, dstBuf, length);
//        byte[] dst = new byte[length];
//        for (int i = 0; i < length; ++i) {
//            byte srcByte = Unsafe.getUnsafe().getByte(srcAddress++);
//            byte dstByte = Unsafe.getUnsafe().getByte(dstBuf++);
//            if (srcByte != dstByte) {
//                Log.e("sanbo", String.format("UnsafeHelper copy Failed!  offset %d: src = '%c', dst = '%c'",
//                        i, srcByte, dstByte));
//            }
//            dst[i] = srcByte;
//        }
//        return dst;
//    }
//
//
//    /*
//     * Protections are chosen from these bits, or-ed together
//     */
//    public static final int PROT_NONE = 0x00;  /* [MC2] no permissions */
//    public static final int PROT_READ = 0x01;  /* [MC2] pages can be read */
//    public static final int PROT_WRITE = 0x02; /* [MC2] pages can be written */
//    public static final int PROT_EXEC = 0x03;  /* [MC2] pages can be executed */
//    /*
//     * Flags contain sharing type and options.
//     * Sharing types; choose one.
//     */
//    public static final int MAP_SHARED = 0x0001;    /* [MF|SHM] share changes */
//    public static final int MAP_PRIVATE = 0x0002;   /* [MF|SHM] changes are private */
//
//    /*
//     * Other flags
//     */
//    public static final int MAP_FIXED = 0x0010;          /* [MF|SHM] interpret addr exactly */
//    public static final int MAP_RENAME = 0x0020;         /* Sun: rename private pages to file */
//    public static final int MAP_NORESERVE = 0x0040;      /* Sun: don't reserve needed swap area */
//    public static final int MAP_RESERVED0080 = 0x0080;   /* previously unimplemented MAP_INHERIT */
//
//    public static final int MAP_NOEXTEND = 0x0100;       /* for MAP_FILE, don't change file size */
//    public static final int MAP_HASSEMAPHORE = 0x0200;   /* region may contain semaphores */
//    public static final int MAP_NOCACHE = 0x0400;        /* don't cache pages for this mapping */
//    public static final int MAP_JIT = 0x0800;            /* Allocate a region that will be used for JIT purposes */
//    /*
//     * Mapping type
//     */
//    public static final int MAP_FILE = 0x0000;            /* map from file (default) */
//    public static final int MAP_ANON = 0x1000;            /* allocated from memory, swap space */
//    public static final int MAP_ANONYMOUS = MAP_ANON;            /* allocated from memory, swap space */
//
//    public static long malloc(int length) {
//        try {
//            return Libcore.rawOs.mmap(0, length, PROT_READ | PROT_WRITE | PROT_EXEC, MAP_PRIVATE | MAP_ANONYMOUS, new FileDescriptor(), 0);
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        return -1;
//    }
//
//    public static void free(long pointer, int length) {
//        try {
//            Libcore.rawOs.munmap(pointer, length);
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Get the address from method
//     *
//     * (Ljava/lang/reflect/Method;)J
//     */
//    public static long getMethodAddress(Method method) {
//        //   dalvik 获取方案需要调整
//        return (Long) getFieldValue(Method.class.getSuperclass(), "artMethod", method);
//    }
//
//    /**
//     *
//     * (Ljava/lang/Object;)J
//     */
//    public static long getObjectAddress(Object object) {
//        Object[] array = new Object[]{object};
//        int arrayIndexScaleObject = Unsafe.getUnsafe().arrayIndexScale(Object[].class);
//        int arrayBaseOffsetObject = Unsafe.getUnsafe().arrayBaseOffset(Object[].class);
//        if (arrayIndexScaleObject == 8) {
//            return Unsafe.getUnsafe().getLong(array, arrayBaseOffsetObject);
//        } else {
//            return 0xffffffffL & Unsafe.getUnsafe().getInt(array, arrayBaseOffsetObject);
//        }
//    }
//
//
//
//
//    public static Object getFieldValue(Class<?> clazz, String fieldName, Object instance) {
//        try {
//            Field addr = getField(clazz, fieldName);
//            if (addr != null) {
//                return addr.get(instance);
//            }
//        } catch (Throwable e) {
////            e(e);
//        }
//        return null;
//    }
//
//    public static Field getField(Class clazz, String fieldName) {
//        if (clazz == null || TextUtils.isEmpty(fieldName)) {
//            return null;
//        }
//        Field field = null;
//        while (clazz != Object.class) {
//            try {
//                field = clazz.getDeclaredField(fieldName);
//
//                if (field != null) {
////                    setFinalFieldReadable(field);
////                    forceAccessible(field);
//                    if (!field.isAccessible()) {
//                        field.setAccessible(true);
//                    }
//                    return field;
//                }
//            } catch (Throwable e) {
//            }
//            clazz = clazz.getSuperclass();
//        }
//        return field;
//    }
//
//    /**
//     *
//     * (JI)I
//     *
//     */
//    public static native int getCharArrayLength(long address, int limit);
//    //jint getCharArrayLength(JNIEnv * env, jclass clazz,jlong address, jint limit) {
//    //  //获取地址的数据？
//    //    char * charArray = (char *)address;
//    //    int length = 0;
//    //    if (limit > 0) {
//    //        while (*charArray != '\0' && length < limit) {
//    //            length++;
//    //            charArray++;
//    //        }
//    //    }else {
//    //        while (*charArray != '\0') {
//    //            length++;
//    //            charArray++;
//    //        }
//    //    }
//    //
//    //    return length;
//    //}
//
//
//    /**
//     * Length of c char
//     * @param address char[] address
//     * @return
//     */
//    public static int getCharArrayLength(long address) {
//        return getCharArrayLength(address, -1);
//    }
//
////    /**
////     *
////     * BigEndian or LittleEndian
////     * Most of device are little endian.
////     *
////     * ()Z
////     */
////    public static boolean isLittleEndian() {
////
////        return false;
////    }
////    //没搞懂 干啥   定义符号0,
////    jboolean isLittleEndian(JNIEnv * env, jclass clazz) {
////        unsigned int num = 0,*p = &num;
////    *(unsigned char *)p = 0xff;
////        if (num == 0xff) {
////            return JNI_TRUE;
////        }
////        return JNI_FALSE;
////    }
//
//    public static boolean isLittleEndian() {
//        if ((0 & 0xffffffffL ) == 0xff) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//
//    public static native long getPointer(long address);
//    //    void * pointer = (void *)address;
//    //    return (jlong)&pointer;
//
//}
