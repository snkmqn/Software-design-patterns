package SDP_assignment_3;

public class PizzaOrdering {
    public interface Pizza{
        String getDescription();
        double getCost();
    }
    public class MargheritaPizza implements Pizza{
        @Override
        public String getDescription() {
            return "Margherita";
        }
        @Override
        public double getCost() {
            return 5.00;
        }
    }
    public class VegetarianPizza implements Pizza{
        @Override
        public String getDescription() {
            return "Vegetarian";
        }
        @Override
        public double getCost() {
            return 5.50;
        }
    }
    public abstract class ToppingDecorator implements Pizza{
        protected Pizza tempPizza;
        public ToppingDecorator(Pizza newPizza){
            this.tempPizza = newPizza;
        }
        @Override
        public String getDescription() {
            return tempPizza.getDescription();
        }

        @Override
        public double getCost() {
            return tempPizza.getCost();
        }
    }
    public class CheeseTopping extends ToppingDecorator {

        public CheeseTopping(Pizza newPizza) {
            super(newPizza);
        }

        @Override
        public String getDescription() {
            return tempPizza.getDescription() + ", Cheese";
        }

        @Override
        public double getCost() {
            return tempPizza.getCost() + 1.00;
        }
    }
    public class MushroomTopping extends ToppingDecorator {

        public MushroomTopping(Pizza newPizza) {
            super(newPizza);
        }

        @Override
        public String getDescription() {
            return tempPizza.getDescription() + ", Mushroom";
        }

        @Override
        public double getCost() {
            return tempPizza.getCost() + 0.75;
        }
    }
    public class PepperoniTopping extends ToppingDecorator {

        public PepperoniTopping(Pizza newPizza) {
            super(newPizza);
        }

        @Override
        public String getDescription() {
            return tempPizza.getDescription() + ", Pepperoni";
        }

        @Override
        public double getCost() {
            return tempPizza.getCost() + 1.50;
        }
    }
}
