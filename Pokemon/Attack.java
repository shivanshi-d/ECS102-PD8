import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An Attack has a name and a power value.
 * 
 * @author Shivi
 * @version 10/6/2026
 */
public class Attack extends Actor
{
    private String name;
    private int power;

    public Attack(String name)
    {
        this.name = name;
        this.power = 10;
    }

    public Attack(String name, int power)
    {
        this.name = name;
        this.power = power;
    }

    public String getName()
    {
        return name;
    }

    public int getPower()
    {
        return power;
    }

    /**
     * Act - do whatever the Attack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}