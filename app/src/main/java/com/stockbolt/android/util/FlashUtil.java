package com.stockbolt.android.util;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;

import java.util.List;

/**
 * Created by guobin.zheng on 2016/7/6.
 * 闪光灯工具
 */
public class FlashUtil {

    public static void switchLight(Camera mCamera) {
        if (mCamera == null) {
            return;
        }
        Parameters parameters = mCamera.getParameters();
        if (parameters == null) {
            return;
        }
        List<String> flashModes = parameters.getSupportedFlashModes();
        // Check if camera flash exists
        if (flashModes == null) {
            // Use the screen as a flashlight (next best thing)
            return;
        }
        String flashMode = parameters.getFlashMode();
        if (Parameters.FLASH_MODE_OFF.equals(flashMode)) {
            // Turn on the flash
            if (flashModes.contains(Parameters.FLASH_MODE_TORCH)) {
                parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
                mCamera.setParameters(parameters);
            }
        } else if (Parameters.FLASH_MODE_TORCH.equals(flashMode)) {
            // Turn off the flash
            if (flashModes.contains(Parameters.FLASH_MODE_OFF)) {
                parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
                mCamera.setParameters(parameters);
            }

        }
    }

//    public static void turnLightOn(Camera mCamera) {
//        if (mCamera == null) {
//            return;
//        }
//        Parameters parameters = mCamera.getParameters();
//        if (parameters == null) {
//            return;
//        }
//        List<String> flashModes = parameters.getSupportedFlashModes();
//        // Check if camera flash exists
//        if (flashModes == null) {
//            // Use the screen as a flashlight (next best thing)
//            return;
//        }
//        String flashMode = parameters.getFlashMode();
//        if (!Parameters.FLASH_MODE_TORCH.equals(flashMode)) {
//            // Turn on the flash
//            if (flashModes.contains(Parameters.FLASH_MODE_TORCH)) {
//                parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
//                mCamera.setParameters(parameters);
//            }
//        }
//    }
//
//    public static void turnLightOff(Camera mCamera) {
//        if (mCamera == null) {
//            return;
//        }
//        Parameters parameters = mCamera.getParameters();
//        if (parameters == null) {
//            return;
//        }
//        List<String> flashModes = parameters.getSupportedFlashModes();
//        String flashMode = parameters.getFlashMode();
//        // Check if camera flash exists
//        if (flashModes == null) {
//            return;
//        }
//        if (!Parameters.FLASH_MODE_OFF.equals(flashMode)) {
//            // Turn off the flash
//            if (flashModes.contains(Parameters.FLASH_MODE_OFF)) {
//                parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
//                mCamera.setParameters(parameters);
//            }
//
//        }
//    }
}
