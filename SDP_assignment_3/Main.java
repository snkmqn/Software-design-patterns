package SDP_assignment_3;

public class Main {
    public static void main(String[] args) {
        adapter(args);
        bridge(args);
        composite(args);
        decorator(args);
        facade(args);
        flyweight(args);
        proxy(args);
    }
    public static void adapter(String[] args){
        AudioPlayer.MusicPlayerApp player = new AudioPlayer().new MusicPlayerApp();
        AudioPlayer.AdvancedAudioPlayer advancedAudioPlayer = new AudioPlayer().new AdvancedAudioPlayer();
        player.play("mp3", "song1.mp3");
        advancedAudioPlayer.playWAV("song2.wav");
        advancedAudioPlayer.playAAC("song3.aac");
        player.play("flac", "song4.flac");
        System.out.println("----------------------------");

    }
    public static void bridge(String[] args){
        RemoteControl.Device tv = new RemoteControl().new TVDevice();
        RemoteControl.Device dvd = new RemoteControl().new DVDDevice();
        RemoteControl.Device soundSystem = new RemoteControl().new SoundSystemDevice();

        RemoteControl.BasicRemote basicRemoteForTV = new RemoteControl().new BasicRemote(tv);
        basicRemoteForTV.powerButton();
        basicRemoteForTV.channelUp();
        basicRemoteForTV.volumeUp();


        RemoteControl.AdvancedRemote advancedRemoteForDVD = new RemoteControl().new AdvancedRemote(dvd);
        advancedRemoteForDVD.powerButton();
        advancedRemoteForDVD.volumeUp();
        advancedRemoteForDVD.volumeDown();
        ((RemoteControl.AdvancedRemote) advancedRemoteForDVD).setSpecificChannel(5);

        RemoteControl.AdvancedRemote advancedRemoteForSoundSystem = new RemoteControl(). new AdvancedRemote(soundSystem);
        advancedRemoteForSoundSystem.powerButton();
        advancedRemoteForSoundSystem.volumeUp();
        advancedRemoteForSoundSystem.powerOff();
        System.out.println("----------------------------");
    }
    public static void composite(String[] args) {
        MenuSystem.MenuComponent appetizer1 = new MenuSystem().new MenuItem("Bruschetta", "Grilled bread topped with tomatoes and basil", 5.99);
        MenuSystem.MenuComponent appetizer2 = new MenuSystem().new MenuItem("Stuffed Mushrooms", "Mushrooms filled with cheese and herbs", 6.99);
        MenuSystem.MenuComponent dessert2 = new MenuSystem().new MenuItem("Tiramisu", "Coffee-flavored Italian dessert", 6.99);

        MenuSystem.MenuComponent appetizerMenu = new MenuSystem().new Menu("Appetizers", "Start your meal with a delicious appetizer");
        MenuSystem.MenuComponent dessertMenu = new MenuSystem().new Menu("Desserts", "Sweet treats to end your meal");

        ((MenuSystem.Menu) appetizerMenu).add(appetizer1);
        ((MenuSystem.Menu) appetizerMenu).add(appetizer2);
        ((MenuSystem.Menu) dessertMenu).add(dessert2);

        MenuSystem.MenuComponent completeMenu = new MenuSystem().new Menu("Complete Menu", "A complete dining experience");
        ((MenuSystem.Menu) completeMenu).add(appetizerMenu);
        ((MenuSystem.Menu) completeMenu).add(dessertMenu);
        ((MenuSystem.Menu) completeMenu).print();
        System.out.println("----------------------------");
    }
    public static void decorator(String[] args){
        PizzaOrdering.Pizza myPizza = new PizzaOrdering().new MargheritaPizza();
        System.out.println(myPizza.getDescription() + " Cost: $" + myPizza.getCost());
        myPizza = new PizzaOrdering().new CheeseTopping(myPizza);
        myPizza = new PizzaOrdering().new PepperoniTopping(myPizza);
        System.out.println(myPizza.getDescription() + " Cost: $" + myPizza.getCost());

        PizzaOrdering.Pizza veggiePizza = new PizzaOrdering().new VegetarianPizza();
        System.out.println(veggiePizza.getDescription() + " Cost: $" + veggiePizza.getCost());
        veggiePizza = new PizzaOrdering().new MushroomTopping(veggiePizza);
        veggiePizza = new PizzaOrdering().new CheeseTopping(veggiePizza);
        System.out.println(veggiePizza.getDescription() + " Cost: $" + veggiePizza.getCost());
        System.out.println("----------------------------");
    }
    public static void facade(String[] args){
        SmartHome.SmartLights lights = new SmartHome.SmartLights();
        SmartHome.SmartThermostat thermostat = new SmartHome.SmartThermostat();
        SmartHome.SmartSecuritySystem securitySystem = new SmartHome.SmartSecuritySystem();
        SmartHome.SmartEntertainmentSystem entertainmentSystem = new SmartHome.SmartEntertainmentSystem();

        SmartHome.SmartHomeFacade smartHome = new SmartHome.SmartHomeFacade(lights, thermostat, securitySystem, entertainmentSystem);
        smartHome.arriveHome();
        smartHome.leaveHome();
        smartHome.movieMode();
        smartHome.nightMode();
        System.out.println("----------------------------");
    }
    public static void flyweight(String[] args) {

        CharacterRendering.CharacterFactory factory = new CharacterRendering().new CharacterFactory();
        CharacterRendering.TextEditor editor = new CharacterRendering().new TextEditor(factory);

        for (int i = 0; i < 2; i++) {
            editor.insertCharacter('H', "Arial", 12, i, 0);
            editor.insertCharacter('e', "Arial", 12, i + 1, 0);
            editor.insertCharacter('l', "Arial", 12, i + 2, 0);
            editor.insertCharacter('l', "Arial", 12, i + 3, 0);
            editor.insertCharacter('o', "Arial", 12, i + 4, 0);
            editor.insertCharacter(' ', "Arial", 12, i + 5, 0);
        }
        editor.renderDocument();
        System.out.println("----------------------------");
    }
    public static void proxy(String[] args){
        OnlineLearning.OnlineCourse course = new OnlineLearning.OnlineCourse();
        course.addLecture(new OnlineLearning().new ProxyVideoLecture("Introduction to Java"));
        course.addLecture(new OnlineLearning().new ProxyVideoLecture("Introduction to C#"));
        System.out.println("Course content:");
        course.showLecturesInfo();

        System.out.println("\nStudent starts watching the first lecture");
        course.playLecture(0);
        System.out.println("\nStudent starts watching the second lecture");
        course.playLecture(1);
        System.out.println("\nStudent watches the first lecture again:");
        course.playLecture(0);
    }
}
