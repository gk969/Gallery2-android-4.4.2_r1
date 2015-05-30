/*
 * Copyright (C) 2011-2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * This file is auto-generated. DO NOT MODIFY!
 * The source Renderscript file: packages/apps/Gallery2/src/com/android/gallery3d/filtershow/filters/grad.rs
 */
package com.android.gallery3d.filtershow.filters;

import android.support.v8.renderscript.*;
import android.content.res.Resources;

/**
 * @hide
 */
public class ScriptC_grad extends ScriptC {
    private static final String __rs_resource_name = "grad";
    // Constructor
    public  ScriptC_grad(RenderScript rs) {
        this(rs,
             rs.getApplicationContext().getResources(),
             rs.getApplicationContext().getResources().getIdentifier(
                 __rs_resource_name, "raw",
                 rs.getApplicationContext().getPackageName()));
    }

    public  ScriptC_grad(RenderScript rs, Resources resources, int id) {
        super(rs, resources, id);
        __U32 = Element.U32(rs);
        __I32 = Element.I32(rs);
        __BOOLEAN = Element.BOOLEAN(rs);
        __U8_4 = Element.U8_4(rs);
    }

    private Element __BOOLEAN;
    private Element __I32;
    private Element __U32;
    private Element __U8_4;
    private FieldPacker __rs_fp_BOOLEAN;
    private FieldPacker __rs_fp_I32;
    private FieldPacker __rs_fp_U32;
    private final static int mExportVarIdx_inputWidth = 0;
    private long mExportVar_inputWidth;
    public synchronized void set_inputWidth(long v) {
        if (__rs_fp_U32!= null) {
            __rs_fp_U32.reset();
        } else {
            __rs_fp_U32 = new FieldPacker(4);
        }
        __rs_fp_U32.addU32(v);
        setVar(mExportVarIdx_inputWidth, __rs_fp_U32);
        mExportVar_inputWidth = v;
    }

    public long get_inputWidth() {
        return mExportVar_inputWidth;
    }

    public Script.FieldID getFieldID_inputWidth() {
        return createFieldID(mExportVarIdx_inputWidth, null);
    }

    private final static int mExportVarIdx_inputHeight = 1;
    private long mExportVar_inputHeight;
    public synchronized void set_inputHeight(long v) {
        if (__rs_fp_U32!= null) {
            __rs_fp_U32.reset();
        } else {
            __rs_fp_U32 = new FieldPacker(4);
        }
        __rs_fp_U32.addU32(v);
        setVar(mExportVarIdx_inputHeight, __rs_fp_U32);
        mExportVar_inputHeight = v;
    }

    public long get_inputHeight() {
        return mExportVar_inputHeight;
    }

    public Script.FieldID getFieldID_inputHeight() {
        return createFieldID(mExportVarIdx_inputHeight, null);
    }

    private final static int mExportVarIdx_mNumberOfLines = 2;
    private int mExportVar_mNumberOfLines;
    public synchronized void set_mNumberOfLines(int v) {
        setVar(mExportVarIdx_mNumberOfLines, v);
        mExportVar_mNumberOfLines = v;
    }

    public int get_mNumberOfLines() {
        return mExportVar_mNumberOfLines;
    }

    public Script.FieldID getFieldID_mNumberOfLines() {
        return createFieldID(mExportVarIdx_mNumberOfLines, null);
    }

    private final static int mExportVarIdx_mask = 3;
    private boolean[] mExportVar_mask;
    public synchronized void set_mask(boolean[] v) {
        mExportVar_mask = v;
        FieldPacker fp = new FieldPacker(16);
        for (int ct1 = 0; ct1 < 16; ct1++) {
            fp.addBoolean(v[ct1]);
        }

        int []__dimArr = new int[1];
        __dimArr[0] = 16;
        setVar(mExportVarIdx_mask, fp, __BOOLEAN, __dimArr);
    }

    public boolean[] get_mask() {
        return mExportVar_mask;
    }

    public Script.FieldID getFieldID_mask() {
        return createFieldID(mExportVarIdx_mask, null);
    }

    private final static int mExportVarIdx_xPos1 = 4;
    private int[] mExportVar_xPos1;
    public synchronized void set_xPos1(int[] v) {
        mExportVar_xPos1 = v;
        FieldPacker fp = new FieldPacker(64);
        for (int ct1 = 0; ct1 < 16; ct1++) {
            fp.addI32(v[ct1]);
        }

        int []__dimArr = new int[1];
        __dimArr[0] = 16;
        setVar(mExportVarIdx_xPos1, fp, __I32, __dimArr);
    }

    public int[] get_xPos1() {
        return mExportVar_xPos1;
    }

    public Script.FieldID getFieldID_xPos1() {
        return createFieldID(mExportVarIdx_xPos1, null);
    }

    private final static int mExportVarIdx_yPos1 = 5;
    private int[] mExportVar_yPos1;
    public synchronized void set_yPos1(int[] v) {
        mExportVar_yPos1 = v;
        FieldPacker fp = new FieldPacker(64);
        for (int ct1 = 0; ct1 < 16; ct1++) {
            fp.addI32(v[ct1]);
        }

        int []__dimArr = new int[1];
        __dimArr[0] = 16;
        setVar(mExportVarIdx_yPos1, fp, __I32, __dimArr);
    }

    public int[] get_yPos1() {
        return mExportVar_yPos1;
    }

    public Script.FieldID getFieldID_yPos1() {
        return createFieldID(mExportVarIdx_yPos1, null);
    }

    private final static int mExportVarIdx_xPos2 = 6;
    private int[] mExportVar_xPos2;
    public synchronized void set_xPos2(int[] v) {
        mExportVar_xPos2 = v;
        FieldPacker fp = new FieldPacker(64);
        for (int ct1 = 0; ct1 < 16; ct1++) {
            fp.addI32(v[ct1]);
        }

        int []__dimArr = new int[1];
        __dimArr[0] = 16;
        setVar(mExportVarIdx_xPos2, fp, __I32, __dimArr);
    }

    public int[] get_xPos2() {
        return mExportVar_xPos2;
    }

    public Script.FieldID getFieldID_xPos2() {
        return createFieldID(mExportVarIdx_xPos2, null);
    }

    private final static int mExportVarIdx_yPos2 = 7;
    private int[] mExportVar_yPos2;
    public synchronized void set_yPos2(int[] v) {
        mExportVar_yPos2 = v;
        FieldPacker fp = new FieldPacker(64);
        for (int ct1 = 0; ct1 < 16; ct1++) {
            fp.addI32(v[ct1]);
        }

        int []__dimArr = new int[1];
        __dimArr[0] = 16;
        setVar(mExportVarIdx_yPos2, fp, __I32, __dimArr);
    }

    public int[] get_yPos2() {
        return mExportVar_yPos2;
    }

    public Script.FieldID getFieldID_yPos2() {
        return createFieldID(mExportVarIdx_yPos2, null);
    }

    private final static int mExportVarIdx_size = 8;
    private int[] mExportVar_size;
    public synchronized void set_size(int[] v) {
        mExportVar_size = v;
        FieldPacker fp = new FieldPacker(64);
        for (int ct1 = 0; ct1 < 16; ct1++) {
            fp.addI32(v[ct1]);
        }

        int []__dimArr = new int[1];
        __dimArr[0] = 16;
        setVar(mExportVarIdx_size, fp, __I32, __dimArr);
    }

    public int[] get_size() {
        return mExportVar_size;
    }

    public Script.FieldID getFieldID_size() {
        return createFieldID(mExportVarIdx_size, null);
    }

    private final static int mExportVarIdx_brightness = 9;
    private int[] mExportVar_brightness;
    public synchronized void set_brightness(int[] v) {
        mExportVar_brightness = v;
        FieldPacker fp = new FieldPacker(64);
        for (int ct1 = 0; ct1 < 16; ct1++) {
            fp.addI32(v[ct1]);
        }

        int []__dimArr = new int[1];
        __dimArr[0] = 16;
        setVar(mExportVarIdx_brightness, fp, __I32, __dimArr);
    }

    public int[] get_brightness() {
        return mExportVar_brightness;
    }

    public Script.FieldID getFieldID_brightness() {
        return createFieldID(mExportVarIdx_brightness, null);
    }

    private final static int mExportVarIdx_contrast = 10;
    private int[] mExportVar_contrast;
    public synchronized void set_contrast(int[] v) {
        mExportVar_contrast = v;
        FieldPacker fp = new FieldPacker(64);
        for (int ct1 = 0; ct1 < 16; ct1++) {
            fp.addI32(v[ct1]);
        }

        int []__dimArr = new int[1];
        __dimArr[0] = 16;
        setVar(mExportVarIdx_contrast, fp, __I32, __dimArr);
    }

    public int[] get_contrast() {
        return mExportVar_contrast;
    }

    public Script.FieldID getFieldID_contrast() {
        return createFieldID(mExportVarIdx_contrast, null);
    }

    private final static int mExportVarIdx_saturation = 11;
    private int[] mExportVar_saturation;
    public synchronized void set_saturation(int[] v) {
        mExportVar_saturation = v;
        FieldPacker fp = new FieldPacker(64);
        for (int ct1 = 0; ct1 < 16; ct1++) {
            fp.addI32(v[ct1]);
        }

        int []__dimArr = new int[1];
        __dimArr[0] = 16;
        setVar(mExportVarIdx_saturation, fp, __I32, __dimArr);
    }

    public int[] get_saturation() {
        return mExportVar_saturation;
    }

    public Script.FieldID getFieldID_saturation() {
        return createFieldID(mExportVarIdx_saturation, null);
    }

    //private final static int mExportForEachIdx_root = 0;
    private final static int mExportForEachIdx_selectiveAdjust = 1;
    public Script.KernelID getKernelID_selectiveAdjust() {
        return createKernelID(mExportForEachIdx_selectiveAdjust, 3, null, null);
    }

    public void forEach_selectiveAdjust(Allocation ain, Allocation aout) {
        forEach_selectiveAdjust(ain, aout, null);
    }

    public void forEach_selectiveAdjust(Allocation ain, Allocation aout, Script.LaunchOptions sc) {
        // check ain
        if (!ain.getType().getElement().isCompatible(__U8_4)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        // check aout
        if (!aout.getType().getElement().isCompatible(__U8_4)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        // Verify dimensions
        Type tIn = ain.getType();
        Type tOut = aout.getType();
        if ((tIn.getCount() != tOut.getCount()) ||
            (tIn.getX() != tOut.getX()) ||
            (tIn.getY() != tOut.getY()) ||
            (tIn.getZ() != tOut.getZ()) ||
            (tIn.hasFaces() != tOut.hasFaces()) ||
            (tIn.hasMipmaps() != tOut.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between input and output parameters!");
        }
        forEach(mExportForEachIdx_selectiveAdjust, ain, aout, null, sc);
    }

    private final static int mExportFuncIdx_setupGradParams = 0;
    public void invoke_setupGradParams() {
        invoke(mExportFuncIdx_setupGradParams);
    }

}

