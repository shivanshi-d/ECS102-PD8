import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Pokemon has hit points (hp), attack points (ap), a name, an image,
 * a fainted status, one Attack, and a type (Fire, Water, or Grass).
 * 
 * @author Shivi
 * @version 10/6/2026
 */
public class Pokemon extends Actor
{
    private int hp;
    private int ap;
    private String name;
    private GreenfootImage img;
    private boolean outStatus;
    private Attack attack;
    private String type;

    public Pokemon(int hp, int ap, String name, String attack, String type)
    {
        this.hp = hp;
        this.ap = ap;
        this.name = name;
        this.attack = new Attack(attack, ap);
        this.type = type;
        this.outStatus = false;

        // Looks for an image named after the Pokemon (e.g. "charmander.png")
        // in the scenario's images folder. Falls back to a text label if missing.
        try
        {
            img = new GreenfootImage(name.toLowerCase() + ".png");
        }
        catch (IllegalArgumentException e)
        {
            img = new GreenfootImage(name, 24, Color.BLACK, Color.WHITE);
        }
        setImage(img);
    }

    public String getType()
    {
        return type;
    }

    // Damages the enemy's current Pokemon if attackName matches this Pokemon's attack
    public void attack(String attackName, User enemy)
    {
        if (outStatus)
        {
            return;
        }
        int damage = getAttackPower(attackName, enemy);
        if (damage > 0)
        {
            printAttack();
            enemy.getPokemon().takeDamage(damage);
        }
    }

    public void takeDamage(int amount)
    {
        hp -= amount;
        if (hp <= 0)
        {
            hp = 0;
            outStatus = true;
        }
    }

    // Restores 20 hp; a fainted Pokemon cannot be healed
    public void heal()
    {
        if (!outStatus)
        {
            hp += 20;
        }
    }

    public void printAttack()
    {
        System.out.println(name + " used " + attack.getName()
                           + " (power " + attack.getPower() + ")");
    }

    // Returns 0 if attackName doesn't match this Pokemon's attack.
    // Type matchups: Fire > Grass > Water > Fire.
    // Strong matchup doubles power, weak matchup halves it.
    public int getAttackPower(String attackName, User enemy)
    {
        if (!attack.getName().equalsIgnoreCase(attackName))
        {
            return 0;
        }

        int power = attack.getPower();
        String enemyType = enemy.getPokemon().getType();

        boolean strong = (type.equalsIgnoreCase("Fire")  && enemyType.equalsIgnoreCase("Grass"))
                      || (type.equalsIgnoreCase("Grass") && enemyType.equalsIgnoreCase("Water"))
                      || (type.equalsIgnoreCase("Water") && enemyType.equalsIgnoreCase("Fire"));

        boolean weak   = (enemyType.equalsIgnoreCase("Fire")  && type.equalsIgnoreCase("Grass"))
                      || (enemyType.equalsIgnoreCase("Grass") && type.equalsIgnoreCase("Water"))
                      || (enemyType.equalsIgnoreCase("Water") && type.equalsIgnoreCase("Fire"));

        if (strong)
        {
            power *= 2;
        }
        else if (weak)
        {
            power /= 2;
        }
        return power;
    }

    public int getHp()
    {
        return hp;
    }

    public int getAp()
    {
        return ap;
    }

    public String getName()
    {
        return name;
    }

    public boolean isOut()
    {
        return outStatus;
    }

    public Attack getAttack()
    {
        return attack;
    }

    /**
     * Act - do whatever the Pokemon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}