import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Turn-based Pokemon battle: press A to attack, H to heal.
 * The computer takes its turn right after yours.
 * 
 * @author Shivi
 * @version 10/6/2026
 */
public class MyWorld extends World
{
    private User player;
    private Computer cpu;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        player = new User("Player");
        cpu = new Computer("Rival");

        player.setPokemon(new Pokemon(100, 15, "Squirtle", "Water Gun", "Water"));
        cpu.setPokemon(new Pokemon(100, 15, "Charmander", "Ember", "Fire"));

        addObject(player.getPokemon(), 150, 280);
        addObject(cpu.getPokemon(), 450, 120);

        showText("A = attack   H = heal", 300, 380);
        updateHp();
    }

    /**
     * Act - called whenever the 'Act' or 'Run' button gets pressed.
     * Handles one round of the battle per key press.
     */
    public void act()
    {
        if (player.isEndGame() || cpu.isEndGame())
        {
            return;
        }

        String key = Greenfoot.getKey();
        if (key == null)
        {
            return;
        }

        // Player's turn
        if (key.equals("a"))
        {
            player.attack(player.getPokemon().getAttack().getName(), cpu);
        }
        else if (key.equals("h"))
        {
            player.heal();
        }
        else
        {
            return; // ignore other keys
        }

        if (cpu.isEndGame())
        {
            updateHp();
            showText(player.getName() + " wins!", 300, 200);
            Greenfoot.stop();
            return;
        }

        // Computer's turn: 10% switch, 20% heal, 70% attack
        int move = Greenfoot.getRandomNumber(10);
        if (move == 0)
        {
            cpu.switchPokemon();
        }
        else if (move <= 2)
        {
            cpu.heal();
        }
        else
        {
            cpu.attack(cpu.getPokemon().getAttack().getName(), player);
        }

        updateHp();

        if (player.isEndGame())
        {
            showText(cpu.getName() + " wins!", 300, 200);
            Greenfoot.stop();
        }
    }

    private void updateHp()
    {
        Pokemon p = player.getPokemon();
        Pokemon c = cpu.getPokemon();
        showText(p.getName() + " HP: " + p.getHp(), 150, 350);
        showText(c.getName() + " HP: " + c.getHp(), 450, 40);
    }
}