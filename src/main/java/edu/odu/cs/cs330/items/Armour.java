package edu.odu.cs.cs330.items;

import java.util.Objects;

/**
 * This class represents one piece of armour--as found in most video games.
 * This includes boots and helmets.
 *
 * Armour may not be stacked.
 */
@SuppressWarnings({
    "PMD.BeanMembersShouldSerialize",
    "PMD.CloneMethodReturnTypeMustMatchClassName",
    "PMD.CloneThrowsCloneNotSupportedException",
    "PMD.LawOfDemeter",
    "PMD.OnlyOneReturn",
    "PMD.ProperCloneImplementation",
    "PMD.MethodArgumentCouldBeFinal",
    "PMD.LocalVariableCouldBeFinal"
})
public class Armour extends Equippable implements Item
{
    /**
     * Format used to generate a printable representation.
     */
    public static final String FMT_STR = String.join(
        "",
        "  Nme: %s%n",
        "  Dur: %s%n",
        "  Def: %d%n",
        "  Mtl: %s%n",
        "  Mdr: %s (Lvl %d)%n",
        "  Emt: %s%n"
    );

    /**
     * The amount of damage that can be negated.
     */
    protected int defense;

    /**
     * Default to a armour with a defense of zero.
     */
    public Armour()
    {
        super();

        this.defense = 0;
    }

    /**
     * Retrieve armour defense.
     *
     * @return total defense provided
     */
    public int getDefense()
    {
        return this.defense;
    }

    /**
     * Update defense.
     *
     * @param def replacement getDefense()
     */
    public void setDefense(int def)
    {
        this.defense = def;
    }

    /**
     * Clone--i.e., copy--this Armour.
     */
    @Override
    public Item clone()
    {
        Armour cpy = new Armour();

        // Refer to the previous assignment

        // Fields inherited from Equippable / Item
        cpy.setName(getName());
        cpy.setMaterial(getMaterial());
        cpy.setDurability(getDurability());
        cpy.setModifier(getModifier());
        cpy.setModifierLevel(getModifierLevel());
        cpy.setElement(getElement());

        // Field in this class
        cpy.setDefense(getDefense());
        return cpy;
    }

    /**
     * Check for logical equivalence--based on name, material, modifier,
     * modifierLevel, element, and defense.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (this == rhs) {
            return true;
        }

        if (!(rhs instanceof Armour)) {
            return false;
        }

        Armour rhsItem = (Armour) rhs;

        return Objects.equals(getName(), rhsItem.getName())
            && Objects.equals(getMaterial(), rhsItem.getMaterial())
            && Objects.equals(getModifier(), rhsItem.getModifier())
            && getModifierLevel() == rhsItem.getModifierLevel()
            && Objects.equals(getElement(), rhsItem.getElement())
            && getDefense() == rhsItem.getDefense();
    }

    /**
     * Compute hashCode based on name, material, modifier, modifierLevel,
     * element, and defense.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(
            this.getName(),
            this.getMaterial(),
            this.getModifier(),
            this.getModifierLevel(),
            this.getElement(),
            this.getDefense()
        );
    }

    /**
     * *Print* one Armour.
     */
    @Override
    public String toString()
    {
        return String.format(
            FMT_STR,
            getName(),
            getDurability(),
            getDefense(),
            getMaterial(),
            getModifier(),
            getModifierLevel(),
            getElement()
        );
    }
}




