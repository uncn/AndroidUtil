package com.sunzn.utils.library;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.util.List;

public class ShellUtils {

    private ShellUtils() {
        throw new RuntimeException("Stub!");
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：是否是在 root 下执行命令
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：command 命令
     * ║ 参数：isRoot  是否需要 root 权限执行
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：CommandResult
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static CommandResult execCmd(String command, boolean isRoot) {
        return execCmd(new String[]{command}, isRoot, true);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：是否是在 root 下执行命令
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：commands 多条命令链表
     * ║ 参数：isRoot   是否需要 root 权限执行
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：CommandResult
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static CommandResult execCmd(List<String> commands, boolean isRoot) {
        return execCmd(commands == null ? null : commands.toArray(new String[]{}), isRoot, true);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：是否是在 root 下执行命令
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：commands 多条命令链表
     * ║ 参数：isRoot   是否需要 root 权限执行
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：CommandResult
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static CommandResult execCmd(String[] commands, boolean isRoot) {
        return execCmd(commands, isRoot, true);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：是否是在 root 下执行命令
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：command         命令
     * ║ 参数：isRoot          是否需要 root 权限执行
     * ║ 参数：isNeedResultMsg 是否需要结果消息
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：CommandResult
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static CommandResult execCmd(String command, boolean isRoot, boolean isNeedResultMsg) {
        return execCmd(new String[]{command}, isRoot, isNeedResultMsg);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：是否是在 root 下执行命令
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：commands        命令链表
     * ║ 参数：isRoot          是否需要 root 权限执行
     * ║ 参数：isNeedResultMsg 是否需要结果消息
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：CommandResult
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static CommandResult execCmd(List<String> commands, boolean isRoot, boolean isNeedResultMsg) {
        return execCmd(commands == null ? null : commands.toArray(new String[]{}), isRoot, isNeedResultMsg);
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：是否是在 root 下执行命令
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 参数：commands        命令数组
     * ║ 参数：isRoot          是否需要 root 权限执行
     * ║ 参数：isNeedResultMsg 是否需要结果消息
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：CommandResult
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static CommandResult execCmd(String[] commands, boolean isRoot, boolean isNeedResultMsg) {
        int result = -1;
        if (commands == null || commands.length == 0) {
            return new CommandResult(result, null, null);
        }
        Process process = null;
        BufferedReader successResult = null;
        BufferedReader errorResult = null;
        StringBuilder successMsg = null;
        StringBuilder errorMsg = null;
        DataOutputStream os = null;
        try {
            process = Runtime.getRuntime().exec(isRoot ? "su" : "sh");
            os = new DataOutputStream(process.getOutputStream());
            for (String command : commands) {
                if (command == null) continue;
                os.write(command.getBytes());
                os.writeBytes("\n");
                os.flush();
            }
            os.writeBytes("exit\n");
            os.flush();
            result = process.waitFor();
            if (isNeedResultMsg) {
                successMsg = new StringBuilder();
                errorMsg = new StringBuilder();
                successResult = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
                errorResult = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));
                String s;
                while ((s = successResult.readLine()) != null) {
                    successMsg.append(s);
                }
                while ((s = errorResult.readLine()) != null) {
                    errorMsg.append(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseUtils.closeIO(os, successResult, errorResult);
            if (process != null) {
                process.destroy();
            }
        }
        return new CommandResult(
                result,
                successMsg == null ? null : successMsg.toString(),
                errorMsg == null ? null : errorMsg.toString()
        );
    }

    /**
     * ╔════════════════════════════════════════════════════════════════════════════════════════════
     * ║ 名称：返回的命令结果实体类
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 字段：result       结果码
     * ║ 字段：successMsg   成功信息
     * ║ 字段：errorMsg     错误信息
     * ╟────────────────────────────────────────────────────────────────────────────────────────────
     * ║ 返回：CommandResult
     * ╚════════════════════════════════════════════════════════════════════════════════════════════
     */
    public static class CommandResult {

        public int result;
        public String successMsg;
        public String errorMsg;

        public CommandResult(int result, String successMsg, String errorMsg) {
            this.result = result;
            this.successMsg = successMsg;
            this.errorMsg = errorMsg;
        }
    }

}