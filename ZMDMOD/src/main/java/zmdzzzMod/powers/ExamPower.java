package zmdzzzMod.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static zmdzzzMod.BasicMod.makeID;

public class ExamPower extends BasePower {
    public static final String POWER_ID = makeID("ExamPower");
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
//    public static int counter = 0;
    //The only thing TURN_BASED controls is the color of the number on the power icon.
    //Turn based powers are white, non-turn based powers are red or green depending on if their amount is positive or negative.
    //For a power to actually decrease/go away on its own they do it themselves.
    //Look at powers that do this like VulnerablePower and DoubleTapPower.

    public ExamPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount <= 0) {
            addToTop((AbstractGameAction) new RemoveSpecificPowerAction(this.owner, this.owner, ExamPower.POWER_ID));
        }
        if(this.amount > 1){
            addToBot((AbstractGameAction) new ReducePowerAction(this.owner, this.owner, ExamPower.POWER_ID, this.amount-1));
        }
    }
    public void onUseCard(AbstractCard card, UseCardAction action) {
        /* 35 */     if (card.type == AbstractCard.CardType.SKILL) {
            /* 36 */       addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ScorePower(AbstractDungeon.player, 1)));
            /*    */     }
        /*    */   }
    public void atEndOfTurnPreEndTurnCards(boolean isPlayer) {
        addToBot((AbstractGameAction) new ReducePowerAction(this.owner, this.owner, ExamPower.POWER_ID, 1));
        if (AbstractDungeon.player.hasPower(ShiliPower.POWER_ID)) {
            if(AbstractDungeon.player.hasPower(ExamFormPower.POWER_ID)){
                addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ScorePower(AbstractDungeon.player, AbstractDungeon.player.getPower(ShiliPower.POWER_ID).amount*2)));
            }
            else {
                addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ScorePower(AbstractDungeon.player, AbstractDungeon.player.getPower(ShiliPower.POWER_ID).amount)));
            }
            addToBot((AbstractGameAction) new ReducePowerAction(AbstractDungeon.player, AbstractDungeon.player, ShiliPower.POWER_ID, AbstractDungeon.player.getPower(ShiliPower.POWER_ID).amount));
        }
    }
    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
}
