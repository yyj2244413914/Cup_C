/*题目3：长度n的子序列最大乘积 
从文件中输入一个数字序列字符串，计算给定的长度n的子序列中的最大乘积值。 
例如：如果输入“1027839564”，指定长度为 3 的最大子序列乘积值为 270（9*5*6）；指定长度
为5的最大子序列乘积值为7560（7*8*3*9*5）。 
备注： 
1. 数字序列字符串的最大长度maxLength的范围为：[1..1000]； 
2. n 的取值范围为[1..maxLength-1]； 
3. 程序要注意处理边界情况； 
4. 程序的输入数据必须从文件中读取。*/

//导入java.util.Scanner包以将输入存储在数组中。
//导入java.io.File包以对文件进行必要的操作。
//导入java.io.FileNotFoundException包以处理文件名错误或无法读取时的异常情况。
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maxlength {
    public static void main(String[] args) {
        //先在try-catch外部定义numbers和n变量。
        int[] numbers = null;
        int n = 0;
        /*主程序以try-catch为框架，以实现以下几个目的：
         1、检验文件名是否正确。
         2、检验字符串长度是否符合要求。
         3、检验n的取值是否正确。
         */
        try {
            // 从文件中读取输入
            //先从控制台输入文件名，并存储在字符串变量中。
            //再通过字符串变量读取对应文件里的内容。
            Scanner scannerfile = new Scanner(System.in);
            System.out.println("请输入文件名：");
            String filename = scannerfile.nextLine();
            scannerfile.close();
            File file = new File("filename");
            Scanner fileScanner = new Scanner(file);
            String input = fileScanner.nextLine();
            fileScanner.close();
            //自定义方法实现从string类型到int类型的转化。
            numbers = saveToIntArray(input);
            if (numbers.length < 1 || numbers.length > 1000) {
                throw new IllegalArgumentException("数字序列字符串的最大长度maxLength的范围为：[1..1000]");
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入指定长度n：");
            n = scanner.nextInt();
            scanner.close();

            if (n < 1 || n > numbers.length - 1) {
                throw new IllegalArgumentException("n 的取值范围为[1.." + (numbers.length - 1) + "]");
            }
        } catch (FileNotFoundException e) {
            System.out.println("未找到输入文件：" + e.getMessage());
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } 
        /*利用Stringbuilder方法对得到的结果（数组）做操作，包括：
          1、在每个数字之间添加“*”号。
          2、在最后一个数前添加“+”号。*/
        int[] maxProduct = findMaxProduct(numbers, n);
        StringBuilder productStr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            productStr.append(maxProduct[i]);
            if (i < n - 1) {
                productStr.append("*");
            }
        }
        productStr.append("=").append(maxProduct[n]);
        //打印完整的乘积形式结果。
        System.out.println("指定长度为" + n + "的最大子序列乘积值为：" + productStr.toString());
    }

    public static int[] saveToIntArray(String input) {
        int[] numbers = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("输入包含非数字字符");      //若出现非数字字符，该方法会返回抛出的异常从而被主程序后面的catch识别到。
            }
            numbers[i] = input.charAt(i) - '0';
        }
        return numbers;
    }
    //自定义方法找到最大乘积值及各个因子，并按先后顺序存储到返回的数组中。
    public static int[] findMaxProduct(int[] numbers, int n) {
        int maxProduct = 0;
        int startIndex = 0;
        for (int i = 0; i <= numbers.length - n; i++) {
            int currentProduct = 1;
            for (int j = 0; j < n; j++) {
                currentProduct *= numbers[i + j];
            }
            if (currentProduct > maxProduct) {
                maxProduct = currentProduct;
                startIndex = i;
            }
        }
        int[] result = new int[n + 1];
        for (int i = 0; i < n; i++) {
            result[i] = numbers[startIndex + i];
        }
        result[n] = maxProduct;
        return result;
    }
}
