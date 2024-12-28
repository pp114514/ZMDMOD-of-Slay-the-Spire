package zmdzzzMod.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static zmdzzzMod.BasicMod.makeID;

public class DeadLineUpgPower extends BasePower {
    public static final String POWER_ID = makeID("DeadLineUpgPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
//    public static int cnts = 0;
    //The only thing TURN_BASED controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if their amount is positive or negative.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public DeadLineUpgPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }
//    public void atStartOfTurn() {
//        addToBot((AbstractGameAction)new DrawCardAction(1));
//        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ExamPower(AbstractDungeon.player, 1),0));
//        addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)new Roll(),1));
//
//    }
//    public void atEndOfTurn(boolean isPlayer) {
//        addToBot(new LoseHPAction(AbstractDungeon.player, AbstractDungeon.player,6));
//    }
    public void onUseCard(AbstractCard card, UseCardAction action) {
        addToBot((AbstractGameAction)new DrawCardAction(1));
    }
    public void atEndOfTurn(boolean isPlayer) {
        addToBot(new LoseHPAction(AbstractDungeon.player, AbstractDungeon.player,10));
    }

        public void updateDescription() {
            this.description = DESCRIPTIONS[0];
    }
}