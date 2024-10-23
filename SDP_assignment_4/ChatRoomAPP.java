package SDP_assignment_4;
import java.util.ArrayList;
import java.util.List;

public class ChatRoomAPP {
    interface ChatMediator {
        void sendMessage(String message, User user);
        void addUser(User user);
    }
    class ChatRoom implements ChatMediator {
        private List<User> users;

        public ChatRoom() {
            this.users = new ArrayList<>();
        }

        @Override
        public void addUser(User user) {
            this.users.add(user);
            System.out.println(user.getName() + " присоединился к чату.");
        }

        @Override
        public void sendMessage(String message, User sender) {
            for (User user : users) {
                if (user != sender) {
                    user.receiveMessage(message, sender);
                }
            }
        }
    }
    abstract class User {
        protected String name;
        protected ChatMediator mediator;

        public User(String name, ChatMediator mediator) {
            this.name = name;
            this.mediator = mediator;
        }

        public String getName() {
            return name;
        }

        public abstract void sendMessage(String message);
        public abstract void receiveMessage(String message, User sender);
    }
    class RegularUser extends User {
        public RegularUser(String name, ChatMediator mediator) {
            super(name, mediator);
        }

        @Override
        public void sendMessage(String message) {
            System.out.println(name + " (Regular) отправляет сообщение: " + message);
            mediator.sendMessage(message, this);
        }

        @Override
        public void receiveMessage(String message, User sender) {
            System.out.println(name + " (Regular) получил сообщение от " + sender.getName() + ": " + message);
        }
    }
    class PremiumUser extends User {
        public PremiumUser(String name, ChatMediator mediator) {
            super(name, mediator);
        }

        @Override
        public void sendMessage(String message) {
            System.out.println(name + " (Premium) отправляет сообщение: " + message);
            mediator.sendMessage(message, this);
        }

        @Override
        public void receiveMessage(String message, User sender) {
            System.out.println(name + " (Premium) получил сообщение от " + sender.getName() + ": " + message);
        }
    }
}
