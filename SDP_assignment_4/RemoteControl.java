package SDP_assignment_4;

public class RemoteControl {
    public interface Command {
        void execute();
        void undo();
    }
    public class TurnTVOnCommand implements Command {
        private TV tv;

        public TurnTVOnCommand(TV tv) {
            this.tv = tv;
        }

        @Override
        public void execute() {
            tv.on();
        }

        @Override
        public void undo() {
            tv.off();
        }
    }

    public class TurnTVOffCommand implements Command {
        private TV tv;

        public TurnTVOffCommand(TV tv) {
            this.tv = tv;
        }

        @Override
        public void execute() {
            tv.off();
        }

        @Override
        public void undo() {
            tv.on();
        }
    }

    public class SetStereoVolumeCommand implements Command {
        private Stereo stereo;
        private int volume;

        public SetStereoVolumeCommand(Stereo stereo, int volume) {
            this.stereo = stereo;
            this.volume = volume;
        }

        @Override
        public void execute() {
            stereo.setVolume(volume);
        }

        @Override
        public void undo() {
            stereo.setVolume(0);
        }
    }
    public class DimLightsCommand implements Command {
        private Light light;
        private int level;

        public DimLightsCommand(Light light, int level) {
            this.light = light;
            this.level = level;
        }

        @Override
        public void execute() {
            light.dim(level);
        }

        @Override
        public void undo() {
            light.dim(100);
        }
    }
    public class TV {
        public void on() {
            System.out.println("The TV is ON.");
        }

        public void off() {
            System.out.println("The TV is OFF.");
        }
    }
    public class Stereo {
        private int volume;

        public void on() {
            System.out.println("Stereo is ON.");
        }

        public void off() {
            System.out.println("Stereo is OFF.");
        }

        public void setVolume(int volume) {
            this.volume = volume;
            System.out.println("Stereo volume set to " + this.volume);
        }
    }
    public class Light {
        public void on() {
            System.out.println("Lights are ON.");
        }

        public void off() {
            System.out.println("Lights are OFF.");
        }

        public void dim(int level) {
            System.out.println("Lights dimmed to " + level + "%.");
        }
    }
    public class RemoteControler {
        private Command[] onCommands;
        private Command[] offCommands;
        private Command undoCommand;

        public RemoteControler() {
            onCommands = new Command[7];
            offCommands = new Command[7];

            Command noCommand = new NoCommand();
            for (int i = 0; i < 7; i++) {
                onCommands[i] = noCommand;
                offCommands[i] = noCommand;
            }
            undoCommand = noCommand;
        }

        public void setCommand(int slot, Command onCommand, Command offCommand) {
            onCommands[slot] = onCommand;
            offCommands[slot] = offCommand;
        }

        public void pressOnButton(int slot) {
            onCommands[slot].execute();
            undoCommand = onCommands[slot];
        }

        public void pressOffButton(int slot) {
            offCommands[slot].execute();
            undoCommand = offCommands[slot];
        }

        public void pressUndoButton() {
            undoCommand.undo();
        }
    }
    class NoCommand implements Command {
        @Override
        public void execute() {
            System.out.println("No command assigned to this slot.");
        }

        @Override
        public void undo() {
            System.out.println("No command to undo.");
        }
    }
}
