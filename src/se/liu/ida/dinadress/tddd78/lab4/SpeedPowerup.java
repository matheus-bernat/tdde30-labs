package se.liu.ida.dinadress.tddd78.lab4;

import java.awt.*;

public class SpeedPowerup implements Powerup
{
    public void paint(Graphics g, int x, int y) {
        g.fillRect(x, y, 10, 10);
    }

    @Override public String getDescription() {
            return "Makes a player faster";
        }

    public void playerHitMe(Player player) {player.setSpeed(Player.SPEED_FAST);} // implement method here
}
