package edu.odu.cs.cs330.items.creation;

import edu.odu.cs.cs330.items.Item;
import edu.odu.cs.cs330.items.Armour;


@SuppressWarnings({
    "PMD.AtLeastOneConstructor"
})
public class ArmourCreation implements ItemCreationStrategy
{
    /**
     * Convenience wrapper to mirror the Rust new-returns-a-builder pattern.
     * Use "construct" since "new" is a reserved keyword in Java.
     */
    public static ArmourCreation construct()
    {
        return new ArmourCreation();
    }

    @Override
    public Item fromDefaults()
    {
        // Maybe call a Default Constructor...
        return new Armour();
    }

    @Override
    public int requiredNumberOfValues()
    {
        // name, material, durability, defense, modifier, modifierLevel, element
        return 7;
    }

    @SuppressWarnings({
        "PMD.LawOfDemeter",
        "PMD.LocalVariableCouldBeFinal"
    })
    @Override
    public Item fromTokens(final String... tokens)
    {
        Armour armour = new Armour();

        // tokens[0]..tokens[6] are after the keyword
        armour.setName(tokens[0]);
        armour.setMaterial(tokens[1]);
        armour.setDurability(Integer.parseInt(tokens[2]));
        armour.setDefense(Integer.parseInt(tokens[3]));
        armour.setModifier(tokens[4]);
        armour.setModifierLevel(Integer.parseInt(tokens[5]));
        armour.setElement(tokens[6]);

        return armour;
    }

    @Override
    public Item fromExisting(final Item original)
    {
        if (!(original instanceof Armour)) {
            throw new IllegalArgumentException("Expected Armour in ArmourCreation.fromExisting");
        }

        return ((Armour) original).clone();
    }
}
