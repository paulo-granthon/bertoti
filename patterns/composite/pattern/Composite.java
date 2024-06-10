package composite.pattern;

public class Composite {
    public interface RobotAction {
        void execute();
    }

    public class MoveForwardAction implements RobotAction {
        @Override
        public void execute() {
            System.out.println("Moving forward");
        }
    }

    public class TurnLeftAction implements RobotAction {
        @Override
        public void execute() {
            System.out.println("Turning left");
        }
    }

    public class TurnRightAction implements RobotAction {
        @Override
        public void execute() {
            System.out.println("Turning right");
        }
    }

    public class Robot implements RobotAction {
        private List<RobotAction> actions;

        public Robot() {
            actions = new ArrayList<>();
        }

        public void addAction(RobotAction action) {
            actions.add(action);
        }

        @Override
        public void execute() {
            for (RobotAction action : actions) {
                action.execute();
            }

            actions.clear();
        }
    }

    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.addAction(new MoveForwardAction());
        robot.addAction(new TurnLeftAction());
        robot.addAction(new MoveForwardAction());
        robot.addAction(new TurnRightAction());
        robot.addAction(new MoveForwardAction());

        robot.execute(); // Moving forward, Turning left, Moving forward, Turning right, Moving forward
    }
}
