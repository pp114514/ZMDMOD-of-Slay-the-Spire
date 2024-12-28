package zmdzzzMod.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static zmdzzzMod.BasicMod.makeID;

public class ReduceScorePower extends BasePower {
    public static final String POWER_ID = makeID("ReduceScorePower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
//    public static int counter = 0;
    //The only thing TURN_BASED controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if their amount is positive or negative.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public ReduceScorePower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void atEndOfTurn(boolean isPlayer) {
        addToBot((AbstractGameAction) new ReducePowerAction(this.owner, this.owner, ScorePower.POWER_ID, amount));
        addToBot((AbstractGameAction) new ReducePowerAction(this.owner, this.owner, ReduceScorePower.POWER_ID, amount));
    }
    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
}
