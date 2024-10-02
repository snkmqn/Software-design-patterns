package SDP_assignment_1;

public class UIG {
    public interface Button {
        void paint();
    }

    public interface TextField {
        void render();
    }

    public static class DarkThemeButton implements Button {
        @Override
        public void paint() {
            System.out.println("Dark Theme Button painted.");
        }
    }

    public static class LightThemeButton implements Button {
        @Override
        public void paint() {
            System.out.println("Light Theme Button painted.");
        }
    }

    public static class DarkThemeTextField implements TextField {
        @Override
        public void render() {
            System.out.println("Dark Theme TextField rendered.");
        }
    }

    public static class LightThemeTextField implements TextField {
        @Override
        public void render() {
            System.out.println("Light Theme TextField rendered.");
        }
    }

    public interface UIFactory {
        Button createButton();
        TextField createTextField();
    }

    public static class DarkThemeFactory implements UIFactory {
        @Override
        public Button createButton() {
            return new DarkThemeButton();
        }

        @Override
        public TextField createTextField() {
            return new DarkThemeTextField();
        }
    }

    public static class LightThemeFactory implements UIFactory {
        @Override
        public Button createButton() {
            return new LightThemeButton();
        }

        @Override
        public TextField createTextField() {
            return new LightThemeTextField();
        }
    }
}
