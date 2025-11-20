package edu.odu.cs.cs330.items;

import java.util.Objects;

/**
 * This class represents one tool--as found in most video games. This includes
 * pickaxes and shovels.
 *
 * Tools may not be stacked. All Constructors must initialize Item::stackable
 * to false.
 */
@SuppressWarnings({
    "PMD.BeanMembersShouldSerialize",
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal",
    "PMD.ShortClassName",
})
public class Tool extends Equippable implements Item {
    /**
     * Format used to generate a printable representation.
     */
    public static final String FMT_STR = String.join(
        "",
        "  Nme: %s%n",
        "  Dur: %d%n",
        "  Spd: %d%n",
        "  Mtl: %s%n",
        "  Mdr: %s (Lvl %d)%n"
    );

    /**
     * Base operation (e.g., harvest/mine) speed.
     */
    protected int speed;

    /**
     * Default to an unstackable tool with zero speed.
     */
    public Tool()
    {
        super();

        this.speed = 0;
    }

    /**
     * Retrieve tool speed.
     *
     * @return how quickly a tool operates
     */
    public int getSpeed()
    {
        return this.speed;
    }

    /**
     * Set tool speed.
     *
     * @param spd new speed
     */
    public void setSpeed(int spd)
    {
        this.speed = spd;
    }

    /**
     * Clone--i.e., copy--this Tool.
     */
    @Override
    public Item clone()
    {
        Tool cpy = new Tool();

        
        cpy.setName(getName());
        cpy.setMaterial(getMaterial());
        cpy.setDurability(getDurability());
        cpy.setSpeed(getSpeed());
        cpy.setModifier(getModifier());
        cpy.setModifierLevel(getModifierLevel());

        return cpy;
    }

    /**
     * Check for logical equivalence--based on name, speed, material, modifier,
     * and modifierLevel
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (this == rhs) {
            return true;
        }

        if (!(rhs instanceof Tool)) {
            return false;
        }

        Tool rhsItem = (Tool) rhs;

        // based on name, speed, material, modifier, modifierLevel
        return Objects.equals(getName(), rhsItem.getName())
            && getSpeed() == rhsItem.getSpeed()
            && Objects.equals(getMaterial(), rhsItem.getMaterial())
            && Objects.equals(getModifier(), rhsItem.getModifier())
            && getModifierLevel() == rhsItem.getModifierLevel();
    }

    /**
     * Compute hashCode using name, speed, material, modifier,
     * and modifierLevel.
     */
    @Override
    public int hashCode()
    {
        // same fields as equals
        return Objects.hash(
            getName(),
            getSpeed(),
            getMaterial(),
            getModifier(),
            getModifierLevel()
        );
    }

    /**
     * *Print* a Tool.
     */
    @Override
    public String toString()
    {
            return String.format(
            FMT_STR,
            getName(),
            getDurability(),
            getSpeed(),
            getMaterial(),
            getModifier(),
            getModifierLevel()
          );
    }
}
