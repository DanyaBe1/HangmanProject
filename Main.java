import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class Main {
    public static String dict[] = {"ПЕЧЕНЬ", "ФИЛЕ", "НОГА", "СЕРДЦЕ", "КРЫЛО"};
    public static ArrayList<String> mistakeLet = new ArrayList<String>();
    private static String word;
    private static int mistakesCount;
    private static String hiddenWord;

    public static void main(String[] args) {
        while (true){
            startValues();
            boolean start = yesOrNot();
            if (start){
                startGame();
                while (mistakesCount > 0) {
                    if (hiddenWord.equals(word)) {
                        System.out.println("Вы выиграли, загаданное слово: " + hiddenWord);
                        break;
                    }
                    gameProcess();
                }
            }
            else{
                System.out.println("Ну ладно");
                return;
            }
                if (mistakesCount <= 0) {
                    System.out.println("Вы не отгадали слово :(");
                    System.out.println("Загаданное слово: " + word);
                }

        }

    }

    public static void startValues(){
        Random random = new Random();
        int randomWord = random.nextInt(5);
        word = dict[randomWord];
        mistakesCount = word.length();
        hiddenWord = "*".repeat(word.length());
    }
    public static void gameProcess(){
        Scanner lt = new Scanner(System.in);
        String letter = lt.nextLine();
        if (letterCheck(letter)){

            System.out.println("Вы отгадали букву!");
            hiddenWordTransformation(letter);
        }else{
            if (mistakeLet.contains(letter) == false){
                mistakesCount--;
                mistakeLet.add(letter);
            }
            System.out.println("Не угадал!");
            System.out.println("Оставшееся количество ошибок: " + mistakesCount);
            switch (mistakesCount){
                case 4:
                    System.out.println(HangmanASCII.first);
                    break;
                case 3:
                    System.out.println(HangmanASCII.second);
                    break;
                case 2:
                    System.out.println(HangmanASCII.third);
                    break;
                case 1:
                    System.out.println(HangmanASCII.fourth);
                    break;
                case 0:
                    System.out.println(HangmanASCII.fifth);
                    break;
                default:
                    break;
            }
        }
    }

    public static void startGame(){
        System.out.println("Доступное количество ошибок: " + mistakesCount);
        System.out.println("Ваше слово: " + hiddenWord);
        System.out.println("Отгадайте букву");
    }

    public static boolean letterCheck(String l){
        return word.contains(l.toUpperCase());

    }

    public static void hiddenWordTransformation(String l){
        l = l.toUpperCase();
        char letter = l.charAt(0);
        StringBuilder sb = new StringBuilder(hiddenWord);
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == letter){
                sb.setCharAt(i, letter);
            }
        }
        hiddenWord = sb.toString();
        System.out.println(hiddenWord);
    }
    public static boolean yesOrNot(){
        Scanner in = new Scanner(System.in);
        System.out.println("Начать игру?");
        System.out.println("[Д]а или [Н]ет");
        String ans = in.nextLine();
        if (ans.equalsIgnoreCase("Д")){
            return true;
        }else {
            return false;
        }

    }

}