package SDP_assignment_3;
import java.util.ArrayList;
import java.util.List;

public class MenuSystem {
    abstract class MenuComponent {
        public String getName(){
            throw new UnsupportedOperationException();
        };
        public String getDescription() {
            throw new UnsupportedOperationException();
        }
        public double getPrice(){
            throw new UnsupportedOperationException();
        }
        public void print(){
            throw new UnsupportedOperationException();
        }
    }
    class MenuItem extends MenuComponent {
        private String name;
        private String description;
        private double price;

        public MenuItem(String name, String description, double price){
            this.name = name;
            this.description = description;
            this.price = price;
        }
        @Override
        public String getName(){
            return name;
        }
        public String getDescription(){
            return description;
        }
        public double getPrice(){
            return price;
        }

        @Override
        public void print() {
            System.out.printf("Item: %s\nDescription: %s\nPrice: %.2f\n", getName(), getDescription(), getPrice());
        }
    }
    class Menu extends MenuComponent {
        private String name;
        private String description;
        private List<MenuComponent> menuComponents = new ArrayList<>();

        public Menu(String name, String description){
            this.name = name;
            this.description = description;
        }
        public void add(MenuComponent menuComponent){
            menuComponents.add(menuComponent);
        }
        public void remove(MenuComponent menuComponent){
            menuComponents.remove(menuComponent);
        }
        @Override
        public String getName(){
            return name;
        }
        @Override
        public String getDescription(){
            return description;
        }
        public void print(){
            System.out.printf("Item: %s\nDescription: %s\n", getName(), getDescription());
            System.out.println("---------------------");
            for(MenuComponent component : menuComponents){
                component.print();
            }
        }
    }
}
