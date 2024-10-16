package SDP_assignment_3;

public class RemoteControl {
    public interface Device {
        void powerOn();
        void powerOff();
        void setChannel(int channel);
        void setVolume(int volume);
    }

    public class TVDevice implements Device {
        private boolean isOn = false;
        private int volume = 0;
        private int channel = 1;

        @Override
        public void powerOn() {
            isOn = true;
            System.out.println("TV is turned on.");
        }

        @Override
        public void powerOff() {
            isOn = false;
            System.out.println("TV is turned off.");
        }

        @Override
        public void setChannel(int channel) {
            this.channel = channel;
            System.out.println("TV channel set to " + channel);
        }

        @Override
        public void setVolume(int volume) {
            this.volume = volume;
            System.out.println("TV volume set to " + volume);
        }
    }

    public class DVDDevice implements Device {
        private boolean isOn = false;
        private int volume = 0;

        @Override
        public void powerOn() {
            isOn = true;
            System.out.println("DVD player is turned on.");
        }

        @Override
        public void powerOff() {
            isOn = false;
            System.out.println("DVD player is turned off.");
        }

        @Override
        public void setChannel(int channel) {
            System.out.println("DVD player does not support channel setting.");
        }

        @Override
        public void setVolume(int volume) {
            this.volume = volume;
            System.out.println("DVD player volume set to " + volume);
        }
    }

    public class SoundSystemDevice implements Device {
        private boolean isOn = false;
        private int volume = 0;

        @Override
        public void powerOn() {
            isOn = true;
            System.out.println("Sound system is turned on.");
        }

        @Override
        public void powerOff() {
            isOn = false;
            System.out.println("Sound system is turned off.");
        }

        @Override
        public void setChannel(int channel) {
            System.out.println("Sound system does not support channel setting.");
        }

        @Override
        public void setVolume(int volume) {
            this.volume = volume;
            System.out.println("Sound system volume set to " + volume);
        }
    }

    public abstract class RemoteControler {
        protected Device device;

        public RemoteControler(Device device) {
            this.device = device;
        }

        public abstract void powerButton();
        public abstract void volumeUp();
        public abstract void volumeDown();
        public abstract void channelUp();
        public abstract void channelDown();
    }

    public class BasicRemote extends RemoteControler {

        public BasicRemote(Device device) {
            super(device);
        }

        @Override
        public void powerButton() {
            System.out.println("Basic Remote: Power button pressed.");
            device.powerOn();
        }

        @Override
        public void volumeUp() {
            System.out.println("Basic Remote: Volume up button pressed.");
            device.setVolume(10);
        }

        @Override
        public void volumeDown() {
            System.out.println("Basic Remote: Volume down button pressed.");
            device.setVolume(5);
        }

        @Override
        public void channelUp() {
            System.out.println("Basic Remote: Channel up button pressed.");
            device.setChannel(2);
        }

        @Override
        public void channelDown() {
            System.out.println("Basic Remote: Channel down button pressed.");
            device.setChannel(1);
        }
    }

    public class AdvancedRemote extends RemoteControler {

        public AdvancedRemote(Device device) {
            super(device);
        }

        @Override
        public void powerButton() {
            System.out.println("Advanced Remote: Power button pressed.");
            device.powerOn();
        }

        @Override
        public void volumeUp() {
            System.out.println("Advanced Remote: Volume up button pressed.");
            device.setVolume(15);
        }

        @Override
        public void volumeDown() {
            System.out.println("Advanced Remote: Volume down button pressed.");
            device.setVolume(7);
        }

        @Override
        public void channelUp() {
            System.out.println("Advanced Remote: Channel up button pressed.");
            device.setChannel(3);
        }

        @Override
        public void channelDown() {
            System.out.println("Advanced Remote: Channel down button pressed.");
            device.setChannel(1);
        }

        public void setSpecificChannel(int channel) {
            System.out.println("Advanced Remote: Setting specific channel to " + channel);
            device.setChannel(channel);
        }
        public void powerOff() {
            System.out.println("Advanced Remote: Power off button pressed.");
            device.powerOff();
        }
    }
}
