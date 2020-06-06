package se.liu.ida.dinadress.tddd78.lab4;

public class Player2
{
    public enum Speed
        {
            SLOW(5) {public String toString() {return "SLOW";}},
	    MEDIUM(10) {public String toString() {return "MEDIUM";}},
	    FAST(20) {public String toString() {return "FAST";}};

            public final int playerSpeed;

            Speed(final int playerSpeed) { this.playerSpeed = playerSpeed; }

            @Override public String toString() {
                return "Speed{" + "playerSpeed=" + playerSpeed + '}';
            }
        }

    public enum Mode
        {
            NORMAL {public String toString() {return "NORMAL";}},
	    GHOST {public String toString() {return "GHOST";}},
	    INVULNERABLE {public String toString() {return "INVULNERABLE";}}
        }

    public static final int SPEED_SLOW = 0;
    public static final int SPEED_MEDIUM = 1;
    public static final int SPEED_FAST = 2;

    public static final String MODE_NORMAL = "Normal";
    public static final String MODE_GHOST = "Ghost";
    public static final String MODE_INVULNERABLE = "Invulnerable";

    private int x, y;
    private int speed; // = SPEED_MEDIUM;
    private String mode; // = MODE_NORMAL;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(final int speed) {
        this.speed = speed;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(final String mode) {
        this.mode = mode;
    }

    public void moveRight(Speed enumSpeed) {
            x += enumSpeed.playerSpeed;
        }

    /**
     * Describe current speed and mode -- used for a status display
     */
    public String getDescription(Speed enumSpeed, Mode enumMode) {
        StringBuilder buf = new StringBuilder();
        buf.append("Player is ");
        buf.append(enumSpeed);
        buf.append(" and ");
        buf.append(enumMode);
        return buf.toString();
    }

    public static void main(String[] args) {
        final Player2 player = new Player2();
        System.out.println(player.getDescription(Speed.FAST, Mode.INVULNERABLE));
    }
}