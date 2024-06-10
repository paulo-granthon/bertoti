package facade.anti;

public class Facade {
  public class DVDPlayer {
    public void on() {
      System.out.println("DVD Player on");
    }

    public void play(String movie) {
      System.out.println("Playing movie: " + movie);
    }

    public void stop() {
      System.out.println("Stopping movie");
    }

    public void off() {
      System.out.println("DVD Player off");
    }
  }

  public class Projector {
    public void on() {
      System.out.println("Projector on");
    }

    public void off() {
      System.out.println("Projector off");
    }
  }

  public class SoundSystem {
    public void on() {
      System.out.println("Sound System on");
    }

    public void off() {
      System.out.println("Sound System off");
    }
  }

  public class Lights {
    public void dim(int level) {
      System.out.println("Dimming lights to " + level + "%");
    }

    public void on() {
      System.out.println("Lights on");
    }
  }

  public class Screen {
    public void down() {
      System.out.println("Screen down");
    }

    public void up() {
      System.out.println("Screen up");
    }
  }

  public class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;
    private Lights lights;
    private Screen screen;

    public HomeTheaterFacade(
        DVDPlayer dvdPlayer,
        Projector projector,
        SoundSystem soundSystem,
        Lights lights,
        Screen screen) {
      this.dvdPlayer = dvdPlayer;
      this.projector = projector;
      this.soundSystem = soundSystem;
      this.lights = lights;
      this.screen = screen;
    }

    public void dimLights(int level) {
      lights.dim(level);
    }

    public void turnLightsOn() {
      lights.on();
    }

    public void lowerScreen() {
      screen.down();
    }

    public void raiseScreen() {
      screen.up();
    }

    public void turnProjectorOn() {
      projector.on();
    }

    public void turnProjectorOff() {
      projector.off();
    }

    public void turnSoundSystemOn() {
      soundSystem.on();
    }

    public void turnSoundSystemOff() {
      soundSystem.off();
    }

    public void turnDVDPlayerOn() {
      dvdPlayer.on();
    }

    public void turnDVDPlayerOff() {
      dvdPlayer.off();
    }

    public void playMovie(String movie) {
      dvdPlayer.play(movie);
    }

    public void stopMovie() {
      dvdPlayer.stop();
    }
  }

  public static void main(String[] args) {
    DVDPlayer dvdPlayer = new DVDPlayer();
    Projector projector = new Projector();
    SoundSystem soundSystem = new SoundSystem();
    Lights lights = new Lights();
    Screen screen = new Screen();

    HomeTheaterFacade homeTheater =
        new HomeTheaterFacade(dvdPlayer, projector, soundSystem, lights, screen);

    System.out.println("Get ready to watch a movie...");
    homeTheater.dimLights(10);
    homeTheater.lowerScreen();
    homeTheater.turnProjectorOn();
    homeTheater.turnSoundSystemOn();
    homeTheater.turnDVDPlayerOn();
    homeTheater.playMovie("Inception");

    System.out.println("Shutting movie theater down...");
    homeTheater.stopMovie();
    homeTheater.turnDVDPlayerOff();
    homeTheater.turnSoundSystemOff();
    homeTheater.turnProjectorOff();
    homeTheater.raiseScreen();
    homeTheater.turnLightsOn();
  }
}
