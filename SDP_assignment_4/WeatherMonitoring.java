package SDP_assignment_4;
import java.util.ArrayList;
import java.util.List;

public class WeatherMonitoring {
    interface WeatherDisplay {
        void update(float temperature, float humidity, float pressure);
    }
    class WeatherStation {
        private List<WeatherDisplay> observers;
        private float temperature;
        private float humidity;
        private float pressure;

        public WeatherStation() {
            observers = new ArrayList<>();
        }

        public void addObserver(WeatherDisplay observer) {
            observers.add(observer);
        }

        public void removeObserver(WeatherDisplay observer) {
            observers.remove(observer);
        }

        public void notifyObservers() {
            for (WeatherDisplay observer : observers) {
                observer.update(temperature, humidity, pressure);
            }
        }

        public void setWeatherData(float temperature, float humidity, float pressure) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
            notifyObservers();
        }
    }
    class CurrentConditionsDisplay implements WeatherDisplay {
        private float temperature;
        private float humidity;

        @Override
        public void update(float temperature, float humidity, float pressure) {
            this.temperature = temperature;
            this.humidity = humidity;
            display();
        }

        public void display() {
            System.out.println("Current conditions: " + temperature + "°C and " + humidity + "% humidity");
        }
    }

    class StatisticsDisplay implements WeatherDisplay {
        private float maxTemp = 0.0f;
        private float minTemp = 100.0f;
        private float tempSum = 0.0f;
        private int numReadings;

        @Override
        public void update(float temperature, float humidity, float pressure) {
            tempSum += temperature;
            numReadings++;

            if (temperature > maxTemp) {
                maxTemp = temperature;
            }

            if (temperature < minTemp) {
                minTemp = temperature;
            }

            display();
        }

        public void display() {
            System.out.println("Avg/Max/Min temperature: " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
        }
    }
    class ForecastDisplay implements WeatherDisplay {
        private float currentPressure = 29.92f;
        private float lastPressure;

        @Override
        public void update(float temperature, float humidity, float pressure) {
            lastPressure = currentPressure;
            currentPressure = pressure;
            display();
        }

        public void display() {
            System.out.print("Forecast: ");
            if (currentPressure > lastPressure) {
                System.out.println("Improving weather on the way!");
            } else if (currentPressure == lastPressure) {
                System.out.println("More of the same");
            } else if (currentPressure < lastPressure) {
                System.out.println("Watch out for cooler, rainy weather");
            }
        }
    }
}
