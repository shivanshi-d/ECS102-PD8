import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Computer is a User that can switch to a randomly chosen Pokemon.
 * 
 * @author Shivi
 * @version 10/6/2026
 */
public class Computer extends User
{
    public Computer(String name)
    {
        super(name);
    }

    // Picks one of three Pokemon at random and switches to it
    public void switchPokemon()
    {
        Pokemon p;
        int choice = Greenfoot.getRandomNumber(3);
        if (choice == 0)
        {
            p = new Pokemon(100, 15, "Charmander", "Ember", "Fire");
        }
        else if (choice == 1)
        {
            p = new Pokemon(100, 15, "Squirtle", "Water Gun", "Water");
        }
        else
        {
            p = new Pokemon(100, 15, "Bulbasaur", "Vine Whip", "Grass");
        }
        switchPokemon(p); // calls User.switchPokemon(Pokemon)
    }

    /**
     * Act - do whatever the Computer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}