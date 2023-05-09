import java.util.*;

public class Main {
    public static void main(String[] args) throws ScannerException {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String answer = calc(num);
        System.out.println(answer);
}

   public static String calc(String input)  throws ScannerException{
       String [] arif = input.split(" ");
       int number;
       String answer;


       // Проверим полученную строку на верно введенное выражение (символов не больше и не меньше)
       if (arif.length != 3) {
           throw new ScannerException("Введено неверное значение. Введите два числа для вычисления через пробел.");
       }

       // Поместим значения в каждую переменную для дальнейшей работы с ними
       String a = arif[0];
       String b = arif[1];
       String c = arif[2];
       String substring_ar = "12345678910";
       String substring_rim = "IIIIIIIVVVIVIIVIIIIXX";
       String operators = "+-*/";

       if (substring_ar.contains(a) && substring_ar.contains(c) && operators.contains(b)) {
           int one= Integer.parseInt(a);
           int two = Integer.parseInt(c);
           number = numbers(one, b, two);
           answer = Integer.toString(number);
       } else if (substring_rim.contains(a) && substring_rim.contains(c) && operators.contains(b)) {
           int one = Romish(a);
           int two = Romish(c);
           number = numbers(one, b, two);
           //answer = Integer.toString(number);
           answer = Arabian(number);
           if (number < 1) {
               throw new ScannerException("Нельзя выполнить операцию");
           }
       } else {throw new ScannerException("Введено неверное значение чисел.");
       }

   return answer;
   }

// Метод вычисления
    private static int numbers(int one, String b, int two) {
        int number = 0;
        if (b.contains("+")) {
            number = (one + two);
        } else {
            if (b.contains("-")) {
                number = (one - two);
            } else {
                if (b.contains("*")) {
                    number = (one * two);
                } else {
                    if (b.contains("/")) {
                        number = (one / two);
                    }
                }
            }
        }
        return number;
    }

// Метод для преобразования римских чисел в арабские
    private static int Romish(String num) throws ScannerException {
        switch (num) {
            case "I" -> {
                return 1;
            }
            case "II" -> {
                return 2;
            }
            case "III" -> {
                return 3;
            }
            case "IV" -> {
                return 4;
            }
            case "V" -> {
                return 5;
            }
            case "VI" -> {
                return 6;
            }
            case "VII" -> {
                return 7;
            }
            case "VIII" -> {
                return 8;
            }
            case "IX" -> {
                return 9;
            }
            case "X" -> {
                return 10;
            }
        }
        throw new ScannerException("Неверный диапазон римских чисел для вычисления");
    }
// Метод для преобразования арабского числа в римское
    private static String Arabian(int num) {
        String rom = null;
        int units = num %10;
        int ten = (num%100)/10;
        int hundred = (num%1000)/100;
        String o = null; //единицы
        switch (units) {
            case 1: o = "I";
                break;
            case 2: o = "II";
                break;
            case 3: o = "III";
                break;
            case 4: o = "IV";
                break;
            case 5: o = "V";
                break;
            case 6: o = "VI";
                break;
            case 7: o = "VII";
                break;
            case 8: o = "VIII";
                break;
            case 9: o = "IX";
                break;
        }
        String p = null; //десятки
        switch (ten) {
            case 1: p = "X";
                break;
            case 2: p = "XX";
                break;
            case 3: p = "XXX";
                break;
            case 4: p = "XL";
                break;
            case 5: p = "L";
                break;
            case 6: p = "LX";
                break;
            case 7: p = "LXX";
                break;
            case 8: p = "LXXX";
                break;
            case 9: p = "XC";
                break;
        }
        if (hundred == 1) {
            rom = "C";
        } else if (units == 0) {
            rom = p;
        } else if (ten == 0) {
            rom = o;
        } else{
            rom = p + o;
        }
        return rom;
    }

}