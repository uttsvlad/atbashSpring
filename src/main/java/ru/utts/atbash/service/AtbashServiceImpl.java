package ru.utts.atbash.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AtbashServiceImpl implements AtbashService {
    private static final Map<Character, Integer> russianLetters = new HashMap<>() {
        {
            put('А', 1);
            put('Б', 2);
            put('В', 3);
            put('Г', 4);
            put('Д', 5);
            put('Е', 6);
            put('Ё', 7);
            put('Ж', 8);
            put('З', 9);
            put('И', 10);
            put('Й', 11);
            put('К', 12);
            put('Л', 13);
            put('М', 14);
            put('Н', 15);
            put('О', 16);
            put('П', 17);
            put('Р', 18);
            put('С', 19);
            put('Т', 20);
            put('У', 21);
            put('Ф', 22);
            put('Х', 23);
            put('Ц', 24);
            put('Ч', 25);
            put('Ш', 26);
            put('Щ', 27);
            put('Ъ', 28);
            put('Ы', 29);
            put('Ь', 30);
            put('Э', 31);
            put('Ю', 32);
            put('Я', 33);
        }
    };
    
    private static final int russianLettersCount = 33;
    
    private static final Map<Character, Integer> englishLetters = new HashMap<>() {
        {
            put('A', 1);
            put('B', 2);
            put('C', 3);
            put('D', 4);
            put('E', 5);
            put('F', 6);
            put('G', 7);
            put('H', 8);
            put('I', 9);
            put('J', 10);
            put('K', 11);
            put('L', 12);
            put('M', 13);
            put('N', 14);
            put('O', 15);
            put('P', 16);
            put('Q', 17);
            put('R', 18);
            put('S', 19);
            put('T', 20);
            put('U', 21);
            put('V', 22);
            put('W', 23);
            put('X', 24);
            put('Y', 25);
            put('Z', 26);
        }
    };
    
    private static final int englishLettersCount = 26;
    
    @Override
    public String encrypt(String message) {
        StringBuilder encoded = new StringBuilder();
        for (char oldChar : message.toCharArray()) {
            if (Character.isLetter(oldChar)) {
                char newChar;
                if ((oldChar >= 'a' && oldChar <= 'z') || (oldChar >= 'A' && oldChar <= 'Z')) {
                    newChar = englishLetters
                            .entrySet()
                            .stream()
                            .filter(entry -> ((englishLettersCount - englishLetters.get(Character.toUpperCase(oldChar))) + 1) == (entry.getValue()))
                            .map(Map.Entry::getKey).findAny().get();
                } else {
                    newChar = russianLetters
                            .entrySet()
                            .stream()
                            .filter(entry -> ((russianLettersCount - russianLetters.get(Character.toUpperCase(oldChar))) + 1) == (entry.getValue()))
                            .map(Map.Entry::getKey).findAny().get();
                }
                encoded.append(Character.isLowerCase(oldChar) ? Character.toLowerCase(newChar) : newChar);
            } else {
                encoded.append(oldChar);
            }
        }
        return encoded.toString();
    }
}
