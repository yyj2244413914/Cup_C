//使用 Java 的 Scanner 类来获取用户输入。
//使用Java的time包来检查身份证号第 7-14 位是否为合法的出生日期。
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class IDcardcheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入 18 位身份证号，输入完成后按回车键：");
        String input = scanner.nextLine();
        /*使用 try-catch 语句依次分析：
        1、身份证号是否满足十八位，若满足，则存储在字符数组中，否则就会抛出异常版块。
        2、前十七位是否都为数字，若满足，则存储在数组中并打印，否则就会抛出异常版块。
        3.内嵌if-else语句检验身份证号第 7-14 位是否为合法的出生日期，若不合法，则用return语句结束主程序。
        4.检验校验码方法同上，通过if-else语句以及布尔类型原理执行。*/ 
        try {
            // 检测身份证号是否满足 18 位.
            char[] charArray = saveToCharArray(input);
            System.out.println("成功将输入的身份证号保存到字符数组中，字符数组内容如下：");
            for (char c : charArray) {
                System.out.print(c + " ");
            }
            System.out.println();
            // 将前十七位以数组形式保存。
            int[] numbers = new int[17];
            try {
                for (int i = 0; i < 17; i++) {
                numbers[i] = Character.getNumericValue(charArray[i]);
            }
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("身份证号前 17 位必须全部为数字。");
        }
        //打印前十七位。
            System.out.println("身份证号前 17 位保存为 int 数组，数组内容如下：");
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();
            // 检验身份证号第 7-14 位是否为合法的出生日期。
            if (checkBirthday(input)) {
                System.out.println("身份证号第 7-14 位对应的出生日期合法。");
            } else {
                throw new IllegalArgumentException("身份证号第 7-14 位对应的出生日期不合法。");
            }
            // 检验身份证号第 18 位是否为合法的校验码
            if (check(checkcheck(numbers), charArray)) {
                System.out.println("身份证第十八位校验码合法。");
            } else {
                throw new IllegalArgumentException("身份证第十八位校验码不合法。");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // 关闭 Scanner，释放系统资源。
        scanner.close();
    }

    // 定义一个方法，将输入的身份证号转换为字符数组
    public static char[] saveToCharArray(String input) {
        // 检查输入是否为 18 位
        if (input.length() != 18) {
            throw new IllegalArgumentException("输入必须是 18 位。");
        }
        // 将身份证号转换为字符数组
        return input.toCharArray();
    }

    // 检验身份证号第 7-14 位是否为合法的出生日期
    public static boolean checkBirthday(String input) {
        try {
            // 提取身份证号中的出生日期部分（第 6 - 14 位）
            String birthDateStr = input.substring(6, 14);
            // 定义日期格式
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            // 尝试将字符串解析为日期
            LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            // 解析失败，说明日期不合法
            return false;
        }
    }
    // 计算身份证号第 18 位。
    public static int checkcheck(int[] input) {
        return ((input[0] *7 + input[1] * 9 + input[2] * 10 + input[3] * 5 + input[4] * 8 + input[5] * 4 + input[6] * 2 + input[7] * 1 + input[8] * 6 + input[9] * 3 + input[10] * 7 + input[11] * 9 + input[12] * 10 + input[13] * 5 + input[14] * 8 + input[15] * 4 + input[16] * 2)%11);
    }
    //定义方法检验身份证号第 18 位是否为合法的校验码
    //先定义两个数组，其中一个数组是余数，另一个数组是校验码。
    //遍历余数数组，找到与计算出的余数相等的元素的下标。
    //然后将余数与校验码进行比较，如果相同，则校验码合法。
    public static boolean check(int input, char[] IDcode) {
        String[] checkcoderemainder = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] checkcode =          {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
        int p=0;
        for (p = 0; p < 11; p++) {
            if (checkcoderemainder[p].equals(String.valueOf(input)))
            break;
            }
        if (checkcode[p].equals(String.valueOf(IDcode[17]))) {
            return true; 
        }
        else {
            return false; 
        }
    }

}
