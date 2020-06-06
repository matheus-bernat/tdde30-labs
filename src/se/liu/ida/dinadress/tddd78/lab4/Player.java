package se.liu.ida.dinadress.tddd78.lab4;

public class Player
{
    public static final int SPEED_SLOW = 0;
    public static final int SPEED_MEDIUM = 1;
    public static final int SPEED_FAST = 2;

    public static final String MODE_NORMAL = "Normal";
    public static final String MODE_GHOST = "Ghost";
    public static final String MODE_INVULNERABLE = "Invulnerable";

    private int x, y;
    private int speed = SPEED_MEDIUM;
    private String mode = MODE_NORMAL;

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

    public void moveRight() {
        switch (speed) {
            case SPEED_SLOW:
                x += 5;
                break;
            case SPEED_MEDIUM:
                x += 10;
                break;
            case SPEED_FAST:
                x += 20;
                break;
        }
    }

    /**
     * Describe current speed and mode -- used for a status display
     */
    public String getDescription() {
        StringBuilder buf = new StringBuilder();
        buf.append("Player is ");

        switch (speed) {
            case SPEED_SLOW:
                buf.append("SLOW");
                break;
            case SPEED_MEDIUM:
                buf.append("MEDIUM");
                break;
            case SPEED_FAST:
                buf.append("FAST");
                break;
        }

        buf.append(" and ");

        switch (mode) {
            case MODE_NORMAL:
                buf.append("NORMAL");
                break;
            case MODE_GHOST:
                buf.append("GHOST");
                break;
            case MODE_INVULNERABLE:
                buf.append("INVULNERABLE");
                break;
        }

        return buf.toString();
    }

    public static void main(String[] args) {
        final Player player = new Player();
        System.out.println(player.getDescription());
    }
}
