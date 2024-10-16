package SDP_assignment_3;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class CharacterRendering {
    public static class Character {

        private char value;    // character itself
        private String font;
        private int size;


        public Character(char value, String font, int size) {
            this.value = value;
            this.font = font;
            this.size = size;
        }


        public void render(int x, int y) {
            System.out.println("Rendering character '" + value + "' at position (" + x + ", " + y + ") with font: "
                    + font + ", size: " + size);
        }
    }

    public class CharacterFactory {

        private HashMap<String, Character> characterMap = new HashMap<>();


        public Character getCharacter(char value, String font, int size) {
            String key = value + "-" + font + "-" + size;
            Character character = characterMap.get(key);


            if (character == null) {
                character = new Character(value, font, size);
                characterMap.put(key, character);
            }

            return character;
        }
    }

    public class TextEditor {
        private CharacterFactory characterFactory;
        private List<TextCharacter> textCharacters = new ArrayList<>();

        public TextEditor(CharacterFactory factory) {
            this.characterFactory = factory;
        }


        private class TextCharacter {
            Character character;
            int x;
            int y;

            public TextCharacter(Character character, int x, int y) {
                this.character = character;
                this.x = x;
                this.y = y;
            }


            public void render() {
                character.render(x, y);
            }
        }

        public void insertCharacter(char value, String font, int size, int x, int y) {
            Character character = characterFactory.getCharacter(value, font, size);
            textCharacters.add(new TextCharacter(character, x, y));
        }

        public void renderDocument() {
            for (TextCharacter textCharacter : textCharacters) {
                textCharacter.render();
            }
        }
    }
}
