package SDP_assignment_4;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        strategy();
        observer();
        command();
        state();
        chain_of_responsibility();
        mediator();
        memento();
        visitor();
        template();
        iterator();
    }
    public static void strategy(){
        PaymentSystem.ShoppingCart cart = new PaymentSystem().new ShoppingCart();
        cart.setPaymentStrategy(new PaymentSystem().new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(100.50);

        cart.setPaymentStrategy(new PaymentSystem().new PayPalPayment("Dasha@gmail.com"));
        cart.checkout(148.80);

        cart.setPaymentStrategy(new PaymentSystem().new CryptoPayment("1A2b3C4d5E6F7G8H9I0J"));
        cart.checkout(100.00);
        System.out.println("-------------------------------------------");
    }
    public static void observer(){
        WeatherMonitoring.WeatherStation weatherStation = new WeatherMonitoring().new WeatherStation();
        WeatherMonitoring.CurrentConditionsDisplay currentDisplay = new WeatherMonitoring().new CurrentConditionsDisplay();
        WeatherMonitoring.StatisticsDisplay statisticsDisplay = new WeatherMonitoring().new StatisticsDisplay();
        WeatherMonitoring.ForecastDisplay forecastDisplay = new WeatherMonitoring().new ForecastDisplay();

        weatherStation.addObserver(currentDisplay);
        weatherStation.addObserver(statisticsDisplay);
        weatherStation.addObserver(forecastDisplay);

        weatherStation.setWeatherData(25.5f, 65.0f, 30.4f);
        weatherStation.setWeatherData(28.0f, 70.0f, 29.2f);
        System.out.println("-------------------------------------------");
    }
    public static void command() {
        RemoteControl.RemoteControler remoteControler = new RemoteControl().new RemoteControler();
        RemoteControl.TV tv = new RemoteControl().new TV();
        RemoteControl.Stereo stereo = new RemoteControl().new Stereo();
        RemoteControl.Light light = new RemoteControl().new Light();

        RemoteControl.Command tvOn = new RemoteControl().new TurnTVOnCommand(tv);
        RemoteControl.Command tvOff =  new RemoteControl().new TurnTVOffCommand(tv);
        RemoteControl.Command stereoVolumeUp = new RemoteControl().new SetStereoVolumeCommand(stereo, 20);
        RemoteControl.Command stereoVolumeDown = new RemoteControl().new SetStereoVolumeCommand(stereo, 0);
        RemoteControl.Command lightsDim = new RemoteControl().new DimLightsCommand(light, 30);
        RemoteControl.Command lightsBright = new RemoteControl().new DimLightsCommand(light, 100);

        remoteControler.setCommand(0, tvOn, tvOff);
        remoteControler.setCommand(1, stereoVolumeUp, stereoVolumeDown);
        remoteControler.setCommand(2, lightsDim, lightsBright);

        System.out.println("--- Pressing TV ON button ---");
        remoteControler.pressOnButton(0);

        System.out.println("--- Pressing TV OFF button ---");
        remoteControler.pressOffButton(0);

        System.out.println("--- Pressing UNDO button ---");
        remoteControler.pressUndoButton();

        System.out.println("--- Pressing Stereo Volume UP button ---");
        remoteControler.pressOnButton(1);

        System.out.println("--- Pressing Lights Dim button ---");
        remoteControler.pressOnButton(2);

        System.out.println("--- Pressing UNDO button ---");
        remoteControler.pressUndoButton();
        System.out.println("-------------------------------------------");
    }
    public static void state(){
        OrderProcessing.Order order = new OrderProcessing().new Order();
        order.shipOrder();
        order.payOrder();
        order.cancelOrder();
        order.shipOrder();
        order.deliverOrder();
        order.cancelOrder();
        System.out.println("-------------------------------------------");
    }
    public static void chain_of_responsibility(){
        ExpenseApproval.Approver approvalChain = new ExpenseApproval().new ApprovalChain().getApprovalChain();
        ExpenseApproval.ExpenseRequest smallExpense = new ExpenseApproval().new ExpenseRequest(500, "Office supplies");
        ExpenseApproval.ExpenseRequest mediumExpense = new ExpenseApproval().new ExpenseRequest(2000, "Team Outing");
        ExpenseApproval.ExpenseRequest largeExpense = new ExpenseApproval().new ExpenseRequest(7000, "New Servers");
        ExpenseApproval.ExpenseRequest hugeExpense = new ExpenseApproval().new ExpenseRequest(15000, "Company-wide Event");

        System.out.println("Processing expense request for Office Supplies:");
        approvalChain.approveExpense(smallExpense);
        System.out.println("\nProcessing expense request for Team Outing:");
        approvalChain.approveExpense(mediumExpense);
        System.out.println("\nProcessing expense request for New Servers:");
        approvalChain.approveExpense(largeExpense);
        System.out.println("\nProcessing expense request for Company-wide Event:");
        approvalChain.approveExpense(hugeExpense);
        System.out.println("-------------------------------------------");
    }
    public static void mediator(){
        ChatRoomAPP.ChatRoom chatRoom = new ChatRoomAPP().new ChatRoom();

        ChatRoomAPP.User user1 = new ChatRoomAPP().new RegularUser("Arsen", chatRoom);
        ChatRoomAPP.User user2 = new ChatRoomAPP().new RegularUser("Daria", chatRoom);
        ChatRoomAPP.User user3 = new ChatRoomAPP().new PremiumUser("Emilia", chatRoom);
        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        user1.sendMessage("Hello world!");
        user2.sendMessage("Hello!");
        user3.sendMessage("How are you, guys?");
        System.out.println("-------------------------------------------");
    }
    public static void memento(){
        DocumentVersionControl.Document document = new DocumentVersionControl().new Document();
        DocumentVersionControl.VersionControl versionControl = new DocumentVersionControl().new VersionControl();
        document.editContent("First draft of the document.");
        versionControl.saveVersion(document, "Version 1.0");

        document.editContent("Second draft of the document.");
        versionControl.saveVersion(document, "Version 2.0");

        versionControl.listVersions();
        versionControl.restoreVersion(document, 0);
        System.out.println("Current document content: " + document.getContent());
        System.out.println("-------------------------------------------");
    }
    public static void visitor(){
        ShapeArea.Drawing drawing = new ShapeArea().new Drawing();
        drawing.addShape(new ShapeArea().new Circle(5));
        drawing.addShape(new ShapeArea().new Rectangle(4, 6));
        drawing.addShape(new ShapeArea().new Triangle(3, 4));

        drawing.calculateAreas();
        System.out.println("-------------------------------------------");
    }
    public static void template(){
        ReportGeneration.ReportGenerator pdfGenerator = new ReportGeneration().new PDFReportGenerator();
        ReportGeneration.ReportGenerator htmlGenerator = new ReportGeneration().new HTMLReportGenerator();
        ReportGeneration.ReportGenerator textGenerator = new ReportGeneration().new PlainTextReportGenerator();

        ReportGeneration.ReportingSystem pdfSystem = new ReportGeneration().new ReportingSystem(pdfGenerator);
        ReportGeneration.ReportingSystem htmlSystem = new ReportGeneration().new ReportingSystem(htmlGenerator);
        ReportGeneration.ReportingSystem textSystem = new ReportGeneration().new ReportingSystem(textGenerator);

        System.out.println("PDF report:\n" + pdfSystem.createReport());
        System.out.println("HTML report:\n" + htmlSystem.createReport());
        System.out.println("Text report:\n" + textSystem.createReport());
        System.out.println("-------------------------------------------");
    }
    public static void iterator(){
        PlaylistManagement.Playlist playlist = new PlaylistManagement().new Playlist();
        playlist.addSong(new PlaylistManagement().new Song("Prey", "The Neighbourhood", "Rock"));
        playlist.addSong(new PlaylistManagement().new Song("Young and Beautiful", "Lana del Rey", "Pop"));
        playlist.addSong(new PlaylistManagement().new Song("One of the girls", "The Weeknd", "Pop"));

        System.out.println("Sequential Playlist:");
        Iterator<PlaylistManagement.Song> sequentialIterator = playlist.createSequentialIterator();
        while (sequentialIterator.hasNext()) {
            PlaylistManagement.Song song = sequentialIterator.next();
            System.out.println(song.getTitle() + " by " + song.getArtist());
        }
        System.out.println("\nShuffled Playlist:");
        Iterator<PlaylistManagement.Song> shuffleIterator = playlist.createShuffleIterator();
        while (shuffleIterator.hasNext()) {
            PlaylistManagement.Song song = shuffleIterator.next();
            System.out.println(song.getTitle() + " by " + song.getArtist());
        }
        System.out.println("\nRock Songs:");
        Iterator<PlaylistManagement.Song> genreFilterIterator = playlist.createGenreFilterIterator("Rock");
        while (genreFilterIterator.hasNext()) {
            PlaylistManagement.Song song = genreFilterIterator.next();
            System.out.println(song.getTitle() + " by " + song.getArtist());
        }
    }
}
