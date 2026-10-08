import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A User (trainer) has a name and one active Pokemon.
 * 
 * @author Shivi
 * @version 10/6/2026
 */
public class User extends Actor
{
    private String name;
    private Pokemon pokemon;

    public User(String name)
    {
        this.name = name;
    }

    public void setPokemon(Pokemon p)
    {
        pokemon = p;
    }

    public Pokemon getPokemon()
    {
        return pokemon;
    }

    // Replaces the active Pokemon. If the old one is in the world,
    // the new one is placed at the same position.
    public void switchPokemon(Pokemon newPokemon)
    {
        if (pokemon != null && pokemon.getWorld() != null)
        {
            World world = pokemon.getWorld();
            int x = pokemon.getX();
            int y = pokemon.getY();
            world.removeObject(pokemon);
            world.addObject(newPokemon, x, y);
        }
        pokemon = newPokemon;
    }

    public void heal()
    {
        pokemon.heal();
    }

    public void attack(String name, User enemy)
    {
        pokemon.attack(name, enemy);
    }

    // The game ends for this user when they have no Pokemon or it has fainted
    public boolean isEndGame()
    {
        return pokemon == null || pokemon.isOut();
    }

    public String getName()
    {
        return name;
    }

    /**
     * Act - do whatever the User wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}