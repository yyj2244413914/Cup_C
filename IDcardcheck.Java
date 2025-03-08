/*题目 1：身份证号码验证
身份证号码的验证规则主要包括以下几个方面：
1.号码长度
18 位身份证号码由 17 位数字本体码和 1 位校验码组成。
2.数字编码规则
（
1）地址码（前 6 位）
第 1、2 位表示省级行政区，如 11 表示北京市，61 表示陕西省。
第 3、4 位表示地级行政区，如 01 表示西安市。
第 5、6 位表示县级行政区，如 02 表示新城区。
（
2）出生日期码（第 7-14 位）
表示持证人出生的年、月、日，其中年用 4 位数字表示，月、日各用 2 位数字表示，如
19900101 表示 1990 年 1 月 1 日出生。
（
3）顺序码（第 15-17 位）
对同年、同月、同日出生的人员编定的顺序号。其中第 17 位奇数分给男性，偶数分给女性。
（
4）校验码（第 18 位）
是根据前面 17 位数字码，按照 ISO 7064:1983.MOD 11-2 校验码计算出来的检验码。计算方法
如下：
将身份证号码前 17 位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7、9、10、
5、8、4、2、1、6、3、7、9、10、5、8、4、2。将这 17 位数字和系数相乘的结果相加。用加出来
和除以 11，看余数是多少。余数只可能有 0、1、2、3、4、5、6、7、8、9、10 这 11 个数字。其分
别对应的最后一位身份证的号码为 1、0、X、9、8、7、6、5、4、3、2。
编写一个程序，通过命令行参数方式输入 1 个 18 位的身份证号码，输出该身份证号码是
否是正确的号码。
注意：
1. 18 位身份证号码并不全是数字；
2. 18 位身份证号码如果全部是数字的话，其大小已经使得数字的表示范围超过了
int 类型能够
表示的大小了；
3. 18 位身份证号码的验证除了最后一位的校验之外，还有出生年月日合法性的校验，那么就需
要在真正执行计算之前对用户输入的参数合法性进行考虑。如果程序的健壮性足够好，就必须
能处理这些不合法的输入。（地区编码的合法性不用检验）*/


//使用 Java 的 Scanner 类来获取用户输入。
//使用Java的time包来检查身份证号第 7-14 位是否为合法的出生日期。
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class IDcardcheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入 18 位身份证号，输入完成后按回车键：");
        String input = scanner.nextLine();
        // 使用 try-catch 语句分析身份证号是否满足 18 位.
        try {
            char[] charArray = saveToCharArray(input);
            System.out.println("成功将输入的身份证号保存到字符数组中，字符数组内容如下：");
            for (char c : charArray) {
                System.out.print(c + " ");
            }
            System.out.println();
            // 将前十七位以数组形式保存。
            int[] numbers = new int[17];
            for (int i = 0; i < 17; i++) {
                numbers[i] = Character.getNumericValue(charArray[i]);
            }
            System.out.println("身份证号前 17 位保存为 int 数组，数组内容如下：");
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();
            // 检验身份证号第 7-14 位是否为合法的出生日期
            if (checkBirthday(input)) {
                System.out.println("身份证号第 7-14 位对应的出生日期合法。");
            } else {
                System.out.println("身份证号第 7-14 位对应的出生日期不合法。");
            }
            // 检验身份证号第 18 位是否为合法的校验码
            //先定义两个数组，其中一个数组是余数，另一个数组是校验码。
            //遍历余数数组，找到与计算出的余数相等的元素的下标。
            //然后将余数与校验码进行比较，如果相同，则校验码合法。
            String[] checkcoderemainder = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            String[] checkcode =          {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
            for (int i = 0; i < 11; i++) {
                if (checkcoderemainder[i].equals(String.valueOf(checkcheck(numbers))) && checkcode[i].equals(String.valueOf(charArray[17]))) {
                    System.out.println("身份证号第 18 位对应的校验码合法。");
                } 
                else {
                    System.out.println("身份证号第 18 位对应的校验码不合法。");
                }
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
}
