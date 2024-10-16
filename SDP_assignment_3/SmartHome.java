package SDP_assignment_3;

public class SmartHome {
    public static class SmartLights {
        public void turnOn() {
            System.out.println("Lights are ON");
        }

        public void turnOff() {
            System.out.println("Lights are OFF");
        }

        public void dim(int level) {
            System.out.println("Lights are dimmed to " + level + "%");
        }
    }
    public static class SmartThermostat {
        public void setTemperature(int temperature) {
            System.out.println("Thermostat set to " + temperature + "°C");
        }

        public void turnOff() {
            System.out.println("Thermostat is OFF");
        }
    }
    public static class SmartSecuritySystem {
        public void arm() {
            System.out.println("Security System is ARMED");
        }

        public void disarm() {
            System.out.println("Security System is DISARMED");
        }
    }

    public static class SmartEntertainmentSystem {
        public void turnOn() {
            System.out.println("Entertainment System is ON");
        }

        public void turnOff() {
            System.out.println("Entertainment System is OFF");
        }

        public void setMovieMode() {
            System.out.println("Entertainment System set to Movie Mode");
        }
    }
    public static class SmartHomeFacade {
        private SmartLights lights;
        private SmartThermostat thermostat;
        private SmartSecuritySystem securitySystem;
        private SmartEntertainmentSystem entertainmentSystem;

        public SmartHomeFacade(SmartLights lights, SmartThermostat thermostat,
                               SmartSecuritySystem securitySystem, SmartEntertainmentSystem entertainmentSystem) {
            this.lights = lights;
            this.thermostat = thermostat;
            this.securitySystem = securitySystem;
            this.entertainmentSystem = entertainmentSystem;
        }
        public void leaveHome() {
            System.out.println("\nLeaving home...");
            lights.turnOff();
            thermostat.turnOff();
            securitySystem.arm();
            entertainmentSystem.turnOff();
        }
        public void arriveHome() {
            System.out.println("\nArriving home...");
            lights.turnOn();
            thermostat.setTemperature(22);
            securitySystem.disarm();
            entertainmentSystem.turnOn();
        }
        public void nightMode() {
            System.out.println("\nActivating night mode...");
            lights.dim(10);
            thermostat.setTemperature(18);
            securitySystem.arm();
        }
        public void movieMode() {
            System.out.println("\nActivating movie mode...");
            lights.dim(30);
            thermostat.setTemperature(21);
            entertainmentSystem.setMovieMode();
        }
    }
}
