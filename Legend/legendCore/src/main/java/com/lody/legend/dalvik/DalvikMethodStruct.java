package com.lody.legend.dalvik;

import android.util.Log;

import com.lody.legend.model.MethodSizeCase;
import com.lody.legend.utility.LegendNative;
import com.lody.legend.utility.Struct;
import com.lody.legend.utility.StructMapping;
import com.lody.legend.utility.StructMember;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import ref.Refunsafe;
import ref.UnsafeHelper;

/**
 * @author Lody
 * @version 1.0
 */

public class DalvikMethodStruct extends Struct {

    @StructMapping(offset = 0)
    public StructMember clazz;

    @StructMapping(offset = 4)
    public StructMember accessFlags;

    @StructMapping(offset = 8, length = 2)
    public StructMember methodIndex;

    @StructMapping(offset = 10, length = 2)
    public StructMember registersSize;

    @StructMapping(offset = 12, length = 2)
    public StructMember outsSize;

    @StructMapping(offset = 14, length = 2)
    public StructMember insSize;

    @StructMapping(offset = 16)
    public StructMember name;

    //struct DexProto {
    @StructMapping(offset = 20)
    public StructMember dexFile;
    @StructMapping(offset = 24)
    public StructMember protoIdx;
    //}

    @StructMapping(offset = 28)
    public StructMember shorty;

    @StructMapping(offset = 32)
    public StructMember insns;

    @StructMapping(offset = 36)
    public StructMember jniArgInfo;

    @StructMapping(offset = 40)
    public StructMember nativeFunc;

    /**
     * The target method
     */
    private Method method;

    private DalvikMethodStruct(Method method) {
        super(LegendNative.getMethodAddress(method));
        this.method = method;
        Log.i("sanbo.legend", "method:" + method
                + "\r\naddress:" + LegendNative.getMethodAddress(method)
                + "\r\ngetMethodAddress:" + getMethodAddress(method)
        );
    }


    /**
     * Create a dalvik struct in java mapping native
     * @param method method
     * @return
     */
    public static DalvikMethodStruct of(Method method) {
        return new DalvikMethodStruct(method);
    }


    private final static int DIRECT_METHOD_OFFSET = 25;
    private final static int VIRTUAL_METHOD_OFFSET = 27;

    public long getMethodAddress(Method method) {
        Class declaringClass = method.getDeclaringClass();
        long virtualMethodAddr = 0;

        if (isDirect(method)) {
            virtualMethodAddr = UnsafeHelper.getInt(declaringClass, DIRECT_METHOD_OFFSET * 4);
        } else {
            virtualMethodAddr = UnsafeHelper.getInt(declaringClass, VIRTUAL_METHOD_OFFSET * 4);
        }
        int slotSrc = (Integer) Refunsafe.getFieldValue(Method.class, "slot", method);
        if (slotSrc < 0) {
            slotSrc = -(slotSrc + 1);
        }
        return virtualMethodAddr + slotSrc * getMethodSize();
    }

    private int getMethodSize() {
        int methodSize = 56;
        int directMethodAddr = UnsafeHelper.getInt(MethodSizeCase.class, DIRECT_METHOD_OFFSET * 4);
        int declaringClassAddr = (int) UnsafeHelper.toAddress(MethodSizeCase.class);
        int count = 0;
        int elementCount = 0;
        //通过扫面内存来确认Method的结构体大小
        for (int i = 0; i < 200; i++) {
            int value = UnsafeHelper.getInt(null, directMethodAddr + i * 4);
            if (value == declaringClassAddr) {
                count++;
            }
            if (count == 2) {
                break;
            }
            if (count == 1) {
                elementCount++;
            }
        }
        methodSize = 4 * elementCount;

        return methodSize;
    }


    private boolean isDirect(Method method) {
        int modifier = method.getModifiers();
        return Modifier.isFinal(modifier) || Modifier.isStatic(modifier)
                || Modifier.isPrivate(modifier);
    }

}
