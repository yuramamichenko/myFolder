import java.util.*;

public class Cypher {

    private static final char[] ALPHABET = {'а', 'б', 'в', ' ', 'г', 'д', 'е', ':', 'ё', 'ж', 'з',
            'и', 'й', '«', 'к', '\'', 'л', 'м', 'н', 'о', '.', 'п', '!', 'р', 'с', 'т', '?', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', '»', 'ы', 'ь', '"', 'э', ',', 'ю', 'я'};

    private Map<Character, Integer> charIntegerMap = new HashMap<>();

    public Cypher() {
        for (int i = 0; i < ALPHABET.length; i++) {
            charIntegerMap.put(ALPHABET[i], i);
        }
    }

    public List<String> encode(List<String> text, int key) {
        List<String> stringList = new ArrayList<>();
        StringBuilder stringBuilder;
        for (String string : text) {
            stringBuilder = new StringBuilder();
            char[] chars = string.toCharArray();
            for (char symbol : chars) {
                if (Character.isLetter(symbol)) {
                    if (Character.isUpperCase(symbol)) {
                        symbol = Character.toLowerCase(symbol);
                    }
                }
                int index = getIndexOfChar(symbol);

                if (index == -1) {
                    continue;
                }

                index += key;

                if (index >= ALPHABET.length) {
                    index -= ALPHABET.length;
                } else if (index < 0) {
                    index += ALPHABET.length;
                }
                stringBuilder.append(ALPHABET[index]);
            }
            stringList.add(stringBuilder.toString().trim());
        }
        return stringList;
    }

    public List<String> decode(List<String> text, int key) {
        return encode(text, key * -1);
    }

    public List<String> brutForce(List<String> text) {
        List<String> stringList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            for (String string : decode(text, i)) {
                if (string.contains(", ") & string.contains(". ")) {
                    stringList = decode(text, i);
                    break;
                }
            }
        }
        return stringList;
    }

    public int getIndexOfChar(char symbol) {
        try {
            return charIntegerMap.get(symbol);
        } catch (Exception e) {
            return -1;
        }
    }
}
