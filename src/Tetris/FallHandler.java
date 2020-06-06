package Tetris;

/**
 * Interface to classes DefaultFallHandler, Heavy and FallThrough. It contains functions that must be implemented by
 * it's kids.
 */
public interface FallHandler
{
    public boolean hasCollision(Board board);

    public String getDescription();

}
