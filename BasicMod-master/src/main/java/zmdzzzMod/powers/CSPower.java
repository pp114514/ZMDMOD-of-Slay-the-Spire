package zmdzzzMod.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;

import static zmdzzzMod.BasicMod.makeID;

public class CSPower extends BasePower {
    public static final String POWER_ID = makeID("CSPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    //The only thing TURN_BASED controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if their amount is positive or negative.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public CSPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

        public void updateDescription() {
            this.description = DESCRIPTIONS[0];
    }
}