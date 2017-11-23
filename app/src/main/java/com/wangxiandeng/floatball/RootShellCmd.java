package com.wangxiandeng.floatball;

import java.io.OutputStream;

/**
 * Created by xinchenxu on 2017/11/23.
 */

public class RootShellCmd {

    private static OutputStream os;

    /**
     * 执行shell指令
     *
     * @param cmd
     *            指令
     */
    public static final void exec(String cmd) {
        try {
            if (os == null) {
                os = Runtime.getRuntime().exec("su").getOutputStream();
            }
            os.write(cmd.getBytes());
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 后台模拟全局按键
     *
     * @param keyCode
     *            键值
     */
    public static void simulateKey(int keyCode) {
        exec("input keyevent " + keyCode + "\n");
    }

}