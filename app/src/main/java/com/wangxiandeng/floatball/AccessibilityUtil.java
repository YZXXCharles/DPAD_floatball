package com.wangxiandeng.floatball;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.provider.Settings;
import android.view.KeyEvent;

import java.io.IOException;

/**
 * Created by wangxiandeng on 2016/11/25.
 */

public class AccessibilityUtil {
    /**
     * 单击DPAD_Center
     */
    public static void doDCenter() {
        RootShellCmd.simulateKey(KeyEvent.KEYCODE_DPAD_CENTER);
    }

    /**
     * 单击DPAD_Left
     */
    public static void doDLeft() {
        RootShellCmd.simulateKey(KeyEvent.KEYCODE_DPAD_LEFT);
    }

    /**
     * 单击DPAD_Right
     */
    public static void doDRight() {
        RootShellCmd.simulateKey(KeyEvent.KEYCODE_DPAD_RIGHT);
    }

    /**
     * 单击DPAD_Down
     */
    public static void doDDown() {
        RootShellCmd.simulateKey(KeyEvent.KEYCODE_DPAD_DOWN);
    }

    /**
     * 单击DPAD_Up
     */
    public static void doDUp() {
        RootShellCmd.simulateKey(KeyEvent.KEYCODE_DPAD_UP);
    }

    public static boolean isAccessibilitySettingsOn(Context context) {
        int accessibilityEnabled = 0;
        try {
            accessibilityEnabled = Settings.Secure.getInt(context.getContentResolver(),
                    android.provider.Settings.Secure.ACCESSIBILITY_ENABLED);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }

        if (accessibilityEnabled == 1) {
            String services = Settings.Secure.getString(context.getContentResolver(),
                    Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            if (services != null) {
                return services.toLowerCase().contains(context.getPackageName().toLowerCase());
            }
        }

        return false;
    }



}
