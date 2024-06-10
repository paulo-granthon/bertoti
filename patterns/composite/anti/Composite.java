package composite.anti;

import java.util.List;

public class Composite {
  public class RobotBase {
    private List<String> actions;

    public void addAction(String action) {
      actions.add(action);
    }

    public void execute() {
      for (String action : actions) {
        handleAction(action);
      }
    }

    public void handleAction(String action) {
      System.out.println("Unknown action: " + action);
    }
  }

  public class MovesForwardRobot extends RobotBase {
    @Override
    public void handleAction(String action) {
      if (action.equals("move forward")) {
        System.out.println("Moving forward");
      } else {
        super.handleAction(action);
      }
    }
  }

  public class TurnsLeftRobot extends RobotBase {
    @Override
    public void handleAction(String action) {
      if (action.equals("turn left")) {
        System.out.println("Turning left");
      } else {
        super.handleAction(action);
      }
    }
  }

  public class TurnsRightRobot extends RobotBase {
    @Override
    public void handleAction(String action) {
      if (action.equals("turn right")) {
        System.out.println("Turning right");
      } else {
        super.handleAction(action);
      }
    }
  }

  public class TurnsBothWaysRobot extends RobotBase {
    @Override
    public void handleAction(String action) {
      if (action.equals("turn left")) {
        System.out.println("Turning left");
      } else if (action.equals("turn right")) {
        System.out.println("Turning right");
      } else {
        super.handleAction(action);
      }
    }
  }

  public class MovesAndTurnsRobot extends RobotBase {
    @Override
    public void handleAction(String action) {
      if (action.equals("move forward")) {
        System.out.println("Moving forward");
      } else if (action.equals("turn left")) {
        System.out.println("Turning left");
      } else if (action.equals("turn right")) {
        System.out.println("Turning right");
      } else {
        super.handleAction(action);
      }
    }
  }

  public static void main(String[] args) {
    RobotBase robotBase = new RobotBase();
    robotBase.addAction("move forward");
    robotBase.execute(); // Unknown action: move forward

    MovesForwardRobot movesForwardRobot = new MovesForwardRobot();
    movesForwardRobot.addAction("move forward");
    movesForwardRobot.addAction("turn left");
    movesForwardRobot.execute(); // Moving forward, Unknown action: turn left

    MovesAndTurnsRobot movesAndTurnsRobot = new MovesAndTurnsRobot();
    movesAndTurnsRobot.addAction("move forward");
    movesAndTurnsRobot.addAction("turn left");
    movesAndTurnsRobot.addAction("move forward");
    movesAndTurnsRobot.addAction("turn right");
    movesAndTurnsRobot.addAction("move forward");

    movesAndTurnsRobot.execute(); // Moving forward, Turning left, Moving forward, Turning right, Moving forward
  }
}
